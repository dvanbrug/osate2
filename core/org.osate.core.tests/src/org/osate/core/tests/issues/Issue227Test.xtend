package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue227Test extends OsateTest {
	override getProjectName() {
		"issue227"
	}

	@Test
	def void issue227() {
		val aadlFile = "issue227.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('Feature group type "TestInvExtendedFeatureGroup" not found', cls.exists[name == 'TestInvExtendedFeatureGroup'])

		val fgt = cls.findFirst[name == 'TestInvExtendedFeatureGroup']

		// check that the fgt contains the expected features
		val features = fgt.allFeatures
		val names = features.map[name]
		
		assertTrue('Feature "o" not in feature group', names.contains('o'))
		assertTrue('Feature "r" not in feature group', names.contains('r'))
		assertTrue('Expected two features but found ' + features.size + ': ' + names, features.size == 2)
	}

	val aadlText = '''
		package issue227
		public
			system TestSys
				features
					fg1: feature group TestExtendedFeatureGroup;
					fg2: feature group TestInvExtendedFeatureGroup;
			end TestSys;
		
			system TestSubSys
			end TestSubSys;
		
			system implementation TestSys.Impl
			end TestSys.Impl;
		
		  feature group BaseFG
		  	features
		  		q: feature;
		  end BaseFG;
		  
			feature group TestFeatureGroup extends BaseFG
				features
					i: in feature;
					p: in feature;
			end TestFeatureGroup;
		
			feature group TestExtendedFeatureGroup extends TestFeatureGroup
				features
					p: refined to in data port;
			end TestExtendedFeatureGroup;
		
			feature group TestInvFeatureGroup
				features
					o: out feature;
					r: out feature;
				inverse of TestFeatureGroup
			end TestInvFeatureGroup;
		
			feature group TestInvExtendedFeatureGroup extends TestInvFeatureGroup
				inverse of TestExtendedFeatureGroup
			end TestInvExtendedFeatureGroup;
		end issue227;
	'''
}

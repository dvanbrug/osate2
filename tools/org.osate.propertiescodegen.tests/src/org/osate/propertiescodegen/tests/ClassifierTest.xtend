package org.osate.propertiescodegen.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.PropertySet
import org.osate.propertiescodegen.PropertiesCodeGen
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class ClassifierTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testClassifier() {
		val otherPs = '''
			property set other_ps is
				other_classifier_type: type classifier;
			end other_ps;
		'''
		val classifierTest = '''
			property set classifier_test is
				with other_ps;
				
				local_classifier_type: type classifier;
				
				owned_classifier: classifier applies to (all);
				referenced_classifier_local: classifier_test::local_classifier_type applies to (all);
				referenced_classifier_other: other_ps::other_classifier_type applies to (all);
				
				list_1_classifier: list of other_ps::other_classifier_type applies to (all);
				list_5_classifier: list of list of list of list of list of other_ps::other_classifier_type applies to (all);
			end classifier_test;
		'''
		val classifierTestClass = '''
			package classifier_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			public class ClassifierTest {
				public static Optional<Classifier> getOwnedClassifier(InstanceObject instanceObject) {
					String name = "classifier_test::owned_classifier";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ClassifierValue) propertyExpression).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(InstanceObject instanceObject) {
					String name = "classifier_test::referenced_classifier_local";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ClassifierValue) propertyExpression).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(InstanceObject instanceObject) {
					String name = "classifier_test::referenced_classifier_other";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ClassifierValue) propertyExpression).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<Classifier>> getList1Classifier(InstanceObject instanceObject) {
					String name = "classifier_test::list_1_classifier";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ClassifierValue) element1).getClassifier();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(InstanceObject instanceObject) {
					String name = "classifier_test::list_5_classifier";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
								return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
									return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
										return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
											return ((ClassifierValue) element5).getClassifier();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(classifierTest, otherPs))
		assertEquals(1, results.size)
		
		assertEquals("ClassifierTest.java", results.head.fileName)
		assertEquals(classifierTestClass.toString, results.head.contents)
	}
}
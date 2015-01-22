/*
 * generated by Xtext
 */
package org.osate.alisa.workbench.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.workbench.alisa.AlisaWorkArea
import org.osate.alisa.workbench.alisa.AssuranceCasePlan
import org.osate.reqspec.reqSpec.Hazard
import org.osate.verify.verify.AllExpr
import org.osate.verify.verify.AndThenExpr
import org.osate.verify.verify.ArgumentExpr
import org.osate.verify.verify.Claim
import org.osate.verify.verify.FailThenExpr
import org.osate.verify.verify.RefExpr
import org.osate.verify.verify.VerificationAssumption
import org.osate.verify.verify.VerificationCondition
import org.osate.verify.verify.VerificationPrecondition

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile
import org.osate.verify.verify.WhenExpr
import org.osate.reqspec.reqSpec.Requirement
import static extension org.osate.alisa.workbench.util.AlisaWorkbenchUtilsExtension.*
import static extension org.osate.assure.util.AssureUtilExtension.*

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class AlisaGenerator implements IGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		val workarea = resource.contents.get(0) as AlisaWorkArea
		workarea.cases.forEach [ mycase |
			fsa.generateFile('''«mycase.name».assure''', generateCase(mycase))
		]
	}

	
	@Inject extension IQualifiedNameProvider qualifiedNameProvider

	def generateCase(AssuranceCasePlan acp) {
		val si = acp.system.buildInstanceModelFile
		si.generate(acp)
	}

	def CharSequence generate(ComponentInstance ci, AssuranceCasePlan acp) {
		val myplans = ci.getVerificationPlans(acp);
		'''	
		«IF !myplans.empty»
		case «acp.name» for «ci.componentClassifier.getQualifiedName»
		instance "«ci.URI.toString»"
		[
			«FOR myplan : myplans»
			«FOR claim : myplan.claim»
			«claim.generate(ci)»
			«ENDFOR»
			«ENDFOR»
			«FOR subci : ci.componentInstances»
			«subci.generate(acp)»
			«ENDFOR»
«««			«FOR hazard : myplan.claim»
«««			«hazard.generate(ci)»
«««			«ENDFOR»
		]
		«ENDIF»
		'''
		// XXX add in hazards for system
	}

	def CharSequence generate(Claim claim,ComponentInstance ci) {
		'''
		claim «claim.name» for «claim.requirement.fullyQualifiedName»
		«IF claim.requirement.target != null»
		instance "«claim.requirement.getRequirementTarget(ci)»"
		«ENDIF»
		[
		    «FOR subclaim : claim?.subclaim»
			«subclaim.generate(ci)»
		    «ENDFOR»
		    «claim.assert.generate»
		]
		'''
	}

	def CharSequence generate(Requirement req) {
		'''
		claim «req.name» for «req.fullyQualifiedName»
		[
«««	assert is part of claim not req	    «claim.assert.generate»
		]
		'''
	}

	def CharSequence generate(ArgumentExpr expr) {
		switch expr {
			AllExpr: expr.doGenerate
			AndThenExpr: expr.doGenerate
			FailThenExpr: expr.doGenerate
			WhenExpr: expr.doGenerate
			RefExpr: expr.doGenerate
		}
	}

	def doGenerate(AllExpr expr) {
		'''
		«FOR subexpr : expr.all»
		«subexpr.generate»
		«ENDFOR»
		'''
	}

	def doGenerate(AndThenExpr expr) {
		'''
		andthen
			«expr.left.generate»
		do
			«expr.right.generate»
		[
		]
		'''
	}

	def doGenerate(FailThenExpr expr) {
		'''
		failthen 
			«expr.left.generate»
		do
			«expr.right.generate»
		[
		]
		'''
	}

	def doGenerate(WhenExpr expr) {
		'''
		«IF expr.evaluate»
		«expr.generate»
		«ENDIF»
		'''
	}

	def doGenerate(RefExpr expr) {
		'''
		verification «expr.verification.name» for «expr.verification.fullyQualifiedName»
		[
			executionstate todo
			resultstate tbd
			«FOR vacond : expr.verification?.method?.conditions»
			«vacond.generate»
			«ENDFOR»
		]
		'''
	}

	def generate(Hazard ha) {
		'''
		hazard «ha.name» for «ha.fullyQualifiedName»
		[
			«FOR req : ha.requirementReference»
			«req.generate»
			«ENDFOR»
		]
		'''
		// add mitigated by requirement as claim
	}

	def generate(VerificationCondition vc) {
		'''
		«vc.keyword» «vc.name» for «vc.fullyQualifiedName»
		[
			«vc.assert.generate»
		]
		'''
	}

	def evaluate(WhenExpr expr) {
		true
	}

	def keyword(VerificationCondition vc) {
		switch vc {
			VerificationAssumption: '''assumption'''
			VerificationPrecondition: '''precondition'''
		}
	}

}

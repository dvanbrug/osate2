/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

/*
* generated by Xtext
*/
package org.osate.reqspec.ui.quickfix

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.osate.aadl2.ComponentClassifier
import org.osate.reqspec.reqSpec.DocumentSection
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.ReqDocument
import org.osate.reqspec.reqSpec.ReqSpec
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.reqspec.validation.ReqSpecValidator

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class ReqSpecQuickfixProvider extends DefaultQuickfixProvider {

	/**
	 * QuickFix for removing a goal duplicated within a StakeholdersGoals
	 * The issue data array is expected to have one element:
	 *
	 * issue.getData()[0]: The URI of the StakeHoldersGoals
	 */
	@Fix(ReqSpecValidator.DUPLICATE_GOAL_WITHIN_STAKEHOLDER_GOALS)
	def public void fixDuplicateGoal(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove goal", null, null,
				new ISemanticModification() {

					override apply(EObject element, IModificationContext context) throws Exception {
						val ResourceSet resourceSet = element.eResource().getResourceSet()
						val stakeholderGoals = resourceSet.getEObject(URI.createURI(issue.getData.head), true) as StakeholderGoals
						val goal = element as Goal
						stakeholderGoals.goals.remove(goal);
					}
				});
	}
	/**
	 * QuickFix for removing a duplicated StakeholderGoals
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The offset of the StakeholderGoals
	 * issue.getData()[1]: The length of the StakeholderGoals
	 * 
	 */
	@Fix(ReqSpecValidator.DUPLICATE_STAKEHOLDER_GOALS)
	def public void fixDuplicateStakeholderGoals(Issue issue, IssueResolutionAcceptor acceptor) {
		val offset = Integer.parseInt(issue.getData().get(0))
		val length = Integer.parseInt(issue.getData().get(1))

		acceptor.accept(issue, "Remove StakeholderGoals", null, null, 
			new IModification() {
				override public void apply(IModificationContext context) throws Exception {
					context.getXtextDocument().replace(offset, length, "");
			}
		});
	}
	/**
	 * QuickFix for rename a reqspec target to match a StakeholdersGoals target based on matching requirement and goal
	 * The issue data array is expected to have one element:
	 * issue.getData()[0]: The name the needs changed
	 * issue.getData()[1]: name it needs changed to
	 * issue.getData()[2]: the uri of what it needs changed to
	 */
	@Fix(ReqSpecValidator.REQSPEC_FOR_DIFFERS_FROM_STAKEHOLDERGOALS_FOR)
	def public void fixDifferingFor(Issue issue, IssueResolutionAcceptor acceptor) {
		val fromName = issue.getData().get(0)
		val toName = issue.getData().get(1)
		val fromURI = issue.getData().get(2)

		acceptor.accept(issue, "Change System Requirement 'for' from '" + fromName + "' to '" + toName + "'", null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						
						val ResourceSet resourceSet = element.eResource().getResourceSet()
						val classifier = resourceSet.getEObject(URI.createURI(fromURI), true) as ComponentClassifier
						val sysReqs = element as SystemRequirementSet
						sysReqs.target = classifier
					}
				});
				
				
	}

	/**
	 * QuickFix for removing a duplicated SystemRequirements
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The offset of the SystemRequirements
	 * issue.getData()[1]: The length of the SystemRequirements
	 * 
	 */
	@Fix(ReqSpecValidator.DUPLICATE_REQUIREMENTS)
	def public void fixDuplicateSystemRequirements(Issue issue, IssueResolutionAcceptor acceptor) {
		val offset = Integer.parseInt(issue.getData().get(0))
		val length = Integer.parseInt(issue.getData().get(1))

		acceptor.accept(issue, "Remove SystemsRequirement", null, null, 
			new IModification() {
				override public void apply(IModificationContext context) throws Exception {
					context.getXtextDocument().replace(offset, length, "")
			}
		});
	}
	/**
	 * QuickFix for removing a goal duplicated within a StakeholdersGoals
	 * The issue data array is expected to have one element:
	 *
	 * issue.getData()[0]: The URI of the StakeHoldersGoals
	 */
	@Fix(ReqSpecValidator.DUPLICATE_REQUIREMENT_WITHIN_REQUIREMENTS)
	def public void fixDuplicateRequirement(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove requirement", null, null,
				new ISemanticModification() {

					override apply(EObject element, IModificationContext context) throws Exception {
						val ResourceSet resourceSet = element.eResource().getResourceSet()
						val SystemRequirements = resourceSet.getEObject(URI.createURI(issue.getData.head), true) as SystemRequirementSet
						val requirement = element as Requirement
						SystemRequirements.requirements.remove(requirement)
					}
				});
	}

	/**
	 * QuickFix for removing a refined from a goal with cycle dependencies
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the refined goal
	 * issue.getData()[1]: The uri of the refined goal
	 * 
	 */
	@Fix(ReqSpecValidator.CYCLE_IN_GOAL_REFINE_HIERARCHY)
	def public void fixCycleInGoalRefineHierarchy(Issue issue, IssueResolutionAcceptor acceptor) {
		val refinedGoalName = issue.getData().head
		val refinedGoalURI = issue.getData().get(1)

		acceptor.accept(issue, "Remove refines " + refinedGoalName, null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val resourceSet = element.eResource().getResourceSet() 
						val refinedGoal = resourceSet.getEObject(URI.createURI(refinedGoalURI), true) as Goal
						val goal = element as Goal
						goal.refinesReference.remove(refinedGoal)
					}
				});
	}

	/**
	 * QuickFix for removing a refined from a requirement with cycle dependencies
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the refined requirement
	 * issue.getData()[1]: The uri of the refined requirement
	 * 
	 */
	@Fix(ReqSpecValidator.CYCLE_IN_REQUIREMENT_REFINE_HIERARCHY)
	def public void fixCycleInRequiremntRefineHierarchy(Issue issue, IssueResolutionAcceptor acceptor) {
		val refinedReqName = issue.getData().head
		val refinedReqURI = issue.getData().get(1)

		acceptor.accept(issue, "Remove refines " + refinedReqName, null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val resourceSet = element.eResource().getResourceSet() 
						val refinedReq = resourceSet.getEObject(URI.createURI(refinedReqURI), true) as Requirement
						val requirement = element as Requirement
						requirement.refinesReference.remove(refinedReq)
					}
				});
	}
	/**
	 * QuickFix for removing an illegal object from a document section of a reqdoc or goaldoc
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The uri of the containing section
	 * 
	 */
	@Fix(ReqSpecValidator.ILLEGAL_OBJECT_FOR_FILETYPE_IN_DOCUMENTSECTION)
	def public void fixIllegalObjectForFileTypeInDocumentSection(Issue issue, IssueResolutionAcceptor acceptor) {
		val elementType = issue.getData().head
		val sectionURI = issue.getData().get(1)

		acceptor.accept(issue, "Remove " + elementType + " from section.", null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val resourceSet = element.eResource().getResourceSet() as ResourceSet
						val section  = resourceSet.getEObject(URI.createURI(sectionURI), true) as DocumentSection
						val illegalObject = element 
						section.content.remove(illegalObject)
					}
				});
	}

	/**
	 * QuickFix for removing an illegal object in a reqdoc or goaldoc
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The uri of the containing parent
	 * 
	 */
	@Fix(ReqSpecValidator.ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQDOCUMENT)
	def public void fixIllegalObjectForFileTypeInReqDocument(Issue issue, IssueResolutionAcceptor acceptor) {
		val elementType = issue.getData().head
		val reqDocURI = issue.getData().get(1)

		acceptor.accept(issue, "Remove " + elementType + ".", null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val resourceSet = element.eResource().getResourceSet() as ResourceSet
						val reqDoc  = resourceSet.getEObject(URI.createURI(reqDocURI), true) as ReqDocument
						val illegalObject = element 
						reqDoc.content.remove(illegalObject)
					}
				});
	}

	/**
	 * QuickFix for removing an illegal object in a ReqSpec
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The uri of the containing parent
	 * 
	 */
	@Fix(ReqSpecValidator.ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQSPEC)
	def public void fixIllegalObjectForFileTypeInReqSpec(Issue issue, IssueResolutionAcceptor acceptor) {
		val elementType = issue.getData().head
		val reqSpecURI = issue.getData().get(1)

		acceptor.accept(issue, "Remove " + elementType + ".", null, null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						val resourceSet = element.eResource().getResourceSet() as ResourceSet
						val reqSpec  = resourceSet.getEObject(URI.createURI(reqSpecURI), true) as ReqSpec
						val illegalObject = element 
						reqSpec.parts.remove(illegalObject)
					}
				});
	}

//	/**
//	 * QuickFix for removing a duplicated GlobalRequirements
//	 * The issue data array is expected to have two elements:
//	 *
//	 * issue.getData()[0]: The offset of the GlobalRequirements
//	 * issue.getData()[1]: The length of the GlobalRequirements
//	 * 
//	 */
//	@Fix(ReqSpecValidator.DUPLICATE_GLOBALREQUIREMENTS)
//	def public void fixDuplicateReqSpecContainer(Issue issue, IssueResolutionAcceptor acceptor) {
//		val offset = Integer.parseInt(issue.getData().get(0))
//		val length = Integer.parseInt(issue.getData().get(1))
//
//		acceptor.accept(issue, "Remove Global Requirements", null, null, 
//			new IModification() {
//				override public void apply(IModificationContext context) throws Exception {
//					context.getXtextDocument().replace(offset, length, "")
//			}
//		});
//	}


}
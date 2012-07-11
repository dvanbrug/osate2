/*
* /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>

*/
package org.osate.xtext.aadl2.propertyset.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.xtext.aadl2.propertyset.services.PropertysetGrammarAccess;

public class PropertysetParser extends AbstractContentAssistParser {

	@Inject
	private PropertysetGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected org.osate.xtext.aadl2.propertyset.ui.contentassist.antlr.internal.InternalPropertysetParser createParser() {
		org.osate.xtext.aadl2.propertyset.ui.contentassist.antlr.internal.InternalPropertysetParser result = new org.osate.xtext.aadl2.propertyset.ui.contentassist.antlr.internal.InternalPropertysetParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPropertySetAccess().getAlternatives_5(), "rule__PropertySet__Alternatives_5");
					put(grammarAccess.getPropertyTypeAccess().getAlternatives_0(), "rule__PropertyType__Alternatives_0");
					put(grammarAccess.getUnnamedPropertyTypeAccess().getAlternatives(), "rule__UnnamedPropertyType__Alternatives");
					put(grammarAccess.getRealTypeAccess().getAlternatives_5(), "rule__RealType__Alternatives_5");
					put(grammarAccess.getUnnamedRealTypeAccess().getAlternatives_3(), "rule__UnnamedRealType__Alternatives_3");
					put(grammarAccess.getIntegerTypeAccess().getAlternatives_5(), "rule__IntegerType__Alternatives_5");
					put(grammarAccess.getUnnamedIntegerTypeAccess().getAlternatives_3(), "rule__UnnamedIntegerType__Alternatives_3");
					put(grammarAccess.getRangeTypeAccess().getAlternatives_5(), "rule__RangeType__Alternatives_5");
					put(grammarAccess.getRangeTypeAccess().getOwnedNumberTypeAlternatives_5_0_0(), "rule__RangeType__OwnedNumberTypeAlternatives_5_0_0");
					put(grammarAccess.getUnnamedRangeTypeAccess().getAlternatives_3(), "rule__UnnamedRangeType__Alternatives_3");
					put(grammarAccess.getUnnamedRangeTypeAccess().getOwnedNumberTypeAlternatives_3_0_0(), "rule__UnnamedRangeType__OwnedNumberTypeAlternatives_3_0_0");
					put(grammarAccess.getQMReferenceAccess().getMetaclassNameAlternatives_1_0(), "rule__QMReference__MetaclassNameAlternatives_1_0");
					put(grammarAccess.getRecordFieldAccess().getAlternatives_2(), "rule__RecordField__Alternatives_2");
					put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_3(), "rule__PropertyDefinition__Alternatives_3");
					put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_8(), "rule__PropertyDefinition__Alternatives_8");
					put(grammarAccess.getListTypeAccess().getAlternatives_2(), "rule__ListType__Alternatives_2");
					put(grammarAccess.getPropertyOwnerAccess().getAlternatives(), "rule__PropertyOwner__Alternatives");
					put(grammarAccess.getPropertyConstantAccess().getAlternatives_3(), "rule__PropertyConstant__Alternatives_3");
					put(grammarAccess.getNumberValueAccess().getAlternatives(), "rule__NumberValue__Alternatives");
					put(grammarAccess.getConstantPropertyExpressionAccess().getAlternatives(), "rule__ConstantPropertyExpression__Alternatives");
					put(grammarAccess.getIntegerRangeAccess().getLowerBoundAlternatives_0_0(), "rule__IntegerRange__LowerBoundAlternatives_0_0");
					put(grammarAccess.getIntegerRangeAccess().getUpperBoundAlternatives_2_0(), "rule__IntegerRange__UpperBoundAlternatives_2_0");
					put(grammarAccess.getRealRangeAccess().getLowerBoundAlternatives_0_0(), "rule__RealRange__LowerBoundAlternatives_0_0");
					put(grammarAccess.getRealRangeAccess().getUpperBoundAlternatives_2_0(), "rule__RealRange__UpperBoundAlternatives_2_0");
					put(grammarAccess.getCoreKeyWordAccess().getAlternatives(), "rule__CoreKeyWord__Alternatives");
					put(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1(), "rule__ContainedPropertyAssociation__Alternatives_1");
					put(grammarAccess.getPropertyAssociationAccess().getAlternatives_1(), "rule__PropertyAssociation__Alternatives_1");
					put(grammarAccess.getPropertyExpressionAccess().getAlternatives(), "rule__PropertyExpression__Alternatives");
					put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
					put(grammarAccess.getContainmentPathElementAccess().getAlternatives(), "rule__ContainmentPathElement__Alternatives");
					put(grammarAccess.getPlusMinusAccess().getAlternatives(), "rule__PlusMinus__Alternatives");
					put(grammarAccess.getSignedIntAccess().getAlternatives_0(), "rule__SignedInt__Alternatives_0");
					put(grammarAccess.getSignedRealAccess().getAlternatives_0(), "rule__SignedReal__Alternatives_0");
					put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
					put(grammarAccess.getPropertySetAccess().getGroup(), "rule__PropertySet__Group__0");
					put(grammarAccess.getPropertySetAccess().getGroup_4(), "rule__PropertySet__Group_4__0");
					put(grammarAccess.getPropertySetAccess().getGroup_4_2(), "rule__PropertySet__Group_4_2__0");
					put(grammarAccess.getPropertyTypeAccess().getGroup(), "rule__PropertyType__Group__0");
					put(grammarAccess.getBooleanTypeAccess().getGroup(), "rule__BooleanType__Group__0");
					put(grammarAccess.getUnnamedBooleanTypeAccess().getGroup(), "rule__UnnamedBooleanType__Group__0");
					put(grammarAccess.getStringTypeAccess().getGroup(), "rule__StringType__Group__0");
					put(grammarAccess.getUnnamedStringTypeAccess().getGroup(), "rule__UnnamedStringType__Group__0");
					put(grammarAccess.getEnumerationTypeAccess().getGroup(), "rule__EnumerationType__Group__0");
					put(grammarAccess.getEnumerationTypeAccess().getGroup_6(), "rule__EnumerationType__Group_6__0");
					put(grammarAccess.getUnnamedEnumerationTypeAccess().getGroup(), "rule__UnnamedEnumerationType__Group__0");
					put(grammarAccess.getUnnamedEnumerationTypeAccess().getGroup_3(), "rule__UnnamedEnumerationType__Group_3__0");
					put(grammarAccess.getUnitsTypeAccess().getGroup(), "rule__UnitsType__Group__0");
					put(grammarAccess.getUnitsTypeAccess().getGroup_6(), "rule__UnitsType__Group_6__0");
					put(grammarAccess.getUnnamedUnitsTypeAccess().getGroup(), "rule__UnnamedUnitsType__Group__0");
					put(grammarAccess.getUnnamedUnitsTypeAccess().getGroup_3(), "rule__UnnamedUnitsType__Group_3__0");
					put(grammarAccess.getUnitLiteralConversionAccess().getGroup(), "rule__UnitLiteralConversion__Group__0");
					put(grammarAccess.getRealTypeAccess().getGroup(), "rule__RealType__Group__0");
					put(grammarAccess.getRealTypeAccess().getGroup_5_1(), "rule__RealType__Group_5_1__0");
					put(grammarAccess.getUnnamedRealTypeAccess().getGroup(), "rule__UnnamedRealType__Group__0");
					put(grammarAccess.getUnnamedRealTypeAccess().getGroup_3_1(), "rule__UnnamedRealType__Group_3_1__0");
					put(grammarAccess.getIntegerTypeAccess().getGroup(), "rule__IntegerType__Group__0");
					put(grammarAccess.getIntegerTypeAccess().getGroup_5_1(), "rule__IntegerType__Group_5_1__0");
					put(grammarAccess.getUnnamedIntegerTypeAccess().getGroup(), "rule__UnnamedIntegerType__Group__0");
					put(grammarAccess.getUnnamedIntegerTypeAccess().getGroup_3_1(), "rule__UnnamedIntegerType__Group_3_1__0");
					put(grammarAccess.getRangeTypeAccess().getGroup(), "rule__RangeType__Group__0");
					put(grammarAccess.getUnnamedRangeTypeAccess().getGroup(), "rule__UnnamedRangeType__Group__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup(), "rule__ClassifierType__Group__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup_4(), "rule__ClassifierType__Group_4__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup_4_2(), "rule__ClassifierType__Group_4_2__0");
					put(grammarAccess.getUnnamedClassifierTypeAccess().getGroup(), "rule__UnnamedClassifierType__Group__0");
					put(grammarAccess.getUnnamedClassifierTypeAccess().getGroup_2(), "rule__UnnamedClassifierType__Group_2__0");
					put(grammarAccess.getUnnamedClassifierTypeAccess().getGroup_2_2(), "rule__UnnamedClassifierType__Group_2_2__0");
					put(grammarAccess.getQMReferenceAccess().getGroup(), "rule__QMReference__Group__0");
					put(grammarAccess.getQMReferenceAccess().getGroup_0(), "rule__QMReference__Group_0__0");
					put(grammarAccess.getReferenceTypeAccess().getGroup(), "rule__ReferenceType__Group__0");
					put(grammarAccess.getReferenceTypeAccess().getGroup_4(), "rule__ReferenceType__Group_4__0");
					put(grammarAccess.getReferenceTypeAccess().getGroup_4_2(), "rule__ReferenceType__Group_4_2__0");
					put(grammarAccess.getUnnamedReferenceTypeAccess().getGroup(), "rule__UnnamedReferenceType__Group__0");
					put(grammarAccess.getUnnamedReferenceTypeAccess().getGroup_2(), "rule__UnnamedReferenceType__Group_2__0");
					put(grammarAccess.getUnnamedReferenceTypeAccess().getGroup_2_2(), "rule__UnnamedReferenceType__Group_2_2__0");
					put(grammarAccess.getRecordTypeAccess().getGroup(), "rule__RecordType__Group__0");
					put(grammarAccess.getUnnamedRecordTypeAccess().getGroup(), "rule__UnnamedRecordType__Group__0");
					put(grammarAccess.getRecordFieldAccess().getGroup(), "rule__RecordField__Group__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup(), "rule__PropertyDefinition__Group__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_4(), "rule__PropertyDefinition__Group_4__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_8_0(), "rule__PropertyDefinition__Group_8_0__0");
					put(grammarAccess.getPropertyDefinitionAccess().getGroup_8_0_1(), "rule__PropertyDefinition__Group_8_0_1__0");
					put(grammarAccess.getListTypeAccess().getGroup(), "rule__ListType__Group__0");
					put(grammarAccess.getPropertyConstantAccess().getGroup(), "rule__PropertyConstant__Group__0");
					put(grammarAccess.getIntegerRangeAccess().getGroup(), "rule__IntegerRange__Group__0");
					put(grammarAccess.getRealRangeAccess().getGroup(), "rule__RealRange__Group__0");
					put(grammarAccess.getFQCREFAccess().getGroup(), "rule__FQCREF__Group__0");
					put(grammarAccess.getFQCREFAccess().getGroup_0(), "rule__FQCREF__Group_0__0");
					put(grammarAccess.getFQCREFAccess().getGroup_2(), "rule__FQCREF__Group_2__0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getGroup(), "rule__ContainedPropertyAssociation__Group__0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3(), "rule__ContainedPropertyAssociation__Group_3__0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1(), "rule__ContainedPropertyAssociation__Group_3_1__0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4(), "rule__ContainedPropertyAssociation__Group_4__0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_3(), "rule__ContainedPropertyAssociation__Group_4_3__0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5(), "rule__ContainedPropertyAssociation__Group_5__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup(), "rule__PropertyAssociation__Group__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup_3(), "rule__PropertyAssociation__Group_3__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1(), "rule__PropertyAssociation__Group_3_1__0");
					put(grammarAccess.getPropertyAssociationAccess().getGroup_4(), "rule__PropertyAssociation__Group_4__0");
					put(grammarAccess.getBasicPropertyAssociationAccess().getGroup(), "rule__BasicPropertyAssociation__Group__0");
					put(grammarAccess.getContainmentPathAccess().getGroup(), "rule__ContainmentPath__Group__0");
					put(grammarAccess.getContainmentPathAccess().getGroup_2(), "rule__ContainmentPath__Group_2__0");
					put(grammarAccess.getModalPropertyValueAccess().getGroup(), "rule__ModalPropertyValue__Group__0");
					put(grammarAccess.getModalPropertyValueAccess().getGroup_5(), "rule__ModalPropertyValue__Group_5__0");
					put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup(), "rule__OptionalModalPropertyValue__Group__0");
					put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1(), "rule__OptionalModalPropertyValue__Group_1__0");
					put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_4(), "rule__OptionalModalPropertyValue__Group_1_4__0");
					put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
					put(grammarAccess.getReferenceTermAccess().getGroup(), "rule__ReferenceTerm__Group__0");
					put(grammarAccess.getReferenceTermAccess().getGroup_3(), "rule__ReferenceTerm__Group_3__0");
					put(grammarAccess.getRecordTermAccess().getGroup(), "rule__RecordTerm__Group__0");
					put(grammarAccess.getOldRecordTermAccess().getGroup(), "rule__OldRecordTerm__Group__0");
					put(grammarAccess.getComputedTermAccess().getGroup(), "rule__ComputedTerm__Group__0");
					put(grammarAccess.getComponentClassifierTermAccess().getGroup(), "rule__ComponentClassifierTerm__Group__0");
					put(grammarAccess.getListTermAccess().getGroup(), "rule__ListTerm__Group__0");
					put(grammarAccess.getListTermAccess().getGroup_2(), "rule__ListTerm__Group_2__0");
					put(grammarAccess.getFieldPropertyAssociationAccess().getGroup(), "rule__FieldPropertyAssociation__Group__0");
					put(grammarAccess.getContainmentPathElementAccess().getGroup_0(), "rule__ContainmentPathElement__Group_0__0");
					put(grammarAccess.getContainmentPathElementAccess().getGroup_1(), "rule__ContainmentPathElement__Group_1__0");
					put(grammarAccess.getANNEXREFAccess().getGroup(), "rule__ANNEXREF__Group__0");
					put(grammarAccess.getArrayRangeAccess().getGroup(), "rule__ArrayRange__Group__0");
					put(grammarAccess.getArrayRangeAccess().getGroup_3(), "rule__ArrayRange__Group_3__0");
					put(grammarAccess.getSignedConstantAccess().getGroup(), "rule__SignedConstant__Group__0");
					put(grammarAccess.getIntegerTermAccess().getGroup(), "rule__IntegerTerm__Group__0");
					put(grammarAccess.getSignedIntAccess().getGroup(), "rule__SignedInt__Group__0");
					put(grammarAccess.getRealTermAccess().getGroup(), "rule__RealTerm__Group__0");
					put(grammarAccess.getSignedRealAccess().getGroup(), "rule__SignedReal__Group__0");
					put(grammarAccess.getNumericRangeTermAccess().getGroup(), "rule__NumericRangeTerm__Group__0");
					put(grammarAccess.getNumericRangeTermAccess().getGroup_3(), "rule__NumericRangeTerm__Group_3__0");
					put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
					put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
					put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
					put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
					put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
					put(grammarAccess.getPropertySetAccess().getNameAssignment_2(), "rule__PropertySet__NameAssignment_2");
					put(grammarAccess.getPropertySetAccess().getImportedUnitAssignment_4_1(), "rule__PropertySet__ImportedUnitAssignment_4_1");
					put(grammarAccess.getPropertySetAccess().getImportedUnitAssignment_4_2_1(), "rule__PropertySet__ImportedUnitAssignment_4_2_1");
					put(grammarAccess.getPropertySetAccess().getOwnedPropertyTypeAssignment_5_0(), "rule__PropertySet__OwnedPropertyTypeAssignment_5_0");
					put(grammarAccess.getPropertySetAccess().getOwnedPropertyAssignment_5_1(), "rule__PropertySet__OwnedPropertyAssignment_5_1");
					put(grammarAccess.getPropertySetAccess().getOwnedPropertyConstantAssignment_5_2(), "rule__PropertySet__OwnedPropertyConstantAssignment_5_2");
					put(grammarAccess.getBooleanTypeAccess().getNameAssignment_0(), "rule__BooleanType__NameAssignment_0");
					put(grammarAccess.getStringTypeAccess().getNameAssignment_0(), "rule__StringType__NameAssignment_0");
					put(grammarAccess.getEnumerationTypeAccess().getNameAssignment_0(), "rule__EnumerationType__NameAssignment_0");
					put(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralAssignment_5(), "rule__EnumerationType__OwnedLiteralAssignment_5");
					put(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralAssignment_6_1(), "rule__EnumerationType__OwnedLiteralAssignment_6_1");
					put(grammarAccess.getUnnamedEnumerationTypeAccess().getOwnedLiteralAssignment_2(), "rule__UnnamedEnumerationType__OwnedLiteralAssignment_2");
					put(grammarAccess.getUnnamedEnumerationTypeAccess().getOwnedLiteralAssignment_3_1(), "rule__UnnamedEnumerationType__OwnedLiteralAssignment_3_1");
					put(grammarAccess.getEnumerationLiteralAccess().getNameAssignment(), "rule__EnumerationLiteral__NameAssignment");
					put(grammarAccess.getUnitsTypeAccess().getNameAssignment_0(), "rule__UnitsType__NameAssignment_0");
					put(grammarAccess.getUnitsTypeAccess().getOwnedLiteralAssignment_5(), "rule__UnitsType__OwnedLiteralAssignment_5");
					put(grammarAccess.getUnitsTypeAccess().getOwnedLiteralAssignment_6_1(), "rule__UnitsType__OwnedLiteralAssignment_6_1");
					put(grammarAccess.getUnnamedUnitsTypeAccess().getOwnedLiteralAssignment_2(), "rule__UnnamedUnitsType__OwnedLiteralAssignment_2");
					put(grammarAccess.getUnnamedUnitsTypeAccess().getOwnedLiteralAssignment_3_1(), "rule__UnnamedUnitsType__OwnedLiteralAssignment_3_1");
					put(grammarAccess.getUnitLiteralAccess().getNameAssignment(), "rule__UnitLiteral__NameAssignment");
					put(grammarAccess.getUnitLiteralConversionAccess().getNameAssignment_0(), "rule__UnitLiteralConversion__NameAssignment_0");
					put(grammarAccess.getUnitLiteralConversionAccess().getBaseUnitAssignment_2(), "rule__UnitLiteralConversion__BaseUnitAssignment_2");
					put(grammarAccess.getUnitLiteralConversionAccess().getFactorAssignment_4(), "rule__UnitLiteralConversion__FactorAssignment_4");
					put(grammarAccess.getRealTypeAccess().getNameAssignment_0(), "rule__RealType__NameAssignment_0");
					put(grammarAccess.getRealTypeAccess().getRangeAssignment_4(), "rule__RealType__RangeAssignment_4");
					put(grammarAccess.getRealTypeAccess().getOwnedUnitsTypeAssignment_5_0(), "rule__RealType__OwnedUnitsTypeAssignment_5_0");
					put(grammarAccess.getRealTypeAccess().getUnitsTypeAssignment_5_1_1(), "rule__RealType__UnitsTypeAssignment_5_1_1");
					put(grammarAccess.getUnnamedRealTypeAccess().getRangeAssignment_2(), "rule__UnnamedRealType__RangeAssignment_2");
					put(grammarAccess.getUnnamedRealTypeAccess().getOwnedUnitsTypeAssignment_3_0(), "rule__UnnamedRealType__OwnedUnitsTypeAssignment_3_0");
					put(grammarAccess.getUnnamedRealTypeAccess().getUnitsTypeAssignment_3_1_1(), "rule__UnnamedRealType__UnitsTypeAssignment_3_1_1");
					put(grammarAccess.getIntegerTypeAccess().getNameAssignment_0(), "rule__IntegerType__NameAssignment_0");
					put(grammarAccess.getIntegerTypeAccess().getRangeAssignment_4(), "rule__IntegerType__RangeAssignment_4");
					put(grammarAccess.getIntegerTypeAccess().getOwnedUnitsTypeAssignment_5_0(), "rule__IntegerType__OwnedUnitsTypeAssignment_5_0");
					put(grammarAccess.getIntegerTypeAccess().getUnitsTypeAssignment_5_1_1(), "rule__IntegerType__UnitsTypeAssignment_5_1_1");
					put(grammarAccess.getUnnamedIntegerTypeAccess().getRangeAssignment_2(), "rule__UnnamedIntegerType__RangeAssignment_2");
					put(grammarAccess.getUnnamedIntegerTypeAccess().getOwnedUnitsTypeAssignment_3_0(), "rule__UnnamedIntegerType__OwnedUnitsTypeAssignment_3_0");
					put(grammarAccess.getUnnamedIntegerTypeAccess().getUnitsTypeAssignment_3_1_1(), "rule__UnnamedIntegerType__UnitsTypeAssignment_3_1_1");
					put(grammarAccess.getRangeTypeAccess().getNameAssignment_0(), "rule__RangeType__NameAssignment_0");
					put(grammarAccess.getRangeTypeAccess().getOwnedNumberTypeAssignment_5_0(), "rule__RangeType__OwnedNumberTypeAssignment_5_0");
					put(grammarAccess.getRangeTypeAccess().getNumberTypeAssignment_5_1(), "rule__RangeType__NumberTypeAssignment_5_1");
					put(grammarAccess.getUnnamedRangeTypeAccess().getOwnedNumberTypeAssignment_3_0(), "rule__UnnamedRangeType__OwnedNumberTypeAssignment_3_0");
					put(grammarAccess.getUnnamedRangeTypeAccess().getNumberTypeAssignment_3_1(), "rule__UnnamedRangeType__NumberTypeAssignment_3_1");
					put(grammarAccess.getClassifierTypeAccess().getNameAssignment_0(), "rule__ClassifierType__NameAssignment_0");
					put(grammarAccess.getClassifierTypeAccess().getClassifierReferenceAssignment_4_1(), "rule__ClassifierType__ClassifierReferenceAssignment_4_1");
					put(grammarAccess.getClassifierTypeAccess().getClassifierReferenceAssignment_4_2_1(), "rule__ClassifierType__ClassifierReferenceAssignment_4_2_1");
					put(grammarAccess.getUnnamedClassifierTypeAccess().getClassifierReferenceAssignment_2_1(), "rule__UnnamedClassifierType__ClassifierReferenceAssignment_2_1");
					put(grammarAccess.getUnnamedClassifierTypeAccess().getClassifierReferenceAssignment_2_2_1(), "rule__UnnamedClassifierType__ClassifierReferenceAssignment_2_2_1");
					put(grammarAccess.getQMReferenceAccess().getAnnexNameAssignment_0_1(), "rule__QMReference__AnnexNameAssignment_0_1");
					put(grammarAccess.getQMReferenceAccess().getMetaclassNameAssignment_1(), "rule__QMReference__MetaclassNameAssignment_1");
					put(grammarAccess.getQCReferenceAccess().getClassifierAssignment(), "rule__QCReference__ClassifierAssignment");
					put(grammarAccess.getReferenceTypeAccess().getNameAssignment_0(), "rule__ReferenceType__NameAssignment_0");
					put(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceAssignment_4_1(), "rule__ReferenceType__NamedElementReferenceAssignment_4_1");
					put(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceAssignment_4_2_1(), "rule__ReferenceType__NamedElementReferenceAssignment_4_2_1");
					put(grammarAccess.getUnnamedReferenceTypeAccess().getNamedElementReferenceAssignment_2_1(), "rule__UnnamedReferenceType__NamedElementReferenceAssignment_2_1");
					put(grammarAccess.getUnnamedReferenceTypeAccess().getNamedElementReferenceAssignment_2_2_1(), "rule__UnnamedReferenceType__NamedElementReferenceAssignment_2_2_1");
					put(grammarAccess.getRecordTypeAccess().getNameAssignment_0(), "rule__RecordType__NameAssignment_0");
					put(grammarAccess.getRecordTypeAccess().getOwnedFieldAssignment_5(), "rule__RecordType__OwnedFieldAssignment_5");
					put(grammarAccess.getUnnamedRecordTypeAccess().getOwnedFieldAssignment_2(), "rule__UnnamedRecordType__OwnedFieldAssignment_2");
					put(grammarAccess.getRecordFieldAccess().getNameAssignment_0(), "rule__RecordField__NameAssignment_0");
					put(grammarAccess.getRecordFieldAccess().getPropertyTypeAssignment_2_0(), "rule__RecordField__PropertyTypeAssignment_2_0");
					put(grammarAccess.getRecordFieldAccess().getOwnedPropertyTypeAssignment_2_1(), "rule__RecordField__OwnedPropertyTypeAssignment_2_1");
					put(grammarAccess.getPropertyDefinitionAccess().getNameAssignment_0(), "rule__PropertyDefinition__NameAssignment_0");
					put(grammarAccess.getPropertyDefinitionAccess().getInheritAssignment_2(), "rule__PropertyDefinition__InheritAssignment_2");
					put(grammarAccess.getPropertyDefinitionAccess().getPropertyTypeAssignment_3_0(), "rule__PropertyDefinition__PropertyTypeAssignment_3_0");
					put(grammarAccess.getPropertyDefinitionAccess().getOwnedPropertyTypeAssignment_3_1(), "rule__PropertyDefinition__OwnedPropertyTypeAssignment_3_1");
					put(grammarAccess.getPropertyDefinitionAccess().getDefaultValueAssignment_4_1(), "rule__PropertyDefinition__DefaultValueAssignment_4_1");
					put(grammarAccess.getPropertyDefinitionAccess().getAppliesToAssignment_8_0_0(), "rule__PropertyDefinition__AppliesToAssignment_8_0_0");
					put(grammarAccess.getPropertyDefinitionAccess().getAppliesToAssignment_8_0_1_1(), "rule__PropertyDefinition__AppliesToAssignment_8_0_1_1");
					put(grammarAccess.getPropertyDefinitionAccess().getAppliesToAssignment_8_1(), "rule__PropertyDefinition__AppliesToAssignment_8_1");
					put(grammarAccess.getAllReferenceAccess().getMetaclassNameAssignment(), "rule__AllReference__MetaclassNameAssignment");
					put(grammarAccess.getListTypeAccess().getElementTypeAssignment_2_0(), "rule__ListType__ElementTypeAssignment_2_0");
					put(grammarAccess.getListTypeAccess().getOwnedElementTypeAssignment_2_1(), "rule__ListType__OwnedElementTypeAssignment_2_1");
					put(grammarAccess.getPropertyConstantAccess().getNameAssignment_0(), "rule__PropertyConstant__NameAssignment_0");
					put(grammarAccess.getPropertyConstantAccess().getPropertyTypeAssignment_3_0(), "rule__PropertyConstant__PropertyTypeAssignment_3_0");
					put(grammarAccess.getPropertyConstantAccess().getOwnedPropertyTypeAssignment_3_1(), "rule__PropertyConstant__OwnedPropertyTypeAssignment_3_1");
					put(grammarAccess.getPropertyConstantAccess().getConstantValueAssignment_5(), "rule__PropertyConstant__ConstantValueAssignment_5");
					put(grammarAccess.getRealLitAccess().getValueAssignment(), "rule__RealLit__ValueAssignment");
					put(grammarAccess.getIntegerLitAccess().getValueAssignment(), "rule__IntegerLit__ValueAssignment");
					put(grammarAccess.getIntegerRangeAccess().getLowerBoundAssignment_0(), "rule__IntegerRange__LowerBoundAssignment_0");
					put(grammarAccess.getIntegerRangeAccess().getUpperBoundAssignment_2(), "rule__IntegerRange__UpperBoundAssignment_2");
					put(grammarAccess.getRealRangeAccess().getLowerBoundAssignment_0(), "rule__RealRange__LowerBoundAssignment_0");
					put(grammarAccess.getRealRangeAccess().getUpperBoundAssignment_2(), "rule__RealRange__UpperBoundAssignment_2");
					put(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0(), "rule__ContainedPropertyAssociation__PropertyAssignment_0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__ContainedPropertyAssociation__AppendAssignment_1_1");
					put(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2(), "rule__ContainedPropertyAssociation__ConstantAssignment_2");
					put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0");
					put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1");
					put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_2");
					put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_3_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_3_1");
					put(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_3(), "rule__ContainedPropertyAssociation__InBindingAssignment_5_3");
					put(grammarAccess.getPropertyAssociationAccess().getPropertyAssignment_0(), "rule__PropertyAssociation__PropertyAssignment_0");
					put(grammarAccess.getPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__PropertyAssociation__AppendAssignment_1_1");
					put(grammarAccess.getPropertyAssociationAccess().getConstantAssignment_2(), "rule__PropertyAssociation__ConstantAssignment_2");
					put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__PropertyAssociation__OwnedValueAssignment_3_0");
					put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_1");
					put(grammarAccess.getPropertyAssociationAccess().getInBindingAssignment_4_3(), "rule__PropertyAssociation__InBindingAssignment_4_3");
					put(grammarAccess.getBasicPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicPropertyAssociation__PropertyAssignment_0");
					put(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BasicPropertyAssociation__OwnedValueAssignment_2");
					put(grammarAccess.getContainmentPathAccess().getContainmentPathElementAssignment_1(), "rule__ContainmentPath__ContainmentPathElementAssignment_1");
					put(grammarAccess.getContainmentPathAccess().getContainmentPathElementAssignment_2_1(), "rule__ContainmentPath__ContainmentPathElementAssignment_2_1");
					put(grammarAccess.getModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__ModalPropertyValue__OwnedValueAssignment_0");
					put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_4(), "rule__ModalPropertyValue__InModeAssignment_4");
					put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_5_1(), "rule__ModalPropertyValue__InModeAssignment_5_1");
					put(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__OptionalModalPropertyValue__OwnedValueAssignment_0");
					put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3(), "rule__OptionalModalPropertyValue__InModeAssignment_1_3");
					put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_4_1(), "rule__OptionalModalPropertyValue__InModeAssignment_1_4_1");
					put(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment(), "rule__PropertyValue__OwnedValueAssignment");
					put(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment(), "rule__LiteralorReferenceTerm__NamedValueAssignment");
					put(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0(), "rule__BooleanLiteral__ValueAssignment_1_0");
					put(grammarAccess.getConstantValueAccess().getNamedValueAssignment(), "rule__ConstantValue__NamedValueAssignment");
					put(grammarAccess.getReferenceTermAccess().getContainmentPathElementAssignment_2(), "rule__ReferenceTerm__ContainmentPathElementAssignment_2");
					put(grammarAccess.getReferenceTermAccess().getContainmentPathElementAssignment_3_1(), "rule__ReferenceTerm__ContainmentPathElementAssignment_3_1");
					put(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__RecordTerm__OwnedFieldValueAssignment_1");
					put(grammarAccess.getOldRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__OldRecordTerm__OwnedFieldValueAssignment_1");
					put(grammarAccess.getComputedTermAccess().getFunctionAssignment_2(), "rule__ComputedTerm__FunctionAssignment_2");
					put(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2(), "rule__ComponentClassifierTerm__ClassifierAssignment_2");
					put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_1(), "rule__ListTerm__OwnedListElementAssignment_1");
					put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1(), "rule__ListTerm__OwnedListElementAssignment_2_1");
					put(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0(), "rule__FieldPropertyAssociation__PropertyAssignment_0");
					put(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__FieldPropertyAssociation__OwnedValueAssignment_2");
					put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0(), "rule__ContainmentPathElement__NamedElementAssignment_0_0");
					put(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1(), "rule__ContainmentPathElement__ArrayRangeAssignment_0_1");
					put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_1_1(), "rule__ContainmentPathElement__NamedElementAssignment_1_1");
					put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
					put(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2(), "rule__ArrayRange__LowerBoundAssignment_2");
					put(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1(), "rule__ArrayRange__UpperBoundAssignment_3_1");
					put(grammarAccess.getSignedConstantAccess().getOpAssignment_0(), "rule__SignedConstant__OpAssignment_0");
					put(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1(), "rule__SignedConstant__OwnedPropertyExpressionAssignment_1");
					put(grammarAccess.getIntegerTermAccess().getValueAssignment_0(), "rule__IntegerTerm__ValueAssignment_0");
					put(grammarAccess.getIntegerTermAccess().getUnitAssignment_1(), "rule__IntegerTerm__UnitAssignment_1");
					put(grammarAccess.getRealTermAccess().getValueAssignment_0(), "rule__RealTerm__ValueAssignment_0");
					put(grammarAccess.getRealTermAccess().getUnitAssignment_1(), "rule__RealTerm__UnitAssignment_1");
					put(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0(), "rule__NumericRangeTerm__MinimumAssignment_0");
					put(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2(), "rule__NumericRangeTerm__MaximumAssignment_2");
					put(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1(), "rule__NumericRangeTerm__DeltaAssignment_3_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.xtext.aadl2.propertyset.ui.contentassist.antlr.internal.InternalPropertysetParser typedParser = (org.osate.xtext.aadl2.propertyset.ui.contentassist.antlr.internal.InternalPropertysetParser) parser;
			typedParser.entryRulePropertySet();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}

	public PropertysetGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PropertysetGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

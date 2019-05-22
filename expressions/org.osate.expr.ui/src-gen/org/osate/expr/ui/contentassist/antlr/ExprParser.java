/*
 * generated by Xtext
 */
package org.osate.expr.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractPartialContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.expr.services.ExprGrammarAccess;

public class ExprParser extends AbstractPartialContentAssistParser {
	
	@Inject
	private ExprGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.expr.ui.contentassist.antlr.internal.InternalExprParser createParser() {
		org.osate.expr.ui.contentassist.antlr.internal.InternalExprParser result = new org.osate.expr.ui.contentassist.antlr.internal.InternalExprParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getExprModelAccess().getAlternatives(), "rule__ExprModel__Alternatives");
					put(grammarAccess.getDeclarationAccess().getAlternatives(), "rule__Declaration__Alternatives");
					put(grammarAccess.getVarDeclAccess().getAlternatives_0(), "rule__VarDecl__Alternatives_0");
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getPrimitiveTypeAccess().getAlternatives(), "rule__PrimitiveType__Alternatives");
					put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
					put(grammarAccess.getOpOrAccess().getAlternatives(), "rule__OpOr__Alternatives");
					put(grammarAccess.getOpAndAccess().getAlternatives(), "rule__OpAnd__Alternatives");
					put(grammarAccess.getOpEqualityAccess().getAlternatives(), "rule__OpEquality__Alternatives");
					put(grammarAccess.getOpCompareAccess().getAlternatives(), "rule__OpCompare__Alternatives");
					put(grammarAccess.getOpAddAccess().getAlternatives(), "rule__OpAdd__Alternatives");
					put(grammarAccess.getOpMultiAccess().getAlternatives(), "rule__OpMulti__Alternatives");
					put(grammarAccess.getUnaryOperationAccess().getAlternatives(), "rule__UnaryOperation__Alternatives");
					put(grammarAccess.getOpUnaryAccess().getAlternatives(), "rule__OpUnary__Alternatives");
					put(grammarAccess.getUnitExpressionAccess().getAlternatives_1_1(), "rule__UnitExpression__Alternatives_1_1");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getModelOrPropertyReferenceAccess().getAlternatives(), "rule__ModelOrPropertyReference__Alternatives");
					put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
					put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
					put(grammarAccess.getMetaClassEnumAccess().getAlternatives(), "rule__MetaClassEnum__Alternatives");
					put(grammarAccess.getTargetTypeAccess().getAlternatives(), "rule__TargetType__Alternatives");
					put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
					put(grammarAccess.getExprModelAccess().getGroup_0(), "rule__ExprModel__Group_0__0");
					put(grammarAccess.getExprModelAccess().getGroup_1(), "rule__ExprModel__Group_1__0");
					put(grammarAccess.getExprLibraryAccess().getGroup(), "rule__ExprLibrary__Group__0");
					put(grammarAccess.getExprSubclauseAccess().getGroup(), "rule__ExprSubclause__Group__0");
					put(grammarAccess.getTypeDeclAccess().getGroup(), "rule__TypeDecl__Group__0");
					put(grammarAccess.getVarDeclAccess().getGroup(), "rule__VarDecl__Group__0");
					put(grammarAccess.getVarDeclAccess().getGroup_2(), "rule__VarDecl__Group_2__0");
					put(grammarAccess.getVarDeclAccess().getGroup_3(), "rule__VarDecl__Group_3__0");
					put(grammarAccess.getFunDeclAccess().getGroup(), "rule__FunDecl__Group__0");
					put(grammarAccess.getPrimitiveTypeAccess().getGroup_0(), "rule__PrimitiveType__Group_0__0");
					put(grammarAccess.getPrimitiveTypeAccess().getGroup_1(), "rule__PrimitiveType__Group_1__0");
					put(grammarAccess.getPrimitiveTypeAccess().getGroup_2(), "rule__PrimitiveType__Group_2__0");
					put(grammarAccess.getPrimitiveTypeAccess().getGroup_3(), "rule__PrimitiveType__Group_3__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_8(), "rule__ComponentCategory__Group_8__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_10(), "rule__ComponentCategory__Group_10__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_12(), "rule__ComponentCategory__Group_12__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_13(), "rule__ComponentCategory__Group_13__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup(), "rule__ClassifierType__Group__0");
					put(grammarAccess.getClassifierTypeAccess().getGroup_2(), "rule__ClassifierType__Group_2__0");
					put(grammarAccess.getRecordTypeAccess().getGroup(), "rule__RecordType__Group__0");
					put(grammarAccess.getFieldAccess().getGroup(), "rule__Field__Group__0");
					put(grammarAccess.getUnionTypeAccess().getGroup(), "rule__UnionType__Group__0");
					put(grammarAccess.getTupleTypeAccess().getGroup(), "rule__TupleType__Group__0");
					put(grammarAccess.getTupleFieldAccess().getGroup(), "rule__TupleField__Group__0");
					put(grammarAccess.getListTypeAccess().getGroup(), "rule__ListType__Group__0");
					put(grammarAccess.getSetTypeAccess().getGroup(), "rule__SetType__Group__0");
					put(grammarAccess.getBagTypeAccess().getGroup(), "rule__BagType__Group__0");
					put(grammarAccess.getMapTypeAccess().getGroup(), "rule__MapType__Group__0");
					put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
					put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
					put(grammarAccess.getOrExpressionAccess().getGroup_1_0(), "rule__OrExpression__Group_1_0__0");
					put(grammarAccess.getOrExpressionAccess().getGroup_1_0_0(), "rule__OrExpression__Group_1_0_0__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1_0(), "rule__AndExpression__Group_1_0__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1_0_0(), "rule__AndExpression__Group_1_0_0__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_1_0(), "rule__EqualityExpression__Group_1_0__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_1_0_0(), "rule__EqualityExpression__Group_1_0_0__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1_0(), "rule__RelationalExpression__Group_1_0__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1_0_0(), "rule__RelationalExpression__Group_1_0_0__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0(), "rule__AdditiveExpression__Group_1_0__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0_0(), "rule__AdditiveExpression__Group_1_0_0__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0(), "rule__MultiplicativeExpression__Group_1_0__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_0(), "rule__MultiplicativeExpression__Group_1_0_0__0");
					put(grammarAccess.getUnaryOperationAccess().getGroup_0(), "rule__UnaryOperation__Group_0__0");
					put(grammarAccess.getUnitExpressionAccess().getGroup(), "rule__UnitExpression__Group__0");
					put(grammarAccess.getUnitExpressionAccess().getGroup_1(), "rule__UnitExpression__Group_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_6(), "rule__PrimaryExpression__Group_6__0");
					put(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0(), "rule__ModelOrPropertyReference__Group_0__0");
					put(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1(), "rule__ModelOrPropertyReference__Group_0_1__0");
					put(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0(), "rule__ModelOrPropertyReference__Group_0_1_0__0");
					put(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0_0(), "rule__ModelOrPropertyReference__Group_0_1_0_0__0");
					put(grammarAccess.getModelReferenceAccess().getGroup(), "rule__ModelReference__Group__0");
					put(grammarAccess.getModelReferenceAccess().getGroup_1(), "rule__ModelReference__Group_1__0");
					put(grammarAccess.getPropertyReferenceAccess().getGroup(), "rule__PropertyReference__Group__0");
					put(grammarAccess.getFunctionCallAccess().getGroup(), "rule__FunctionCall__Group__0");
					put(grammarAccess.getFunctionCallAccess().getGroup_3(), "rule__FunctionCall__Group_3__0");
					put(grammarAccess.getFunctionCallAccess().getGroup_3_1(), "rule__FunctionCall__Group_3_1__0");
					put(grammarAccess.getRangeExpressionAccess().getGroup(), "rule__RangeExpression__Group__0");
					put(grammarAccess.getRangeExpressionAccess().getGroup_5(), "rule__RangeExpression__Group_5__0");
					put(grammarAccess.getIfExpressionAccess().getGroup(), "rule__IfExpression__Group__0");
					put(grammarAccess.getIfExpressionAccess().getGroup_5(), "rule__IfExpression__Group_5__0");
					put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
					put(grammarAccess.getIntegerLiteralAccess().getGroup(), "rule__IntegerLiteral__Group__0");
					put(grammarAccess.getRealLiteralAccess().getGroup(), "rule__RealLiteral__Group__0");
					put(grammarAccess.getStringLiteralAccess().getGroup(), "rule__StringLiteral__Group__0");
					put(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup(), "rule__CommaSeparatedExpressions__Group__0");
					put(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup_1(), "rule__CommaSeparatedExpressions__Group_1__0");
					put(grammarAccess.getListLiteralAccess().getGroup(), "rule__ListLiteral__Group__0");
					put(grammarAccess.getSetLiteralAccess().getGroup(), "rule__SetLiteral__Group__0");
					put(grammarAccess.getRecordLiteralAccess().getGroup(), "rule__RecordLiteral__Group__0");
					put(grammarAccess.getUnionLiteralAccess().getGroup(), "rule__UnionLiteral__Group__0");
					put(grammarAccess.getTupleLiteralAccess().getGroup(), "rule__TupleLiteral__Group__0");
					put(grammarAccess.getBagLiteralAccess().getGroup(), "rule__BagLiteral__Group__0");
					put(grammarAccess.getMapLiteralAccess().getGroup(), "rule__MapLiteral__Group__0");
					put(grammarAccess.getQCLREFAccess().getGroup(), "rule__QCLREF__Group__0");
					put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
					put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
					put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
					put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
					put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
					put(grammarAccess.getExprModelAccess().getAnnexAssignment_0_1(), "rule__ExprModel__AnnexAssignment_0_1");
					put(grammarAccess.getExprModelAccess().getAnnexAssignment_1_1(), "rule__ExprModel__AnnexAssignment_1_1");
					put(grammarAccess.getExprLibraryAccess().getDeclsAssignment_1(), "rule__ExprLibrary__DeclsAssignment_1");
					put(grammarAccess.getExprSubclauseAccess().getDeclsAssignment_1(), "rule__ExprSubclause__DeclsAssignment_1");
					put(grammarAccess.getTypeDeclAccess().getNameAssignment_1(), "rule__TypeDecl__NameAssignment_1");
					put(grammarAccess.getTypeDeclAccess().getTypeAssignment_3(), "rule__TypeDecl__TypeAssignment_3");
					put(grammarAccess.getVarDeclAccess().getConstAssignment_0_0(), "rule__VarDecl__ConstAssignment_0_0");
					put(grammarAccess.getVarDeclAccess().getNameAssignment_1(), "rule__VarDecl__NameAssignment_1");
					put(grammarAccess.getVarDeclAccess().getTypeAssignment_2_1(), "rule__VarDecl__TypeAssignment_2_1");
					put(grammarAccess.getVarDeclAccess().getValueAssignment_3_1(), "rule__VarDecl__ValueAssignment_3_1");
					put(grammarAccess.getFunDeclAccess().getNameAssignment_1(), "rule__FunDecl__NameAssignment_1");
					put(grammarAccess.getCategoryAccess().getCategoryAssignment(), "rule__Category__CategoryAssignment");
					put(grammarAccess.getMetaClassAccess().getClassAssignment(), "rule__MetaClass__ClassAssignment");
					put(grammarAccess.getClassifierTypeAccess().getBaseAssignment_2_1(), "rule__ClassifierType__BaseAssignment_2_1");
					put(grammarAccess.getRecordTypeAccess().getFieldAssignment_3(), "rule__RecordType__FieldAssignment_3");
					put(grammarAccess.getFieldAccess().getNameAssignment_0(), "rule__Field__NameAssignment_0");
					put(grammarAccess.getFieldAccess().getTypeAssignment_2(), "rule__Field__TypeAssignment_2");
					put(grammarAccess.getTupleTypeAccess().getFieldAssignment_3(), "rule__TupleType__FieldAssignment_3");
					put(grammarAccess.getTupleFieldAccess().getTypeAssignment_1(), "rule__TupleField__TypeAssignment_1");
					put(grammarAccess.getListTypeAccess().getTypeAssignment_3(), "rule__ListType__TypeAssignment_3");
					put(grammarAccess.getSetTypeAccess().getTypeAssignment_2(), "rule__SetType__TypeAssignment_2");
					put(grammarAccess.getBagTypeAccess().getTypeAssignment_2(), "rule__BagType__TypeAssignment_2");
					put(grammarAccess.getMapTypeAccess().getDomAssignment_1(), "rule__MapType__DomAssignment_1");
					put(grammarAccess.getMapTypeAccess().getImgAssignment_3(), "rule__MapType__ImgAssignment_3");
					put(grammarAccess.getTypeRefAccess().getRefAssignment(), "rule__TypeRef__RefAssignment");
					put(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__OrExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getOrExpressionAccess().getRightAssignment_1_1(), "rule__OrExpression__RightAssignment_1_1");
					put(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AndExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAndExpressionAccess().getRightAssignment_1_1(), "rule__AndExpression__RightAssignment_1_1");
					put(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__EqualityExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_1(), "rule__EqualityExpression__RightAssignment_1_1");
					put(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__RelationalExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_1(), "rule__RelationalExpression__RightAssignment_1_1");
					put(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AdditiveExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_1(), "rule__AdditiveExpression__RightAssignment_1_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_1(), "rule__MultiplicativeExpression__RightAssignment_1_1");
					put(grammarAccess.getUnaryOperationAccess().getOperatorAssignment_0_1(), "rule__UnaryOperation__OperatorAssignment_0_1");
					put(grammarAccess.getUnaryOperationAccess().getOperandAssignment_0_2(), "rule__UnaryOperation__OperandAssignment_0_2");
					put(grammarAccess.getUnitExpressionAccess().getConvertAssignment_1_1_0(), "rule__UnitExpression__ConvertAssignment_1_1_0");
					put(grammarAccess.getUnitExpressionAccess().getDropAssignment_1_1_1(), "rule__UnitExpression__DropAssignment_1_1_1");
					put(grammarAccess.getUnitExpressionAccess().getUnitAssignment_1_2(), "rule__UnitExpression__UnitAssignment_1_2");
					put(grammarAccess.getVarRefAccess().getRefAssignment(), "rule__VarRef__RefAssignment");
					put(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1(), "rule__ModelOrPropertyReference__PropertyAssignment_0_1_1");
					put(grammarAccess.getModelReferenceAccess().getModelElementAssignment_0(), "rule__ModelReference__ModelElementAssignment_0");
					put(grammarAccess.getModelReferenceAccess().getModelElementAssignment_1_2(), "rule__ModelReference__ModelElementAssignment_1_2");
					put(grammarAccess.getPropertyReferenceAccess().getPropertyAssignment_2(), "rule__PropertyReference__PropertyAssignment_2");
					put(grammarAccess.getFunctionCallAccess().getFunctionAssignment_1(), "rule__FunctionCall__FunctionAssignment_1");
					put(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_0(), "rule__FunctionCall__ArgumentsAssignment_3_0");
					put(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_1_1(), "rule__FunctionCall__ArgumentsAssignment_3_1_1");
					put(grammarAccess.getRangeExpressionAccess().getMinimumAssignment_2(), "rule__RangeExpression__MinimumAssignment_2");
					put(grammarAccess.getRangeExpressionAccess().getMaximumAssignment_4(), "rule__RangeExpression__MaximumAssignment_4");
					put(grammarAccess.getRangeExpressionAccess().getDeltaAssignment_5_1(), "rule__RangeExpression__DeltaAssignment_5_1");
					put(grammarAccess.getIfExpressionAccess().getIfAssignment_2(), "rule__IfExpression__IfAssignment_2");
					put(grammarAccess.getIfExpressionAccess().getThenAssignment_4(), "rule__IfExpression__ThenAssignment_4");
					put(grammarAccess.getIfExpressionAccess().getElseAssignment_5_1(), "rule__IfExpression__ElseAssignment_5_1");
					put(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0(), "rule__BooleanLiteral__ValueAssignment_1_0");
					put(grammarAccess.getIntegerLiteralAccess().getValueAssignment_1(), "rule__IntegerLiteral__ValueAssignment_1");
					put(grammarAccess.getRealLiteralAccess().getValueAssignment_1(), "rule__RealLiteral__ValueAssignment_1");
					put(grammarAccess.getStringLiteralAccess().getValueAssignment_1(), "rule__StringLiteral__ValueAssignment_1");
					put(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_0(), "rule__CommaSeparatedExpressions__ElementsAssignment_0");
					put(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_1_1(), "rule__CommaSeparatedExpressions__ElementsAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.expr.ui.contentassist.antlr.internal.InternalExprParser typedParser = (org.osate.expr.ui.contentassist.antlr.internal.InternalExprParser) parser;
			typedParser.entryRuleExprModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}
	
	public ExprGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ExprGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

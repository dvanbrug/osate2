
/*
 * generated by Xtext
 */
lexer grammar InternalOrganizationLexer;


@header {
package org.osate.organization.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




Organization : 'organization';

Description : 'description';

Stakeholder : 'stakeholder';

Supervisor : 'supervisor';

Email : 'email';

Phone : 'phone';

Title : 'title';

Full : 'full';

Name : 'name';

Role : 'role';

FullStop : '.';

LeftSquareBracket : '[';

RightSquareBracket : ']';



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;




//parser grammar ExprParser;
//options { tokenVocab=ExprLexer; }

grammar enact;

enact_program: enact_rule+;

enact_rule : y 'enact-as' enact_effect'.';

enact_effect
 	:	pred;


y :	sff_or_expr;
sff_or_expr	:	sff_and_expr (TK_OR sff_or_expr)?;
sff_and_expr	:	sff_rel (TK_AND sff_and_expr)?;	
sff_rel	:		arithm_term((TK_REL_OP|TK_IS) sff_rel)?; 
arithm_term	:	arithm_factor (('+'|'-') arithm_term)?;
arithm_factor	:	sff_atom (('*'|'/'|INTDIV|INTMOD) arithm_factor)?;
//sff_atom	:       NEGATION? ((VAR|pred|sai__is_term)|('('sff_or_expr')')|(DIGIT+));
sff_atom	:       NEGATION? ((VAR|pred)|('('sff_or_expr')')|(DIGIT+));

TK_OR		:	'|';
TK_AND		:	'&';
TK_REL_OP	:	'<' | '<=' | '>' | '>=' | '==' | '\\==' | '=' | '=..';
TK_IS		:	'is';


/*** Template for arithm.expressions ***
arithm_expression	:	arithm_term;
arithm_term		:	arithm_factor (('+'|'-') arithm_term)?;
arithm_factor		:	arithm_atom (('*'|'/'|INTDIV|INTMOD) arithm_factor)?;
arithm_atom		:	VAR|DIGIT+|'('arithm_term')';	//the basic element of arithm.expressions

*/


//sai__is_term:	'sai__is('pred_term','pred_term','y')';

pred	:	//ATOM(list)?;
		//(TK_NEG)?ATOM(list_of_pred_terms)?(list)?;
		ATOM(list_of_pred_terms)?(list)?;
list_of_pred_terms
	:	'('pred_terms')';
pred_terms
	:	pred_term(','pred_term)*;	
pred_term
	:	//VAR|TERM_NULL|STRING|DIGIT+|ATOM(list_of_pred_terms)?|list_of_pred_terms;
	       VAR|TERM_NULL|STRING|DIGIT+|list|ATOM(list_of_pred_terms)?|('('sff_or_expr')');
annotation
	:	list;

// *** List section
list	:	'['list_term(','list_term)*']';
list_term
	:	//pred(','pred)*;	
	(list|arithm_term|STRING);
//*** end of list section/

//Logic expr session	




STRING
	:	//'"'(ATOM|VAR|DIGIT|SPECIAL_CHAR_TERM)+(('/'|' ')(ATOM|VAR|DIGIT|SPECIAL_CHAR_TERM))*'"';	
		'"'('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@'|SPECIAL_CHAR_TERM|' ')*'"';
		
NEGATION 	:	'not';
TK_NEG 	:                     '~';
INTDIV	:	 'div';
INTMOD	:	 'mod';		
ATOM	:	('a'..'z')('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@')*;
VAR	:	('A'..'Z')('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@')*;
//numeral :	DIGIT+;
DIGIT	:	'0'..'9';

TERM_NULL:	'_';

SPECIAL_CHAR_TERM
	:	('-'|'+'|'%'|'*'|'!'|'@'|'#'|'&'|'/'|':'|'.');

COMMENT_STAT
	:	 '/*' (options {greedy=false;} : .)* '*/' //{$channel=HIDDEN;} //<- para antlr3
	//:	'/*' .*? '*/'-> channel(HIDDEN) //<- para antlr4
		;

WS 	:	(' '|'\r'|'\n')+{skip();} ;
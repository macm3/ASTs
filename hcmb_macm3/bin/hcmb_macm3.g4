grammar hcmb_macm3;

type:	 		'int''['']'
			|	'boolean'
			|	'int'
			|	identifier;
			
identifier: IDENTIFIER;

formal: type identifier;

varDecl: formal';' ;

methodDecl: 'public' formal '(' (formal(','formal)*)?')' '{' (varDecl)* (statement)* 'return' expression ';' '}';

main: 'class' identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{' statement '}' '}';

classDecl: 'class' identifier ('extends' identifier)? '{' (varDecl)* (methodDecl)* '}';

goal: main (classDecl)* EOF;

statement:		'{' (statement)* '}'
			|	'if' '(' expression ')' statement 'else' statement
			|	'while' '(' expression ')' statement
			|	'System.out.println' '(' expression ')' ';'
			|	identifier '=' expression ';'
			|	identifier '[' expression ']' '=' expression ';';		
			
expression: 	expression('&&'|'+'|'-'|'*'|'<')expression
			|	expression'['expression']'
			|	expression'.''length'
			|	expression'.'identifier'('(expression(','expression)*)?')'
			|	INTEGERLITERAL
			|	'true'
			|	'false'
			|	identifier
			|	'this'
			|	'new''int''['expression']'
			|	'new'identifier'('')'
			|	'!'expression
			|	'('expression')';






IDENTIFIER:('_'|[A-za-z])((([A-Za-z]|[0-9]|'_')+)*);
INTEGERLITERAL:([1-9][0-9]*)|'0';
SPACES:('\n'|' '|'\r'|'\t')->skip;
COMMENT_LINE: '//'(~[\n\r])* ->skip;

MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;
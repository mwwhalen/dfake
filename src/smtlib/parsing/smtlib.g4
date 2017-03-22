grammar smtlib;

program: (sexpr)* EOF; 

toplevel: sexpr                        # tl
   ;

sexpr:  spec_constant                  # sConstant
      | symbol                         # sym
      | keyword                        # kw
      | '(' (sexpr)* ')'               # cons 
      ;

spec_constant :   NUMERAL               # numeralConstant
                | REAL                  # realConstant
                | HEX                   # hexConstant 
                | BIN                   # binConstant
                | STRING                # stringConstant
                ; 

symbol: SIMPLE_SYMBOL | QUOTED_SYMBOL ; 
keyword: ':' SIMPLE_SYMBOL ; 

REAL: NUMERAL '.' NUMERAL;

NUMERAL: [0-9]+;
HEX: '#x'[0-9A-Fa-f]+;
BIN: '#b'[0-1]+;
// ID: [a-zA-Z_~][a-zA-Z_0-9~]*;
// ~ is used internally. Users should not use it.
// come back to this to add all allowed symbols...need to figure out how to get ANTLR 
// to recognize symbols like ! and *
SIMPLE_SYMBOL: SYMBOL_CHAR SYMBOL_OR_NUM_CHAR*;
SYMBOL_CHAR: ('a'..'z' | 'A'..'Z' | '_' | '~' | '-' | '\\' | '!' | '@' | '$' | '%' | '^' | '&' | '*' | '+' | '=' | '<' | '>' | '.' | '?' | '/' );
SYMBOL_OR_NUM_CHAR: (SYMBOL_CHAR | '0'..'9');

QUOTED_SYMBOL: '|' (~'|'.*?) '|';
STRING: '"' ('""' | .)*? '"';
WS: [ \t\n\r\f]+ -> skip;
COMMENT: ';' (~[%\n\r] ~[\n\r]* | /* empty */) ('\r'? '\n')? -> skip; 
// SL_COMMENT: '--' (~[%\n\r] ~[\n\r]* | /* empty */) ('\r'? '\n')? -> skip;
// ML_COMMENT: '(*' .*? '*)' -> skip;

ERROR: .;

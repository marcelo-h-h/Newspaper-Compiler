grammar NDL;

@header {
  package org.ndlang;
}

//Regras Sintáticas

newspaper
  : config header body;

config
  : 'options' '(' 'default' options (IDENT options)* ')';

options
  : '(' option* ')';

option
  : 'font' '(' (INT|IDENT|STR)* ')'
  | 'format' '(' STR ')';

header
  : 'header' '(' 'name' STR 'date' INT INT INT 'city' STR 'state' STR ')';

body
  : row* ;

row
  : 'row' '(' col (col)? (col)? (col)? ')';

col
  : ('col-full'|'col-half'|'col-quarter') '(' (row|article) ')';

article
  : 'article' '(' 'title' STR 'description' STR 'author' STR 'content' content ')';

content
  : 'text' '(' (paragraph|image)+ ')';

paragraph
  : 'paragraph' STR
  | 'image' path=STR legend=STR;

// REGRAS LÉXICAS

INT
  : DIGIT+;

IDENT
  : [a-zA-Z_]+;

STR
  : '"' (~('"'|'\\"'))* '"';

fragment DIGIT
    : [0-9];

WS
  : ([ \n\r\t]+ | EOF) -> channel(HIDDEN);

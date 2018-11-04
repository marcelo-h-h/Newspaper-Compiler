grammar NDL;

@header {
  package org.ndlang;
}

//Regras Sintáticas

newspaper
  : 'programa' config? header body;

config
  : 'options' '(' 'default' optionsr (IDENT optionsr)* ')';

optionsr
  : '(' option* ')';

option
  : 'font' '(' (INT|IDENT|STR)* ')'
  | 'format' '(' STR ')';

header
  : 'header' '(' 'name' name=STR 'date' date1=INT date2=INT date3=INT 'city' city=STR 'state' state=STR ')';

body
  : row+ ;

row
  : 'row' '(' col{1,4} ')';

col
  : ('col-full'|'col-half'|'col-quarter') '(' article ')';

article
  : 'article' '(' 'title' STR 'description' STR 'author' STR 'content' content ')';

content
  : 'text' '(' (paragraph)+ ')';

paragraph
  : 'paragraph' STR
  | 'image' path=STR legend=STR;

// REGRAS LÉXICAS

INT
  : DIGIT+;

IDENT
  : [a-zA-Z_]+;

STR
  : '"' (~('"')|'\\"')* '"';

fragment DIGIT
    : [0-9];

WS
  : ([ \n\r\t]+ | EOF) -> channel(HIDDEN);

grammar NDL;

@header {
  package org.ndlang;
}

//Regras Sintáticas

newspaper
  : config? header body;

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
  : 'row' '(' first=col second=col? third=col? fourth=col? ')';

col
  : ('col-full'|'col-half'|'col-quarter') '(' article ')';

article
  : 'article' '(' 'title' title=STR 'description' description=STR 'author' author=STR 'content' content ')';

content
  : '(' (paragraph)+ ')';

paragraph
  : 'paragraph' lparagraph+=STR+
  | 'image' path=STR description=STR;

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

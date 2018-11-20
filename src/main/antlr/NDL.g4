grammar NDL;

@header {
  package org.ndlang;
}

//Regras Sintáticas

newspaper
  : header body;

header
  : 'header' '(' 'name' name=STR 'date' date1=INT date2=INT date3=INT 'city' city=STR 'state' state=STR highlights? ')';

highlights
  : 'highlights' '(' (ids+=STR)+ ')';

body
  : (rows+=row)+ ;

row
  : 'row' '(' (cols+=col)+ ')';

col
  : colType=('col-full'|'col-half'|'col-quarter') '(' article ')';

article
  : 'article' '(' 'id' id=STR 'title' title=STR 'description' description=STR 'author' author=STR 'content' content ')';

content
  : '(' (paragraph)+ ')';

paragraph
  : 'paragraph' lparagraph+=STR+
  | 'image' path=STR description+=STR+;

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

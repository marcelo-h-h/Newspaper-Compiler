grammar NDL;

@header {
  package org.ndllang;
}

//Regras Sintáticas

newspaper
  : setup header 'news' body 'end news';

setup
  : '(' default name date header (image)? ')';

default
  : font;

name
  : font;

date
  : 'format' '(' DATE ')';

header
  : 'format' '(' HEADER_FORMAT ')';

image
  : 'image' URL ALT_TEXT;

font
  : 'font' '(' SIZE (STYLE)? FONTS ')';

body
  : (news_body)* ;

news_body
  : news_head news_row;

news_head
  : 'name' NEWS_NAME 'date' DATE ('local' NEWS_LOCAL);

news_row
  : (article)+ ;

article
  : 'title' ART_TITLE 'description' ART_DESC 'author' ART_AUTH content;

content
  : (paragraph | image | URL)+;

paragraph
  : TEXT_STRING;

// REGRAS LÉXICAS

SIZE
  :  DIGIT+;

FONTS
  :  [a-zA-Z_]+;

STYLE
  :  [a-zA-Z_]+;

DATE
  :  DIGIT{2} '/' DIGIT{2} '/' DIGIT{4};

fragment DIGIT
    : [0-9];

WS
  : ([ \n\r\t]+ | EOF) -> channel(HIDDEN);

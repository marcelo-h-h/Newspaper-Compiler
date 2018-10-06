grammar NDL;

@header {
  package org.ndllang;
}

//Regras Sintáticas

newspaper
  : setup header 'news' body 'end news';

WS
  : ([ \n\r\t]+ | EOF) -> channel(HIDDEN);

setup
  : '(' default name date header (image)? ')';

default
  : 'font' '(' SIZE FONTS ')';

name 
  : 'font' '(' SIZE (STYLE)? FONTS ')';

date
  : 'format' '(' DATE_FORMAT ')';

header
  : 'format' '(' HEADER_FORMAT ')';

image
  : 'url' '(' IMAGE_URL ')' WS 'format' '(' IMAGE_FORMAT ')';

body
  : (news_body)* ;

news_body
  : news_head news_row;

news_head
  : 'name' NEWS_NAME 'date' NEWS_DATE ('local' NEWS_LOCAL);

news_row
  : (article)+ ;

article
  : 'title' ART_TITLE 'description' ART_DESC 'author' ART_AUTH content;

content
  : (paragraph | image | link)+;

paragraph
  : TEXT_STRING;

link
  : URL;
grammar NDL;

@header {
  package org.ndllang;
}

//Regras Sintáticas

programa
  : 'programa';

WS
  : ([ \n\r\t]+ | EOF) -> channel(HIDDEN);

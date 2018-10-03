package org.ndllang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

class NDLGeracao extends NDLBaseVisitor<String> {
  private StringBuffer out;

  public NDLGeracao(StringBuffer out) {
    this.out = out;
  }

  @Override
  public String visitPrograma(NDLParser.ProgramaContext ctx) {
    this.out.append("<html>\n");
    this.out.append("</html>\n");

    return null;
  }
}

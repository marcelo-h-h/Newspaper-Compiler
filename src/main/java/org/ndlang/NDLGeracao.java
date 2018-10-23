package org.ndlang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

class NDLGeracao extends NDLBaseVisitor<String> {
  private StringBuffer out;

  public NDLGeracao(StringBuffer out) {
    this.out = out;
  }

  @Override
  public String visitNewspaper(NDLParser.NewspaperContext ctx) {
    this.out.append("<html>\n");
    this.visitChildren(ctx);
    this.out.append("</html>\n");

    return null;
  }
  
  @Override
  public String visitRow(NDLParser.RowContext ctx) {
    this.out.append("<div class=\"row\">\n");
    this.out.append("</div>\n");

    return null;
  }
}

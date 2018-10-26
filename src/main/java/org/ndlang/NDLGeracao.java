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
    this.out.append("<!DOCTYPE html>\n<meta charset=\"UTF-8\">\n<html>\n<head>\n");
    this.out.append("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
    this.out.append("</head>\n");
    this.out.append("<body>\n");
    this.visitChildren(ctx);
    this.out.append("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
    this.out.append("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
    this.out.append("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
    this.out.append("</body>\n");
    this.out.append("</html>\n");

    return null;
  }

  // @Override
  // public String visitHeader(NDLParser.HeaderContext ctx) {
  //   this.out.append("<div class=container")
  // }
  
  @Override
  public String visitRow(NDLParser.RowContext ctx) {
    this.out.append("<div class=\"row\">\n");
    this.out.append("</div>\n");

    return null;
  }
}

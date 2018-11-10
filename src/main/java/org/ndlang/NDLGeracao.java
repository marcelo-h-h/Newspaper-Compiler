package org.ndlang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

class NDLGeracao extends NDLBaseVisitor<String> {
  private StringBuffer out;
  private StringBuffer error;

  public NDLGeracao(StringBuffer out, StringBuffer error) {
    this.out = out;
    this.error = error;
  }

  private void logError(String error) {
    if(this.error.length() > 0) {
      this.error.append("\n");
    }
    this.error.append(error);
  }

  @Override
  public String visitNewspaper(NDLParser.NewspaperContext ctx) {
    this.out.append("<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n");
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

  @Override
  public String visitHeader(NDLParser.HeaderContext ctx) {
    this.out.append("<div class=\"jumbotron no-margin\">\n\t");
    this.out.append("<div class=\"container-fluid\">\n\t\t");
    this.out.append("<h1 style=\"text-align: center;\">\n\t\t\t");
    this.out.append(ctx.name.getText().replace("\"", "") + "\n");
    this.out.append("\t\t</h1>\n");
    this.out.append("\t\t<hr style=\"border-top: 3px double #8c8b8b\">\n");
    this.out.append("\t</div>\n");
    this.out.append("<div class=\"row\">\n");
    this.out.append("\t<div class=\"col-sm-4 \"></div>\n");
    this.out.append("\t<div class=\"col-sm-4 text-center\">");
    this.out.append("");
    this.out.append(" " + ctx.date1.getText() + "/" + ctx.date2.getText() + "/" + ctx.date3.getText() + " ");
    this.out.append("\t</div>\n\t<div class=\"col-sm-4 text-center\">");
    this.out.append(ctx.city.getText().replace("\"", "") + ", " + ctx.state.getText().replace("\"", ""));
    this.out.append("\t</div>\n");
    this.out.append("</div>\n");
    this.out.append("\t<hr style=\"border-top: 3px double #8c8b8b\">\n");
    this.out.append("\n\t</div>\n");
    
    return null;
  }

  @Override
  public String visitBody(NDLParser.BodyContext ctx) {
    this.out.append("<div class=\"container-fluid\">\n<div class=\"col-12\">");
    this.visitChildren(ctx);
    this.out.append("</div>\n</div>\n");

    return null;
  }
  
  @Override
  public String visitRow(NDLParser.RowContext ctx) {
    int colTotal = 0;

    this.out.append("<div class=\"row\">\n");

    for(NDLParser.ColContext col: ctx.cols) {
      if(col.colType.getText().equals("col-full"))
        colTotal += 4;
      else if(col.colType.getText().equals("col-half"))
        colTotal += 2;
      else
        colTotal += 1;
    }

    if(colTotal != 4) {
      this.logError("A quantidade de colunas em uma linha deve somar 4");
    }

    this.visitChildren(ctx);
    this.out.append("</div>\n");

    return null;
  }

  @Override
  public String visitCol(NDLParser.ColContext ctx) {
    if(ctx.colType.getText().equals("col-full"))
      this.out.append("<div class=\"col-12\">\n");
    else if(ctx.colType.getText().equals("col-half"))
      this.out.append("<div class=\"col-6\">\n");
    else
      this.out.append("<div class=\"col-3\">\n");

    this.visitChildren(ctx);

    this.out.append("</div>\n");

    return null;
  }

  @Override
  public String visitArticle(NDLParser.ArticleContext ctx){
    this.out.append("<div class=\"row\">\n<h1>\n");
    this.out.append(ctx.title.getText().replace("\"","") + "\n");
    this.out.append("</h1>\n</div>\n");

    this.out.append("<div class=\"row\">\n<h5>\n");
    this.out.append(ctx.author.getText().replace("\"","") + "\n");
    this.out.append("</h5>\n</div>\n");

    this.out.append("<div class=\"row\">\n<h7><i>\n");
    this.out.append(ctx.description.getText().replace("\"","") + "\n");
    this.out.append("</i></h5></div>\n");

    this.out.append("<div class=\"row\">\n");
    this.visitChildren(ctx);
    this.out.append("</div>");

    return null;
  }

  @Override
  public String visitContent(NDLParser.ContentContext ctx){
    for(NDLParser.ParagraphContext paragraphCtx: ctx.paragraph()){
      this.visitParagraph(paragraphCtx);
      this.out.append("\n");
    }
    
    return null;
  }

  @Override
  public String visitParagraph(NDLParser.ParagraphContext ctx){
    for(Token lparagraph: ctx.lparagraph){
      this.out.append(lparagraph.getText().replace("\"",""));
    }

    return null;
  }
}

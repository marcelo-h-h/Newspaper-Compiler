package org.ndlang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

class NDLMain {
  public static void main(String[] args){
    //se recebeu o número de argumentos errado mostra como eles devem ser inseridos
    if(args.length < 1) {
        System.out.println("java -jar la source_code [output_file]");
    } else {
      try {
        StringBuffer out = new StringBuffer();
        StringBuffer error_out = new StringBuffer();

        CharStream input = CharStreams.fromFileName(args[0]);
        NDLLexer lexer = new NDLLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NDLParser parser = new NDLParser(tokens);

        NDLParser.NewspaperContext ast = parser.newspaper();

        if(parser.getNumberOfSyntaxErrors() == 0) {
          NDLGeracao geracao = new NDLGeracao(out, error_out);
          geracao.visitNewspaper(ast);

          if(error_out.length() > 0) {
            System.out.println(error_out.toString());
          } else {
            if(args.length < 2) {
              System.out.println(out);
            } else {
              BufferedWriter file_out = new BufferedWriter(new FileWriter(new File(args[1])));


              file_out.write(out.toString());

                file_out.flush();
                file_out.close();
            }
          }
        }
      //caso haja uma excessão ao lidar com o arquivo imprimir mensagem correspondente
      } catch (IOException exception) {
        System.out.println("Erro ao abrir o arquivo: " + exception.getMessage());
    }
    }
  }
}

package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import ast.*;
import visitor.PrettyPrintVisitor;


public class Main {

	public static void main(String[] args) throws IOException {
		InputStream stream = new FileInputStream("src/teste.txt");
		ANTLRInputStream input = new ANTLRInputStream(stream);
		hcmb_macm3Lexer lexer = new hcmb_macm3Lexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		hcmb_macm3Parser parser = new hcmb_macm3Parser(token);
		ParseTree tree = parser.goal();
		hcmb_macm3TestVisitor visitor = new hcmb_macm3TestVisitor();
		Program program = (Program) visitor.visit(tree);
		program.accept(new PrettyPrintVisitor());
	}

}

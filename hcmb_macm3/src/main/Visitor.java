package main;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.synth.SynthSeparatorUI;
import org.antlr.v4.runtime.tree.ParseTree;
import ast.*;

public class Visitor extends hcmb_macm3BaseVisitor<Object>{
	
	@Override
	public Object visitGoal(hcmb_macm3Parser.GoalContext ctx) {
		MainClass main = (MainClass) this.visit(ctx.getChild(0));
		ClassDeclList declList = new ClassDeclList();
		for (hcmb_macm3Parser.ClassDeclContext d : ctx.classDecl()) 
			declList.addElement((ClassDecl) this.visit(d));
		return new Program(main, declList);
	}
	
	@Override
	public Object visitMain(hcmb_macm3Parser.MainContext ctx) {
		Identifier i1 = new Identifier(ctx.identifier(0).getText());
		Identifier i2 = new Identifier(ctx.identifier(1).getText());
		Statement s = (Statement) this.visit(ctx.statement());
		return new MainClass(i1, i2, s);
	}
	
	@Override
	public Object visitMethodDecl(hcmb_macm3Parser.MethodDeclContext ctx) {
		Formal f = (Formal) this.visit(ctx.formal(0));
		FormalList formals = new FormalList();
		VarDeclList varDecls = new VarDeclList();
		StatementList statements = new StatementList();
		Exp exp = (Exp) this.visit(ctx.expression());
		for (hcmb_macm3Parser.FormalContext fm : ctx.formal()) 
			formals.addElement((Formal) this.visit(fm));
		for (hcmb_macm3Parser.VarDeclContext vd : ctx.varDecl()) 
			varDecls.addElement((VarDecl) this.visit(vd));
		for (hcmb_macm3Parser.StatementContext st : ctx.statement()) 
			statements.addElement((Statement) this.visit(st));
		return new MethodDecl(f.t, f.i, formals, varDecls, statements, exp);
	}
	
	@Override
	public Object visitStatement(hcmb_macm3Parser.StatementContext ctx) {
		if (ctx.getChild(0).getText().equals("{")) {
			StatementList statements = new StatementList();
			for (hcmb_macm3Parser.StatementContext st : ctx.statement()) 
				statements.addElement((Statement) this.visit(st));
			return new Block(statements);
		} else if (ctx.getChild(0).getText().equals("if")) {
			Exp e1 = (Exp) this.visit(ctx.expression(0));
			Statement s1 = (Statement) this.visit(ctx.statement(0));
			Statement s2 = (Statement) this.visit(ctx.statement(1));
			return new If(e1, s1, s2);
		} else if (ctx.getChild(0).getText().equals("while")) {
			Exp e1 = (Exp) this.visit(ctx.expression(0));
			Statement s1 = (Statement) this.visit(ctx.statement(0));
			return new While(e1, s1);
		} else if (ctx.getChild(0).getText().equals("System.out.println")) {
			return new Print((Exp) this.visit(ctx.expression(0)));
		} else if (ctx.getChild(1).getText().equals("=")) {
			Identifier id1 = (Identifier) this.visit(ctx.identifier());
			Exp e1 =  (Exp) this.visit(ctx.expression(0));
			return new Assign(id1, e1);
		} else {
			Identifier id1 = (Identifier) this.visit(ctx.identifier());
			Exp e1 =  (Exp) this.visit(ctx.expression(0));
			Exp e2 =  (Exp) this.visit(ctx.expression(1));
			return new ArrayAssign(id1, e1, e2);
		}
	}
	
	@Override
	public Object visitType(hcmb_macm3Parser.TypeContext ctx) {
		if (ctx.getChild(0).getText().equals("int")) {
			if(ctx.getChildCount() <= 1)
				return new IntegerType();
			else
				return new IntArrayType();
		} else if (ctx.getChild(0).getText().equals("boolean")) {
			return new BooleanType();
		} else {
			return new IdentifierType(ctx.getText());
		}
	}

	@Override
	public Object visitVarDecl(hcmb_macm3Parser.VarDeclContext ctx) {
		Formal f = (Formal) this.visit(ctx.formal());
		return new VarDecl(f.t, f.i);
	}
}
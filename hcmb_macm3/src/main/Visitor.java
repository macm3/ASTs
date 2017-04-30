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
	
	@Override
	public Object visitIdentifier(hcmb_macm3Parser.IdentifierContext ctx){
		return new Identifier(ctx.getText()); 
	}
	
	@Override
	public Object visitClassDecl(hcmb_macm3Parser.ClassDeclContext ctx){
		Identifier id1 = (Identifier) this.visit(ctx.identifier(0));
		Identifier id2 = null;
		if(ctx.identifier().size() > 1) 
			id2 = (Identifier) this.visit(ctx.identifier(1));
		VarDeclList vDs = new VarDeclList(); 
		MethodDeclList mDs = new MethodDeclList();
		for(hcmb_macm3Parser.VarDeclContext vD : ctx.varDecl())
			vDs.addElement((VarDecl) this.visit(vD));
		for(hcmb_macm3Parser.MethodDeclContext mD : ctx.methodDecl())
			mDs.addElement((MethodDecl) this.visit(mD));
		if(id2 != null)
			return new ClassDeclExtends(id1, id2, vDs, mDs);
		 else
			return new ClassDeclSimple(id1, vDs, mDs);
	}

	@Override
	public Object visitFormal(hcmb_macm3Parser.FormalContext ctx){
		Type t = (Type) this.visit(ctx.type());
		Identifier iD = (Identifier) this.visit(ctx.identifier());
		return new Formal(t, iD);
		
	}

	@Override
	public Object visitExpression(hcmb_macm3Parser.ExpressionContext ctx) {
		if (ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals(".")) {
			if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("length")) {
				return new ArrayLength((Exp) this.visit(ctx.expression(0)));
			} else {
				List<hcmb_macm3Parser.ExpressionContext> expressionContext = ctx.expression();
				List<Exp> exps = new ArrayList<Exp>();
				for (hcmb_macm3Parser.ExpressionContext ctxs : expressionContext) 
					exps.add((Exp) this.visit(ctxs));
				Exp first = exps.get(0);
				exps.remove(0);
				ExpList list = new ExpList();
				for (Exp exp2 : exps) 
					list.addElement(exp2);
				return new Call(first, new Identifier(ctx.identifier().getText()), list);
			}
		} else if (ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("[")) {
			Exp e1 = (Exp) this.visit(ctx.expression(0));
			Exp e2 = (Exp) this.visit(ctx.expression(1));
			return new ArrayLookup(e1, e2);
		} else if (ctx.INTEGERLITERAL() != null) {
			return new IntegerLiteral(Integer.parseInt(ctx.INTEGERLITERAL().getText()));
		} else if (ctx.identifier() != null) {
			return new IdentifierExp(ctx.identifier().getText());
		} else if (ctx.getChildCount() > 0 && ctx.getChild(0).getText().equals("new")) {
			if (ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("int")) {
				return new NewArray((Exp) this.visit(ctx.expression(0)));
			} else {
				return new NewObject(new Identifier(ctx.identifier().getText()));
			}
		} else if (ctx.getChildCount() > 0 && ctx.getChild(0).getText().equals("!")) {
			return new Not((Exp) this.visit(ctx.expression(0)));
		} else if (ctx.getChildCount() > 0 && ctx.getChild(0).getText().equals("(")) {
			return (Exp) this.visit(ctx.expression(0));
		} else if (ctx.getText().equals("true")) {
			return new True();
		} else if (ctx.getText().equals("false")) {
			return new False();
		} else if (ctx.getText().equals("this")) {
			return new This();
		} else {
			Exp e1 = (Exp) this.visit(ctx.expression(0));
			Exp e2 = (Exp) this.visit(ctx.expression(1));
			if(ctx.op.getText().equals("&&"))
				return new And(e1, e2);
			else if (ctx.op.getText().equals("<"))
				return new LessThan(e1, e2);
			else if (ctx.op.getText().equals("+"))
				return new Plus(e1, e2);
			else if(ctx.op.getText().equals("-"))
				return new Minus(e1, e2);
			else if(ctx.op.getText().equals("*"))
				return new Times(e1, e2);
		}
		return null;
	}
}
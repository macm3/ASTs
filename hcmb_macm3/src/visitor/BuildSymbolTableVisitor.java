package visitor;

import symboltable.SymbolTable;
import symboltable.Variable;
import symboltable.Class;
import symboltable.Method;

import java.util.Enumeration;

import ast.And;
import ast.ArrayAssign;
import ast.ArrayLength;
import ast.ArrayLookup;
import ast.Assign;
import ast.Block;
import ast.BooleanType;
import ast.Call;
import ast.ClassDecl;
import ast.ClassDeclExtends;
import ast.ClassDeclSimple;
import ast.False;
import ast.Formal;
import ast.Identifier;
import ast.IdentifierExp;
import ast.IdentifierType;
import ast.If;
import ast.IntArrayType;
import ast.IntegerLiteral;
import ast.IntegerType;
import ast.LessThan;
import ast.MainClass;
import ast.MethodDecl;
import ast.Minus;
import ast.NewArray;
import ast.NewObject;
import ast.Not;
import ast.Plus;
import ast.Print;
import ast.Program;
import ast.This;
import ast.Times;
import ast.True;
import ast.Type;
import ast.VarDecl;
import ast.While;

public class BuildSymbolTableVisitor implements Visitor {

	SymbolTable symbolTable;

	public BuildSymbolTableVisitor() {
		symbolTable = new SymbolTable();
	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	private Class currClass;
	private Method currMethod;

	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		AddClass(n);
		n.i1.accept(this);
		n.i2.accept(this);
		AddMethod("main", null);
		AddParam(n.i2.s, null);
		n.s.accept(this);
		currMethod = null;
		currClass = null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		AddClass(n);
		n.i.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		currClass = null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		AddClass(n);
		n.i.accept(this);
		n.j.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		currClass = null;
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
		n.t.accept(this);
		n.i.accept(this);
		AddVariable(n);
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
		AddMethod(n);
		n.t.accept(this);
		n.i.accept(this);
		for (int i = 1; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		n.e.accept(this);
		currMethod = null;
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		n.t.accept(this);
		n.i.accept(this);
		AddParam(n);
	}

	public void visit(IntArrayType n) {
	}

	public void visit(BooleanType n) {
	}

	public void visit(IntegerType n) {
	}

	// String s;
	public void visit(IdentifierType n) {
	}

	// StatementList sl;
	public void visit(Block n) {
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		n.e.accept(this);
		n.s.accept(this);
	}

	// Exp e;
	public void visit(Print n) {
		n.e.accept(this);
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		n.i.accept(this);
		n.e.accept(this);
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(And n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Times n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e;
	public void visit(ArrayLength n) {
		n.e.accept(this);
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		n.e.accept(this);
		n.i.accept(this);
		for (int i = 0; i < n.el.size(); i++) {
			n.el.elementAt(i).accept(this);
		}
	}

	// int i;
	public void visit(IntegerLiteral n) {
	}

	public void visit(True n) {
	}

	public void visit(False n) {
	}

	// String s;
	public void visit(IdentifierExp n) {
	}

	public void visit(This n) {
	}

	// Exp e;
	public void visit(NewArray n) {
		n.e.accept(this);
	}

	// Identifier i;
	public void visit(NewObject n) {
	}

	// Exp e;
	public void visit(Not n) {
		n.e.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
	}
	
	void AddClass(ClassDeclSimple cd){
		symbolTable.addClass(cd.i.s, "");
		currClass = symbolTable.getClass(cd.i.s);
	}
	
	void AddClass(ClassDeclExtends cd){
		symbolTable.addClass(cd.i.s, cd.j.s);
		currClass = symbolTable.getClass(cd.i.s);
	
	}
	
	void AddClass(MainClass n){
		symbolTable.addClass(n.i1.s, "");
		currClass = symbolTable.getClass(n.i1.s);
	}
	
	void AddVariable(VarDecl vd){
		if(currMethod != null){
			symbolTable.getMethod(currMethod.getId(), currClass.getId()).addVar(vd.i.s, vd.t);
		} else {
			symbolTable.getClass(currClass.getId()).addVar(vd.i.s, vd.t);
		}
	}
	
	void AddParam(Formal f){
		symbolTable.getMethod(currMethod.getId(), currClass.getId()).addParam(f.i.s, f.t);
	}
	
	void AddParam(String id, Type type){
		symbolTable.getMethod(currMethod.getId(), currClass.getId()).addParam(id, type);
	}
	
	void AddMethod(MethodDecl md){
		symbolTable.getClass(currClass.getId()).addMethod(md.i.s, md.t);
		currMethod = symbolTable.getMethod(md.i.s, currClass.getId());
	}
	
	void AddMethod(String id, Type type){
		symbolTable.getClass(currClass.getId()).addMethod(id, type);
		currMethod = symbolTable.getMethod(id, currClass.getId());
	}
	

}

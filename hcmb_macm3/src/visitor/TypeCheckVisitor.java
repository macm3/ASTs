package visitor;

import symboltable.Method;
import symboltable.Class;
import symboltable.SymbolTable;
import ast.And;
import ast.ArrayAssign;
import ast.ArrayLength;
import ast.ArrayLookup;
import ast.Assign;
import ast.Block;
import ast.BooleanType;
import ast.Call;
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

public class TypeCheckVisitor implements TypeVisitor {

	private SymbolTable symbolTable;
	

	public TypeCheckVisitor(SymbolTable st) {
		symbolTable = st;
	}

	private Class currClass;
	private Method currMethod;
	
	// MainClass m;
	// ClassDeclList cl;
	public Type visit(Program n) {
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i1,i2;
	// Statement s;
	public Type visit(MainClass n) {
		n.i1.accept(this);
		n.i2.accept(this);
		n.s.accept(this);
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclSimple n) {
		n.i.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclExtends n) {
		n.i.accept(this);
		n.j.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(VarDecl n) {
		n.t.accept(this);
		n.i.accept(this);
		return null;
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public Type visit(MethodDecl n) {
		n.t.accept(this);
		n.i.accept(this);
		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		n.e.accept(this);
		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(Formal n) {
		n.t.accept(this);
		n.i.accept(this);
		return null;
	}

	public Type visit(IntArrayType n) {
		return n;
	}

	public Type visit(BooleanType n) {
		return n;
	}

	public Type visit(IntegerType n) {
		return n;
	}

	// String s;
	public Type visit(IdentifierType n) {
		return n;
	}

	// StatementList sl;
	public Type visit(Block n) {
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		return null;
	}
	
	// Exp e;
	// Statement s1,s2;
	public Type visit(If n) {
		Type t = n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);

		BooleanType b = new BooleanType();

		if (symbolTable.compareTypes(t, b)) return null;
		
		System.out.println("Erro no argumento do IF! Tipo: " + t.toString() + " Expressao: " + n.e.toString());
			
		return null; 
		
	}

	// Exp e;
	// Statement s;
	public Type visit(While n) {
		Type t = n.e.accept(this);
		n.s.accept(this);
		
		BooleanType b = new BooleanType();
		
		if(symbolTable.compareTypes(t, b)) return null;
		
		System.out.println("Erro no argumento do While! Tipo: " + t.toString() + " Expressao: " + n.e.toString());
		
		return null;
	}

	// Exp e;
	public Type visit(Print n) {
		n.e.accept(this);
		return null;
	}

	// Identifier i;
	// Exp e;
	public Type visit(Assign n) {
		Type t = n.i.accept(this);
		Type t1 = n.e.accept(this);
		
		if(symbolTable.compareTypes(t, t1)) return null;
		
		System.out.println("Erro no Assign! Tipo: " + t.toString() + " Identificador: " + n.i.s + "\n");
		System.out.println("Tipo: " + t1.toString() + " Expressao: " + n.e.toString());
		
		return null;
	}

	// Identifier i;
	// Exp e1,e2;
	public Type visit(ArrayAssign n) {
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(And n) {
		Type t = n.e1.accept(this);
		Type t1 = n.e2.accept(this);
		
		BooleanType b = new BooleanType();
		
		if(symbolTable.compareTypes(t, b) && symbolTable.compareTypes(t1, b)) return null;
		
		System.out.println("Erro no argumento do And!");
		
		return null;
	}

	// Exp e1,e2;
	public Type visit(LessThan n) {
		Type t = n.e1.accept(this);
		Type t1 = n.e2.accept(this);
		
		IntegerType type = new IntegerType();
		
		if(symbolTable.compareTypes(t, type) && symbolTable.compareTypes(t1, type)) return null;
		System.out.println("Erro no argumento do LessThan!");
		
		return null;
	}

	// Exp e1,e2;
	public Type visit(Plus n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		
		IntegerType type = new IntegerType();

		if(symbolTable.compareTypes(t1, type) && symbolTable.compareTypes(t2, type)) return null;
		System.out.println("Erro no argumento do Plus!");
		
		return null;
	}

	// Exp e1,e2;
	public Type visit(Minus n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		
		IntegerType type = new IntegerType();

		if(symbolTable.compareTypes(t1, type) && symbolTable.compareTypes(t2, type)) return null;
		System.out.println("Erro no argumento do Minus!");
		
		return null;
	}

	// Exp e1,e2;
	public Type visit(Times n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		
		IntegerType type = new IntegerType();

		if(symbolTable.compareTypes(t1, type) && symbolTable.compareTypes(t2, type)) return null;
		System.out.println("Erro no argumento do Times!");
		
		return null;
	}

	// Exp e1,e2;
	public Type visit(ArrayLookup n) {
		n.e1.accept(this);
		n.e2.accept(this);
		return null;
	}

	// Exp e;
	public Type visit(ArrayLength n) {
		n.e.accept(this);
		return null;
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public Type visit(Call n) {
		Class save = currClass;
		IdentifierType t = (IdentifierType) n.e.accept(this);
		currClass = symbolTable.getClass(t.s);
		Type t1 = n.i.accept(this);
		currClass = save;
		
		int i;
		for(i=0; i<n.el.size(); i++){
			n.el.elementAt(i).accept(this);
		}
		return null;
		
	}

	// int i;
	public Type visit(IntegerLiteral n) {
		return null;
	}

	public Type visit(True n) {
		return null;
	}

	public Type visit(False n) {
		return null;
	}

	// String s;
	public Type visit(IdentifierExp n) {
		return symbolTable.getVarType(currMethod, currClass, n.s);
	}

	public Type visit(This n) {
		//return IdentifierType(currClass.getId()); ->eu achava q era assim 
		return null;
	}

	// Exp e;
	public Type visit(NewArray n) {
		n.e.accept(this);
		return null;
	}

	// Identifier i;
	public Type visit(NewObject n) {
		return null;
	}

	// Exp e;
	public Type visit(Not n) {
		Type t = n.e.accept(this);
		BooleanType b = new BooleanType();
		if(symbolTable.compareTypes(t, b)) return null;
		
		System.out.println("Erro no argumento do NOT!");
		
		return null;
	}

	// String s;
	public Type visit(Identifier n) {
		return null;
	}
}

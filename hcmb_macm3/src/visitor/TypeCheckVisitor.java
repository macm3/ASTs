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
		currClass = symbolTable.getClass(n.i1.s);
		n.i1.accept(this);
		//n.i2.accept(this); //nao eh necesssario checar o tipo do parametro da classe main
		n.s.accept(this);
		currClass = null;
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclSimple n) {
		currClass = symbolTable.getClass(n.i.s);
		n.i.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);		
		}
		currClass = null;
		return null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclExtends n) {
		currClass = symbolTable.getClass(n.i.s);
		n.i.accept(this);
		n.j.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);		
		}
		if(!symbolTable.containsClass(n.j.s)){
			System.out.println("Classe " + n.i.s + " herdando de classe inexistente (" + n.j.s + ")");
		}
		currClass = null;
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
		currMethod = symbolTable.getMethod(n.i.s, currClass.getId());
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
		if(!symbolTable.compareTypes(currMethod.type(), n.e.accept(this))){
			System.out.println("Retorno do m�todo "+ n.i.s +" n�o condiz com seu tipo");
		}
		currMethod = null;
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
		if(!symbolTable.compareTypes(t, new BooleanType())){
			System.out.println("Erro no argumento do IF! Tipo: " + t.toString() + " Expressao: " + n.e.toString());
		}
		n.s1.accept(this);
		n.s2.accept(this);
		return null; 
		
	}

	// Exp e;
	// Statement s;
	public Type visit(While n) {
		Type t = n.e.accept(this);
		if(!symbolTable.compareTypes(t, new BooleanType())){
			System.out.println("Erro no argumento do While! Tipo: " + t.toString() + " Expressao: " + n.e.toString());
		}
		n.s.accept(this);
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
		if(!symbolTable.compareTypes(t, t1)){
			System.out.println("Erro no Assign! Tipo: " + t.toString() + " Identificador: " + n.i.s + "\n");
		}
		return t1;
	}

	// Identifier i;
	// Exp e1,e2;
	public Type visit(ArrayAssign n) {
		if(!symbolTable.compareTypes(n.i.accept(this), new IntArrayType())){
			System.out.println("Assigning to an int array typed wrong.");
		}
		if(!symbolTable.compareTypes(n.e1.accept(this), new IntegerType())){
			System.out.println("Acessing index with non integer type in array assign");
		}
		if(!symbolTable.compareTypes(n.e2.accept(this), new IntegerType())){
			System.out.println("Assigning non integer value to an int array");
		}
		return new IntegerType();
	}

	// Exp e1,e2;
	public Type visit(And n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		BooleanType type = new BooleanType();
		if(!symbolTable.compareTypes(t1, type) || !symbolTable.compareTypes(t2, type)) {
			System.out.println("One of the and operators in a expression isn't boolean");
		}
		return type;
	}

	// Exp e1,e2;
	public Type visit(LessThan n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		IntegerType type = new IntegerType();
		if(!symbolTable.compareTypes(t1, type) || !symbolTable.compareTypes(t2, type)) {
			System.out.println("One of the less than operators in a expression isn't integer");
		}
		return new BooleanType();
	}

	// Exp e1,e2;
	public Type visit(Plus n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		IntegerType type = new IntegerType();
		if(!symbolTable.compareTypes(t1, type) || !symbolTable.compareTypes(t2, type)) {
			System.out.println("One of the sums in a expression isn't integer");
		}
		return type;
	}

	// Exp e1,e2;
	public Type visit(Minus n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		IntegerType type = new IntegerType();
		if(!symbolTable.compareTypes(t1, type) || !symbolTable.compareTypes(t2, type)) {
			System.out.println("One of the subtractions in a expression isn't integer");
		}
		return type;
	}

	// Exp e1,e2;
	public Type visit(Times n) {
		Type t1 = n.e1.accept(this);
		Type t2 = n.e2.accept(this);
		IntegerType type = new IntegerType();
		if(!symbolTable.compareTypes(t1, type) || !symbolTable.compareTypes(t2, type)) {
			System.out.println("One of the multiplications in a expression isn't integer");
		}
		return type;
	}

	// Exp e1,e2;
	public Type visit(ArrayLookup n) {
		if(!symbolTable.compareTypes(n.e1.accept(this), new IntArrayType())){
			System.out.println("Looking up in an array that isn't IntArrayType.");
		}
		if(!symbolTable.compareTypes(n.e2.accept(this), new IntegerType())){
			System.out.println("Looking up in an array with an non IntegerType index");	
		}
		return new IntegerType();
	}

	// Exp e;
	public Type visit(ArrayLength n) {
		if(!symbolTable.compareTypes(n.e.accept(this), new IntArrayType())){
			System.out.println("Expression at .lenght isn't an int array");
		}
		return new IntegerType();
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public Type visit(Call n) {
		Type te = n.e.accept(this);
		
		if(!(te instanceof IdentifierType)){
			System.out.println("Expression isn't a class in call");
		}
		
		n.i.accept(this);
		
		Method m = symbolTable.getMethod(n.i.s, ((IdentifierType)te).s);
		if(m ==  null){
			int i;
			for(i=0; i < n.el.size() ; i++){
				n.el.elementAt(i).accept(this);
			}
			return null;
		}
		
		
		int i;
		for(i=0; i < n.el.size() ; i++){
			if(m.getParamAt(i) == null){
				System.out.println("Extra param at method " + m.getId() +  " call.");
			}
			if(!symbolTable.compareTypes(n.el.elementAt(i).accept(this), m.getParamAt(i).type())){
				System.out.println("Different param type at method " + m.getId() +  " call.");
			}
		}
		
		if(m.getParamAt(i) != null){
			System.out.println("Missing "+ m.getParamAt(i).type() +" param at method " + m.getId() +  " call.");
		}
		
		return m.type();
	}

	// int i;
	public Type visit(IntegerLiteral n) {
		return new IntegerType();
	}

	public Type visit(True n) {
		return new BooleanType();
	}

	public Type visit(False n) {
		return new BooleanType();
	}

	// String s;
	public Type visit(IdentifierExp n) {
		return symbolTable.getVarType(currMethod, currClass, n.s);
	}

	public Type visit(This n) {
		return currClass.type();
	}

	// Exp e;
	public Type visit(NewArray n) {
		Type t = n.e.accept(this);
		if(!(symbolTable.compareTypes(t, new IntegerType()))){
			System.out.println("Wrong expression type at array creation");
		}
		return new IntArrayType();
	}

	// Identifier i;
	public Type visit(NewObject n) {
		Class c = symbolTable.getClass(n.i.s);
		if(c == null){
			System.out.println("Error! Trying to create a new object of undeclared class " + n.i.s);
			return null;
		}
		return n.i.accept(this);
	}

	// Exp e;
	public Type visit(Not n) {
		Type t = n.e.accept(this);
		if(!symbolTable.compareTypes(t, new BooleanType())) {
			System.out.println("Wrong typings at NOT");
		}
		return new BooleanType();
	}

	// String s;
	public Type visit(Identifier n) {
		if(symbolTable.containsClass(n.s)) return symbolTable.getClass(n.s).type();
		if(currClass != null && currClass.containsVar(n.s)) return currClass.getVar(n.s).type();
		if(currClass != null && currClass.containsMethod(n.s)) return currClass.getMethod(n.s).type();
		if(currMethod != null && currMethod.containsParam(n.s)) return currMethod.getParam(n.s).type();
		if(currMethod != null && currMethod.containsVar(n.s)) return currMethod.getVar(n.s).type();
		System.out.println("Erro! Identificador " + n.s + " nao declarado.");
		return null;
	}
}

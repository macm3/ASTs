// Generated from hcmb_macm3.g4 by ANTLR 4.4
package main;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link hcmb_macm3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface hcmb_macm3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(@NotNull hcmb_macm3Parser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull hcmb_macm3Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(@NotNull hcmb_macm3Parser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull hcmb_macm3Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(@NotNull hcmb_macm3Parser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull hcmb_macm3Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(@NotNull hcmb_macm3Parser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(@NotNull hcmb_macm3Parser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull hcmb_macm3Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link hcmb_macm3Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull hcmb_macm3Parser.VarDeclContext ctx);
}
// Generated from hcmb_macm3.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link hcmb_macm3Parser}.
 */
public interface hcmb_macm3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(@NotNull hcmb_macm3Parser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(@NotNull hcmb_macm3Parser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull hcmb_macm3Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull hcmb_macm3Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(@NotNull hcmb_macm3Parser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(@NotNull hcmb_macm3Parser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull hcmb_macm3Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull hcmb_macm3Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMethod_declaration(@NotNull hcmb_macm3Parser.Method_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMethod_declaration(@NotNull hcmb_macm3Parser.Method_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull hcmb_macm3Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull hcmb_macm3Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(@NotNull hcmb_macm3Parser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(@NotNull hcmb_macm3Parser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#main_class}.
	 * @param ctx the parse tree
	 */
	void enterMain_class(@NotNull hcmb_macm3Parser.Main_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#main_class}.
	 * @param ctx the parse tree
	 */
	void exitMain_class(@NotNull hcmb_macm3Parser.Main_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void enterClass_declaration(@NotNull hcmb_macm3Parser.Class_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void exitClass_declaration(@NotNull hcmb_macm3Parser.Class_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link hcmb_macm3Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull hcmb_macm3Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link hcmb_macm3Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull hcmb_macm3Parser.TypeContext ctx);
}
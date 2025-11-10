package enact.lang.parser;

// Generated from enact.g by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link enactParser}.
 */
public interface enactListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link enactParser#enact_program}.
	 * @param ctx the parse tree
	 */
	void enterEnact_program(enactParser.Enact_programContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#enact_program}.
	 * @param ctx the parse tree
	 */
	void exitEnact_program(enactParser.Enact_programContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#enact_rule}.
	 * @param ctx the parse tree
	 */
	void enterEnact_rule(enactParser.Enact_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#enact_rule}.
	 * @param ctx the parse tree
	 */
	void exitEnact_rule(enactParser.Enact_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#enact_effect}.
	 * @param ctx the parse tree
	 */
	void enterEnact_effect(enactParser.Enact_effectContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#enact_effect}.
	 * @param ctx the parse tree
	 */
	void exitEnact_effect(enactParser.Enact_effectContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#y}.
	 * @param ctx the parse tree
	 */
	void enterY(enactParser.YContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#y}.
	 * @param ctx the parse tree
	 */
	void exitY(enactParser.YContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#sff_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterSff_or_expr(enactParser.Sff_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#sff_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitSff_or_expr(enactParser.Sff_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#sff_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterSff_and_expr(enactParser.Sff_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#sff_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitSff_and_expr(enactParser.Sff_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#sff_rel}.
	 * @param ctx the parse tree
	 */
	void enterSff_rel(enactParser.Sff_relContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#sff_rel}.
	 * @param ctx the parse tree
	 */
	void exitSff_rel(enactParser.Sff_relContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#arithm_term}.
	 * @param ctx the parse tree
	 */
	void enterArithm_term(enactParser.Arithm_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#arithm_term}.
	 * @param ctx the parse tree
	 */
	void exitArithm_term(enactParser.Arithm_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#arithm_factor}.
	 * @param ctx the parse tree
	 */
	void enterArithm_factor(enactParser.Arithm_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#arithm_factor}.
	 * @param ctx the parse tree
	 */
	void exitArithm_factor(enactParser.Arithm_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#sff_atom}.
	 * @param ctx the parse tree
	 */
	void enterSff_atom(enactParser.Sff_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#sff_atom}.
	 * @param ctx the parse tree
	 */
	void exitSff_atom(enactParser.Sff_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#pred}.
	 * @param ctx the parse tree
	 */
	void enterPred(enactParser.PredContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#pred}.
	 * @param ctx the parse tree
	 */
	void exitPred(enactParser.PredContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 */
	void enterList_of_pred_terms(enactParser.List_of_pred_termsContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 */
	void exitList_of_pred_terms(enactParser.List_of_pred_termsContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#pred_terms}.
	 * @param ctx the parse tree
	 */
	void enterPred_terms(enactParser.Pred_termsContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#pred_terms}.
	 * @param ctx the parse tree
	 */
	void exitPred_terms(enactParser.Pred_termsContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#pred_term}.
	 * @param ctx the parse tree
	 */
	void enterPred_term(enactParser.Pred_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#pred_term}.
	 * @param ctx the parse tree
	 */
	void exitPred_term(enactParser.Pred_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(enactParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(enactParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(enactParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(enactParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link enactParser#list_term}.
	 * @param ctx the parse tree
	 */
	void enterList_term(enactParser.List_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link enactParser#list_term}.
	 * @param ctx the parse tree
	 */
	void exitList_term(enactParser.List_termContext ctx);
}
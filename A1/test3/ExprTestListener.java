// Generated from ExprTest.g by ANTLR 4.5

import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprTestParser}.
 */
public interface ExprTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprTestParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprTestParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprTestParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprTestParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprTestParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ExprTestParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprTestParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ExprTestParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprTestParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprTestParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprTestParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(ExprTestParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprTestParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(ExprTestParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprTestParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ExprTestParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprTestParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ExprTestParser.AtomContext ctx);
}
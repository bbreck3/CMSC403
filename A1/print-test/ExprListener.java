// Generated from Expr.g by ANTLR 4.5

import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ExprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ExprParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(ExprParser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(ExprParser.EContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(ExprParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(ExprParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#eList}.
	 * @param ctx the parse tree
	 */
	void enterEList(ExprParser.EListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#eList}.
	 * @param ctx the parse tree
	 */
	void exitEList(ExprParser.EListContext ctx);
}
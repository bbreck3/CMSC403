// Generated from expr.g by ANTLR 4.5.2

	import java.io.*;
	import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link exprParser}.
 */
public interface exprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link exprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(exprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(exprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(exprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(exprParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(exprParser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(exprParser.EContext ctx);
}
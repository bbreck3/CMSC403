// Generated from test1.g by ANTLR 4.5.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link test1Parser}.
 */
public interface test1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link test1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(test1Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link test1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(test1Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link test1Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(test1Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link test1Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(test1Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link test1Parser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(test1Parser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link test1Parser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(test1Parser.EContext ctx);
}
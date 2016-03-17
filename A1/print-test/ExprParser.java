// Generated from Expr.g by ANTLR 4.5

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MUL=7, DIV=8, ADD=9, SUB=10, 
		VAR=11, PRINT=12, STRING=13, INTEGER=14, INT=15, STR=16, ID=17, NEWLINE=18, 
		WS=19;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_e = 2, RULE_idList = 3, RULE_eList = 4;
	public static final String[] ruleNames = {
		"prog", "stat", "e", "idList", "eList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':='", "'='", "'('", "')'", "','", "'*'", "'/'", "'+'", 
		"'-'", "'var'", "'print'", "'string'", "'int'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", 
		"VAR", "PRINT", "STRING", "INTEGER", "INT", "STR", "ID", "NEWLINE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    /** "memory" for our calculator; variable/value pairs go here */
	    Map<String, Object> memory = new HashMap<>();

	    int eval(int left, int op, int right) {
	        switch ( op ) {
	            case MUL : return left * right;
	            case DIV :
	                if (right == 0){
	                    error("ERROR: DIVIDE BY ZERO");
	                } 
	                return left / right;
	            case ADD : return left + right;
	            case SUB : return left - right;
	        }
	        error();
	        return 0;
	    }
	    
	    String eval(String left, int op, String right) {
	        switch (op) {
	            case ADD : return left + right;
	        }
	        error();
	        return "";
	    }
	    
	    String eval(String left, int op, int right) {
	        switch (op) {
	            case MUL :
	                if ( right >= 0 ){
	                    StringBuilder sb = new StringBuilder();
	                    for (int i = 0; i < right; i++) {
	                        sb.append(left);
	                    }
	                    return sb.toString();
	                }
	                error("ERROR: NEGATIVE STRING MULTIPLIER");
	                return "";
	            case ADD :
	                if ( right > 0 ) {
	                    if ( right < left.length() ){
	                        return left.substring(right);
	                    } else {
	                        return "";
	                    }
	                } else {
	                    if ( (right * -1) < left.length() ){
	                        return left.substring(0, left.length() + right);
	                    } else {
	                        return "";
	                    }
	                }
	            case SUB :
	                if ( right > 0) {
	                    if ( right < left.length() ){
	                        return left.substring(0, left.length() - right);
	                    } else {
	                        return "";
	                    }
	                } else {
	                    if ( (right * -1) < left.length() ){
	                        return left.substring(right * -1);
	                    } else {
	                        return "";
	                    }
	                }
	        }
	        error();
	        return "";
	    }
	    
	    void error() {
	        error("SYNTAX ERROR");
	    }
	    
	    void error(String msg){
	        System.err.println(msg);
	        System.exit(0);
	    }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				stat();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << VAR) | (1L << PRINT) | (1L << ID) | (1L << NEWLINE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public EContext e;
		public Token ID;
		public IdListContext a;
		public EListContext b;
		public TerminalNode PRINT() { return getToken(ExprParser.PRINT, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode VAR() { return getToken(ExprParser.VAR, 0); }
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(ExprParser.INTEGER, 0); }
		public EListContext eList() {
			return getRuleContext(EListContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				match(PRINT);
				setState(16);
				((StatContext)_localctx).e = e(0);
				setState(17);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				System.out.println(((StatContext)_localctx).e.v);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				((StatContext)_localctx).ID = match(ID);
				setState(21);
				match(T__1);
				setState(22);
				((StatContext)_localctx).e = e(0);
				setState(23);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}

				            if(memory.containsKey((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null))){ //If the variable to be declared already exists
				                error();
				            } else {
				                memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).e.v);
				            }
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				((StatContext)_localctx).ID = match(ID);
				setState(27);
				match(T__2);
				setState(28);
				((StatContext)_localctx).e = e(0);
				setState(29);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}

				            if(memory.containsKey((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null))){
				                if ((memory.get((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null)) instanceof String && ((StatContext)_localctx).e.v instanceof String) ||
				                    (memory.get((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null)) instanceof Integer && ((StatContext)_localctx).e.v instanceof Integer)){ //If the types match
				                    memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).e.v);
				                } else {
				                    error();
				                }
				            } else {
				                error();
				            }
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				match(VAR);
				setState(33);
				((StatContext)_localctx).a = idList();
				setState(34);
				match(STRING);
				setState(35);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}

				            for (String id : ((StatContext)_localctx).a.list){
				                memory.put(id, "");
				            }
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				match(VAR);
				setState(39);
				((StatContext)_localctx).a = idList();
				setState(40);
				match(INTEGER);
				setState(41);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}

				            for (String id : ((StatContext)_localctx).a.list){
				                memory.put(id, 0);
				            }
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				match(VAR);
				setState(45);
				((StatContext)_localctx).a = idList();
				setState(46);
				match(STRING);
				setState(47);
				match(T__2);
				setState(48);
				((StatContext)_localctx).b = eList();
				setState(49);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}

				            List<String> ids = ((StatContext)_localctx).a.list;
				            List<Object> exprs = ((StatContext)_localctx).b.list;
				            if(ids.size() == exprs.size()){
				                for (int i = 0; i < ids.size(); i++){
				                    if(exprs.get(i) instanceof String){
				                        memory.put(ids.get(i), (String)exprs.get(i));
				                    } else {
				                        error();
				                    }
				                }
				            } else {
				                error();
				            }
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				match(VAR);
				setState(53);
				((StatContext)_localctx).a = idList();
				setState(54);
				match(INTEGER);
				setState(55);
				match(T__2);
				setState(56);
				((StatContext)_localctx).b = eList();
				setState(57);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}

				            List<String> ids = ((StatContext)_localctx).a.list;
				            List<Object> exprs = ((StatContext)_localctx).b.list;
				            if(ids.size() == exprs.size()){
				                for (int i = 0; i < ids.size(); i++){
				                    if(exprs.get(i) instanceof Integer){
				                        memory.put(ids.get(i), (Integer)exprs.get(i));
				                    } else {
				                        error();
				                    }
				                }
				            } else {
				                error();
				            }
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(60);
				match(NEWLINE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(61);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EContext extends ParserRuleContext {
		public Object v;
		public EContext a;
		public Token INT;
		public Token STR;
		public Token ID;
		public Token op;
		public EContext b;
		public TerminalNode SUB() { return getToken(ExprParser.SUB, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode STR() { return getToken(ExprParser.STR, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode MUL() { return getToken(ExprParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ExprParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(ExprParser.ADD, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			switch (_input.LA(1)) {
			case SUB:
				{
				setState(65);
				match(SUB);
				setState(66);
				((EContext)_localctx).a = e(5);

				            if(((EContext)_localctx).a.v instanceof Integer){
				                ((EContext)_localctx).v =  -1 * (Integer)((EContext)_localctx).a.v;
				            } else {
				                error();
				            }
				        
				}
				break;
			case INT:
				{
				setState(69);
				((EContext)_localctx).INT = match(INT);
				((EContext)_localctx).v =  (((EContext)_localctx).INT!=null?Integer.valueOf(((EContext)_localctx).INT.getText()):0);
				}
				break;
			case STR:
				{
				setState(71);
				((EContext)_localctx).STR = match(STR);
				((EContext)_localctx).v =  (((EContext)_localctx).STR!=null?((EContext)_localctx).STR.getText():null).replaceAll("\"", "");
				}
				break;
			case ID:
				{
				setState(73);
				((EContext)_localctx).ID = match(ID);

				        String id = (((EContext)_localctx).ID!=null?((EContext)_localctx).ID.getText():null);
				        if (memory.containsKey(id)){
				            ((EContext)_localctx).v =  memory.get(id);
				        } else {
				            error();
				        }
				      
				}
				break;
			case T__3:
				{
				setState(75);
				match(T__3);
				setState(76);
				((EContext)_localctx).a = e(0);
				setState(77);
				match(T__4);
				((EContext)_localctx).v =  ((EContext)_localctx).a.v;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(82);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(83);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(84);
						((EContext)_localctx).b = e(8);
						   
						                      if (((EContext)_localctx).a.v instanceof Integer && ((EContext)_localctx).b.v instanceof Integer){
						                          ((EContext)_localctx).v =  eval((Integer)((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (Integer)((EContext)_localctx).b.v);
						                      } else if (((EContext)_localctx).a.v instanceof String && ((EContext)_localctx).b.v instanceof Integer){
						                          ((EContext)_localctx).v =  eval((String)((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (Integer)((EContext)_localctx).b.v);
						                      } else if (((EContext)_localctx).a.v instanceof Integer && ((EContext)_localctx).b.v instanceof String){
						                          ((EContext)_localctx).v =  eval((String)((EContext)_localctx).b.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (Integer)((EContext)_localctx).a.v);
						                      } else {
						                          error();
						                      }
						                  
						}
						break;
					case 2:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(87);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(88);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(89);
						((EContext)_localctx).b = e(7);

						                      if (((EContext)_localctx).a.v instanceof Integer && ((EContext)_localctx).b.v instanceof Integer){
						                          ((EContext)_localctx).v =  eval((Integer)((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (Integer)((EContext)_localctx).b.v);
						                      } else if (((EContext)_localctx).a.v instanceof String && ((EContext)_localctx).b.v instanceof String){
						                          ((EContext)_localctx).v =  eval((String)((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (String)((EContext)_localctx).b.v);
						                      } else if (((EContext)_localctx).a.v instanceof String && ((EContext)_localctx).b.v instanceof Integer){
						                          ((EContext)_localctx).v =  eval((String)((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (Integer)((EContext)_localctx).b.v);
						                      } else if (((EContext)_localctx).a.v instanceof Integer && ((EContext)_localctx).b.v instanceof String){
						                          ((EContext)_localctx).v =  eval((String)((EContext)_localctx).b.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), (Integer)((EContext)_localctx).a.v);
						                      } else {
						                          error();
						                      }
						                  
						}
						break;
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public List<String> list;
		public List<String> ids =  new ArrayList<>();;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitIdList(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			((IdListContext)_localctx).ID = match(ID);
			_localctx.ids.add((((IdListContext)_localctx).ID!=null?((IdListContext)_localctx).ID.getText():null));
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(99);
				match(T__5);
				setState(100);
				((IdListContext)_localctx).ID = match(ID);
				_localctx.ids.add((((IdListContext)_localctx).ID!=null?((IdListContext)_localctx).ID.getText():null));
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((IdListContext)_localctx).list =  _localctx.ids;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EListContext extends ParserRuleContext {
		public List<Object> list;
		public List<Object> exprs =  new ArrayList<>();;
		public EContext a;
		public EContext b;
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public EListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEList(this);
		}
	}

	public final EListContext eList() throws RecognitionException {
		EListContext _localctx = new EListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			((EListContext)_localctx).a = e(0);
			_localctx.exprs.add(((EListContext)_localctx).a.v);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(111);
				match(T__5);
				setState(112);
				((EListContext)_localctx).b = e(0);
				_localctx.exprs.add(((EListContext)_localctx).b.v);
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((EListContext)_localctx).list =  _localctx.exprs;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25}\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4S\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4_\n\4\f\4\16\4b\13\4\3\5\3\5\3\5\3\5\3\5\7\5i\n\5"+
		"\f\5\16\5l\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6v\n\6\f\6\16\6y\13"+
		"\6\3\6\3\6\3\6\2\3\6\7\2\4\6\b\n\2\5\4\2\3\3\24\24\3\2\t\n\3\2\13\f\u0088"+
		"\2\r\3\2\2\2\4@\3\2\2\2\6R\3\2\2\2\bc\3\2\2\2\no\3\2\2\2\f\16\5\4\3\2"+
		"\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21"+
		"\22\7\16\2\2\22\23\5\6\4\2\23\24\t\2\2\2\24\25\b\3\1\2\25A\3\2\2\2\26"+
		"\27\7\23\2\2\27\30\7\4\2\2\30\31\5\6\4\2\31\32\t\2\2\2\32\33\b\3\1\2\33"+
		"A\3\2\2\2\34\35\7\23\2\2\35\36\7\5\2\2\36\37\5\6\4\2\37 \t\2\2\2 !\b\3"+
		"\1\2!A\3\2\2\2\"#\7\r\2\2#$\5\b\5\2$%\7\17\2\2%&\t\2\2\2&\'\b\3\1\2\'"+
		"A\3\2\2\2()\7\r\2\2)*\5\b\5\2*+\7\20\2\2+,\t\2\2\2,-\b\3\1\2-A\3\2\2\2"+
		"./\7\r\2\2/\60\5\b\5\2\60\61\7\17\2\2\61\62\7\5\2\2\62\63\5\n\6\2\63\64"+
		"\t\2\2\2\64\65\b\3\1\2\65A\3\2\2\2\66\67\7\r\2\2\678\5\b\5\289\7\20\2"+
		"\29:\7\5\2\2:;\5\n\6\2;<\t\2\2\2<=\b\3\1\2=A\3\2\2\2>A\7\24\2\2?A\7\3"+
		"\2\2@\21\3\2\2\2@\26\3\2\2\2@\34\3\2\2\2@\"\3\2\2\2@(\3\2\2\2@.\3\2\2"+
		"\2@\66\3\2\2\2@>\3\2\2\2@?\3\2\2\2A\5\3\2\2\2BC\b\4\1\2CD\7\f\2\2DE\5"+
		"\6\4\7EF\b\4\1\2FS\3\2\2\2GH\7\21\2\2HS\b\4\1\2IJ\7\22\2\2JS\b\4\1\2K"+
		"L\7\23\2\2LS\b\4\1\2MN\7\6\2\2NO\5\6\4\2OP\7\7\2\2PQ\b\4\1\2QS\3\2\2\2"+
		"RB\3\2\2\2RG\3\2\2\2RI\3\2\2\2RK\3\2\2\2RM\3\2\2\2S`\3\2\2\2TU\f\t\2\2"+
		"UV\t\3\2\2VW\5\6\4\nWX\b\4\1\2X_\3\2\2\2YZ\f\b\2\2Z[\t\4\2\2[\\\5\6\4"+
		"\t\\]\b\4\1\2]_\3\2\2\2^T\3\2\2\2^Y\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2"+
		"\2\2a\7\3\2\2\2b`\3\2\2\2cd\7\23\2\2dj\b\5\1\2ef\7\b\2\2fg\7\23\2\2gi"+
		"\b\5\1\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2m"+
		"n\b\5\1\2n\t\3\2\2\2op\5\6\4\2pw\b\6\1\2qr\7\b\2\2rs\5\6\4\2st\b\6\1\2"+
		"tv\3\2\2\2uq\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2"+
		"z{\b\6\1\2{\13\3\2\2\2\t\17@R^`jw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
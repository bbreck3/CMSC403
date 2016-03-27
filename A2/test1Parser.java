// Generated from test1.g by ANTLR 4.5.2

	import java.io.*;
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
public class test1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, NEWLINE=2, WS=3;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_e = 2;
	public static final String[] ruleNames = {
		"prog", "stat", "e"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STRING", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "test1.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		/**

			Debugging: Input should be read from system.in using a scanner
			Currently: Doesnt work
		*/
		//File file = new File(test.java);
		//String trgToken ="";
		String token ="";
		String parse(String str){
		Scanner scan = new Scanner(str);

		String line=scan.nextLine();
		if(line.contains("#") || !(line.indexOf("String") > 0))
		{
			System.out.println("Debug");
			token = extract(line); //"Target-->" +line;
			//if(!(line.indexOf("String") > 0)){
			//token = extract(line); //"Target-->" +line;
			//}
		} else { token = line;}
		return token;



		/*for(int i=0; i<line.length(); i++){	
			if(line.charAt(i)=='#'){

			String next = line.substring(10,12);
			switch(next){
			case "MA": token="MAP";
							Sytsem.out.println("Debug --> MAP");
						break;
					
			case "FI": token="FILTER";
						Sytsem.out.println("Debug-->Filter");
						break;

			case "FO": token="FOLD";
						Sytsem.out.println("Debug --> FOLD");
						break;
			default: return 
						
			}
				return token;	
		} else return "Invalid Input";
		}*/ 
		
			
		}

		String extract(String str){
					//System.out.println("Debug-->" + str);
					int hashTagIdx= str.indexOf('#');
					int equalIdx = str.indexOf('=');
					int leftBrak = str.indexOf('[');
					int rightBrak = str.indexOf(']');
					int leftCurly = str.indexOf('{');
					int rightCurly = str.indexOf('}');
					int commaPos=0;
					int commaCounter=0;
					String trgToken="";
					String arr[];
				for(int i=0; i<str.length()-1; i++){
				//System.out.println(i);
					if(str.charAt(i)=='#'){
					
					String contents = str.substring(leftBrak+1, rightBrak);
					//System.out.println("Debug: contents::-->" + contents);
					//System.out.println("Hash-->" + hashTagIdx + ", equal-->" + equalIdx);
					String listName = str.substring(hashTagIdx+1, equalIdx);
					token = listName;
					for(int j=0; j<contents.length(); j++){
						//System.out.println(contents.charAt(j));
						if(contents.charAt(j)==','){
							
								commaCounter++;
						}
					}
					//System.out.println("Debug--> " + commaCounter);
					arr = new String[commaCounter];
					for(int j=0;j<contents.length();j++){
							
							if(!(contents.charAt(j)==',')){
									trgToken+=contents.charAt(j);
							} else{ arr[commaPos]=trgToken; commaPos++; trgToken="";}
					}
					for(int j=0; j<arr.length; j++){
						System.out.println(arr[j] + "\n");
					}
					
					
							
							/*switch(next){
							case "MA": token="MAP";
										return token;
						
							case "FI": token="FILTER";
										return token;

							case "FO": token="FOLD";
										return token;
							} */

					} 	
				}return token;
		}



		/**

			Currently works, but is not reading in the input correctly...should be from scanner, not using a method

		*/
		/*String parse(String str){
		if(str.charAt(0)=='#'){
			String temp = eval(str);
			return temp;
		} else {
			str="Invalid";
		}
		return str;
		}*/

		String eval(String str){
		//for debugging
		char trash = str.charAt(0);
		System.out.println("Trash: --> " +trash);
		String rest = str.substring(1,str.length());
		System.out.println("Debug -->" +rest);
		//end debugging
		return  rest;

		}


	public test1Parser(TokenStream input) {
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
			if ( listener instanceof test1Listener ) ((test1Listener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof test1Listener ) ((test1Listener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				stat();
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(test1Parser.NEWLINE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof test1Listener ) ((test1Listener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof test1Listener ) ((test1Listener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			((StatContext)_localctx).e = e();
			setState(12);
			match(NEWLINE);
			System.out.println(((StatContext)_localctx).e.v);
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
		public String v;
		public Token a;
		public TerminalNode STRING() { return getToken(test1Parser.STRING, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof test1Listener ) ((test1Listener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof test1Listener ) ((test1Listener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_e);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			((EContext)_localctx).a = match(STRING);

			 	String s = (((EContext)_localctx).a!=null?((EContext)_localctx).a.getText():null);
				((EContext)_localctx).v =  parse(s);
				
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\5\25\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\6\2\n\n\2\r\2\16\2\13\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\2\2\5\2\4\6\2\2\22\2\t\3\2\2\2\4\r\3\2\2\2\6\21\3\2\2\2\b\n\5\4\3\2\t"+
		"\b\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\3\3\2\2\2\r\16\5\6"+
		"\4\2\16\17\7\4\2\2\17\20\b\3\1\2\20\5\3\2\2\2\21\22\7\3\2\2\22\23\b\4"+
		"\1\2\23\7\3\2\2\2\3\13";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
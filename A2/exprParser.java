// Generated from expr.g by ANTLR 4.5.2

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
public class exprParser extends Parser {
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
	public String getGrammarFileName() { return "expr.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		
		String token ="";// --> empty string for the return token
		String parse(String str){ // --> method that takes a string as input
		Scanner scan = new Scanner(str);
		String line=scan.nextLine(); // if the line contains a # symbol, take a closer look at that line
									// Example: #outList0=MAP[inCollection,String,s,Integer,len,{len=s.length();}]
		if(line.contains("#")){
			System.out.println("//" + line);
			
			if(!(line.contains("\""))){ //verifies that a line that contians a # symbol does not contains quotes ' " '
										//example: String z="#outList=MAP[inCollection,String,s,Integer,len,{len=s.length();}]"; <-- do not parse that as //this is a valid string
										//if the line fits the criterion, further examine it
			token = extract(line);
			}
		} else { token = line;} // if the line does not contain # then do nothing, it is of no concern so simply return it
		return token;
		
			
		}
		
		String extract(String str){ //--> //method the extract the contents of the line that contianed a #
					
					//find the index of various key components
					int hashTagIdx= str.indexOf('#');
					int equalIdx = str.indexOf('=');
					int leftBrak = str.indexOf('[');
					int rightBrak = str.indexOf(']');
					int leftCurly = str.indexOf('{');
					int rightCurly = str.indexOf('}'); 
					
					int commaPos=0; // --> records whether or not the current character is a , and increments by one if it is....for an array purposes
					int commaCounter=0; // --> //keep count of the number of commas--> in order to find out how many tokens are inside the [  ] 
					String trgToken=""; // --> if the currently parsed token in the [  ] is  then assign the value of that string to this
					String arr[]; // --> array to hold all the tokens inside the  [    ]
					String function="";// ---> stting to hold the funtion eg : MAP, FILTER or FOLD
					String retTok=""; // String hold the final result if that will return that correct output of the parsed string

					//interate through the string that contains the # symbol
					for(int i=0; i<str.length()-1; i++){
				
					if(str.charAt(i)=='#'){ // detect the #
					
					
					String contents = str.substring(leftBrak+1, rightBrak); // --> grab contents between [  ]
					String listName = str.substring(hashTagIdx+1, equalIdx); // --> grabs the listName
					String extractFunc=str.substring(equalIdx+1,leftBrak); // --> grabs the fucntion name: MAP, FILTER, FOLD
					String betweenCurly = str.substring(leftCurly+1, rightCurly);// --> grabs the info between {   }
					switch(extractFunc){ // evaluate the function and assign the correct one
						case "MAP": function="MAP";
							
						break;
					
						case "FILTER": function="FILTER";
							
						break;

						case "FOLD": function="FOLD";
							
						break;
						default: System.out.println("No Such Case");
						
					}

					for(int j=0; j<contents.length(); j++){ // --> Iterate through the contect in order to count the number of commas
						
						if(contents.charAt(j)==','){
							
								commaCounter++;
						}
					}
					
					arr = new String[commaCounter]; // --> initialize an array with the number of found commas

					for(int j=0;j<contents.length();j++){ // iterate through the contents again looking for commmans, 
															// while you do not find one, build a string 
															// with all the non , chars that you do find, once a , is found, add that string to the array and // reset the string...repeat
							if(!(contents.charAt(j)==',')){
									trgToken+=contents.charAt(j);
							} else{ arr[commaPos]=trgToken; commaPos++; trgToken="";}
					}

					
						//filter the return token by function and built the string by each function case
						if(function=="MAP"){
						retTok+="List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();\n";
						retTok+="for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )\n";
						retTok+="{ \n";
						retTok+=arr[3] + " " + arr[4] +";\n";
						retTok+=betweenCurly +"\n";
						retTok+="outListInternal.add(" +arr[4] + ");\n";
						retTok+="} \n";
						retTok+=listName + "=outListInternal;";


						} else if(function=="FILTER"){
						retTok+="List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();\n";
						retTok+="for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )\n";
						retTok+="{ \n";
						retTok+="if(" + betweenCurly+")\n";
						retTok+="{ \n";
						retTok+="outListInternal.add(" +arr[2] + ");\n";
						retTok+="} \n";
						retTok+="} \n";
						retTok+=listName + "=outListInternal;\n";

						} else if(function=="FOLD"){
						retTok+="List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();\n";
						retTok+="for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )\n";
						retTok+="{ \n";
						retTok+=betweenCurly+"\n";
						retTok+="} \n";
						}
					} 	
				}return retTok;
		}


	public exprParser(TokenStream input) {
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
			if ( listener instanceof exprListener ) ((exprListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitProg(this);
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
		public TerminalNode NEWLINE() { return getToken(exprParser.NEWLINE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitStat(this);
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
		public TerminalNode STRING() { return getToken(exprParser.STRING, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitE(this);
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
			 // each token must be a string...parse each string line by line
			 	String s = (((EContext)_localctx).a!=null?((EContext)_localctx).a.getText():null); // grab the value of the token
				((EContext)_localctx).v =  parse(s); // parse the value
				
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
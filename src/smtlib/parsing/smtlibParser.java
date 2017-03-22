// Generated from smtlib.g4 by ANTLR 4.6
package smtlib.parsing;
import java.util.List;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class smtlibParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, REAL=4, NUMERAL=5, HEX=6, BIN=7, SIMPLE_SYMBOL=8, 
		SYMBOL_CHAR=9, SYMBOL_OR_NUM_CHAR=10, QUOTED_SYMBOL=11, STRING=12, WS=13, 
		COMMENT=14, ERROR=15;
	public static final int
		RULE_program = 0, RULE_toplevel = 1, RULE_sexpr = 2, RULE_spec_constant = 3, 
		RULE_symbol = 4, RULE_keyword = 5;
	public static final String[] ruleNames = {
		"program", "toplevel", "sexpr", "spec_constant", "symbol", "keyword"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "REAL", "NUMERAL", "HEX", "BIN", "SIMPLE_SYMBOL", 
		"SYMBOL_CHAR", "SYMBOL_OR_NUM_CHAR", "QUOTED_SYMBOL", "STRING", "WS", 
		"COMMENT", "ERROR"
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
	public String getGrammarFileName() { return "smtlib.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public smtlibParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(smtlibParser.EOF, 0); }
		public List<SexprContext> sexpr() {
			return getRuleContexts(SexprContext.class);
		}
		public SexprContext sexpr(int i) {
			return getRuleContext(SexprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << REAL) | (1L << NUMERAL) | (1L << HEX) | (1L << BIN) | (1L << SIMPLE_SYMBOL) | (1L << QUOTED_SYMBOL) | (1L << STRING))) != 0)) {
				{
				{
				setState(12);
				sexpr();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);
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

	public static class ToplevelContext extends ParserRuleContext {
		public ToplevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toplevel; }
	 
		public ToplevelContext() { }
		public void copyFrom(ToplevelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TlContext extends ToplevelContext {
		public SexprContext sexpr() {
			return getRuleContext(SexprContext.class,0);
		}
		public TlContext(ToplevelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterTl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitTl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitTl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToplevelContext toplevel() throws RecognitionException {
		ToplevelContext _localctx = new ToplevelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_toplevel);
		try {
			_localctx = new TlContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			sexpr();
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

	public static class SexprContext extends ParserRuleContext {
		public SexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexpr; }
	 
		public SexprContext() { }
		public void copyFrom(SexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SymContext extends SexprContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public SymContext(SexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterSym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitSym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitSym(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SConstantContext extends SexprContext {
		public Spec_constantContext spec_constant() {
			return getRuleContext(Spec_constantContext.class,0);
		}
		public SConstantContext(SexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterSConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitSConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitSConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KwContext extends SexprContext {
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public KwContext(SexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterKw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitKw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitKw(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConsContext extends SexprContext {
		public List<SexprContext> sexpr() {
			return getRuleContexts(SexprContext.class);
		}
		public SexprContext sexpr(int i) {
			return getRuleContext(SexprContext.class,i);
		}
		public ConsContext(SexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterCons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitCons(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexprContext sexpr() throws RecognitionException {
		SexprContext _localctx = new SexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sexpr);
		int _la;
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL:
			case NUMERAL:
			case HEX:
			case BIN:
			case STRING:
				_localctx = new SConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				spec_constant();
				}
				break;
			case SIMPLE_SYMBOL:
			case QUOTED_SYMBOL:
				_localctx = new SymContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				symbol();
				}
				break;
			case T__2:
				_localctx = new KwContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				keyword();
				}
				break;
			case T__0:
				_localctx = new ConsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				match(T__0);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << REAL) | (1L << NUMERAL) | (1L << HEX) | (1L << BIN) | (1L << SIMPLE_SYMBOL) | (1L << QUOTED_SYMBOL) | (1L << STRING))) != 0)) {
					{
					{
					setState(26);
					sexpr();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Spec_constantContext extends ParserRuleContext {
		public Spec_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec_constant; }
	 
		public Spec_constantContext() { }
		public void copyFrom(Spec_constantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumeralConstantContext extends Spec_constantContext {
		public TerminalNode NUMERAL() { return getToken(smtlibParser.NUMERAL, 0); }
		public NumeralConstantContext(Spec_constantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterNumeralConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitNumeralConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitNumeralConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConstantContext extends Spec_constantContext {
		public TerminalNode STRING() { return getToken(smtlibParser.STRING, 0); }
		public StringConstantContext(Spec_constantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HexConstantContext extends Spec_constantContext {
		public TerminalNode HEX() { return getToken(smtlibParser.HEX, 0); }
		public HexConstantContext(Spec_constantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterHexConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitHexConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitHexConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealConstantContext extends Spec_constantContext {
		public TerminalNode REAL() { return getToken(smtlibParser.REAL, 0); }
		public RealConstantContext(Spec_constantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterRealConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitRealConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitRealConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinConstantContext extends Spec_constantContext {
		public TerminalNode BIN() { return getToken(smtlibParser.BIN, 0); }
		public BinConstantContext(Spec_constantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterBinConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitBinConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitBinConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Spec_constantContext spec_constant() throws RecognitionException {
		Spec_constantContext _localctx = new Spec_constantContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_spec_constant);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERAL:
				_localctx = new NumeralConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(NUMERAL);
				}
				break;
			case REAL:
				_localctx = new RealConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(REAL);
				}
				break;
			case HEX:
				_localctx = new HexConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(HEX);
				}
				break;
			case BIN:
				_localctx = new BinConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				match(BIN);
				}
				break;
			case STRING:
				_localctx = new StringConstantContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode SIMPLE_SYMBOL() { return getToken(smtlibParser.SIMPLE_SYMBOL, 0); }
		public TerminalNode QUOTED_SYMBOL() { return getToken(smtlibParser.QUOTED_SYMBOL, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(_la==SIMPLE_SYMBOL || _la==QUOTED_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode SIMPLE_SYMBOL() { return getToken(smtlibParser.SIMPLE_SYMBOL, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof smtlibListener ) ((smtlibListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof smtlibVisitor ) return ((smtlibVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_keyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__2);
			setState(45);
			match(SIMPLE_SYMBOL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\4\5\4$"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\5\5+\n\5\3\6\3\6\3\7\3\7\3\7\3\7\2\2\b\2\4\6"+
		"\b\n\f\2\3\4\2\n\n\r\r\64\2\21\3\2\2\2\4\26\3\2\2\2\6#\3\2\2\2\b*\3\2"+
		"\2\2\n,\3\2\2\2\f.\3\2\2\2\16\20\5\6\4\2\17\16\3\2\2\2\20\23\3\2\2\2\21"+
		"\17\3\2\2\2\21\22\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25\7\2\2\3\25"+
		"\3\3\2\2\2\26\27\5\6\4\2\27\5\3\2\2\2\30$\5\b\5\2\31$\5\n\6\2\32$\5\f"+
		"\7\2\33\37\7\3\2\2\34\36\5\6\4\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2"+
		"\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"$\7\4\2\2#\30\3\2\2\2#\31\3\2\2"+
		"\2#\32\3\2\2\2#\33\3\2\2\2$\7\3\2\2\2%+\7\7\2\2&+\7\6\2\2\'+\7\b\2\2("+
		"+\7\t\2\2)+\7\16\2\2*%\3\2\2\2*&\3\2\2\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2"+
		"\2+\t\3\2\2\2,-\t\2\2\2-\13\3\2\2\2./\7\5\2\2/\60\7\n\2\2\60\r\3\2\2\2"+
		"\6\21\37#*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from smtlib.g4 by ANTLR 4.6
package smtlib.parsing;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class smtlibLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, REAL=4, NUMERAL=5, HEX=6, BIN=7, SIMPLE_SYMBOL=8, 
		SYMBOL_CHAR=9, SYMBOL_OR_NUM_CHAR=10, QUOTED_SYMBOL=11, STRING=12, WS=13, 
		COMMENT=14, ERROR=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "REAL", "NUMERAL", "HEX", "BIN", "SIMPLE_SYMBOL", 
		"SYMBOL_CHAR", "SYMBOL_OR_NUM_CHAR", "QUOTED_SYMBOL", "STRING", "WS", 
		"COMMENT", "ERROR"
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


	public smtlibLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "smtlib.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\6\6-\n\6\r\6\16\6.\3\7\3\7\3\7\3\7\6\7\65\n\7"+
		"\r\7\16\7\66\3\b\3\b\3\b\3\b\6\b=\n\b\r\b\16\b>\3\t\3\t\7\tC\n\t\f\t\16"+
		"\tF\13\t\3\n\3\n\3\13\3\13\5\13L\n\13\3\f\3\f\3\f\7\fQ\n\f\f\f\16\fT\13"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\\\n\r\f\r\16\r_\13\r\3\r\3\r\3\16\6\16"+
		"d\n\16\r\16\16\16e\3\16\3\16\3\17\3\17\3\17\7\17m\n\17\f\17\16\17p\13"+
		"\17\3\17\5\17s\n\17\3\17\5\17v\n\17\3\17\5\17y\n\17\3\17\3\17\3\20\3\20"+
		"\4R]\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21\3\2\n\3\2\62;\5\2\62;CHch\3\2\62\63\13\2##&(,-/\61>\\"+
		"^^`ac|\u0080\u0080\3\2~~\5\2\13\f\16\17\"\"\5\2\f\f\17\17\'\'\4\2\f\f"+
		"\17\17\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2"+
		"\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13,\3\2\2\2\r\60\3\2\2\2\178\3"+
		"\2\2\2\21@\3\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31W\3\2\2\2\33"+
		"c\3\2\2\2\35i\3\2\2\2\37|\3\2\2\2!\"\7*\2\2\"\4\3\2\2\2#$\7+\2\2$\6\3"+
		"\2\2\2%&\7<\2\2&\b\3\2\2\2\'(\5\13\6\2()\7\60\2\2)*\5\13\6\2*\n\3\2\2"+
		"\2+-\t\2\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\f\3\2\2\2\60\61"+
		"\7%\2\2\61\62\7z\2\2\62\64\3\2\2\2\63\65\t\3\2\2\64\63\3\2\2\2\65\66\3"+
		"\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\16\3\2\2\289\7%\2\29:\7d\2\2:<\3"+
		"\2\2\2;=\t\4\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\20\3\2\2\2@"+
		"D\5\23\n\2AC\5\25\13\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\22\3\2"+
		"\2\2FD\3\2\2\2GH\t\5\2\2H\24\3\2\2\2IL\5\23\n\2JL\4\62;\2KI\3\2\2\2KJ"+
		"\3\2\2\2L\26\3\2\2\2MN\7~\2\2NR\n\6\2\2OQ\13\2\2\2PO\3\2\2\2QT\3\2\2\2"+
		"RS\3\2\2\2RP\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7~\2\2V\30\3\2\2\2W]\7$\2\2"+
		"XY\7$\2\2Y\\\7$\2\2Z\\\13\2\2\2[X\3\2\2\2[Z\3\2\2\2\\_\3\2\2\2]^\3\2\2"+
		"\2][\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7$\2\2a\32\3\2\2\2bd\t\7\2\2cb\3\2"+
		"\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\16\2\2h\34\3\2\2\2ir"+
		"\7=\2\2jn\n\b\2\2km\n\t\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2os"+
		"\3\2\2\2pn\3\2\2\2qs\3\2\2\2rj\3\2\2\2rq\3\2\2\2sx\3\2\2\2tv\7\17\2\2"+
		"ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wy\7\f\2\2xu\3\2\2\2xy\3\2\2\2yz\3\2\2\2"+
		"z{\b\17\2\2{\36\3\2\2\2|}\13\2\2\2} \3\2\2\2\20\2.\66>DKR[]enrux\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
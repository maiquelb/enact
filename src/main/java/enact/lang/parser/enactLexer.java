package enact.lang.parser;

// Generated from enact.g by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class enactLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TK_OR=12, TK_AND=13, TK_REL_OP=14, TK_IS=15, STRING=16, 
		NEGATION=17, TK_NEG=18, INTDIV=19, INTMOD=20, ATOM=21, VAR=22, DIGIT=23, 
		TERM_NULL=24, SPECIAL_CHAR_TERM=25, COMMENT_STAT=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "TK_OR", "TK_AND", "TK_REL_OP", "TK_IS", "STRING", "NEGATION", 
			"TK_NEG", "INTDIV", "INTMOD", "ATOM", "VAR", "DIGIT", "TERM_NULL", "SPECIAL_CHAR_TERM", 
			"COMMENT_STAT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'enact-as'", "'.'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
			"','", "'['", "']'", "'|'", "'&'", null, "'is'", null, "'not'", "'~'", 
			"'div'", "'mod'", null, null, null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TK_OR", "TK_AND", "TK_REL_OP", "TK_IS", "STRING", "NEGATION", "TK_NEG", 
			"INTDIV", "INTMOD", "ATOM", "VAR", "DIGIT", "TERM_NULL", "SPECIAL_CHAR_TERM", 
			"COMMENT_STAT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public enactLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "enact.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 26:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u001b\u00b2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\rh\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000fs\b\u000f\n\u000f\f\u000fv\t"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u008c\b\u0014\n\u0014\f\u0014"+
		"\u008f\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u0095\b\u0015\n\u0015\f\u0015\u0098\t\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u00a4\b\u0019\n\u0019\f\u0019\u00a7\t\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0004\u001a\u00ad\b\u001a"+
		"\u000b\u001a\f\u001a\u00ae\u0001\u001a\u0001\u001a\u0000\u0000\u001b\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b\u0001\u0000\u0004\u0002\u0000AZaz\u0003\u0000"+
		"$$@@__\u0007\u0000!!##%&*+-/::@@\u0003\u0000\n\n\r\r  \u00c5\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00017\u0001\u0000\u0000\u0000\u0003@\u0001"+
		"\u0000\u0000\u0000\u0005B\u0001\u0000\u0000\u0000\u0007D\u0001\u0000\u0000"+
		"\u0000\tF\u0001\u0000\u0000\u0000\u000bH\u0001\u0000\u0000\u0000\rJ\u0001"+
		"\u0000\u0000\u0000\u000fL\u0001\u0000\u0000\u0000\u0011N\u0001\u0000\u0000"+
		"\u0000\u0013P\u0001\u0000\u0000\u0000\u0015R\u0001\u0000\u0000\u0000\u0017"+
		"T\u0001\u0000\u0000\u0000\u0019V\u0001\u0000\u0000\u0000\u001bg\u0001"+
		"\u0000\u0000\u0000\u001di\u0001\u0000\u0000\u0000\u001fl\u0001\u0000\u0000"+
		"\u0000!y\u0001\u0000\u0000\u0000#}\u0001\u0000\u0000\u0000%\u007f\u0001"+
		"\u0000\u0000\u0000\'\u0083\u0001\u0000\u0000\u0000)\u0087\u0001\u0000"+
		"\u0000\u0000+\u0090\u0001\u0000\u0000\u0000-\u0099\u0001\u0000\u0000\u0000"+
		"/\u009b\u0001\u0000\u0000\u00001\u009d\u0001\u0000\u0000\u00003\u009f"+
		"\u0001\u0000\u0000\u00005\u00ac\u0001\u0000\u0000\u000078\u0005e\u0000"+
		"\u000089\u0005n\u0000\u00009:\u0005a\u0000\u0000:;\u0005c\u0000\u0000"+
		";<\u0005t\u0000\u0000<=\u0005-\u0000\u0000=>\u0005a\u0000\u0000>?\u0005"+
		"s\u0000\u0000?\u0002\u0001\u0000\u0000\u0000@A\u0005.\u0000\u0000A\u0004"+
		"\u0001\u0000\u0000\u0000BC\u0005+\u0000\u0000C\u0006\u0001\u0000\u0000"+
		"\u0000DE\u0005-\u0000\u0000E\b\u0001\u0000\u0000\u0000FG\u0005*\u0000"+
		"\u0000G\n\u0001\u0000\u0000\u0000HI\u0005/\u0000\u0000I\f\u0001\u0000"+
		"\u0000\u0000JK\u0005(\u0000\u0000K\u000e\u0001\u0000\u0000\u0000LM\u0005"+
		")\u0000\u0000M\u0010\u0001\u0000\u0000\u0000NO\u0005,\u0000\u0000O\u0012"+
		"\u0001\u0000\u0000\u0000PQ\u0005[\u0000\u0000Q\u0014\u0001\u0000\u0000"+
		"\u0000RS\u0005]\u0000\u0000S\u0016\u0001\u0000\u0000\u0000TU\u0005|\u0000"+
		"\u0000U\u0018\u0001\u0000\u0000\u0000VW\u0005&\u0000\u0000W\u001a\u0001"+
		"\u0000\u0000\u0000Xh\u0005<\u0000\u0000YZ\u0005<\u0000\u0000Zh\u0005="+
		"\u0000\u0000[h\u0005>\u0000\u0000\\]\u0005>\u0000\u0000]h\u0005=\u0000"+
		"\u0000^_\u0005=\u0000\u0000_h\u0005=\u0000\u0000`a\u0005\\\u0000\u0000"+
		"ab\u0005=\u0000\u0000bh\u0005=\u0000\u0000ch\u0005=\u0000\u0000de\u0005"+
		"=\u0000\u0000ef\u0005.\u0000\u0000fh\u0005.\u0000\u0000gX\u0001\u0000"+
		"\u0000\u0000gY\u0001\u0000\u0000\u0000g[\u0001\u0000\u0000\u0000g\\\u0001"+
		"\u0000\u0000\u0000g^\u0001\u0000\u0000\u0000g`\u0001\u0000\u0000\u0000"+
		"gc\u0001\u0000\u0000\u0000gd\u0001\u0000\u0000\u0000h\u001c\u0001\u0000"+
		"\u0000\u0000ij\u0005i\u0000\u0000jk\u0005s\u0000\u0000k\u001e\u0001\u0000"+
		"\u0000\u0000lt\u0005\"\u0000\u0000ms\u0007\u0000\u0000\u0000ns\u0003-"+
		"\u0016\u0000os\u0007\u0001\u0000\u0000ps\u00031\u0018\u0000qs\u0005 \u0000"+
		"\u0000rm\u0001\u0000\u0000\u0000rn\u0001\u0000\u0000\u0000ro\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000sv\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0005\"\u0000\u0000"+
		"x \u0001\u0000\u0000\u0000yz\u0005n\u0000\u0000z{\u0005o\u0000\u0000{"+
		"|\u0005t\u0000\u0000|\"\u0001\u0000\u0000\u0000}~\u0005~\u0000\u0000~"+
		"$\u0001\u0000\u0000\u0000\u007f\u0080\u0005d\u0000\u0000\u0080\u0081\u0005"+
		"i\u0000\u0000\u0081\u0082\u0005v\u0000\u0000\u0082&\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005m\u0000\u0000\u0084\u0085\u0005o\u0000\u0000\u0085"+
		"\u0086\u0005d\u0000\u0000\u0086(\u0001\u0000\u0000\u0000\u0087\u008d\u0002"+
		"az\u0000\u0088\u008c\u0007\u0000\u0000\u0000\u0089\u008c\u0003-\u0016"+
		"\u0000\u008a\u008c\u0007\u0001\u0000\u0000\u008b\u0088\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e*\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0096\u0002AZ\u0000\u0091\u0095"+
		"\u0007\u0000\u0000\u0000\u0092\u0095\u0003-\u0016\u0000\u0093\u0095\u0007"+
		"\u0001\u0000\u0000\u0094\u0091\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0098\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097,\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u000209\u0000\u009a.\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0005_\u0000\u0000\u009c0\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0007\u0002\u0000\u0000\u009e2\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"/\u0000\u0000\u00a0\u00a1\u0005*\u0000\u0000\u00a1\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\t\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005*\u0000\u0000\u00a9"+
		"\u00aa\u0005/\u0000\u0000\u00aa4\u0001\u0000\u0000\u0000\u00ab\u00ad\u0007"+
		"\u0003\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006"+
		"\u001a\u0000\u0000\u00b16\u0001\u0000\u0000\u0000\n\u0000grt\u008b\u008d"+
		"\u0094\u0096\u00a5\u00ae\u0001\u0001\u001a\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
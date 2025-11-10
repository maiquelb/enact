package enact.lang.parser;

// Generated from enact.g by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class enactParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TK_OR=13, TK_AND=14, TK_REL_OP=15, TK_IS=16, 
		STRING=17, NEGATION=18, TK_NEG=19, INTDIV=20, INTMOD=21, ATOM=22, VAR=23, 
		DIGIT=24, TERM_NULL=25, SPECIAL_CHAR_TERM=26, COMMENT_STAT=27, WS=28;
	public static final int
		RULE_enact_program = 0, RULE_enact_rule = 1, RULE_enact_effect = 2, RULE_y = 3, 
		RULE_sff_or_expr = 4, RULE_sff_and_expr = 5, RULE_sff_rel = 6, RULE_arithm_term = 7, 
		RULE_arithm_factor = 8, RULE_sff_atom = 9, RULE_sai__is_term = 10, RULE_pred = 11, 
		RULE_list_of_pred_terms = 12, RULE_pred_terms = 13, RULE_pred_term = 14, 
		RULE_annotation = 15, RULE_list = 16, RULE_list_term = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"enact_program", "enact_rule", "enact_effect", "y", "sff_or_expr", "sff_and_expr", 
			"sff_rel", "arithm_term", "arithm_factor", "sff_atom", "sai__is_term", 
			"pred", "list_of_pred_terms", "pred_terms", "pred_term", "annotation", 
			"list", "list_term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'enact-as'", "'.'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
			"'sai__is('", "','", "'['", "']'", "'|'", "'&'", null, "'is'", null, 
			"'not'", "'~'", "'div'", "'mod'", null, null, null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TK_OR", "TK_AND", "TK_REL_OP", "TK_IS", "STRING", "NEGATION", 
			"TK_NEG", "INTDIV", "INTMOD", "ATOM", "VAR", "DIGIT", "TERM_NULL", "SPECIAL_CHAR_TERM", 
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

	@Override
	public String getGrammarFileName() { return "enact.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public enactParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enact_programContext extends ParserRuleContext {
		public List<Enact_ruleContext> enact_rule() {
			return getRuleContexts(Enact_ruleContext.class);
		}
		public Enact_ruleContext enact_rule(int i) {
			return getRuleContext(Enact_ruleContext.class,i);
		}
		public Enact_programContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enact_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterEnact_program(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitEnact_program(this);
		}
	}

	public final Enact_programContext enact_program() throws RecognitionException {
		Enact_programContext _localctx = new Enact_programContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_enact_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				enact_rule();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 29622400L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class Enact_ruleContext extends ParserRuleContext {
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public Enact_effectContext enact_effect() {
			return getRuleContext(Enact_effectContext.class,0);
		}
		public Enact_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enact_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterEnact_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitEnact_rule(this);
		}
	}

	public final Enact_ruleContext enact_rule() throws RecognitionException {
		Enact_ruleContext _localctx = new Enact_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_enact_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			y();
			setState(42);
			match(T__0);
			setState(43);
			enact_effect();
			setState(44);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Enact_effectContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public Enact_effectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enact_effect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterEnact_effect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitEnact_effect(this);
		}
	}

	public final Enact_effectContext enact_effect() throws RecognitionException {
		Enact_effectContext _localctx = new Enact_effectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_enact_effect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			pred();
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

	@SuppressWarnings("CheckReturnValue")
	public static class YContext extends ParserRuleContext {
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public YContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitY(this);
		}
	}

	public final YContext y() throws RecognitionException {
		YContext _localctx = new YContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_y);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			sff_or_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sff_or_exprContext extends ParserRuleContext {
		public Sff_and_exprContext sff_and_expr() {
			return getRuleContext(Sff_and_exprContext.class,0);
		}
		public TerminalNode TK_OR() { return getToken(enactParser.TK_OR, 0); }
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public Sff_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterSff_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitSff_or_expr(this);
		}
	}

	public final Sff_or_exprContext sff_or_expr() throws RecognitionException {
		Sff_or_exprContext _localctx = new Sff_or_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sff_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			sff_and_expr();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_OR) {
				{
				setState(51);
				match(TK_OR);
				setState(52);
				sff_or_expr();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sff_and_exprContext extends ParserRuleContext {
		public Sff_relContext sff_rel() {
			return getRuleContext(Sff_relContext.class,0);
		}
		public TerminalNode TK_AND() { return getToken(enactParser.TK_AND, 0); }
		public Sff_and_exprContext sff_and_expr() {
			return getRuleContext(Sff_and_exprContext.class,0);
		}
		public Sff_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterSff_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitSff_and_expr(this);
		}
	}

	public final Sff_and_exprContext sff_and_expr() throws RecognitionException {
		Sff_and_exprContext _localctx = new Sff_and_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sff_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			sff_rel();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_AND) {
				{
				setState(56);
				match(TK_AND);
				setState(57);
				sff_and_expr();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sff_relContext extends ParserRuleContext {
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public Sff_relContext sff_rel() {
			return getRuleContext(Sff_relContext.class,0);
		}
		public TerminalNode TK_REL_OP() { return getToken(enactParser.TK_REL_OP, 0); }
		public TerminalNode TK_IS() { return getToken(enactParser.TK_IS, 0); }
		public Sff_relContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterSff_rel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitSff_rel(this);
		}
	}

	public final Sff_relContext sff_rel() throws RecognitionException {
		Sff_relContext _localctx = new Sff_relContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sff_rel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			arithm_term();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_REL_OP || _la==TK_IS) {
				{
				setState(61);
				_la = _input.LA(1);
				if ( !(_la==TK_REL_OP || _la==TK_IS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(62);
				sff_rel();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Arithm_termContext extends ParserRuleContext {
		public Arithm_factorContext arithm_factor() {
			return getRuleContext(Arithm_factorContext.class,0);
		}
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public Arithm_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterArithm_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitArithm_term(this);
		}
	}

	public final Arithm_termContext arithm_term() throws RecognitionException {
		Arithm_termContext _localctx = new Arithm_termContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arithm_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			arithm_factor();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2 || _la==T__3) {
				{
				setState(66);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(67);
				arithm_term();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Arithm_factorContext extends ParserRuleContext {
		public Sff_atomContext sff_atom() {
			return getRuleContext(Sff_atomContext.class,0);
		}
		public Arithm_factorContext arithm_factor() {
			return getRuleContext(Arithm_factorContext.class,0);
		}
		public TerminalNode INTDIV() { return getToken(enactParser.INTDIV, 0); }
		public TerminalNode INTMOD() { return getToken(enactParser.INTMOD, 0); }
		public Arithm_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterArithm_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitArithm_factor(this);
		}
	}

	public final Arithm_factorContext arithm_factor() throws RecognitionException {
		Arithm_factorContext _localctx = new Arithm_factorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arithm_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			sff_atom();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3145824L) != 0)) {
				{
				setState(71);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3145824L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(72);
				arithm_factor();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sff_atomContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(enactParser.NEGATION, 0); }
		public TerminalNode VAR() { return getToken(enactParser.VAR, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public List<TerminalNode> DIGIT() { return getTokens(enactParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(enactParser.DIGIT, i);
		}
		public Sff_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterSff_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitSff_atom(this);
		}
	}

	public final Sff_atomContext sff_atom() throws RecognitionException {
		Sff_atomContext _localctx = new Sff_atomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sff_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(75);
				match(NEGATION);
				}
			}

			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
			case VAR:
				{
				setState(80);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(78);
					match(VAR);
					}
					break;
				case ATOM:
					{
					setState(79);
					pred();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__6:
				{
				{
				setState(82);
				match(T__6);
				setState(83);
				sff_or_expr();
				setState(84);
				match(T__7);
				}
				}
				break;
			case DIGIT:
				{
				{
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					match(DIGIT);
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sai__is_termContext extends ParserRuleContext {
		public List<Pred_termContext> pred_term() {
			return getRuleContexts(Pred_termContext.class);
		}
		public Pred_termContext pred_term(int i) {
			return getRuleContext(Pred_termContext.class,i);
		}
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public Sai__is_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sai__is_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterSai__is_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitSai__is_term(this);
		}
	}

	public final Sai__is_termContext sai__is_term() throws RecognitionException {
		Sai__is_termContext _localctx = new Sai__is_termContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sai__is_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__8);
			setState(94);
			pred_term();
			setState(95);
			match(T__9);
			setState(96);
			pred_term();
			setState(97);
			match(T__9);
			setState(98);
			y();
			setState(99);
			match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PredContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(enactParser.ATOM, 0); }
		public List_of_pred_termsContext list_of_pred_terms() {
			return getRuleContext(List_of_pred_termsContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public PredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterPred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitPred(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pred);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(ATOM);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(102);
				list_of_pred_terms();
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(105);
				list();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class List_of_pred_termsContext extends ParserRuleContext {
		public Pred_termsContext pred_terms() {
			return getRuleContext(Pred_termsContext.class,0);
		}
		public List_of_pred_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_of_pred_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterList_of_pred_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitList_of_pred_terms(this);
		}
	}

	public final List_of_pred_termsContext list_of_pred_terms() throws RecognitionException {
		List_of_pred_termsContext _localctx = new List_of_pred_termsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_list_of_pred_terms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__6);
			setState(109);
			pred_terms();
			setState(110);
			match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Pred_termsContext extends ParserRuleContext {
		public List<Pred_termContext> pred_term() {
			return getRuleContexts(Pred_termContext.class);
		}
		public Pred_termContext pred_term(int i) {
			return getRuleContext(Pred_termContext.class,i);
		}
		public Pred_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterPred_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitPred_terms(this);
		}
	}

	public final Pred_termsContext pred_terms() throws RecognitionException {
		Pred_termsContext _localctx = new Pred_termsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pred_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			pred_term();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(113);
				match(T__9);
				setState(114);
				pred_term();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Pred_termContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(enactParser.VAR, 0); }
		public TerminalNode TERM_NULL() { return getToken(enactParser.TERM_NULL, 0); }
		public TerminalNode STRING() { return getToken(enactParser.STRING, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(enactParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(enactParser.DIGIT, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode ATOM() { return getToken(enactParser.ATOM, 0); }
		public List_of_pred_termsContext list_of_pred_terms() {
			return getRuleContext(List_of_pred_termsContext.class,0);
		}
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public Pred_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterPred_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitPred_term(this);
		}
	}

	public final Pred_termContext pred_term() throws RecognitionException {
		Pred_termContext _localctx = new Pred_termContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pred_term);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(VAR);
				}
				break;
			case TERM_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(TERM_NULL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(STRING);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(123);
					match(DIGIT);
					}
					}
					setState(126); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				list();
				}
				break;
			case ATOM:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(ATOM);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(130);
					list_of_pred_terms();
					}
				}

				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(133);
				match(T__6);
				setState(134);
				sff_or_expr();
				setState(135);
				match(T__7);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			list();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public List<List_termContext> list_term() {
			return getRuleContexts(List_termContext.class);
		}
		public List_termContext list_term(int i) {
			return getRuleContext(List_termContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__10);
			setState(142);
			list_term();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(143);
				match(T__9);
				setState(144);
				list_term();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class List_termContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public TerminalNode STRING() { return getToken(enactParser.STRING, 0); }
		public List_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).enterList_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof enactListener ) ((enactListener)listener).exitList_term(this);
		}
	}

	public final List_termContext list_term() throws RecognitionException {
		List_termContext _localctx = new List_termContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_list_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(152);
				list();
				}
				break;
			case T__6:
			case NEGATION:
			case ATOM:
			case VAR:
			case DIGIT:
				{
				setState(153);
				arithm_term();
				}
				break;
			case STRING:
				{
				setState(154);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0004"+
		"\u0000&\b\u0000\u000b\u0000\f\u0000\'\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u00046\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005;\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006@\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007E\b\u0007\u0001\b\u0001\b\u0001\b\u0003\bJ\b\b\u0001\t\u0003"+
		"\tM\b\t\u0001\t\u0001\t\u0003\tQ\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0004\tX\b\t\u000b\t\f\tY\u0003\t\\\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"h\b\u000b\u0001\u000b\u0003\u000bk\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0005\rt\b\r\n\r\f\rw\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0004\u000e}\b\u000e\u000b\u000e\f\u000e"+
		"~\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0084\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u008a\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0092\b\u0010\n\u0010\f\u0010\u0095\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u009c\b\u0011\u0001\u0011"+
		"\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0003\u0001\u0000\u000f\u0010"+
		"\u0001\u0000\u0003\u0004\u0002\u0000\u0005\u0006\u0014\u0015\u00a4\u0000"+
		"%\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0004.\u0001"+
		"\u0000\u0000\u0000\u00060\u0001\u0000\u0000\u0000\b2\u0001\u0000\u0000"+
		"\u0000\n7\u0001\u0000\u0000\u0000\f<\u0001\u0000\u0000\u0000\u000eA\u0001"+
		"\u0000\u0000\u0000\u0010F\u0001\u0000\u0000\u0000\u0012L\u0001\u0000\u0000"+
		"\u0000\u0014]\u0001\u0000\u0000\u0000\u0016e\u0001\u0000\u0000\u0000\u0018"+
		"l\u0001\u0000\u0000\u0000\u001ap\u0001\u0000\u0000\u0000\u001c\u0089\u0001"+
		"\u0000\u0000\u0000\u001e\u008b\u0001\u0000\u0000\u0000 \u008d\u0001\u0000"+
		"\u0000\u0000\"\u009b\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001\u0000"+
		"%$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(\u0001\u0001\u0000\u0000\u0000)*\u0003"+
		"\u0006\u0003\u0000*+\u0005\u0001\u0000\u0000+,\u0003\u0004\u0002\u0000"+
		",-\u0005\u0002\u0000\u0000-\u0003\u0001\u0000\u0000\u0000./\u0003\u0016"+
		"\u000b\u0000/\u0005\u0001\u0000\u0000\u000001\u0003\b\u0004\u00001\u0007"+
		"\u0001\u0000\u0000\u000025\u0003\n\u0005\u000034\u0005\r\u0000\u00004"+
		"6\u0003\b\u0004\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"6\t\u0001\u0000\u0000\u00007:\u0003\f\u0006\u000089\u0005\u000e\u0000"+
		"\u00009;\u0003\n\u0005\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;\u000b\u0001\u0000\u0000\u0000<?\u0003\u000e\u0007\u0000=>\u0007"+
		"\u0000\u0000\u0000>@\u0003\f\u0006\u0000?=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@\r\u0001\u0000\u0000\u0000AD\u0003\u0010\b\u0000BC"+
		"\u0007\u0001\u0000\u0000CE\u0003\u000e\u0007\u0000DB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000E\u000f\u0001\u0000\u0000\u0000FI\u0003"+
		"\u0012\t\u0000GH\u0007\u0002\u0000\u0000HJ\u0003\u0010\b\u0000IG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0011\u0001\u0000\u0000"+
		"\u0000KM\u0005\u0012\u0000\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000M[\u0001\u0000\u0000\u0000NQ\u0005\u0017\u0000\u0000OQ\u0003"+
		"\u0016\u000b\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000"+
		"Q\\\u0001\u0000\u0000\u0000RS\u0005\u0007\u0000\u0000ST\u0003\b\u0004"+
		"\u0000TU\u0005\b\u0000\u0000U\\\u0001\u0000\u0000\u0000VX\u0005\u0018"+
		"\u0000\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000"+
		"[P\u0001\u0000\u0000\u0000[R\u0001\u0000\u0000\u0000[W\u0001\u0000\u0000"+
		"\u0000\\\u0013\u0001\u0000\u0000\u0000]^\u0005\t\u0000\u0000^_\u0003\u001c"+
		"\u000e\u0000_`\u0005\n\u0000\u0000`a\u0003\u001c\u000e\u0000ab\u0005\n"+
		"\u0000\u0000bc\u0003\u0006\u0003\u0000cd\u0005\b\u0000\u0000d\u0015\u0001"+
		"\u0000\u0000\u0000eg\u0005\u0016\u0000\u0000fh\u0003\u0018\f\u0000gf\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000"+
		"ik\u0003 \u0010\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"k\u0017\u0001\u0000\u0000\u0000lm\u0005\u0007\u0000\u0000mn\u0003\u001a"+
		"\r\u0000no\u0005\b\u0000\u0000o\u0019\u0001\u0000\u0000\u0000pu\u0003"+
		"\u001c\u000e\u0000qr\u0005\n\u0000\u0000rt\u0003\u001c\u000e\u0000sq\u0001"+
		"\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000v\u001b\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000x\u008a\u0005\u0017\u0000\u0000y\u008a\u0005\u0019\u0000\u0000"+
		"z\u008a\u0005\u0011\u0000\u0000{}\u0005\u0018\u0000\u0000|{\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u008a\u0001\u0000\u0000\u0000\u0080\u008a"+
		"\u0003 \u0010\u0000\u0081\u0083\u0005\u0016\u0000\u0000\u0082\u0084\u0003"+
		"\u0018\f\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u008a\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0007"+
		"\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000\u0087\u0088\u0005\b\u0000"+
		"\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089x\u0001\u0000\u0000\u0000"+
		"\u0089y\u0001\u0000\u0000\u0000\u0089z\u0001\u0000\u0000\u0000\u0089|"+
		"\u0001\u0000\u0000\u0000\u0089\u0080\u0001\u0000\u0000\u0000\u0089\u0081"+
		"\u0001\u0000\u0000\u0000\u0089\u0085\u0001\u0000\u0000\u0000\u008a\u001d"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0003 \u0010\u0000\u008c\u001f\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\u000b\u0000\u0000\u008e\u0093\u0003"+
		"\"\u0011\u0000\u008f\u0090\u0005\n\u0000\u0000\u0090\u0092\u0003\"\u0011"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0005\f\u0000\u0000\u0097!\u0001\u0000\u0000\u0000"+
		"\u0098\u009c\u0003 \u0010\u0000\u0099\u009c\u0003\u000e\u0007\u0000\u009a"+
		"\u009c\u0005\u0011\u0000\u0000\u009b\u0098\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c"+
		"#\u0001\u0000\u0000\u0000\u0012\'5:?DILPY[gju~\u0083\u0089\u0093\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
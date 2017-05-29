// Generated from hcmb_macm3.g4 by ANTLR 4.4
package main;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class hcmb_macm3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__34=1, T__33=2, T__32=3, T__31=4, T__30=5, T__29=6, T__28=7, T__27=8, 
		T__26=9, T__25=10, T__24=11, T__23=12, T__22=13, T__21=14, T__20=15, T__19=16, 
		T__18=17, T__17=18, T__16=19, T__15=20, T__14=21, T__13=22, T__12=23, 
		T__11=24, T__10=25, T__9=26, T__8=27, T__7=28, T__6=29, T__5=30, T__4=31, 
		T__3=32, T__2=33, T__1=34, T__0=35, IDENTIFIER=36, INTEGERLITERAL=37, 
		SPACES=38, COMMENT_LINE=39, MULTILINE_COMMENT=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'main'", "'length'", "'new'", "'true'", "'return'", "'class'", 
		"'while'", "'void'", "'{'", "';'", "'&&'", "'='", "'extends'", "'}'", 
		"'if'", "'int'", "'('", "'*'", "'this'", "','", "'false'", "'.'", "'boolean'", 
		"'System.out.println'", "'['", "'<'", "'String'", "'public'", "']'", "'!'", 
		"'static'", "'else'", "')'", "'+'", "'-'", "IDENTIFIER", "INTEGERLITERAL", 
		"SPACES", "COMMENT_LINE", "MULTILINE_COMMENT"
	};
	public static final int
		RULE_type = 0, RULE_identifier = 1, RULE_formal = 2, RULE_varDecl = 3, 
		RULE_methodDecl = 4, RULE_main = 5, RULE_classDecl = 6, RULE_goal = 7, 
		RULE_statement = 8, RULE_expression = 9;
	public static final String[] ruleNames = {
		"type", "identifier", "formal", "varDecl", "methodDecl", "main", "classDecl", 
		"goal", "statement", "expression"
	};

	@Override
	public String getGrammarFileName() { return "hcmb_macm3.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public hcmb_macm3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type);
		try {
			setState(26);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20); match(T__19);
				setState(21); match(T__10);
				setState(22); match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); match(T__12);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24); match(T__19);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(25); identifier();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(hcmb_macm3Parser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); match(IDENTIFIER);
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

	public static class FormalContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); type();
			setState(31); identifier();
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

	public static class VarDeclContext extends ParserRuleContext {
		public FormalContext formal() {
			return getRuleContext(FormalContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); formal();
			setState(34); match(T__25);
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

	public static class MethodDeclContext extends ParserRuleContext {
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(T__7);
			setState(37); formal();
			setState(38); match(T__18);
			setState(47);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__12) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(39); formal();
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(40); match(T__15);
					setState(41); formal();
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(49); match(T__2);
			setState(50); match(T__26);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51); varDecl();
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__26) | (1L << T__20) | (1L << T__11) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(57); statement();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63); match(T__30);
			setState(64); expression(0);
			setState(65); match(T__25);
			setState(66); match(T__21);
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

	public static class MainContext extends ParserRuleContext {
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(T__29);
			setState(69); identifier();
			setState(70); match(T__26);
			setState(71); match(T__7);
			setState(72); match(T__4);
			setState(73); match(T__27);
			setState(74); match(T__34);
			setState(75); match(T__18);
			setState(76); match(T__8);
			setState(77); match(T__10);
			setState(78); match(T__6);
			setState(79); identifier();
			setState(80); match(T__2);
			setState(81); match(T__26);
			setState(82); statement();
			setState(83); match(T__21);
			setState(84); match(T__21);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(T__29);
			setState(87); identifier();
			setState(90);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(88); match(T__22);
				setState(89); identifier();
				}
			}

			setState(92); match(T__26);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__12) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(93); varDecl();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(99); methodDecl();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105); match(T__21);
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

	public static class GoalContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(hcmb_macm3Parser.EOF, 0); }
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitGoal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitGoal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); main();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(108); classDecl();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114); match(EOF);
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

	public static class StatementContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); match(T__26);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__26) | (1L << T__20) | (1L << T__11) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(117); statement();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123); match(T__21);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124); match(T__20);
				setState(125); match(T__18);
				setState(126); expression(0);
				setState(127); match(T__2);
				setState(128); statement();
				setState(129); match(T__3);
				setState(130); statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132); match(T__28);
				setState(133); match(T__18);
				setState(134); expression(0);
				setState(135); match(T__2);
				setState(136); statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(138); match(T__11);
				setState(139); match(T__18);
				setState(140); expression(0);
				setState(141); match(T__2);
				setState(142); match(T__25);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144); identifier();
				setState(145); match(T__23);
				setState(146); expression(0);
				setState(147); match(T__25);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149); identifier();
				setState(150); match(T__10);
				setState(151); expression(0);
				setState(152); match(T__6);
				setState(153); match(T__23);
				setState(154); expression(0);
				setState(155); match(T__25);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public TerminalNode INTEGERLITERAL() { return getToken(hcmb_macm3Parser.INTEGERLITERAL, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hcmb_macm3Listener ) ((hcmb_macm3Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hcmb_macm3Visitor ) return ((hcmb_macm3Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(160); match(T__5);
				setState(161); expression(2);
				}
				break;
			case 2:
				{
				setState(162); match(INTEGERLITERAL);
				}
				break;
			case 3:
				{
				setState(163); match(T__31);
				}
				break;
			case 4:
				{
				setState(164); match(T__14);
				}
				break;
			case 5:
				{
				setState(165); identifier();
				}
				break;
			case 6:
				{
				setState(166); match(T__16);
				}
				break;
			case 7:
				{
				setState(167); match(T__32);
				setState(168); match(T__19);
				setState(169); match(T__10);
				setState(170); expression(0);
				setState(171); match(T__6);
				}
				break;
			case 8:
				{
				setState(173); match(T__32);
				setState(174); identifier();
				setState(175); match(T__18);
				setState(176); match(T__2);
				}
				break;
			case 9:
				{
				setState(178); match(T__18);
				setState(179); expression(0);
				setState(180); match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(211);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(185);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__17) | (1L << T__9) | (1L << T__1) | (1L << T__0))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(186); expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(188); match(T__10);
						setState(189); expression(0);
						setState(190); match(T__6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(193); match(T__13);
						setState(194); match(T__33);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(196); match(T__13);
						setState(197); identifier();
						setState(198); match(T__18);
						setState(207);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__31) | (1L << T__18) | (1L << T__16) | (1L << T__14) | (1L << T__5) | (1L << IDENTIFIER) | (1L << INTEGERLITERAL))) != 0)) {
							{
							setState(199); expression(0);
							setState(204);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__15) {
								{
								{
								setState(200); match(T__15);
								setState(201); expression(0);
								}
								}
								setState(206);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(209); match(T__2);
						}
						break;
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 13);
		case 1: return precpred(_ctx, 12);
		case 2: return precpred(_ctx, 11);
		case 3: return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6-\n\6\f\6\16\6\60\13\6\5\6\62\n\6\3\6\3\6"+
		"\3\6\7\6\67\n\6\f\6\16\6:\13\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b]\n\b\3\b\3\b\7\ba\n\b\f\b\16\bd\13\b\3"+
		"\b\7\bg\n\b\f\b\16\bj\13\b\3\b\3\b\3\t\3\t\7\tp\n\t\f\t\16\ts\13\t\3\t"+
		"\3\t\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a0\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00b9\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00cd\n\13"+
		"\f\13\16\13\u00d0\13\13\5\13\u00d2\n\13\3\13\3\13\7\13\u00d6\n\13\f\13"+
		"\16\13\u00d9\13\13\3\13\2\3\24\f\2\4\6\b\n\f\16\20\22\24\2\3\6\2\r\r\24"+
		"\24\34\34$%\u00ef\2\34\3\2\2\2\4\36\3\2\2\2\6 \3\2\2\2\b#\3\2\2\2\n&\3"+
		"\2\2\2\fF\3\2\2\2\16X\3\2\2\2\20m\3\2\2\2\22\u009f\3\2\2\2\24\u00b8\3"+
		"\2\2\2\26\27\7\22\2\2\27\30\7\33\2\2\30\35\7\37\2\2\31\35\7\31\2\2\32"+
		"\35\7\22\2\2\33\35\5\4\3\2\34\26\3\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34"+
		"\33\3\2\2\2\35\3\3\2\2\2\36\37\7&\2\2\37\5\3\2\2\2 !\5\2\2\2!\"\5\4\3"+
		"\2\"\7\3\2\2\2#$\5\6\4\2$%\7\f\2\2%\t\3\2\2\2&\'\7\36\2\2\'(\5\6\4\2("+
		"\61\7\23\2\2).\5\6\4\2*+\7\26\2\2+-\5\6\4\2,*\3\2\2\2-\60\3\2\2\2.,\3"+
		"\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61)\3\2\2\2\61\62\3\2\2\2\62"+
		"\63\3\2\2\2\63\64\7#\2\2\648\7\13\2\2\65\67\5\b\5\2\66\65\3\2\2\2\67:"+
		"\3\2\2\28\66\3\2\2\289\3\2\2\29>\3\2\2\2:8\3\2\2\2;=\5\22\n\2<;\3\2\2"+
		"\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7\7\2\2BC\5\24"+
		"\13\2CD\7\f\2\2DE\7\20\2\2E\13\3\2\2\2FG\7\b\2\2GH\5\4\3\2HI\7\13\2\2"+
		"IJ\7\36\2\2JK\7!\2\2KL\7\n\2\2LM\7\3\2\2MN\7\23\2\2NO\7\35\2\2OP\7\33"+
		"\2\2PQ\7\37\2\2QR\5\4\3\2RS\7#\2\2ST\7\13\2\2TU\5\22\n\2UV\7\20\2\2VW"+
		"\7\20\2\2W\r\3\2\2\2XY\7\b\2\2Y\\\5\4\3\2Z[\7\17\2\2[]\5\4\3\2\\Z\3\2"+
		"\2\2\\]\3\2\2\2]^\3\2\2\2^b\7\13\2\2_a\5\b\5\2`_\3\2\2\2ad\3\2\2\2b`\3"+
		"\2\2\2bc\3\2\2\2ch\3\2\2\2db\3\2\2\2eg\5\n\6\2fe\3\2\2\2gj\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\20\2\2l\17\3\2\2\2mq\5\f\7\2"+
		"np\5\16\b\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2"+
		"\2tu\7\2\2\3u\21\3\2\2\2vz\7\13\2\2wy\5\22\n\2xw\3\2\2\2y|\3\2\2\2zx\3"+
		"\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u00a0\7\20\2\2~\177\7\21\2\2\177"+
		"\u0080\7\23\2\2\u0080\u0081\5\24\13\2\u0081\u0082\7#\2\2\u0082\u0083\5"+
		"\22\n\2\u0083\u0084\7\"\2\2\u0084\u0085\5\22\n\2\u0085\u00a0\3\2\2\2\u0086"+
		"\u0087\7\t\2\2\u0087\u0088\7\23\2\2\u0088\u0089\5\24\13\2\u0089\u008a"+
		"\7#\2\2\u008a\u008b\5\22\n\2\u008b\u00a0\3\2\2\2\u008c\u008d\7\32\2\2"+
		"\u008d\u008e\7\23\2\2\u008e\u008f\5\24\13\2\u008f\u0090\7#\2\2\u0090\u0091"+
		"\7\f\2\2\u0091\u00a0\3\2\2\2\u0092\u0093\5\4\3\2\u0093\u0094\7\16\2\2"+
		"\u0094\u0095\5\24\13\2\u0095\u0096\7\f\2\2\u0096\u00a0\3\2\2\2\u0097\u0098"+
		"\5\4\3\2\u0098\u0099\7\33\2\2\u0099\u009a\5\24\13\2\u009a\u009b\7\37\2"+
		"\2\u009b\u009c\7\16\2\2\u009c\u009d\5\24\13\2\u009d\u009e\7\f\2\2\u009e"+
		"\u00a0\3\2\2\2\u009fv\3\2\2\2\u009f~\3\2\2\2\u009f\u0086\3\2\2\2\u009f"+
		"\u008c\3\2\2\2\u009f\u0092\3\2\2\2\u009f\u0097\3\2\2\2\u00a0\23\3\2\2"+
		"\2\u00a1\u00a2\b\13\1\2\u00a2\u00a3\7 \2\2\u00a3\u00b9\5\24\13\4\u00a4"+
		"\u00b9\7\'\2\2\u00a5\u00b9\7\6\2\2\u00a6\u00b9\7\27\2\2\u00a7\u00b9\5"+
		"\4\3\2\u00a8\u00b9\7\25\2\2\u00a9\u00aa\7\5\2\2\u00aa\u00ab\7\22\2\2\u00ab"+
		"\u00ac\7\33\2\2\u00ac\u00ad\5\24\13\2\u00ad\u00ae\7\37\2\2\u00ae\u00b9"+
		"\3\2\2\2\u00af\u00b0\7\5\2\2\u00b0\u00b1\5\4\3\2\u00b1\u00b2\7\23\2\2"+
		"\u00b2\u00b3\7#\2\2\u00b3\u00b9\3\2\2\2\u00b4\u00b5\7\23\2\2\u00b5\u00b6"+
		"\5\24\13\2\u00b6\u00b7\7#\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00a1\3\2\2\2"+
		"\u00b8\u00a4\3\2\2\2\u00b8\u00a5\3\2\2\2\u00b8\u00a6\3\2\2\2\u00b8\u00a7"+
		"\3\2\2\2\u00b8\u00a8\3\2\2\2\u00b8\u00a9\3\2\2\2\u00b8\u00af\3\2\2\2\u00b8"+
		"\u00b4\3\2\2\2\u00b9\u00d7\3\2\2\2\u00ba\u00bb\f\17\2\2\u00bb\u00bc\t"+
		"\2\2\2\u00bc\u00d6\5\24\13\20\u00bd\u00be\f\16\2\2\u00be\u00bf\7\33\2"+
		"\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7\37\2\2\u00c1\u00d6\3\2\2\2\u00c2"+
		"\u00c3\f\r\2\2\u00c3\u00c4\7\30\2\2\u00c4\u00d6\7\4\2\2\u00c5\u00c6\f"+
		"\f\2\2\u00c6\u00c7\7\30\2\2\u00c7\u00c8\5\4\3\2\u00c8\u00d1\7\23\2\2\u00c9"+
		"\u00ce\5\24\13\2\u00ca\u00cb\7\26\2\2\u00cb\u00cd\5\24\13\2\u00cc\u00ca"+
		"\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7#\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00ba\3\2\2\2\u00d5\u00bd\3\2\2\2\u00d5\u00c2\3\2\2\2\u00d5\u00c5\3\2"+
		"\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\25\3\2\2\2\u00d9\u00d7\3\2\2\2\22\34.\618>\\bhqz\u009f\u00b8\u00ce\u00d1"+
		"\u00d5\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
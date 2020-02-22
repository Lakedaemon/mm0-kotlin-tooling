package org.lakedaemon.mm0.plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import org.lakedaemon.mm0.plugin.psi.MM0Types;

%%

%class MM0Lexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

COMMENTS = ('--' [^\n]* '\n')+
WHITE_STUFF = [\ \n\t\f\r]+
MATH_STRING = '\$' [^\$]* '\$'
ID = [a-zA-Z_][a-zA-Z0-9_]*
NUMBER = 0 | [1-9][0-9]*
//STAR = "*"
DOT = "."
COLON = ":"
SEMI_COLON = ";"
LEFT_PARENTHESIS = "("
RIGHT_PARENTHESIS = ")"
GREATER = ">"
LEFT_BRACE ="{"
RIGHT_BRACE = "}"
EQUAL = "="
UNDERSCORE = "_"


%state WAITING_VALUE

%%

<YYINITIAL> {COMMENTS}                { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;}
<YYINITIAL> {WHITE_STUFF}             { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;}
<YYINITIAL> {MATH_STRING}             { yybegin(YYINITIAL); return MM0Types.MATH_STRING;}
<YYINITIAL> {ID}                      { yybegin(YYINITIAL); return MM0Types.ID; }
<YYINITIAL> {NUMBER}                  { yybegin(YYINITIAL); return MM0Types.NUMBER; }
<YYINITIAL> {DOT}                     { yybegin(YYINITIAL); return MM0Types.DOT; }
<YYINITIAL> {DOT}                     { yybegin(YYINITIAL); return MM0Types.DOT; }
<YYINITIAL> {COLON}                   { yybegin(YYINITIAL); return MM0Types.COLON; }
<YYINITIAL> {SEMI_COLON}              { yybegin(YYINITIAL); return MM0Types.SEMI_COLON; }
<YYINITIAL> {LEFT_PARENTHESIS}        { yybegin(YYINITIAL); return MM0Types.LEFT_PARENTHESIS; }
<YYINITIAL> {RIGHT_PARENTHESIS}       { yybegin(YYINITIAL); return MM0Types.RIGHT_PARENTHESIS; }
<YYINITIAL> {LEFT_BRACE}              { yybegin(YYINITIAL); return MM0Types.LEFT_BRACE; }
<YYINITIAL> {RIGHT_BRACE}             { yybegin(YYINITIAL); return MM0Types.RIGHT_BRACE; }
<YYINITIAL> {EQUAL}                   { yybegin(YYINITIAL); return MM0Types.EQUAL; }
<YYINITIAL> {UNDERSCORE}              { yybegin(YYINITIAL); return MM0Types.UNDERSCORE; }



[^]                                   { return TokenType.BAD_CHARACTER; }

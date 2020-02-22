package org.lakedaemon.mm0.plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;import org.lakedaemon.mm0.plugin.psi.MMUTypes;

%%

%class MMULexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \n\t\f\r]+
LEFT_PARENTHESIS = "("
RIGHT_PARENTHESIS = ")"
ID=[0-9a-zA-Z_]+



%state WAITING_VALUE

%%



<YYINITIAL> {WHITE_SPACE}+                          { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;}
<YYINITIAL> {LEFT_PARENTHESIS}                           { yybegin(YYINITIAL); return MMUTypes.LEFT_PARENTHESIS; }
<YYINITIAL> {RIGHT_PARENTHESIS}                           { yybegin(YYINITIAL); return MMUTypes.RIGHT_PARENTHESIS; }

<YYINITIAL> {ID}                           { yybegin(YYINITIAL); return MMUTypes.ID; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
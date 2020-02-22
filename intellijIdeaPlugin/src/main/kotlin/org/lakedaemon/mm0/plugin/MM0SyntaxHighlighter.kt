package org.lakedaemon.mm0.plugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.lakedaemon.mm0.plugin.psi.MM0Types
import org.lakedaemon.mm0.plugin.psi.MMUTypes


class MM0SyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer =MM0LexerAdapter()


    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> = when(tokenType) {
        MM0Types.LEFT_PARENTHESIS -> PARENTHESIS_KEYS
        MM0Types.RIGHT_PARENTHESIS -> PARENTHESIS_KEYS
        MM0Types.ID -> IDENTIFIER_KEYS
        MM0Types.FORMULA -> FORMULA_KEYS
        else -> STRING_KEYS
    }

    companion object {
        val ID : TextAttributesKey = createTextAttributesKey("Identifier", DefaultLanguageHighlighterColors.IDENTIFIER)
        //val SORT : TextAttributesKey = createTextAttributesKey("Sort", DefaultLanguageHighlighterColors.CLASS_NAME)
        val BRACES : TextAttributesKey = createTextAttributesKey("Braces", DefaultLanguageHighlighterColors.BRACES)
        val PARENTHESIS : TextAttributesKey = createTextAttributesKey("Parentheses", DefaultLanguageHighlighterColors.PARENTHESES)

        val COLON : TextAttributesKey = createTextAttributesKey("Colon", DefaultLanguageHighlighterColors.SEMICOLON)
        val FORMULA : TextAttributesKey = createTextAttributesKey("Colon", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)

        val KEYWORD: TextAttributesKey = createTextAttributesKey("Keyword", DefaultLanguageHighlighterColors.KEYWORD)
        val MODIFIER: TextAttributesKey = createTextAttributesKey("Modifier", DefaultLanguageHighlighterColors.METADATA)

        val STRING: TextAttributesKey = createTextAttributesKey("String", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER: TextAttributesKey = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val PARENTHESIS_KEYS = arrayOf(PARENTHESIS)
        private val BRACES_KEYS = arrayOf(BRACES)
        //private val KEYWORD_KEYS = arrayOf(KEYWORD)
        //private val SORT_KEYS = arrayOf(SORT)
        private val STRING_KEYS = arrayOf(STRING)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val IDENTIFIER_KEYS = arrayOf(ID)
        private val FORMULA_KEYS = arrayOf(FORMULA)
        private val COLON_KEYS = arrayOf(COLON)
        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }
}
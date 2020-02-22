package org.lakedaemon.mm0.plugin

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.lakedaemon.mm0.plugin.psi.MMUTypes


class MMUParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = MMULexerAdapter()
    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACES
    override fun getCommentTokens(): TokenSet =TokenSet.EMPTY
    override fun getStringLiteralElements(): TokenSet =TokenSet.EMPTY
    override fun createParser(project: Project): PsiParser = MMUParser()
    override fun getFileNodeType(): IFileElementType = FILE
    override fun createFile(viewProvider: FileViewProvider): PsiFile =MMUFile(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode,right: ASTNode): SpaceRequirements = SpaceRequirements.MAY
    override fun createElement(node: ASTNode): PsiElement = MMUTypes.Factory.createElement(node)

    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val FILE = IFileElementType(MMULanguage.INSTANCE)
    }
}
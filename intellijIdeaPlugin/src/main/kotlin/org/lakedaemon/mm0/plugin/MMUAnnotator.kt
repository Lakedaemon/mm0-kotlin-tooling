package org.lakedaemon.mm0.plugin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement


class MMUAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) { // Ensure the Psi Element is an expression

        if (element.children.isNotEmpty()) return
        val res = map[element.text] ?: return
        val range = TextRange.from(element.textRange.startOffset, element.text.length)
        val keyRange = TextRange(range.startOffset, range.endOffset)

        val annotation = holder.createInfoAnnotation(keyRange, null);
        annotation.textAttributes = res
    }

    val map = mutableMapOf(
        "term" to MMUSyntaxHighlighter.KEYWORD,
        "sort" to MMUSyntaxHighlighter.KEYWORD,
        "theorem" to MMUSyntaxHighlighter.KEYWORD,
        "def" to MMUSyntaxHighlighter.KEYWORD,
        "pub" to MMUSyntaxHighlighter.MODIFIER,
        "local" to MMUSyntaxHighlighter.MODIFIER,
        "pure" to MMUSyntaxHighlighter.MODIFIER,
        "strict" to MMUSyntaxHighlighter.MODIFIER,
        "provable" to MMUSyntaxHighlighter.MODIFIER,
        "free" to MMUSyntaxHighlighter.MODIFIER
    )

    companion object {
        // Define strings for the Simple language prefix - used for annotations, line markers, etc.
        const val SIMPLE_PREFIX_STR = "simple"
        const val SIMPLE_SEPARATOR_STR = ":"
    }
}
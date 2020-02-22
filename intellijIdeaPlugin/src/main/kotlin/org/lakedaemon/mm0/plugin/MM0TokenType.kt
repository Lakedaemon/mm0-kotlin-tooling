package org.lakedaemon.mm0.plugin

import com.intellij.psi.tree.IElementType


class MM0TokenType(debugName: String) : IElementType(debugName, MM0Language.INSTANCE) {
    override fun toString(): String = "MM0TokenType.${super.toString()}"
}
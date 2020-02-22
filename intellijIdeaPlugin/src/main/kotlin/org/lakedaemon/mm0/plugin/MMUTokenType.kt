package org.lakedaemon.mm0.plugin

import com.intellij.psi.tree.IElementType


class MMUTokenType(debugName: String) : IElementType(debugName, MMULanguage.INSTANCE) {
    override fun toString(): String = "MMUTokenType.${super.toString()}"
}
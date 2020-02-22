package org.lakedaemon.mm0.plugin

import com.intellij.lexer.FlexAdapter
import java.io.Reader


class MM0LexerAdapter : FlexAdapter(MM0Lexer(null as Reader?))
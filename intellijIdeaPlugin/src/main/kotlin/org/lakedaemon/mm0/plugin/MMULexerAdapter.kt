package org.lakedaemon.mm0.plugin

import com.intellij.lexer.FlexAdapter
import java.io.Reader


class MMULexerAdapter : FlexAdapter(MMULexer(null as Reader?))
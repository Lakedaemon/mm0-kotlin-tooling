package org.lakedaemon.mm0.plugin

import com.intellij.lang.Language

class MMULanguage private constructor(): Language("MMU") {
    companion object {
        val INSTANCE = MMULanguage()
    }
}
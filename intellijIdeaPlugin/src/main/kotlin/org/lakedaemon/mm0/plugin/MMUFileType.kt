package org.lakedaemon.mm0.plugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class MMUFileType private constructor() : LanguageFileType(MMULanguage.INSTANCE) {
    override fun getName(): String ="mmu file"
    override fun getDescription(): String="mmu language file"
    override fun getDefaultExtension(): String = "mmu"
    override fun getIcon(): Icon? = Icons.MMU
    companion object {
        val INSTANCE = MMUFileType()
    }
}
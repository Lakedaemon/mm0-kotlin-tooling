package org.lakedaemon.mm0.plugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class MM0FileType private constructor() : LanguageFileType(MM0Language.INSTANCE) {
    override fun getName(): String ="mm0 file"
    override fun getDescription(): String="mm0 language file"
    override fun getDefaultExtension(): String = "mm0"
    override fun getIcon(): Icon? = Icons.MM0
    companion object {
        val INSTANCE = MM0FileType()
    }
}
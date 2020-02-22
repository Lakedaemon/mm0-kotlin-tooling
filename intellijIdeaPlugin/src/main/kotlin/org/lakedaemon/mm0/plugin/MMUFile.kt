package org.lakedaemon.mm0.plugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MMUFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MMULanguage.INSTANCE) {
    override fun getFileType(): FileType = MMUFileType.INSTANCE
    override fun toString(): String = "Mmu File"
}
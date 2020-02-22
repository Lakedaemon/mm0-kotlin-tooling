package org.lakedaemon.mm0.plugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MM0File(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MM0Language.INSTANCE) {
    override fun getFileType(): FileType = MM0FileType.INSTANCE
    override fun toString(): String = "Mm0 File"
}
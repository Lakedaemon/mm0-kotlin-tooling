package org.lakedaemon.mm0.plugin;

import com.intellij.lang.Language


// https://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/registering_file_type.html
// https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/language_and_filetype.html
class MM0Language private constructor(): Language("MM0") {
    companion object {
        val INSTANCE = MM0Language()
    }
}
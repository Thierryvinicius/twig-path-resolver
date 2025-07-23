package com.thierry.twigpathresolver

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class TwigReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val file = element.containingFile
                    if (file == null || !file.name.endsWith(".php")) {
                        return PsiReference.EMPTY_ARRAY
                    }
                    val text = element.text
                    if (text.startsWith("\"") || text.startsWith("'")) {
                        val value = text.trim('"', '\'')
                        return arrayOf(TwigViewReference(element, value))
                    }
                    return PsiReference.EMPTY_ARRAY
                }
            }
        )
    }
}

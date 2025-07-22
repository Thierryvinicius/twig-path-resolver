package com.thierry.twigpathresolver

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope

class TwigViewReference(
    element: PsiElement,
    private val path: String
) : PsiReferenceBase<PsiElement>(element, TextRange(1, element.textLength - 1)) {

    override fun resolve(): PsiElement? {
        val project = myElement.project
        val viewPath = "views/$path.html"

        val targetName = path.substringAfterLast("/") + ".html"

        val files = FilenameIndex.getVirtualFilesByName(
            project,
            targetName,
            GlobalSearchScope.projectScope(project)
        )

        return files.firstOrNull { it.path.contains(viewPath) }?.let {
            PsiManager.getInstance(project).findFile(it)
        }
    }

    override fun getVariants(): Array<Any> = emptyArray()
}

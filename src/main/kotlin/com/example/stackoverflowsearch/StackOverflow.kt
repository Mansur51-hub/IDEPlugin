package com.example.stackoverflowsearch

import com.intellij.execution.console.LanguageConsoleImpl.ConsoleEditorsPanel
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformCoreDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.ui.Messages
import com.intellij.ui.AnActionButton
import java.net.URL

class StackOverflow : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(PlatformDataKeys.EDITOR);
        var text = editor?.selectionModel?.selectedText;
        if (text != null) {
            text = text.replace(' ', '+')
        }; else {
            Messages.showWarningDialog("Please select text for searching", "err");
            return
        }
        val url = String.format("https://stackoverflow.com/search?q=%s", text)
        BrowserUtil.browse(url);
    }

}
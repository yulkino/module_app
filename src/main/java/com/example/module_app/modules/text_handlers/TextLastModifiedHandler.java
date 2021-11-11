package com.example.module_app.modules.text_handlers;

import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

@Component
public class TextLastModifiedHandler extends TextHandler {
    @Override
    public void process(File text, ConsoleUI consoleUI) {
        var lastModified = new Date(text.lastModified());

        consoleUI.showSomeString("Дата последнего редактирования: " + lastModified);
    }

    @Override
    public String getFunctionsDescription() {
        return "Узнать дату последнего редактирования";
    }
}

package com.example.module_app.modules.text_handlers;

import com.drew.lang.Charsets;
import com.example.module_app.ui.ConsoleUI;
import com.google.common.io.Files;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Component
public class TextLineCountHandler extends TextHandler {
    @Override
    public void process(File text, ConsoleUI consoleUI) {
        int num = 0;

        try {
            num = Files.readLines(text, StandardCharsets.UTF_8).size();
        }
        catch (Exception e) {
            consoleUI.showSomeString("Произошла ошибка");
        }

        consoleUI.showSomeString("Количество строк :" + num);
    }

    @Override
    public String getFunctionsDescription() {
        return "Подсчет и вывод количества строк";
    }
}

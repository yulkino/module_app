package com.example.module_app.modules.text_handlers;

import com.drew.lang.Charsets;
import com.example.module_app.ui.ConsoleUI;
import com.google.common.io.Files;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;

@Component
public class TextCharFrequencyHandler extends TextHandler {
    @Override
    public void process(File text, ConsoleUI consoleUI) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        String str;
        try {
            str = Files.asCharSource(text, Charsets.UTF_8).read();
        }
        catch (Exception e) {
            consoleUI.showSomeString("Произошла ошибка");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            if(Character.isLetter(c))
                chars.merge(c, 1, (a, b) -> a + b);
        }

        consoleUI.showMap(chars);
    }

    @Override
    public String getFunctionsDescription() {
        return "Вывод частоты вхождения каждого символа";
    }
}

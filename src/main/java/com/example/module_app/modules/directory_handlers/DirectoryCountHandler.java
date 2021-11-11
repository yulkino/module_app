package com.example.module_app.modules.directory_handlers;

import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoryCountHandler extends DirectoryHandler {
    @Override
    public void process(File directory, ConsoleUI consoleUI) {
        var count = 0;

        for(var file : directory.listFiles()) {
            count += file.length();
        }

        consoleUI.showSomeString("Размер всех элементов в директории: " + count + "b");
    }

    @Override
    public String getFunctionsDescription() {
        return "Подсчет размера всех файлов в каталоге";
    }
}

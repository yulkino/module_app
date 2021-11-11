package com.example.module_app.modules.directory_handlers;

import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoryCountOfDirectoriesHandler extends DirectoryHandler {
    @Override
    public void process(File directory, ConsoleUI consoleUI) {
        long count = 0;
        for(File file : directory.listFiles()){
            if (file.isDirectory())
                count += 1;
        }

        consoleUI.showSomeString("Количество директорий в этой директории: " + count);
    }

    @Override
    public String getFunctionsDescription() {
        return "Подсчёт количества директоий в данной директории";
    }
}

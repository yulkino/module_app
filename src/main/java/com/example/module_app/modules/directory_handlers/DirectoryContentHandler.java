package com.example.module_app.modules.directory_handlers;

import com.example.module_app.modules.Handler;
import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoryContentHandler extends DirectoryHandler {
    @Override
    public void process(File directory, ConsoleUI consoleUI) {
        for(var file : directory.listFiles()) {
            consoleUI.showSomeString(file.getName());
        }
    }

    @Override
    public String getFunctionsDescription(){
        return "Вывод всего списка содержимого файлов в каталоге";
    }
}

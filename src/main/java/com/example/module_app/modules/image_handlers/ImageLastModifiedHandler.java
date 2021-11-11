package com.example.module_app.modules.image_handlers;

import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

@Component
public class ImageLastModifiedHandler extends ImageHandler{
    @Override
    public void process(File image, ConsoleUI consoleUI) {
        Date lastModified = new Date(image.lastModified());

        consoleUI.showSomeString("Дата последнего редактирования: " + lastModified);
    }

    @Override
    public String getFunctionsDescription() {
        return "Узнать дату последнего редактирования";
    }
}

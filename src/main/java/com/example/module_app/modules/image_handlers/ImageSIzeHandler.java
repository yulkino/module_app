package com.example.module_app.modules.image_handlers;

import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageSIzeHandler extends ImageHandler {
    @Override
    public void process(File image, ConsoleUI consoleUI) {
        var length = image.length() / 1024;

        consoleUI.showSomeString("Размер картинки: " + length + "Кб");
    }

    @Override
    public String getFunctionsDescription() {
        return "Узнать размер картинкии в Кб";
    }
}

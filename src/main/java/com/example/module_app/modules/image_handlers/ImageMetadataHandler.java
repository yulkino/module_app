package com.example.module_app.modules.image_handlers;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.example.module_app.ui.ConsoleUI;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageMetadataHandler extends ImageHandler {
    @Override
    public void process(File image, ConsoleUI consoleUI) {
        List<String> result = new ArrayList<>();
        Metadata metadata;
        try {
            metadata = ImageMetadataReader.readMetadata(image);
        }
        catch (Exception e) {
            consoleUI.showSomeString("Произошла ошибка во время получения метаданных");
            return;
        }

        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                result.add(directory.getName() + " - " + tag.getTagName()+ " = " + tag.getDescription());
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }
        consoleUI.showSomeString("Метаданные: \n");
        consoleUI.showListOfItem(result);
    }

    @Override
    public String getFunctionsDescription() {
        return "Узнать метаданные";
    }
}

package com.example.module_app.modules.text_handlers;

import com.example.module_app.modules.Handler;
import com.example.module_app.ui.ConsoleUI;
import com.example.module_app.util.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class TextHandler implements Handler {
    @Autowired
    protected FileHelper fileHelper;

    private final List<String> fileExtends = new ArrayList<>();{
        fileExtends.add("txt");
        fileExtends.add("docx");
    }

    public boolean isExtendService(File file){
        return fileExtends.contains(fileHelper.getFileExtension(file));
    }
}

package com.example.module_app.modules.image_handlers;

import com.example.module_app.modules.Handler;
import com.example.module_app.util.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class ImageHandler implements Handler {
    @Autowired
    protected FileHelper fileHelper;

    private final List<String> fileExtends = new ArrayList<>();{
        fileExtends.add("jpeg");
        fileExtends.add("jpg");
        fileExtends.add("png");
    }

    @Override
    public boolean isExtendService(File file){
        return fileExtends.contains(fileHelper.getFileExtension(file));
    }
}

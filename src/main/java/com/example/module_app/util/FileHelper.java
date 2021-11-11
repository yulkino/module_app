package com.example.module_app.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Locale;

@Component
public class FileHelper {
    public File findAndSetFile(String fileName){
        File file = null;
        try{
            file = new File(fileName);
        }
        catch (NullPointerException e){
            e.getMessage();
            System.out.println("File not found");
        }
        return file;
    }

    public String getFileExtension(File file){
        String name = file.getName();
        String ext = "";
        if(name.contains("."))
            ext = name.substring(file.getName().indexOf('.')).replace(".", "").toLowerCase(Locale.ROOT);
        return ext;
    }
}

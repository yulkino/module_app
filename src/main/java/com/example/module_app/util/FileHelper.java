package com.example.module_app.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Locale;

@Component
public class FileHelper {

    private File file;

    public void findAndSetFile(String fileName){
        try{
            this.file = new File(fileName);
        }
        catch (NullPointerException e){
            e.getMessage();
            System.out.println("File not found");
        }
    }

    public String getFileExtend(){
        String name = file.getName();
        String ext = "";
        if(name.contains("."))
            ext = name.substring(file.getName().indexOf('.')).replace(".", "").toLowerCase(Locale.ROOT);
        return ext;
    }

    public File getFile() {
        return file;
    }


}

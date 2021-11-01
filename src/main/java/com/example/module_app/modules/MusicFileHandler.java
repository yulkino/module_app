package com.example.module_app.modules;

import com.drew.imaging.ImageProcessingException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MusicFileHandler implements Handler {

    private final List<String> fileExtends = new ArrayList<>();{
        fileExtends.add("mp3");
        fileExtends.add("wav");
    }

    private File musicFile;

    public String getFunctionsDescription() {
        return "1. вывод названия трека из тегов \n" +
                "2. вывод длительности в секундах \n" +
                "3. узнать дату последнего редактирования \n";
    }

    public boolean isExtendService(String ext){
        return fileExtends.contains(ext);
    }

    public List<String> getMusicNameAndTags() throws ImageProcessingException, IOException {
        return null;
    }

    public double getDuration(){
        return 0;
    }

    public Date getDataOfLastModifying(){
        return new Date(musicFile.lastModified());
    }

    public void setFile(File musicFile) {
        this.musicFile = musicFile;
    }
}

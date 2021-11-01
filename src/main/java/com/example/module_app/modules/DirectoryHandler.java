package com.example.module_app.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Component
public class DirectoryHandler implements Handler {

    private File directory;

    public String getFunctionsDescription(){
        return "1. вывод всего(!) списка содержимого файлов в каталоге \n" +
                "2. подсчет размера всех файлов(!) в каталоге \n" +
                "3. подсчёт количества директоий(!) в данной директории \n";
    }

    public List<File> getAllFilesInside(){
        return Arrays.asList(directory.listFiles());
    }

    public long getAllFilesSizeInKb(){
        long totalSize = 0;
        for(File f : getAllFilesInside()){
            if(f.isFile())
                totalSize += f.length();
        }
        return totalSize/1024;
    }

    public long getDirectoriesCount(){
        long totalCount = 0;
        for(File f : getAllFilesInside()){
            if(!f.isFile())
                totalCount += 1;
        }
        return totalCount;
    }

    public void setFile(File directory) {
        this.directory = directory;
    }

    @Override
    public boolean isExtendService(String ext) {
        return ext.equals("");
    }
}

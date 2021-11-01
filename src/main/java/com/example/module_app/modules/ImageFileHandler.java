package com.example.module_app.modules;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ImageFileHandler implements Handler {

    private final List<String> fileExtends = new ArrayList<>();{
        fileExtends.add("jpeg");
        fileExtends.add("jpg");
        fileExtends.add("png");
    }

    private File imageFile;

    public String getFunctionsDescription() {
        return "1. узнать размер картинкии в Кб \n" +
                "2. узнать мета данные \n" +
                "3. узнать дату последнего редактирования \n";
    }

    public boolean isExtendService(String ext){
        return fileExtends.contains(ext);
    }

    public long getImageSizeInKb(){
        return imageFile.length() / 1024;
    }

    public List<String> getExif() throws ImageProcessingException, IOException {
        List<String> result = new ArrayList<>();
        Metadata metadata = ImageMetadataReader.readMetadata(imageFile);

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
        return result;
    }

    public Date getDataOfLastModifying(){
        return new Date(imageFile.lastModified());
    }

    public void setFile(File imageFile) {
        this.imageFile = imageFile;
    }
}

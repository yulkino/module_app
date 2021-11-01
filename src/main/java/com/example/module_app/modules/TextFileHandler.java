package com.example.module_app.modules;

import com.drew.lang.Charsets;
import com.google.common.io.Files;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class TextFileHandler implements Handler {

    private final List<String> fileExtends = new ArrayList<>();{
        fileExtends.add("txt");
        fileExtends.add("docx");
    }
    private File textFile;

    public String getFunctionsDescription() {
        return "1. подсчет и вывод количества строк \n" +
                "2. вывод частоты вхождения каждого символа \n" +
                "3. узнать дату последнего редактирования \n";
    }

    public boolean isExtendService(String ext){
        return fileExtends.contains(ext);
    }

    public long getAllLinesCount() throws IOException {
        int num = 0;
        String s =  Files.asCharSource(textFile, Charsets.UTF_8).read();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '\n')
                num += 1;
        }
        return num;
    }

    public HashMap<Character, Integer> getCharsFrequency() throws IOException {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String s =  Files.asCharSource(textFile, Charsets.UTF_8).read();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c))
                map.merge(c, 1, (a, b) -> a + b);
        }
        return map;
    }

    public Date getDataOfLastModifying(){
        return new Date(textFile.lastModified());
    }

    public void setFile(File textFile) {
        this.textFile = textFile;
    }
}

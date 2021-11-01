package com.example.module_app;

import com.drew.imaging.ImageProcessingException;
import com.example.module_app.modules.*;
import com.example.module_app.ui.ConsoleUI;
import com.example.module_app.util.FileHelper;
import com.example.module_app.util.ModuleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
public class Controller {

    @Autowired
    public FileHelper fileHelper;
    @Autowired
    public ConsoleUI consoleUI;
    @Autowired
    public DirectoryHandler directoryHandler;
    @Autowired
    public ImageFileHandler imageFileHandler;
    @Autowired
    public MusicFileHandler musicFileHandler;
    @Autowired
    public TextFileHandler textFileHandler;
    @Autowired
    public ModuleHelper moduleHelper;
    public File file;

    public void startWork(ApplicationContext applicationContext) throws ImageProcessingException, IOException {
        File fileOrDirectory = figureOutFileOrDirectory();
        String nameOfModule = figureOutModule(applicationContext);
        if(nameOfModule != null){
            Object module = applicationContext.getBean(nameOfModule);
            if(directoryHandler.getClass().equals(module.getClass())){
                workWithDirectory();
            }
            else if(imageFileHandler.getClass().equals(module.getClass())){
                workWithImageFile();
            }
            else if(textFileHandler.getClass().equals(module.getClass())){
                workWithTextFile();
            }
            else if(musicFileHandler.getClass().equals(module.getClass())){
                workWithMusicFile();
            }
        }
        else {
            consoleUI.showMsgModuleNotSupport();
        }
    }

    private String figureOutModule(ApplicationContext applicationContext){
        moduleHelper.checkBeansPresence(applicationContext);
        Map<Integer, String> modules = moduleHelper.getModules();
        consoleUI.showMap(modules);
        return modules.get(consoleUI.getNumber());
    }

    private File figureOutFileOrDirectory(){
        fileHelper.findAndSetFile(consoleUI.getFileName());
        file = fileHelper.getFile();
        return file;
    }

    private void workWithDirectory(){
        int num = initialization(directoryHandler);
        if(num == 0) {
            consoleUI.showMsgFunctionNotSupport();
            return;
        }
        switch (num){
            case 1: consoleUI.showListOfItem(directoryHandler.getAllFilesInside());
                break;
            case 2: consoleUI.showSomeString(String.valueOf(directoryHandler.getAllFilesSizeInKb()));
                break;
            case 3: consoleUI.showSomeString(String.valueOf(directoryHandler.getDirectoriesCount()));
                break;
        }
    }

    private void workWithImageFile() throws ImageProcessingException, IOException {
        int num = initialization(imageFileHandler);
        if(num == 0) {
            consoleUI.showMsgFunctionNotSupport();
            return;
        }
        switch (num){
            case 1: consoleUI.showSomeString(String.valueOf(imageFileHandler.getImageSizeInKb()));
                break;
            case 2: consoleUI.showListOfItem(imageFileHandler.getExif());
                break;
            case 3: consoleUI.showSomeString(String.valueOf(imageFileHandler.getDataOfLastModifying()));
                break;
        }
    }

    private void workWithTextFile() throws IOException {
        int num = initialization(textFileHandler);
        if(num == 0) {
            consoleUI.showMsgFunctionNotSupport();
            return;
        }
        switch (num){
            case 1: consoleUI.showSomeString(String.valueOf(textFileHandler.getAllLinesCount()));
                break;
            case 2: consoleUI.showMap(textFileHandler.getCharsFrequency());
                break;
            case 3: consoleUI.showSomeString(String.valueOf(textFileHandler.getDataOfLastModifying()));
                break;
        }
    }

    private void workWithMusicFile() throws ImageProcessingException, IOException {
        int num = initialization(musicFileHandler);
        if(num == 0) {
            consoleUI.showMsgFunctionNotSupport();
            return;
        }
        switch (num){
            case 1: consoleUI.showListOfItem(musicFileHandler.getMusicNameAndTags());
                break;
            case 2: consoleUI.showSomeString(String.valueOf(musicFileHandler.getDuration()));
                break;
            case 3: consoleUI.showSomeString(String.valueOf(musicFileHandler.getDataOfLastModifying()));
                break;
        }
    }

    private int initialization(Handler handler){
        handler.setFile(file);
        int num = 0;
        if(handler.isExtendService(fileHelper.getFileExtend())) {
            consoleUI.showSomeString(handler.getFunctionsDescription());
            num = consoleUI.getNumber();
        }
        else
            consoleUI.showMsgFormatNotSupport();
        return num < 1 || num > 3 ? 0 : num;
    }
}

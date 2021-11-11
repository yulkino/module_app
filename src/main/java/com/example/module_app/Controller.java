package com.example.module_app;

import com.drew.imaging.ImageProcessingException;
import com.example.module_app.modules.*;
import com.example.module_app.modules.directory_handlers.DirectoryContentHandler;
import com.example.module_app.ui.ConsoleUI;
import com.example.module_app.util.FileHelper;
import com.example.module_app.util.ModuleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Controller {

    @Autowired
    public FileHelper fileHelper;
    @Autowired
    public ConsoleUI consoleUI;
    @Autowired
    public ModuleHelper moduleHelper;

    public void startWork(ApplicationContext applicationContext) throws ImageProcessingException, IOException {
        var handlers = moduleHelper.getHandlers(applicationContext);
        var file = getFile();

        var appropriateHandlers = handlers
                .entrySet()
                .stream()
                .filter(handler -> handler.getValue().isExtendService(file))
                .collect(Collectors.toList());

        var size = appropriateHandlers.size();

        switch(size){
            case 0:
                noModules();
                break;
            case 1:
                processSingleHandler(appropriateHandlers.get(0).getValue(), file);
                break;
            default:
                choseHandler(appropriateHandlers, file);
                break;
        }

    }

    private File getFile(){
        return fileHelper.findAndSetFile(consoleUI.getFileName());
    }

    private void noModules() {
        consoleUI.showMsgFormatNotSupport();
    }

    private void processSingleHandler(Handler handler, File file) {
        consoleUI.showSomeString(handler.getFunctionsDescription());
        handler.process(file, consoleUI);
    }

    private void choseHandler(List<Map.Entry<String, Handler>> handlers, File file) {
        var counter = 1;
        for (var kvp : handlers) {
            var name = kvp.getKey();
            var handler = kvp.getValue();
            consoleUI.showSomeString(counter++ + ". Хэндлер " + name + " - " + handler.getFunctionsDescription());
        }

        var num = consoleUI.getNumber();

        handlers.get(num - 1).getValue().process(file, consoleUI);
    }
}

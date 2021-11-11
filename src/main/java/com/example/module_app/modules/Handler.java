package com.example.module_app.modules;

import com.example.module_app.ui.ConsoleUI;

import java.io.File;

public interface Handler {
    public void process(File file, ConsoleUI consoleUI);
    public boolean isExtendService(File file);
    String getFunctionsDescription();
}

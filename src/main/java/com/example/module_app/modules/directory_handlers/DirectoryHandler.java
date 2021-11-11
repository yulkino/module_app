package com.example.module_app.modules.directory_handlers;

import com.example.module_app.modules.Handler;

import java.io.File;

public abstract class DirectoryHandler implements Handler {
    @Override
    public boolean isExtendService(File file) {
        return file.isDirectory();
    }
}

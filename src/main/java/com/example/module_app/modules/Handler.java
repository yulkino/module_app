package com.example.module_app.modules;

import java.io.File;

public interface Handler {
    public void setFile(File file);
    public boolean isExtendService(String ext);
    String getFunctionsDescription();
}

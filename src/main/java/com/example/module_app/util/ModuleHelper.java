package com.example.module_app.util;

import com.example.module_app.modules.Handler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ModuleHelper {
    public Map<String, Handler> getHandlers(ApplicationContext applicationContext) {
        return applicationContext.getBeansOfType(Handler.class);
    }
}

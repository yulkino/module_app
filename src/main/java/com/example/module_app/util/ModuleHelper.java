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

    private Map<Integer, String> modules = new HashMap<>();

    public void checkBeansPresence(ApplicationContext applicationContext) {
        modules = new HashMap<>();
        int i = 0;
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            if(applicationContext.containsBean(beanName) && Handler.class.isAssignableFrom(applicationContext.getBean(beanName).getClass())) {
                //System.out.println(Handler.class.isAssignableFrom(applicationContext.getBean(beanName).getClass()));
                modules.put(++i, beanName);
            }
        }
    }

    public Map<Integer, String> getModules() {
        return modules;
    }
}

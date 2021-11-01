package com.example.module_app;

import com.drew.imaging.ImageProcessingException;
import com.example.module_app.util.ModuleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ModuleAppApplication {

	public static ApplicationContext applicationContext;

	public static void main(String[] args) throws ImageProcessingException, IOException {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Controller controller = applicationContext.getBean("controller", Controller.class);

		controller.startWork(applicationContext);
	}


}
package edu.tsinghua.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cglib.core.DebuggingClassWriter;

@SpringBootApplication
@ConfigurationPropertiesScan("edu.tsinghua.demo.config")
public class DemoApplication {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String path = System.getProperty("user.dir");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
        SpringApplication.run(DemoApplication.class, args);

    }

}

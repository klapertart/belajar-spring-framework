package com.klapertart.belajarspring.model;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;


/**
 * @author otongsunandar
 * @since 27/04/20
 */
@Component
public class FileBean implements ResourceLoaderAware {
    private  ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void printInfo() throws IOException {
        //Resource resource = resourceLoader.getResource("file:info.txt");
        Resource resource = resourceLoader.getResource("classpath:files/info.txt");

        Scanner scanner = new Scanner(resource.getInputStream());
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}

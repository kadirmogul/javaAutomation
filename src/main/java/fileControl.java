package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class fileControl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String downloadPath="C:\\Users\\Anıl\\Downloads";
        String fileName ="CV_Abdul Kadir Moğul.pdf";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(isFileLoaded(downloadPath,fileName));
        driver.quit();
    }

    public static boolean isFileLoaded(String downloadPathFunc,String fileNameFunc){
        File file =new  File(downloadPathFunc);
        File[] files =file.listFiles();

        for (int i=0; i<files.length; i++){
            if (files[i].getName().equals(fileNameFunc)){
                return true;
            }
        }
        return false;

    }

}

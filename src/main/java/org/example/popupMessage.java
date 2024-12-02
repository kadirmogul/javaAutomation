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


public class screenShot {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Ekran görüntüsü aldırma

        driver.get("https://www.sabah.com.tr/");
        TakesScreenshot srcShot =((TakesScreenshot)driver);
        File srcFile=srcShot.getScreenshotAs(OutputType.FILE);
        File DestFile =new File("C://Users//Anıl//OneDrive//Masaüstü//SS/test.png");
        try {
            FileUtils.copyFile(srcFile,DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}

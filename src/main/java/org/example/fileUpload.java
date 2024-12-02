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


public class doubleClick {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL4="https://demo.guru99.com/test/simple_context_menu.html";
        driver.get(baseURL4);
        WebElement doubleClickButton =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action =new Actions(driver);
        action.doubleClick(doubleClickButton).perform();


        driver.quit();
        }


    }


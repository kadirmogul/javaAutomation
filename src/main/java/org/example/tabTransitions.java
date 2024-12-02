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


public class tabTransitions
{
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Tab Sekmeler arası geçiş

        String baseURL6="https://demo.guru99.com/popup.php";
        driver.get(baseURL6);
        WebElement clickButton= driver.findElement(By.xpath("//*[contains(@href,'popup.php')]"));

        //tablar arası geçiş
        List<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.name("emailid")).sendKeys("aa@aa.aa");
        driver.findElement(By.name("btnLogin")).click();

        clickButton.click();

        driver.quit();

    }

}

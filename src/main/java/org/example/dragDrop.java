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


public class dragDrop {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        String baseURL2="http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
        driver.get(baseURL2);

    //Şehirler
        WebElement Oslo =driver.findElement(By.id("box1"));
        WebElement Stockholm =driver.findElement(By.id("box2"));
        WebElement Washington =driver.findElement(By.id("box3"));
        WebElement Copenhagen =driver.findElement(By.id("box4"));
        WebElement Seoul =driver.findElement(By.id("box5"));
        WebElement Rome =driver.findElement(By.id("box6"));
        WebElement Madrid =driver.findElement(By.id("box7"));

    //Ülkeler
        WebElement Italy =driver.findElement(By.id("box106"));
        WebElement Spain =driver.findElement(By.id("box107"));
        WebElement Norway =driver.findElement(By.id("box101"));
        WebElement Denmark =driver.findElement(By.id("box104"));
        WebElement southKorea =driver.findElement(By.id("box105"));
        WebElement Sweden =driver.findElement(By.id("box102"));
        WebElement unitedStates =driver.findElement(By.id("box103"));

        Actions action =new Actions(driver);

        action.dragAndDrop(Oslo,Norway).build().perform();
        action.dragAndDrop(Stockholm,Sweden).build().perform();
        action.dragAndDrop(Washington,unitedStates).build().perform();
        action.dragAndDrop(Copenhagen,Denmark).build().perform();
        action.dragAndDrop(Seoul,southKorea).build().perform();
        action.dragAndDrop(Rome,Italy).build().perform();
        action.dragAndDrop(Madrid,Spain).build().perform();

        driver.quit();

    }

}

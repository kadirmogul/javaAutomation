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


public class popupMessage {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL5 ="https://demo.guru99.com/test/delete_customer.php";
        driver.get(baseURL5);
        WebElement customerID =driver.findElement(By.name("cusid"));
        customerID.sendKeys("123");

        WebElement submitButton =driver.findElement(By.name("submit"));
        submitButton.click();

        Alert alert =driver.switchTo().alert();
        String alertMassage= driver.switchTo().alert().getText();
        System.out.println(alertMassage);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alert.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Alert alert1 =driver.switchTo().alert();
        //alert1.accept();
        alert.accept();

        driver.quit();

    }

}

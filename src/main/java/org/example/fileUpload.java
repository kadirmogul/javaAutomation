package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class fileUpload {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL4="https://demo.guru99.com/test/upload/";
        driver.get(baseURL4);
        WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));
        uploadButton.sendKeys("C:\\Users\\Anıl\\IdeaProjects\\moouseEvent\\src\\images\\gratisography-cool-cat-800x525.jpg");

        WebElement acceptButton =driver.findElement(By.id("terms"));
        acceptButton.click();

        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        submitButton.click();
        driver.quit();
        }


    }


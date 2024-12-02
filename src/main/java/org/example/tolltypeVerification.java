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


public class tolltypeVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL7 ="https://demo.guru99.com/test/social-icon.html";
        String expectDataMail="Mail";
        driver.get(baseURL7);
        WebElement mailButton=driver.findElement(By.xpath("//*[@id='page']/div[2]/div/a[1]"));
        String actualDataMail =mailButton.getAttribute("title");
        ;
        if (actualDataMail.equals(expectDataMail)){
            System.out.println("Mail karşılaştırması başarılı");
        }
        else  {
            System.out.println("Mail karşılaştırması başarısız");
        }

        String expectDataGoogle="Google+";
        WebElement googleButton= driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[2]"));
        String actualDataGoogle =googleButton.getAttribute("title");

        if (actualDataGoogle.equals(expectDataGoogle)){
            System.out.println("Google title kontrolü başarılı");
        }else {
            System.out.println("Google title kontrolü başarısız");
        }
        driver.quit();

        //Sayfa scroll etmek
        String baseURl8="https://demo.guru99.com/test/guru99home";
        driver.get(baseURl8);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,500)");
        WebElement linux = driver.findElement(By.linkText("Linux"));
        //js.executeScript("arguments[0].scrollIntoView();",linux);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");


        driver.quit();

    }

}

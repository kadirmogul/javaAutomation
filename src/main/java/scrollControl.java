
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


public class scrollControl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

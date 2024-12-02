

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


public class buttonClick {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL="https://www.amazon.com.tr/";
        driver.get(baseURL);
        Actions action =new Actions(driver);
        WebElement loginBar = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(loginBar).perform();

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
        loginButton.click();

        driver.quit();

    }

}

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


public class rightClick {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL3="https://demo.guru99.com/test/simple_context_menu.html";
        driver.get(baseURL3);
        WebElement rightClick=driver.findElement(By.xpath("//*[@id='authentication']/span"));
        Actions actions =new Actions(driver);
        actions.contextClick(rightClick).perform();
        WebElement copyButton= driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        actions.click(copyButton).perform();
        driver.switchTo().alert().accept();


        driver.quit();

    }

}

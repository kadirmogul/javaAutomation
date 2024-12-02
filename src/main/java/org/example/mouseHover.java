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


public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

/*
    //Amazon Login Page

    //Mouse Hover Actions

        String baseURL="https://www.amazon.com.tr/";
        driver.get(baseURL);

        Actions action =new Actions(driver);
        WebElement loginBar = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(loginBar).perform();

    //Login Button Click

       WebElement loginButton = driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
       loginButton.click();


    //Drag Drop

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

//Sağ tıklama Action - Content Click

       String baseURL3="https://demo.guru99.com/test/simple_context_menu.html";
       driver.get(baseURL3);
       WebElement rightClick=driver.findElement(By.xpath("//*[@id='authentication']/span"));
       Actions actions =new Actions(driver);
       actions.contextClick(rightClick).perform();
       WebElement copyButton= driver.findElement(By.cssSelector(".context-menu-icon-copy"));
       actions.click(copyButton).perform();
       driver.switchTo().alert().accept();


//Çift tıklama Action - Double Click

        String baseURL4="https://demo.guru99.com/test/simple_context_menu.html";
        driver.get(baseURL4);
        WebElement doubleClickButton =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action =new Actions(driver);
        action.doubleClick(doubleClickButton).perform();



//Dosya Yükleme

        String baseURL4="https://demo.guru99.com/test/upload/";
        driver.get(baseURL4);
        WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));
        uploadButton.sendKeys("C:\\Users\\Anıl\\IdeaProjects\\moouseEvent\\src\\images\\gratisography-cool-cat-800x525.jpg");

        WebElement acceptButton =driver.findElement(By.id("terms"));
        acceptButton.click();

        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        submitButton.click();

//İndirilen dosyalar arasında dosya olup olmadığının kontrolü


    String downloadPath="C:\\Users\\Anıl\\Downloads";
    String fileName ="CV_Abdul Kadir Moğul.pdf";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(isFileLoaded(downloadPath,fileName));
    }

    public static boolean isFileLoaded(String downloadPathFunc,String fileNameFunc){
        File file =new  File(downloadPathFunc);
        File[] files =file.listFiles();

        for (int i=0; i<files.length; i++){
            if (files[i].getName().equals(fileNameFunc)){
                return true;
            }
        }
        return false;


    //Popup mesajları

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

    //tolltip doğrulama

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

 */
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
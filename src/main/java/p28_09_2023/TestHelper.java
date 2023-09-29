package p28_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class TestHelper {
   private WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean elementExists (By by){

        try {
        driver.findElement(by);
                return true;
        } catch (Exception e) {
        return false;
            }
    }
    public boolean existByList(By by){
         List<WebElement> lista= driver.findElements(by);
           return lista.size()> 0;

    }
    public void setDefaultImplicitWait(){
        driver= new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void setImplicitWait (int sekund){
        driver= new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sekund));
    }
}




//        metodu setImplicitWait koja postavlja implicitno cekanje iz prosledjene vrednosti.

package d28_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) {
//        Ucitati stranicu http://seleniumdemo.com/?product=bdd-cucumber
//        Klik na korpu iz gornjeg desnog ugla
//        Sacekati da naslov stranice bude Cart – Selenium Demo Page
//        Proveriti da li element koji prikazuje stanje korpe ima tekst Your cart is currently empty.

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://seleniumdemo.com/?product=bdd-cucumber");

        WebElement korpa= driver.findElement(By.cssSelector("i.icn-shoppingcart"));
        korpa.click();
        wait.
        until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.navbar-brand.col-auto")));

        WebElement infoOKorpi= driver.findElement(By.cssSelector("div#page-5"));
        String tekstInfoOKorpi= infoOKorpi.getText();
        if (tekstInfoOKorpi.equals("Your cart is currently empty.")){
            System.out.println("Test pass");
        }else {
            System.out.println("Test faild");
        }
        driver.quit();
    }
}

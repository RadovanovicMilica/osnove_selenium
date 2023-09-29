package p29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu https://youtube.com i u
//        search baru unosi tekste Breskvica i ceka da se pojavi vise od 3 rezultata
//        iz padajuceg menija i zatim klikce na prvi.
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

      WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(" https://youtube.com");
        driver.findElement(By.name("search_query")).click();
        Thread.sleep(1000);

        driver.findElement(By.name("search_query")).sendKeys("Breskvica");
        driver.findElement(By.cssSelector("button#search-icon-legacy")).sendKeys(Keys.ENTER);

        wait
                .withMessage("Pretraga nije prikazala preporuke")
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.cssSelector("[role='presentation']"), 2));



        Thread.sleep(5000);
        driver.quit();

    }
}

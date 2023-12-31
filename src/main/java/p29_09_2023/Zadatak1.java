package p29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV i
//        // ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://s.bootsnipp.com/iframe/klDWV");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loader = driver.findElement(By.className("preloader-wrap"));
        wait
                .withMessage("Stranica se nije ucitala!")
                .until(ExpectedConditions.attributeContains(loader, "stile", "display: none;"));
        System.out.println("Stranica je ucitana!");


//
//        WebElement preloader =
//                driver.findElement(By.className("preloader-wrap"));
//        for (int i = 0; i < 20; i++) {
//
//            System.out.println(i + " " + preloader.isDisplayed());
//    }

        }
}

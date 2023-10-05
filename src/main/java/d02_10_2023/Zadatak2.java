package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://itbootcamp.rs/");

        List<WebElement> navigacija = driver.findElements(By.cssSelector("li.dropdown>a"));
        List<WebElement> padajuciMeni = driver.findElements(By.cssSelector("ul.dropdown-menu"));

        Actions actions = new Actions(driver);
//        for (int i = 0; i < 3; i++) {
//            WebElement stavka = navigacija.get(i);
//            actions.moveToElement(stavka).perform();    //?
//            wait
//                    .withMessage("Greska! Padajuci meni nije vidljiv!!")
//                    .until(ExpectedConditions.visibilityOf(padajuciMeni.get(i)));
        WebElement stavka = navigacija.get(0);
        actions.moveToElement(stavka).perform();
        wait
                .withMessage("Greska! Padajuci meni za 'Vesti' nije vidljiv.")
                .until(ExpectedConditions.visibilityOf(padajuciMeni.get(0)));
        Thread.sleep(1000);

        stavka= navigacija.get(1);
        actions.moveToElement(stavka).perform();
        wait
                .withMessage("Greska! Padajuci meni za 'Kursevi' nije vidljiv.")
                .until(ExpectedConditions.visibilityOf(padajuciMeni.get(1)));
            Thread.sleep(1000);

        stavka= navigacija.get(2);
        actions.moveToElement(stavka).perform();
        wait
                .withMessage("Greska! Padajuci meni za 'Prijava i pravilnik' nije vidljiv.")
                .until(ExpectedConditions.visibilityOf(padajuciMeni.get(2)));
        Thread.sleep(1000);
//        } //petlja

        driver.quit();
//    }
    }
}

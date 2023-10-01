package d29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
//    Napisati program koji testira infinity scroll.
//    Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//    Selektujte delay od 2000ms, koristeci Select klasu.
//            Skrol do Show more dugmeta koje se nalazi na dnu stranice
//    Sacekajte da dugme bude klikljivo
//    Klik na Show more dugme
//    Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//    Sacekajte da dugme vise ne bude klikljivo

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

       WebElement selectElement= driver.findElement(By.id("delay-select"));
       Select select= new Select(selectElement);
       select.selectByValue("2000");

        Actions actions = new Actions(driver);

        WebElement showMoreButton = driver.findElement(By.xpath("//button[contains(text(), 'Show more')]"));

        wait
                .until(ExpectedConditions.elementToBeClickable(showMoreButton));
        showMoreButton.click();
//
//
        int expectedElementCount = 3;
        WebDriverWait waitCount= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("your-element-class"), 3));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(showMoreButton)));


        driver.quit();
    }
}

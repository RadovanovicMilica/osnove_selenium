package p29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
//        Napisati program koji
//        ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik Primary dugme
//        Ceka da se pojavi toasts u gornjem desnom uglu
//        Ispisuje da se element pojavio
//        Ceka da se izgubi toasts u gornjem desnom uglu
//        Ispisuje da se elment izgubio
//        Klik na primary dugme
//        Ceka da se pojavi toasts u gornjem desnom uglu
//        Ispisuje da se element pojavio
//        Klik na x dugme iz toasts-a
//        Ceka da se element izgubi
//        Ispisuje da se element izgubio
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
       WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.id("basic-primary-trigger")).click();
        WebElement toasts= driver.findElement(By.id("basic-primary-example"));
        wait
                .withMessage("Element se pojavio.")
                .until(ExpectedConditions.visibilityOf(toasts));
        wait
                .withMessage("Neka pporuka za gresku")
                .until(ExpectedConditions.invisibilityOf(toasts));

        driver.findElement(By.id("basic-primary-trigger")).click();
        wait
                .withMessage("Element se pojavio.")
                .until(ExpectedConditions.visibilityOfAllElements(toasts));
        driver.findElement(By.cssSelector("div.toast=header.toast-primary > button")).click();
        wait
                .withMessage("Neka pporuka za gresku")
                .until(ExpectedConditions.invisibilityOf(toasts));


        driver.quit();
    }
}

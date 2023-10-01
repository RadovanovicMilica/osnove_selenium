package d29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    //Sesti sa casa
//    Napisati program koji:
//    Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//    Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//    Ceka da broj toasts-a bude 4
//    Ispisuje poruku, toasts su prikazani
//    Ceka da broj toasts-a bude 0
//    Ispisuje poruku, toasts su se izgubili
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        long start=0;
        long kraj=0;
        start= System.currentTimeMillis();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.findElement(By.id("basic-primary-trigger")).click();
        driver.findElement(By.id("basic-secondary-trigger")).click();
        driver.findElement(By.id("basic-success-trigger")).click();
        driver.findElement(By.id("basic-danger-trigger")).click();

        double time=0;
       wait
               .withMessage("Toasts su prikazani.")
               .until(ExpectedConditions.numberOfElementsToBe( By.xpath("//div[contains(@class,'toast-fixed show')]"),  0));

       kraj= System.currentTimeMillis();
       time=(kraj-start) / 1000.0;

       driver.quit();
    }

}

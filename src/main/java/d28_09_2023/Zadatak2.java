package d28_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik na svako dugme od PRIMARY do DARK
//        Sacekati da se toasts u desnom gornjem uglu pojavi
//        Pauza izmedju klikova 1s
//        Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.findElement(By.id("basic-primary-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-secondary-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-success-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-danger-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-warning-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-danger-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-info-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-light-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");
        driver.findElement(By.id("basic-dark-trigger")).click();
        Thread.sleep(1000);
        System.out.println("Element se pojavio.");

driver.quit();
    }

}

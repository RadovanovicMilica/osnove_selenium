package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;
public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        driver.get("file:///C:/Users/Dell/Downloads/Zadatak4%20(4).html");


        driver.findElement(By.id("showInBtn")).click();

//        driver.findElement(By.id("id-0"));
        wait
        .withMessage("IT BOOTCAMP poruka se nije pojavila za 10s.")
        .until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));
//


        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
            wait
                    .withMessage("")
                    .until(ExpectedConditions
                            .numberOfElementsToBe(
                                    By.xpath("//*[contains(@id, 'id-')]"), i + 1));

        }
        System.out.println("KRAJ");



    }
}



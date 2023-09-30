package d28_09_2023;
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
//        Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//        Klik na Type drawdown
//        Klik na Public iz drowdowna
//        Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//        Kilk na Clear filter u desnom uglu
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().to("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        WebElement drawdown = driver.findElement(By.cssSelector("summary.btn"));
        drawdown.click();
wait
        .until(ExpectedConditions.visibilityOf(drawdown));
       WebElement publicButton = driver.findElement(By.id("type_public"));
       publicButton.click();
 wait
         .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='reset']")));
        driver.findElement(By.cssSelector("button[type='reset']")).click();


        driver.quit();
    }
}

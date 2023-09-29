package p28_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/modal-dialogs");

         driver.findElement(By.id("showLargeModal")).click();
         boolean dijalog= true;
         try {
             driver.findElement(By.id("example-modal-sizes-title-lg"));
         }catch (Exception e){
             dijalog= false;
         }
         if (dijalog== true){
             System.out.println("Dijalog se pojavio.");
         }else {
             System.out.println("Dijalog se nije pojavio.");
         }
         driver.quit();
    }


}

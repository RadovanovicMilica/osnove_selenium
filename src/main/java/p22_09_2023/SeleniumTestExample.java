package p22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        // Otvaranje veb stranice
        driver.get("https://google.com");
        Thread.sleep(500);
        driver.get("https://facebook.com");
        Thread.sleep(1500);
        driver.get("https://youtube.com");
        Thread.sleep(1500);
//       500ms= 0.5s
//       1000ms= 1s
//       1200ms=1.2s

        // Mesto za test kod ...


//        // Zatvoranje pretrazivaca nakon sto se zavrsi testiranje
//        driver.quit();
    }
}




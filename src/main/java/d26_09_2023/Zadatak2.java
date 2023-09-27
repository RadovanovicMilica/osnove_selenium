package d26_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        List<WebElement> dugmeZatvaranja= driver.findElements(By.xpath("//button[@class='close']"));

        for (int i=0; i< dugmeZatvaranja.size(); i++){
            WebElement zatvori= dugmeZatvaranja.get(i);
            zatvori.click();
        }
    }
}



package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://demoqa.com/broken ");

        List<WebElement> links= driver.findElements(By.cssSelector(".col-md-6 a")); //?
        for (int i=0; i< links.size(); i++){
            String url= links.get(i).getAttribute("href");
            if (Helper.getHTTPResponseStatusCode(url)>=200
            && Helper.getHTTPResponseStatusCode(url) <400){
                System.out.println("Link " + url + " je validan");
            } else {
                System.out.println("Link " + url + " je nevalidan");
            }
        }

    }
}

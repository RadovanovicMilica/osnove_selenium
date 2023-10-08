package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        WebElement links = driver.findElement(By.className("owl-stage"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", links);

        List<WebElement> URLimage = driver.findElements(By.cssSelector("owl-stage img"));
        for (int i = 0; i < URLimage.size(); i++) {
            String url = URLimage.get(i).getAttribute("src");
            if (Helper.getHTTPResponseStatusCode(url) >= 200
                    && Helper.getHTTPResponseStatusCode(url) < 300) {
                Helper.downloadImage(URLimage.toString(),"downloads/Webp.net-resizeimage-2.png");
            }
        }
        driver.quit();
    }
}


//        Azurirajte gitignore da ignorise itbootcamp_slider folder ?

package d29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    //Sedmi zadatak sa predavanja
//    Napisati program koji:
//    Ucitava stranicu https://tus.io/demo.html
//    Hvata sve linkove sa stranice
//    Skrola do svakog h3 elementa
//    Od svakog h3 elementa cita text
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");
        List<WebElement> listaLinkova= driver.findElements(By.xpath("//link"));
        List<WebElement> elementi = driver.findElements(By.xpath("//h3"));

        for (int i=0; i< elementi.size(); i++){
            WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[" + (i+1) + "]")));
            Thread.sleep(1000);
        }}

    }


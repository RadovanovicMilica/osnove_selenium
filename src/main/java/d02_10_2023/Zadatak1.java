package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.findElement(By.id("active-face")).click();
        wait
                .withMessage("Greska: Iskacuci prozor se nije pojavio. ")
                .until(ExpectedConditions.elementToBeClickable(By.id("image-option-remove")))
                .click();

        driver.findElement(By.cssSelector(".edit-image")).click();
        wait
                .withMessage("Greska: Desni meni se nije pojavio. ")
                .until(ExpectedConditions.elementToBeClickable(By.className("ihSIDX")))
                .sendKeys("test_data/front.jpg");
        wait
                .withMessage("Greska: Slika nije ubacena. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"), 1));
         driver.findElement(By.cssSelector(".sc-fsQiph:last-child div"))
                 .click();
        wait
                .withMessage("Greska: 'Done' dugme se nije pojavilo. ")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit]")))
                .click();
        Thread.sleep(2000);

        driver.findElement(By.id("active-face")).click();
        wait
                .withMessage("Greska: Desni meni se nije pojavio. ")
                .until(ExpectedConditions.elementToBeClickable(By.className("ihSIDX")))
                .sendKeys("test_data/right.jpg");
        wait
                .withMessage("Greska: Slika nije ubacena. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"), 2));
        driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();
        wait
                .withMessage("Greska: 'Done' dugme se nije pojavilo. ")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit]")))
                .click();
        Thread.sleep(2000);

        driver.findElement(By.id("active-face")).click();
        wait
                .withMessage("Greska: Desni meni se nije pojavio. ")
                .until(ExpectedConditions.elementToBeClickable(By.className("ihSIDX")))
                .sendKeys("test_data/back.jpg");
        wait
                .withMessage("Greska: Slika nije ubacena. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"), 3));
        driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();
        wait
                .withMessage("Greska: 'Done' dugme se nije pojavilo. ")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit]")))
                .click();
        Thread.sleep(2000);

        driver.findElement(By.id("active-face")).click();
        wait
                .withMessage("Greska: Desni meni se nije pojavio. ")
                .until(ExpectedConditions.elementToBeClickable(By.className("ihSIDX")))
                .sendKeys("test_data/left.jpg");
        wait
                .withMessage("Greska: Slika nije ubacena. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"), 4));
        driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();
        wait
                .withMessage("Greska: 'Done' dugme se nije pojavilo. ")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit]")))
                .click();
        Thread.sleep(2000);

        wait
                .withMessage("Dugme'Next' nije vidljivo")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-ejDCVS.bObSCL"))).click();

        driver.findElement(By.id("next-button"))
                        .sendKeys("Camping lovers");
        Thread.sleep(2000);

        driver.findElement(By.id("next-button"))
                .click();
        driver.findElement(By.id("next-button"))
                .click();

        Thread.sleep(5000);

        driver.quit();
    }
}




//
//


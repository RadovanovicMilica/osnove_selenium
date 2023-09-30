package d28_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
//        Ucitati stranicu http://seleniumdemo.com/?post_type=product
//        Klik na search dugme u gornjem desnom uglu
//        Cekati da forma za pretragu bude vidljiva
//        Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//        Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst
//        koji je unet za pretragu. Ispisati odgovarajuce poruke u terminalu

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(" http://seleniumdemo.com/?post_type=product");
        WebElement dugmeZaPretragu= driver.findElement(By.cssSelector("search-toggle_btn icn-search czr-dropdown"));
        dugmeZaPretragu.click();

        wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search_wrapper")))
                .sendKeys("BDD Cucumber", Keys.ENTER);
        WebElement prviRezultatPretrage= driver.findElement(By.cssSelector("a.bg-link"));
        prviRezultatPretrage.click();
        String nazivPrvogRezultata= prviRezultatPretrage.getText();
        if (nazivPrvogRezultata.contains("BDD Cucumber")){
            System.out.println("Prvi rezultat sadrzi zeljeni tekst.");
        } else {
            System.out.println("Prvi rezultat ne sadrzi zeljeni tekst.");
        }


    }
}

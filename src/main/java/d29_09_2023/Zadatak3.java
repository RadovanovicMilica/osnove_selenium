package d29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
//    Napisati program koji:
//    Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//    Implicitno cekanje za trazenje elemenata je maksimalno 10s
//    Implicitno cekanje za ucitavanje stranice je 5s
//    Ucitava stranicu https://docs.katalon.com/
//    Maksimizuje prozor
//    Od html elementa cita data-theme atribut.
//    Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//    Klikce na dugme za zamenu tema
//    Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//    Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//    Ceka da se dijalog za pretragu pojavi
//    Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//    Zatvara pretrazivac
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://docs.katalon.com/");

    WebElement htmlElement = driver.findElement(By.tagName("html"));
    String dataThemeAttribute = htmlElement.getAttribute("data-theme");
    if (dataThemeAttribute.equals("light")) {
        System.out.println("Tema je svetla.");
    } else {
        System.out.println("Tema je tamna.");
    }

    driver.findElement(By.id("theme-switch")).click();
    wait
            .until(ExpectedConditions.attributeToBe(htmlElement, "data-theme", "dark"));

    Actions actions = new Actions(driver);
    actions.keyDown(Keys.CONTROL).sendKeys("k").keyUp(Keys.CONTROL).perform();

    WebElement searchDialog= driver.findElement(By.id("search-dialog"));
    wait
            .until(ExpectedConditions.visibilityOf(searchDialog));

    WebElement searchInput = searchDialog.findElement(By.tagName("input"));
    String inputType = searchInput.getAttribute("type");

    if (inputType.equals("search")) {
        System.out.println("Input za pretragu ima ispravan  Tipe atribut.");
    } else {
        System.out.println("Input za pretragu nema ispravan Tipe atribut.");
    }
    driver.quit();
}
}

package d25_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php\n");

        String ime="Micke";
        String odeljenje="qa";
        String telefona= "38164555555";

//        ArrayList<String> dodavanjeRedova = new ArrayList<>();
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/button"))
                .click();
        for (int i=0; i< 5; i++) {
            WebElement poljeZaIme = driver.findElement(By.xpath("//input[@name='name[]']"));
            poljeZaIme.sendKeys(ime);
            WebElement poljeZaOdeljenje = driver.findElement(By.xpath("//input[@name='department[]']"));
            poljeZaOdeljenje.sendKeys(odeljenje);
            WebElement poljeZaTelefon = driver.findElement(By.xpath("//input[@name='phone[]']"));
            poljeZaTelefon.sendKeys(telefona);

            List<WebElement> dugmeKlik = driver.findElements(By.xpath("//tbody//tr[last()]//a[contains(text(),'Add')]"));
            if (!dugmeKlik.isEmpty()) {
                dugmeKlik.get(0).click();
            }
            Thread.sleep(500);
        }
        driver.quit();
    }
}

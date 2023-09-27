package d25_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://artplayer.org/");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("art-control art-control-playAndPause"))
                .click();
        driver.findElement(By.cssSelector("div.art-control-volume"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.art-icon.art-icon-screenshot"))
                .click();
        driver.findElement(By.cssSelector("div.art-control.art-control-pip.hint--roundend.hint--top"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.art-control.art-control-pip.hint--roundend.hint--top"))
                .click();
        driver.findElement(By.cssSelector("i.art-icon.art-icon-fullscreenWebOn"))
                .click();
        driver.findElement(By.cssSelector("i.art-icon.art-icon-fullscreenWebOn"))
                .click();
        Thread.sleep(1000);

        driver.quit();


    }
}

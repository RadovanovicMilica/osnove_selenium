package d25_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='UserName']"))
                .clear();
        driver.findElement(By.xpath("//input[@placeholder='UserName']"))
                .sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("admin123");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/div/div/input"))
                .clear();
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/div/div/input"))
                .sendKeys("Me");

        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"))
                .click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("#app header>div>div:nth-child(2)>ul>li>span>img"))
                .click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='app']//ul/li[4]/a"))
                .click();
        Thread.sleep(5000);

        driver.close();
    }
}



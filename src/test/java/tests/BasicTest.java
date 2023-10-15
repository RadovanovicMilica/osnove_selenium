package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LeftNavPage;
import pages.loginPage;
import pages.TopNavPage;

import java.time.Duration;

public abstract class BasicTest {

        protected WebDriver driver;
        protected WebDriverWait wait;
        protected String baseUrl = "https://www.saucedemo.com/";
        protected pages.loginPage loginPage;
        protected String username;
        protected String password;
        protected LeftNavPage leftNav;
        protected InventoryPage inventory;
        protected TopNavPage topNav;

    public BasicTest(WebDriver driver, WebDriverWait wait, String baseUrl) {
    }


    @BeforeClass
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            loginPage = new loginPage(driver, wait);
            baseUrl = "https://www.saucedemo.com/";
            username = "standard_user";
            password = "secret_sauce";
            leftNav = new LeftNavPage(driver,wait);
            inventory = new InventoryPage(driver,wait);
            topNav = new TopNavPage(driver,wait);

        }
    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.LocalStorage.clear();");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

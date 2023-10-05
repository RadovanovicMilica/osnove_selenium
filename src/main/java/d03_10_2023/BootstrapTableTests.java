package d03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
       driver.navigate().to("https://s.bootsnipp.com/iframe/K5yrx ");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Error! This is not expected title.");
    }
    @Test(priority = 1)
    public void editRow (){
        driver.findElement(By.xpath("//button[@data-uid='1']")).click();
        wait
                .withMessage("Error! 'Update data' didn't appear")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
       WebElement firstName= driver.findElement(By.id("fn"));
       firstName.clear();
       firstName.sendKeys("Milica");
       firstName.sendKeys(Keys.ENTER);

        WebElement lastName= driver.findElement(By.id("ln"));
        lastName.clear();
        lastName.sendKeys("Radovanovic");
        lastName.sendKeys(Keys.ENTER);

        WebElement middleName= driver.findElement(By.id("mn"));
        middleName.clear();
        middleName.sendKeys("Mila");
        middleName.sendKeys(Keys.ENTER);

        driver.findElement(By.id("up")).click();
        wait
                .withMessage("Error! Update data didn't closed.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("div.row")));
        WebElement firstNameCell = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        WebElement lastNameCell = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement middleNameCell = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]"));

        String expectedFirstName="Milica";
        Assert.assertEquals(
                "Milica",
                "Milica",
                "Actual first name is not expected");
        String expectedLastName="Radovanovic";
        Assert.assertEquals(
                "Radovanovic",
                "Radovanovic",
                "Actual last name is not expected");
        String expectedMiddleName="Mila";
        Assert.assertEquals(
                "Mila",
                "Mila",
                "Actual middle name is not expected");
    }
    @Test (priority = 2)
    public void deleteRow (){

        List<WebElement> rowsBeforeDelete = driver.findElements(By.xpath("//table/tbody/tr"));
        driver.findElement(By.className("delete")).click();
        wait
                .withMessage("Error! 'Delete data' didn't appear")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        driver.findElement(By.id("del"))
                .click();
        wait
                .withMessage("Error! Delete data didn't closed.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("div.row")));
        List<WebElement> rowsAfterDelete= driver.findElements(By.xpath("//table/tbody/tr"));
        Assert.assertEquals(
                rowsAfterDelete.size(),
         rowsBeforeDelete.size() - 1,
                "Error! Number of rows isn't 1 less after deletion.");
    }
    @Test (priority = 3)
    public void takeAScreenshot() throws IOException{
        File sch=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination= new File("screenshots/image1.png");
        Files.copy(sch.toPath(), destination.toPath());
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

package p05_10_2023;

import d02_10_2023.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test (priority = 1, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing (){
        driver.findElement(By.id("login-button"))
                .click();
        Assert.assertEquals(driver.findElement(By.cssSelector("error-message-container error")),
                "Epic sadface: Username is required",
                "Error! Trhere is not a message 'Username is required'");

    }
    @Test (priority = 2)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing (){
       WebElement userName= driver.findElement(By.id("user-name"));
       userName.sendKeys("micke5");
        driver.findElement(By.id("login-button"))
                .click();
        Assert.assertEquals(driver.findElement(By.cssSelector("error-message-container error")),
                "Epic sadface: Password is required",
                "Error! Trhere is not a message 'Password is required'");
    }
    @Test (priority = 3)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong (){
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("invalidpassword");
        driver.findElement(By.id("login-button"))
                .click();
        Assert.assertEquals(driver.findElement(By.cssSelector("error-message-container error")),
                "Epic sadface: Username and password do not match any user in this service",
                "Error! The client loged in");
    }
    @Test (priority = 4)
    public void verifyErrorIsDisplayedWhenUserIsLocked (){
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
       Assert.assertEquals(driver.findElement(By.cssSelector("error-message-container error")),
               "Epic sadface: Sorry, this user has been locked out",
               "Error! The client loged in");
    }
    @Test (priority = 5)
    public void verifySuccessfulLogin (){
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        driver.findElement(By.id("react-burger-menu-btn"))
                .click();
        wait
                .withMessage("Error! Menu button is not visible on the page")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bm-menu")));
        driver.findElement(By.id("logout_sidebar_link"))
                .click();
        wait
                .withMessage("Error! The screen didn't return to the login form!")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("login-box")));
    }
    @Test (priority = 6)
    public void addingProductsToCart (){
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        product.click();
        wait
                .withMessage("Error! Remove button doesn't appear ")
                .until(ExpectedConditions.elementToBeClickable(By.id("remove-sauce-labs-backpack")));
        Assert
                .assertEquals(driver.findElement(By.className("shopping_card_badge")).getText(), "1",
                "Error! Added product didn't displayed in shoping cart");
    }
    @Test (priority = 7)
    public void viewingProductDetails (){
        driver.findElement(By.id("user-name"))
             .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        driver.findElement(By.id("item_4_title_link")).click();
        Assert.assertEquals(driver.findElement(By.className("inventory_details_desc large_size")).isDisplayed(),
                "Error! Description item is not present.");
        Assert.assertEquals(driver.findElement(By.className("inventory_details_price")).isDisplayed(),
                "Error! Price item isn't present.");
        Assert.assertEquals(driver.findElement(By.id("add-to-cart-souce-labs-backpack")).isDisplayed(),
                "Error! Add to cart item isn't present.");
    }
    @Test (priority = 8)
    public void removingProductsFromCart (){
        driver.findElement(By.id("user-name"))
        .sendKeys("standard_user");
        driver.findElement(By.id("password"))
       .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        product.click();
        Assert
                .assertEquals(driver.findElement(By.className("shopping_card_badge")).getText(), "1",
                        "Error! Added product didn't displayed in shoping cart");
       WebElement shoppingCart= driver.findElement(By.id("shopping_cart_container"));
       shoppingCart.click();
        Assert.assertEquals(shoppingCart,
                "Product 'Sauce Labs Backpack' is in the basket",
                "Error! Product 'Sauce Labs Backpack' isn't in the basket");
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
        Assert.assertEquals(removeButton,
                "Product 'Sauce Labs Backpack' moved from the basket",
                "Error! Product 'Sauce Labs Backpack' is sitl in the basket");
    }
    @Test (priority = 9)
    public void productCheckout (){
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        product.click();
        Assert
                .assertEquals(driver.findElement(By.className("shopping_card_badge")).getText(), "1",
                        "Error! Added product didn't displayed in shoping cart");
        WebElement shoppingCart= driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();
        Assert.assertEquals(shoppingCart,
                "Product 'Sauce Labs Backpack' is in the basket",
                "Error! Product 'Sauce Labs Backpack' isn't in the basket");
        driver.findElement(By.id("checkout"))
                .click();
        driver.findElement(By.id("first-name"))
                .sendKeys("Mara");
        driver.findElement(By.id("last-name"))
                .sendKeys("Maric");
        driver.findElement(By.id("postal-code"))
                .sendKeys("21000");
        driver.findElement(By.id("continue"))
                .click();
        wait
                .withMessage("Error! Info about client are not valid")
                .until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
        wait
                .withMessage("Error! ")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_complete_container")));
    }
    @Test(priority = 10)
    public void validateSocialLinksInFooter () throws IOException {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

        List<WebElement> listOfSocials = driver.findElements(By.cssSelector("secret_sauce"));
        for (int i = 0; i < listOfSocials.size(); i++) {
            String url = listOfSocials.get(i).getAttribute("href");
            if (Helper.getHTTPResponseStatusCode(url) == 200) {
                System.out.println("Link " + url + " je validan");
            } else {
                System.out.println("Link " + url + " je nevalidan");
            }
        }
    }
    @Test (priority = 11)
    public void testDefaultNameSortA_Z() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        List<WebElement> productNames = driver.findElements(By.cssSelector(".inventory_item_name"));
       List<String> productNameText=new ArrayList<>();
        for (WebElement productName: productNames){
            productNameText.add(productName.getText());
        }
        Assert.assertEquals(productNameText, productNameText,
                "Product names are not sorted A-Z");
    }
    @Test (priority = 12)
    public void testInvertNamedSortZ_A (){
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        wait
                .withMessage("Error! URL doesn't contain '/inventory.html'")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        WebElement selectBy= driver.findElement(By.cssSelector("select.product_sort_container"));
        selectBy.click();
        WebElement optionZtoA = driver.findElement(By.xpath("//option[text()='Name (Z to A)']"));
        optionZtoA.click();
        Assert.assertTrue(optionZtoA.isSelected(), "Error! Name Z-A option isn't selected.");
        wait
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
    }
    @Test (priority = 13)
    public void testSortPriceLowHigh (){
    driver.findElement(By.id("user-name"))
            .sendKeys("standard_user");
    driver.findElement(By.id("password"))
            .sendKeys("secret_sauce");
    driver.findElement(By.id("login-button"))
            .click();
    wait
            .withMessage("Error! URL doesn't contain '/inventory.html'")
            .until(ExpectedConditions.urlContains("/inventory.html"));
    WebElement selectBy= driver.findElement(By.cssSelector("select.product_sort_container"));
    selectBy.click();
    WebElement lowToHigh= driver.findElement(By.xpath("'//option[text()='Price (low to high)']'"));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
        List<WebElement> productPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
        List<String> productPricesText = new ArrayList<>();
        for (WebElement price : productPrices) {
            productPricesText.add(price.getText());
        }
        Assert.assertTrue(lowToHigh.isSelected(),
                "Error! The prices are not sorted by lowest to highest");
    }

    @AfterMethod
    public void afterMethod (){
    driver.manage().deleteAllCookies();
    ((JavascriptExecutor) driver).executeScript("window.LocalStorage.clear();");
}
    @AfterClass
    public void afterClass (){
        driver.quit();
    }


}



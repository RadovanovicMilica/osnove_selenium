package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavPage extends BasicPage{
    public TopNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public static WebElement getMenuButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public static void clickOnMenuButton() {
        getMenuButton().click();
    }
    public static WebElement getCartBadge(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }
    public static String getCartText(){
        return getCartBadge().getText();
    }
    public static void clickOnCartButton() {

    }
    public byte[] getHeaderTitle() {

        return new byte[0];
    }
    public WebElement getCartLink() {
        return null;
    }
}


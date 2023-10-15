package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftNavPage extends BasicPage {
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static void waitForMenuToBeVisible() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("bm-menu-wrap")));
    }

    public static boolean doesLogoutButtonExist() {

        return elementExists(By.linkText("Logout"), 0);
    }

    public static void isOptionSpellingCorrect(int i, String allItems) {
    }

    public static WebElement getEkisButton() {
        return null;
    }

    public static boolean isLeftMenuWindowInvisible() {
        return true;
    }

    public void scrollToItem(){
        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("item_4_title_link")))
                .perform();
    }
    public static WebElement getAddtoCartButton(){
        return driver.findElement(By.cssSelector(".inventory_item button"));
    }
    public static Object clickOnAddToCartButton() {
        getAddtoCartButton().click();
        return null;
    }
    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }
    public static WebElement getLogoutLink() {

        return driver.findElement(By.linkText("Logout"));
    }
    public static void clickOnLogoutLink() {

        getLogoutLink().click();
    }

}

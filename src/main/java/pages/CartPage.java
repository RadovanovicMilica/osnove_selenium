package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasicPage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean checkIfAddedItemsExist(){
        return elementExists(By.className("cart_item"));
    }
    public WebElement getItemTitleElement(){
        return driver.findElement(By.className("inventory_item_name"));
    }
    public WebElement getItemDescriptionElement(){
        return driver.findElement(By.className("inventory_item_desc"));
    }
    public WebElement getItemPriceElement(){
        return driver.findElement(By.className("inventory_item_price"));
    }
    public WebElement getItemQuantityElement(){
        return driver.findElement(By.className("cart_quantity"));
    }
    public String getTextFromAddedItemName(){
        return  getItemTitleElement().getText();
    }
    public WebElement getRemoveButton(){
        return driver.findElement(By.xpath("//button[text()='Remove']"));
    }
    public static WebElement getContinueShoppingButton(){
        return driver.findElement(By.id("continue-shopping"));
    }

    public static WebElement getCheckoutButton(){
        return driver.findElement(By.id("checkout"));
    }


    public void clickOnRemoveButton(){
        getRemoveButton().click();
    }
    public void clickContinueShoppingButton(){
        getContinueShoppingButton().click();
    }
    public void waitForItemTitle(){
        wait
                .withMessage("Item title is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getItemTitleElement()));
    }
    public void waitForItemTitleToBeClickable(){
        wait
                .withMessage("Item title is not clickable in the cart")
                .until(ExpectedConditions.elementToBeClickable(getItemTitleElement())).click();
    }
    public void waitForItemDescription(){
        wait
                .withMessage("Item description is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getItemDescriptionElement()));
    }
    public void waitForItemPrice(){
        wait
                .withMessage("Item price is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getItemPriceElement()));
    }
    public void waitForItemQuantity(){
        wait
                .withMessage("Item quantity is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getItemQuantityElement()));
    }
    public void waitForRemoveButtonToBeVisible(){
        wait
                .withMessage("Remove button is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getRemoveButton()));
    }
    public static boolean waitForContinueShoppingButtonToBeVisible(String sauceLabsBackpack){
        wait
                .withMessage("Continue shopping button is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getContinueShoppingButton()));
        return false;
    }

    public void waitForCheckoutButtonToBeVisible(){
        wait
                .withMessage("Checkout button is not visible in the cart")
                .until(ExpectedConditions.visibilityOf(getCheckoutButton()));
    }

}

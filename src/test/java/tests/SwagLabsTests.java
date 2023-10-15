package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import retry.BootsnippRetry;

public class SwagLabsTests extends  BasicTest {
    private Object cartBodyPage;

    public SwagLabsTests(WebDriver driver, WebDriverWait wait, String baseUrl) {
        super(driver, wait, baseUrl);
    }

    @Test(priority = 1)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(),
                "Epic sadface: Username is required",
                "Error message doesn't apear!");
    }

    @Test(priority = 2)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "micke5";
        loginPage.clearAndTypeUsername(username);
        loginPage.clickOnLoginButton();
    }

    @Test(priority = 3)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.getLoginButton();
        Assert.assertEquals(
                loginPage.getErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not valid when credentials are wrong.");
    }

    @Test(priority = 4, retryAnalyzer = BootsnippRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(
                loginPage.getErrorMessageText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message is not valid when user is locked out.");
    }

    @Test(priority = 5, retryAnalyzer = BootsnippRetry.class)
    public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        TopNavPage.clickOnMenuButton();
        LeftNavPage.waitForMenuToBeVisible();
        Assert.assertTrue(LeftNavPage.doesLogoutButtonExist(),
                "Logout link should exists on menu.");

        LeftNavPage.clickOnLogoutLink();

        Assert.assertTrue(
                loginPage.doesUsernameInputExist(),
                "Should be redirected to login page after logout.");
    }
    @Test(priority = 6, retryAnalyzer = BootsnippRetry.class)
    public void addingProductstoCart (){
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

    }
    @Test (priority = 7, retryAnalyzer = BootsnippRetry.class)
    public void verifyUrl(){
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "cart.html",
                "User should be redirected to Cart page.");
    }
    @Test(priority = 8, retryAnalyzer = BootsnippRetry.class)
    public void verifyTheTitlePage(){
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Page title should be Swag Labs.");
    }
    @Test (priority = 9, retryAnalyzer = BootsnippRetry.class)
    public void verifyTheTitleInHeader() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertEquals(TopNavPage.getCartText(),
                "Swag Labs",
                "Title in header should be Swag Labs.");

    }
    @Test (priority = 10, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertTrue(TopNavPage.getMenuButton().isDisplayed(),
                "Hamburger menu button should be presented");

    }
    @Test (priority = 11, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheCartIconIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        Assert.assertTrue(TopNavPage.getCartBadge().isEnabled(),
                "The cart icon should be enabled.");
    }
    @Test (priority = 12, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsEnabled() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        TopNavPage.clickOnMenuButton();
        Assert.assertTrue(TopNavPage.getMenuButton().isEnabled(),
                "Menu button should be enabled after click.");
    }
    @Test (priority = 13, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheCartIconIsEnabled() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertTrue(TopNavPage.getCartBadge().isEnabled(),
                "Cart icon should be enabled after click.");
    }
    @Test (priority = 14, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheHamburgerButtonIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.waitForMenuToBeVisible();
        Assert.assertTrue(LeftNavPage.getLogoutLink()
                        .isDisplayed(),
                "User should see ..");
    }
    @Test (priority = 15, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheCartIconIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"),
                "User should be redirected to cart page.");
    }
    @Test (priority = 16, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheCartIconHasCorrectNumberOfAddedItems() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
        Assert.assertEquals(TopNavPage.getCartText(), "1",
                "Number in the cart icon should be equivalent to the total number of added items");
    }
    @Test (priority = 17, retryAnalyzer = BootsnippRetry.class)
    public void verifyTheSubHeaderTitle() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertEquals(TopNavPage.getCartText(),
                "Your Cart",
                "Sub-header title should be 'Your Cart'");
    }
    @Test (priority = 18, retryAnalyzer = BootsnippRetry.class)
    public void verifyTheTotalNumberOfMenuOptions() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertEquals(LeftNavPage.clickOnAddToCartButton(),
                4,
                "There should be 4 total options in menu");
    }
    @Test (priority = 19, retryAnalyzer = BootsnippRetry.class)
    public void verifyTheSpellingOfAllOptionsInMenu() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.isOptionSpellingCorrect(0,"All Items");
        LeftNavPage.isOptionSpellingCorrect(1,"About");
        LeftNavPage.isOptionSpellingCorrect(2,"Logout");
        LeftNavPage.isOptionSpellingCorrect(3,"Reset App");
    }
    @Test (priority = 20, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfAllItemsOptionIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.clickOnAddToCartButton();
        Assert.assertEquals(TopNavPage.getCartText(),
                "Products",
                "Customer should be redirected to the products page");
    }
    @Test (priority = 21, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfAboutOptionIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.clickOnAddToCartButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://saucelabs.com/",
                "User should be redirected to the the sauce labs website");
    }
    @Test (priority = 22, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfLogoutOptionIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.clickOnAddToCartButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://saucelabs.com/",
                "User should be redirected to login page.");
    }
    @Test (priority = 23, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfResetAppStateIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.clickOnAddToCartButton();
        Assert.assertEquals(driver.getCurrentUrl(),
        Assert.assertEquals(TopNavPage.getCartText(),
                "0",
                "The state of web app should be reseted.");
    }
    @Test (priority = 24, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheEkisButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        Assert.assertTrue(LeftNavPage.getEkisButton().isDisplayed(),
                "Ekis button should be visible.");
    }
    @Test (priority = 25, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheEkisButtonIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        TopNavPage.clickOnMenuButton();
        LeftNavPage.getEkisButton();
        Assert.assertTrue(LeftNavPage.isLeftMenuWindowInvisible(),
                "It should close the left menu navigation.");
    }
    @Test (priority = 26, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheItemsAddedIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
        wait
                .withMessage("Title of items should be visible.")
                .until(ExpectedConditions.textToBePresentInElement(.getSingleItem(0)), //?
    }
    @Test (priority = 27, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheItemsTitleIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.scrollToItem("Sauce Labs Backpack");
        InventoryPage.clickOnAddToCartButton("Sauce Labs Backpack");
        TopNavPage.clickOnCartButton();
    }
    @Test (priority = 28, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheItemsDescriptionIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
    }
    @Test (priority = 29, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheItemsPriceIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.scrollToItem("Sauce Labs Backpack");
        InventoryPage.clickOnAddToCartButton("Sauce Labs Backpack");
        TopNavPage.clickOnCartButton();

        Assert.assertTrue(cartBodyPage
                        .doesItemsPriceExist(),
                "Item's price should be visible");
    }
    @Test (priority = 30, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheQuantityOfItemIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();

    }
    @Test (priority = 31, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheItemsTitleIsClickable() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
    }
    @Test (priority = 32, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheItemsTitleIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.scrollToItem("Sauce Labs Backpack");
        InventoryPage.clickOnAddToCartButton("Sauce Labs Backpack");
        TopNavPage.clickOnCartButton();
        cartBodyPage.clickOnProductTitleInCartByProductNameText();
        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("inventory-item.html"),
                "User should be redirected to the the item's page.");
    }
    @Test (priority = 33, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheRemoveButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.scrollToItem("Sauce Labs Backpack");
        InventoryPage.clickOnAddToCartButton("Sauce Labs Backpack");
        TopNavPage.clickOnCartButton();
        Assert.assertTrue(CartPage
                        .waitForContinueShoppingButtonToBeVisible("Sauce Labs Backpack"),
                "Remove button should be visible");
    }
    @Test (priority = 34, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheRemoveButtonIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
    }
    @Test (priority = 35, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheContinueShoppingButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
    }
    @Test (priority = 36, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheContinueShoppingButtonIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "User should be redirected to the inventory page");

    }
    @Test (priority = 37, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheCheckoutButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
    }
    @Test (priority = 38, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheCheckoutButtonIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        InventoryPage.clickOnAddToCartButton();
        TopNavPage.clickOnCartButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "User should be redirected to checkout page.");
        CartPage.getCheckoutButton();
    }
    @Test (priority = 39, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheTwitterButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        FooterPage footer = null;
        Assert.assertTrue(footer.getSingleSocial(0).isDisplayed(),
                "Twitter icon should be visible");

    }
    @Test (priority = 40, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheFacebookButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        FooterPage footer = null;
        Assert.assertTrue(footer.getSingleSocial(1).isDisplayed(),
                "Facebook buttom should be visible");

    }
    @Test (priority = 41, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheLinkedinButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        FooterPage footer = null;
        Assert.assertTrue(footer.getSingleSocial(2).isDisplayed(),
                "Linkedin button should be visible");
    }
    @Test (priority = 42, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheTwitterButtonIsWorking()  {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        FooterPage.scrollToFooter();
        FooterPage.clickOnSocial(1);
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://twitter.com/saucelabs",
                "User should be redirected to the sauce labs twitter account.");
    }
    @Test (priority = 41, retryAnalyzer = BootsnippRetry.class)
    public void verifyIfTheFaceboogkButtonIsWorking() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        TopNavPage.clickOnCartButton();
        FooterPage.clickOnSocial(1);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs",
                "User should be redirected to sauce labs facebook account.");
}
}
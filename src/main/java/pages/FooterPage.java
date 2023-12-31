package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FooterPage  extends BasicPage{
    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static void scrollToFooter() {
    }

    public List<WebElement> getSocialList(){
        return driver.findElements(By.cssSelector(".social > li"));
    }
    public WebElement getSingleSocial(int index){
        return getSocialList().get(index);
    }
    public static void clickOnSocial(int index){
        getSingleSocial(index).findElement(By.tagName("a")).click();
    }
    public String getFooterCopyrightText(){
        return driver.findElement(By.className("footer_copy")).getText();
    }
}

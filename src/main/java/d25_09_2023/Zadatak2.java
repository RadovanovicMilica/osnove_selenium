package d25_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        ArrayList<String> nizToDo = new ArrayList<>();
        nizToDo.add("Visit Paris");
        nizToDo.add("Visit Prague");
        nizToDo.add("Visit London");
        nizToDo.add("Visit New York");
        nizToDo.add("Visit Belgrade");

        driver.get("https://example.cypress.io/todo");
        for (int i=0; i< nizToDo.size(); i++){
            WebElement unosNaStranicu= driver.findElement(By.className("new-todo"));
            unosNaStranicu.sendKeys(nizToDo.get(i));
            unosNaStranicu.sendKeys(Keys.ENTER);
        }
        for (int i=0; i<nizToDo.size(); i++){
            WebElement toDo= driver.findElement(By.name(nizToDo.get(i)));
            toDo.click();
        }
Thread.sleep(5000);
        driver.close();
    }
}


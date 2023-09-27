package d26_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://demoqa.com/automation-practice-form");
        Scanner s= new Scanner(System.in);

        System.out.println("Unesite ime: ");
        String ime= s.next();
        System.out.println("Unesite prezime: ");
        String prezime= s.next();
        System.out.println("Unesite email: ");
        String mail= s.next();
        System.out.println("Unesite mobilni: ");
        String mob= s.next();
        System.out.println("Unesite datum: ");
        String datum= s.next();
        System.out.println("Unesite naslov: ");
        String naslov=s.next();

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys(ime);
        WebElement lastNameInput= driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys(prezime);
        WebElement emailInput= driver.findElement(By.id("userEmail"));
        emailInput.sendKeys(mail);
        driver.findElement(By.cssSelector("label.custom-control-label::after"))
                .click();
        WebElement mobileInput= driver.findElement(By.id("userNumber"));
        mobileInput.sendKeys(mob);
        WebElement dateInput= driver.findElement(By.id("dateOfBirthInput"));
        dateInput.sendKeys(datum);
        WebElement subjectInput = driver.findElement(By.id("subjects"));
        subjectInput.sendKeys(naslov);
        driver.findElement(By.cssSelector("label.custom-control-label"))
                .click();
        driver.findElement(By.id("uploadPicture"))
                .click();

    }
}

package Vezbanje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Vezba1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
       WebElement usernameField= driver.findElement(By.id("username"));
       usernameField.sendKeys("student");
       WebElement passwordField=driver.findElement(By.id("password"));
       passwordField.sendKeys("Password123");
       WebElement submitButton=driver.findElement(By.id("submit"));
       submitButton.click();
//provera URL
      String expectedUrl="https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        //provera da li stranica sadrzi odredjeni deo teksta

       WebElement paragraph=driver.findElement(By.className("has-text-align-center"));
       String text=paragraph.getText();
       Assert.assertTrue(text.contains("Congratulations") || text.contains("successfully logged in"));

        //da li postoji Log out dugme
        WebElement logoutButton= driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());
        driver.quit();


    }
}

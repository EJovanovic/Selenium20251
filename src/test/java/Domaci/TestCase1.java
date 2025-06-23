package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
        WebElement usernameField=driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("standard_user");
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");
        WebElement submitButton=driver.findElement(By.id("login-button"));
        submitButton.click();


        String expectedUrl="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        WebElement shoppingCart= driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(shoppingCart.isDisplayed());

        driver.quit();


    }
}

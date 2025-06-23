package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
        WebElement usernameField=driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("locked_out_user");
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");
        WebElement submitButton=driver.findElement(By.id("login-button"));
        submitButton.click();

        WebElement errorMessage= driver.findElement(By.cssSelector(".error-message-container.error"));
        Assert.assertTrue(errorMessage.isDisplayed());


        String actualUrl=driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains("inventory.html"));


        WebElement loginButton= driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());

        driver.quit();


    }
}

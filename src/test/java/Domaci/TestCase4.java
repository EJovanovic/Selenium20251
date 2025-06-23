package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;

public class TestCase4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
        WebElement usernameField=driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("problem_user");
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");
        WebElement submitButton=driver.findElement(By.id("login-button"));
        submitButton.click();

        String expectedUrl= "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        WebElement menuButton=driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(menuButton.isDisplayed());

       List<WebElement>pictures=driver.findElements(By.className("inventory_item_img"));
       for(WebElement picture:pictures){
           Assert.assertTrue(picture.isDisplayed());
       }
       driver.quit();



    }
}

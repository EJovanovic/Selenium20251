package Vezbanje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Vezba2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameFeld=driver.findElement(By.id("username"));
        usernameFeld.sendKeys("incorrectUser");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedUrl="https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        String expectedText="Your username is invalid!";
      String text=errorMessage.getText();
      Assert.assertEquals(expectedText,text);


    }
}

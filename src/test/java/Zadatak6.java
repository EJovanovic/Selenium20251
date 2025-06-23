import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;


public class Zadatak6 {
    private static final Logger log = LoggerFactory.getLogger(Zadatak6.class);

    /*// Zadatak 6
    // Ulogovati se na wordpress aplikaciju koristeci sopstvene kredencijale
    // Fokus treba da bude na cekanjima i lokatorima

         */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));

        driver.navigate().to("https://wordpress.com/");

       WebElement logInField= driver.findElement(By.linkText("Log in"));
       logInField.click();

       WebElement emailField=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("usernameOrEmail"))));
       emailField.sendKeys("emilijajovanovic25@gmail.com");
       WebElement continueButton=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("login__form-action"))));
       continueButton.click();
       WebElement passwordField=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
       passwordField.sendKeys("radivojefelix");
       passwordField.click();
       WebElement loginButton=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("login__form-action"))));
       loginButton.click();

       String expectedUrl="https://wordpress.com";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

        WebElement loginButtonpresent=driver.findElement(By.linkText("Log in"));
        Assert.assertTrue(loginButtonpresent.isDisplayed());

        WebElement continueButtonIsPresent=driver.findElement(By.className("login__form-action"));
        Assert.assertTrue(continueButtonIsPresent.isDisplayed());







    }
}

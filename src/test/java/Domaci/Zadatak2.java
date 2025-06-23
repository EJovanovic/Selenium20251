package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebElement continueButton=driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button"));
        continueButton.click();
        WebElement addToCart=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("add-to-cart-button"))));
        addToCart.click();
        driver.manage().deleteCookieNamed("session-id");
        driver.navigate().refresh();

        WebElement emptyCartText= driver.findElement(By.cssSelector("h3.a-size-large.a-spacing-top-base.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(emptyCartText.isDisplayed());

        driver.quit();


    }
}





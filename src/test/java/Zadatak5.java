import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        Thread.sleep(2000);
        WebElement practiceButton= driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement loginLink= driver.findElement(By.linkText("Test Login Page"));
        loginLink.click();
        WebElement usernameLog=driver.findElement(By.id("username"));
        usernameLog.clear();
        usernameLog.sendKeys("student");
        WebElement passwordLog=driver.findElement(By.id("password"));
        passwordLog.clear();
        passwordLog.sendKeys("Password123");
        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedUrl= "practicetestautomation.com/logged-in-successfully/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        WebElement loginElement=driver.findElement(By.className("post-title"));
        Assert.assertTrue(loginElement.isDisplayed());

        WebElement logoutButton=driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement userTitle=driver.findElement(By.className("has-text-align-center"));
        String expectedTitle= "Congratulations" + usernameLog + "You successfully logged in!";
        Assert.assertEquals(expectedTitle,userTitle);







    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Zadatak8 {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }
        @BeforeMethod
    public void navigate() {
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement logInbutton = driver.findElement(By.linkText("Test Login Page"));
            logInbutton.click();
        }

        @Test
    public void testLogIn() {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.id("submit"));
            usernameField.clear();
            usernameField.sendKeys("student");
            passwordField.clear();
            passwordField.sendKeys("Password123");
            submitButton.click();

            String exceptedUrl = "https://practicetestautomation.com/logged-in-successfully/";
            Assert.assertEquals(exceptedUrl, driver.getCurrentUrl());

            WebElement logoutButton = driver.findElement(By.linkText("Log out"));
            Assert.assertTrue(logoutButton.isDisplayed());
        }

            @AfterMethod
    public void deleteCookies() {
                driver.manage().deleteAllCookies();
            }


            @Test
    public void invalidUsername() {
                WebElement usernameField = driver.findElement(By.id("username"));
                WebElement passwordField = driver.findElement(By.id("password"));
                WebElement submitButton = driver.findElement(By.id("submit"));
                usernameField.clear();
                usernameField.sendKeys("student1");
                passwordField.clear();
                passwordField.sendKeys("Password123");
                submitButton.click();

                String exceptedUrl = "https://practicetestautomation.com/practice-test-login/";
                Assert.assertEquals(exceptedUrl, driver.getCurrentUrl());

                WebElement errorMessage = driver.findElement(By.id("error"));
                Assert.assertTrue(errorMessage.isDisplayed());

            }
            @Test
    public void invalidPassword(){
                WebElement usernameField = driver.findElement(By.id("username"));
                WebElement passwordField = driver.findElement(By.id("password"));
                WebElement submitButton = driver.findElement(By.id("submit"));
                usernameField.clear();
                usernameField.sendKeys("student");
                passwordField.clear();
                passwordField.sendKeys("Password");
                submitButton.click();

                String expectedUrl= "https://practicetestautomation.com/practice-test-login/";
                Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

                WebElement errorMessage=driver.findElement(By.id("error"));
                Assert.assertTrue(errorMessage.isDisplayed());

                String expectedText="Your password is invalid!";


            }





    }


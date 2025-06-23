import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium6 {
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
        WebElement usernameField= driver.findElement(By.id("username"));
        WebElement passwordField=driver.findElement(By.id("password"));
        String usernamecredentials="student";
        String passwordcredentials= "Password123";
        usernameField.clear();
        usernameField.sendKeys(usernamecredentials);
        passwordField.clear();
        passwordField.sendKeys(passwordcredentials);
        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedUrl= "practicetestautomation.com/logged-in-successfully/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        WebElement logoutButton=driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());
        //_________________________

        logoutButton.click();

        Assert.assertNotEquals(expectedUrl,driver.getCurrentUrl());

        WebElement submitButtonAfterLogout=driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfterLogout.isDisplayed());

        //___________
        // Kada zelimo da proverimo da li neki element NIJE PRISUTAN
        // ne mozemo tek tako da koristimo Assert.assertFalse(element)
        // jer program ce da vrati gresku da ne moze da pronadje element

        // Nacin da zaobidjemo ovaj problem je da koristimo try catch blok
        // Try deo ce uvek da pokusa da izvrsi deo koda ali ako ne uspe i ako dobijemo gresku
        // onda program nece da pukne tu nego ce nastaviti dalje
        // Catch deo nam nije bitan, ali je obavezna u javi kao deo try catch bloka i potrebno je
        // samo da kreiramo taj deo i da prosledimo da uhvati neki Exception
        // Ako zelimo taj Exception koji smo nazvali 'e' mozemo da odstampamo u catch bloku

        // Pre pocetka pravimo boolean cija je vrednost false
        // Na kraju cemo raditi asertaciju bas ovo booleana i ocekujemo da bude false
        // Taj boolean ce se promeniti na true samo ako element bude vidljiv na stranici

        boolean isPresent=false;

        try {
            // Upravo u ovom delu kazemo programu - Ako pronadjes element, promeni vrednost booleana na true
            isPresent = driver.findElement(By.linkText("Log out")).isDisplayed();
        }
        catch (Exception e) {
        }
        Assert.assertFalse(isPresent);
        }


    }


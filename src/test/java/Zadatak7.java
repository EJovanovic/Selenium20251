import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak7 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");
        Cookie cookie= new Cookie("wordpress_logged_in","emilijajovanovic25%7C1845055448%7CP4uJKf36OKxRBYrEb7IyXCc8j5ArhuRJBnT34CQjsyt%7C1b4653034c1e61daee2dc075baf77de25e13b6358cfc3fa3e98649e0e1443b32");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}

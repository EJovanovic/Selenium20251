import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        driver.navigate().to("https://www.youtube.com");
        ArrayList<String> listaTabova=new ArrayList<>(driver.getWindowHandles());//mora posle otvaranja svih tabova
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.google.com");
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        driver.quit();
    }
}

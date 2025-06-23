import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak4 {
    /*//Zadatak 3
//Otici na Bing
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola Tesla"

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);
        WebElement searchBox=driver.findElement(By.id("sb_form_q"));
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement wikipediaButton=driver.findElement(By.linkText("Wikipedia"));
        wikipediaButton.click();
        ArrayList<String>windowhHandlesList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowhHandlesList.get(1));
       WebElement wikipediaSearchBox=driver.findElement(By.id("searchInput"));
      wikipediaSearchBox.sendKeys("Nikola Tesla");
      // wikipediaSearchBox.click();
       // WebElement searchButton=driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
       WebElement searchButton=driver.findElement(By.cssSelector("button[type=submit]"));
        searchButton.click();




    }
}

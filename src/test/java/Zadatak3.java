import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
/*/Zadatak 3
//Otici na Bing
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola Tesla"

 */

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys("Wikipedia");
        Thread.sleep(2000);
        driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/main/ol/li[1]/h2/a")).click();
        ArrayList<String>listaTabova=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input")).sendKeys("Nikola Tesla");
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/button/i")).click();
    }
}

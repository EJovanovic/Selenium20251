import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {
        //u ovoj komandi postavljam driver
        WebDriverManager.chromedriver().setup();
        //u ovoj komandi kreiram objekat sa kojim cu da da radim
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.google.com");//nece cekati da se stranica odazove
        driver.navigate().to("https://www.google.com");//prvo saceka da se google da je sve okej i onda nastavlja
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().back();

        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        driver.close();//zatvara trenutni tab na kom se nalazi, ako imate jedan on ce zatvoriti samo taj tab
        driver.quit();//zatvorice citav browser
    }
}

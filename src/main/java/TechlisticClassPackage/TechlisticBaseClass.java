package TechlisticClassPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TechlisticBaseClass {
    WebDriver driver=null;
    public void BrowserConfig(String Browser) {
        if (Browser.contains("Chrome")) {
            //***Below statement used instead of "System.setProperty()"

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.get("https://www.techlistic.com/2020/07/automation-testing-demo-websites.html");
        }
        if (Browser.contains("Firefox")) {
            //***Below statement used instead of "System.setProperty()"
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }
    public static void main(String args[]){

         TechlisticBaseClass tbc=new TechlisticBaseClass();
         tbc.BrowserConfig("Chrome");


    }

}

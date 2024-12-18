package TechlisticClassPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class TechlisticBaseClass {
          public static WebDriver driver;
    public void BrowserConfig(String Browser) throws InterruptedException {
        if (Browser.contains("Chrome")) {
            //********** commented part if you want headless mode for automation. *********
           /*ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);*/
            //***Below statement used instead of "System.setProperty()"
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.get("https://subodhshukla.github.io/TestSite/TestSite.html");
            System.out.println("Application ran successfully, thanks");

        }
        if (Browser.contains("Firefox")) {
            //***Below statement used instead of "System.setProperty()"
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
	    	
        }

    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
    public static void main(String args[]) throws InterruptedException {

         TechlisticBaseClass tbc=new TechlisticBaseClass();
          tbc.BrowserConfig("Chrome");
	      System.out.println("I have created a Branch on Git: StageBranch ");


    }

}

package TechlisticClassPackage;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage extends TechlisticBaseClass{
    Properties homePageProp=new Properties();
    public HomePage() throws IOException {
        InputStream inputStr = new FileInputStream("D:\\subodh\\subodh_Spar\\Automation\\DemoSiteTechlistic\\src\\main\\resources\\HomePage.properties");
        homePageProp.load(inputStr);
    }

    public String verifyHomePage(){
       // driver.findElement(By.xpath("/html/body/nav/ul/li[1]/a")).click();
        driver.findElement(By.xpath(homePageProp.getProperty("HomePageTab"))).click();
     // String homepageActualTile=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h1")).getText();
        String homepageActualTile=driver.findElement(By.xpath(homePageProp.getProperty("HomePageTitle"))).getText();
        return homepageActualTile;
    }

}

package TechlisticClassPackage;

import org.openqa.selenium.By;

public class HomePage extends TechlisticBaseClass{
    String homepageExpectedTitle="CHEMSCOPE LABSOLUTION INDIA LLP";
    public String verifyHomePage(){
        driver.findElement(By.xpath("/html/body/nav/ul/li[1]/a")).click();
      String homepageActualTile=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h1")).getText();
        return homepageActualTile;
    }

}

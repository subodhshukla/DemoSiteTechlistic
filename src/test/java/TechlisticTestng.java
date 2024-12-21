import TechlisticClassPackage.HomePage;
import TechlisticClassPackage.LoginPage;
import TechlisticClassPackage.TechlisticBaseClass;
import org.openqa.selenium.devtools.v127.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TechlisticTestng extends TechlisticBaseClass{
    public LoginPage userlogin=new LoginPage();
    //TechlisticBaseClass tbc=new TechlisticBaseClass();
    public HomePage hpage=new HomePage();

    public TechlisticTestng() throws IOException {
    }

    @Test(priority = 1)
   @Parameters("Browsername")
    public void openBrowser(String Browser) throws InterruptedException {
        //TechlisticBaseClass tbc=new TechlisticBaseClass();
        BrowserConfig(Browser);
        System.out.println("Browser launched");
        System.out.println("pushed on dev enviornment ");
        Thread.sleep(2000);

    }
    @Test (priority = 2)
    public void validateHomePage(){
        String homepageExpectedTitle="CHEMSCOPE LABSOLUTION INDIA LLP";
        String homepageActualTile= hpage.verifyHomePage();
        try {
            Assert.assertEquals(homepageActualTile, homepageExpectedTitle, "home page text not matching");
            System.out.println("Assertion Passed: Page title matches.");
        }
        catch (AssertionError e) {
            System.err.println("Assertion Failed: " + e.getMessage());
            throw e; // Fail the test
        }
    }
   /* @Test (priority = 2)
    public void loginToTestSite() throws InterruptedException {
       userlogin.login();
    }
*/
  /*  @Test (priority = 3)
    public void quitNow(){
       closeBrowser();
    }*/
   //driver.quit();
}

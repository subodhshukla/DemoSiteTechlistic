import TechlisticClassPackage.LoginPage;
import TechlisticClassPackage.TechlisticBaseClass;
import org.openqa.selenium.devtools.v127.browser.Browser;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TechlisticTestng extends TechlisticBaseClass{
    public LoginPage userlogin=new LoginPage();
    //TechlisticBaseClass tbc=new TechlisticBaseClass();
   @Test(priority = 1)
   @Parameters("Browsername")
    public void openBrowser(String Browser) throws InterruptedException {
        //TechlisticBaseClass tbc=new TechlisticBaseClass();
        BrowserConfig(Browser);
        System.out.println("Browser launched");
        System.out.println("pushed on dev enviornment ");
        Thread.sleep(2000);

    }
   /* @Test (priority = 2)
    public void loginToTestSite() throws InterruptedException {
       userlogin.login();
    }
*/
    @Test (priority = 2)
    public void quitNow(){
       closeBrowser();
    }
   //driver.quit();
}

import TechlisticClassPackage.TechlisticBaseClass;
import org.openqa.selenium.devtools.v127.browser.Browser;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TechlisticTestng {

   @Test
   @Parameters("Browsername")
    public void enterDetails(String Browser){
        TechlisticBaseClass tbc=new TechlisticBaseClass();
        tbc.BrowserConfig(Browser);
        System.out.println("Browser launched");
        System.out.println("pushed on dev enviornment ");

    }
}

import TechlisticClassPackage.TechlisticBaseClass;
import org.testng.annotations.Test;

public class TechlisticTestng {

   @Test
    public void enterDetails(){
        TechlisticBaseClass tbc=new TechlisticBaseClass();
        tbc.BrowserConfig("Chrome");
        System.out.println("Browser launched");
        System.out.println("pushed on dev enviornment ");

    }
}

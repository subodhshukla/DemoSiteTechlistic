package TestPackage;

import TechlisticClassPackage.TechlisticBaseClass;
import org.testng.annotations.Test;
public class TechlisticTestng {

   @Test
    public void enterDetails(){
        TechlisticBaseClass tbc=new TechlisticBaseClass();
        tbc.BrowserConfig("Chrome");

    }
}

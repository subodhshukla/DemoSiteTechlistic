package TechlisticClassPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends TechlisticBaseClass {
    public LoginPage() throws IOException {
    }

    // WebDriver driver=null;
    public void login() throws InterruptedException {
       // this.driver=super.driver;
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("subodh");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(("subodh"));
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        driver.switchTo().alert().accept();

    }

}

package lt.techin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage{


    public UserPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickLogout(String randomName) {
        WebElement buttonLogout = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/a[.='Logout, " + randomName + "']"));
        buttonLogout.click();
    }
}

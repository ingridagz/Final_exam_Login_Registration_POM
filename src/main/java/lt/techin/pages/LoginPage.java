package lt.techin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class LoginPage extends BasePage {

    private static final Logger log = getLogger(lookup().lookupClass());
    @FindBy(xpath = "//a[@href='/registruoti']")
    WebElement linklSukurtiNaujaPaskyra;
    @FindBy(xpath = "//form[@id='userForm']/button[@type='submit']")
    WebElement buttonSukurti;
    @FindBy(css = ".form-signin-heading")
    WebElement labelNaujosPaskyrosSukurimas;

    @FindBy(xpath = "//input[@name='username']")
    WebElement inputPrisijungimoVardas;

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputSlaptazodis;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonPrisijungti;

@FindBy(xpath = "//form[@action='/prisijungti']/div/span[2]")
   WebElement errorBlogasSlaptazodis;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSukurtiNaujaPaskyra() {
        linklSukurtiNaujaPaskyra.click();
    }

    public void isButtonSukurtiDisplayed() {
        try {
            buttonSukurti.isDisplayed();
        } catch (Exception e) {
            log.error("Logout button is not displayed {}", e.getMessage());
        }
    }

    public String getLabelText() {
        return labelNaujosPaskyrosSukurimas.getText();
    }

    public void fillLoginPrisijungimoVardas(String name) {
        inputPrisijungimoVardas.sendKeys(name);
    }

    public void fillLoginSlaptazodis(String password) {
        inputSlaptazodis.sendKeys(password);
    }

  public void clickPrisijungti(){
      buttonPrisijungti.click();
  }
    public String getErrorBlogasSlaptazodisText() {
        return errorBlogasSlaptazodis.getText();
    }

}

package lt.techin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;

import java.util.List;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class RegisterPage extends BasePage {

    private static final Logger log = getLogger(lookup().lookupClass());

    @FindBy(css = "input#username")
    WebElement inputPrisijungimoVardas;
    @FindBy(css = "input#password")
    WebElement inputSlaptazodis;

    @FindBy(css = "input#passwordConfirm")
    WebElement inputSlaptazodioPatvirtinimas;

    @FindBy(xpath = "//form[@id='userForm']/button[@type='submit']")
    WebElement buttonSukurti;
    @FindBy(xpath = "//span[@id='passwordConfirm.errors']")
    WebElement errorSlaptazodzioPatvirtinimas;

    @FindBy(xpath = "//form/input[@value='skaičiuoti']")
    WebElement buttonSkaiciuoti;

    @FindBy(xpath = "//span")
    List<WebElement> errorRegistrationMessages;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillPrisijungimoVardas(String name) {
        inputPrisijungimoVardas.sendKeys(name);
    }

    public void fillSlaptazodis(String password) {
        inputSlaptazodis.sendKeys(password);
    }

    public void confirmSlaptazodis(String password) {
        inputSlaptazodioPatvirtinimas.sendKeys(password);
    }

    public void clickSukurti() {
        buttonSukurti.click();
    }
    public String getErrorSlaptazodzioPatvirtinimasText() {
        return errorSlaptazodzioPatvirtinimas.getText();
    }

    public boolean isButtonSkaiciuotiDisplayed() {
           return buttonSkaiciuoti.isDisplayed();
    }
    public boolean isErrorMessageDisplayed(String messageErr) {
        return errorRegistrationMessages.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.equals(messageErr));
    }
}

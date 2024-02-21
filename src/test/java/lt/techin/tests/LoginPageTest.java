package lt.techin.tests;

import lt.techin.pages.LoginPage;
import lt.techin.pages.RegisterPage;
import lt.techin.pages.UserPage;
import lt.techin.tests.utils.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class LoginPageTest extends BasePageTest {
    private static final Logger log = getLogger(lookup().lookupClass());

    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected UserPage userPage;

    private final String password = "666666";
    private final String wrongPassword = "555555";


    @BeforeEach
    void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    void goToRegisterPageTest() {
        log.info("'goToRegisterPageTest' initialized");
        loginPage.clickSukurtiNaujaPaskyra();
        loginPage.isButtonSukurtiDisplayed();
        Assertions.assertEquals("Naujos paskyros sukūrimas", loginPage.getLabelText(), "No such label");
        log.info("'goToLoginPageTest' completed. Label is: " + loginPage.getLabelText());
    }

    @Test
    void userCorectLoginTest() {
        log.info("'userCorectLoginTest' initialized");
        loginPage.clickSukurtiNaujaPaskyra();
        String randomName = UtilsTest.getRandomName();
        registerPage.fillPrisijungimoVardas(randomName);
        registerPage.fillSlaptazodis(password);
        registerPage.confirmSlaptazodis(password);
        registerPage.clickSukurti();

        userPage.clickLogout(randomName);

        loginPage.fillLoginPrisijungimoVardas(randomName);
        loginPage.fillLoginSlaptazodis(password);
        loginPage.clickPrisijungti();
        Assertions.assertTrue(registerPage.isButtonSkaiciuotiDisplayed());
        log.info("'userCorectLoginTest' completed. Credentials: " + randomName + "/" + password);
    }

    @Test
    void userWrongLoginTest() {
        log.info("'userWrongLoginTest' initialized");
        loginPage.clickSukurtiNaujaPaskyra();
        String randomName = UtilsTest.getRandomName();
        registerPage.fillPrisijungimoVardas(randomName);
        registerPage.fillSlaptazodis(password);
        registerPage.confirmSlaptazodis(password);
        registerPage.clickSukurti();

        userPage.clickLogout(randomName);

        loginPage.fillLoginPrisijungimoVardas(randomName);
        loginPage.fillLoginSlaptazodis(wrongPassword);
        loginPage.clickPrisijungti();
        Assertions.assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", loginPage.getErrorBlogasSlaptazodisText(),"No error message");
        log.info("'userWrongLoginTest' completed. Credentials: " + randomName + "/ Registration password: " +password+ "/ Login password: " +wrongPassword);
    }
}

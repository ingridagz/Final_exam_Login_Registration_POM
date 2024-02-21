package lt.techin.tests;

import lt.techin.pages.LoginPage;
import lt.techin.pages.RegisterPage;
import lt.techin.tests.utils.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;

import java.util.Objects;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class RegisterPageTest extends BasePageTest {
    protected static final Logger log = getLogger(lookup().lookupClass());
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    private final String password = "666666";
    private final String confirmPassword = "555555";

    @BeforeEach
    void setUpRegisterPage() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    void userCorectRegistrationTest() {
        log.info("'userCorectRegistrationTest' initialized");
        loginPage.clickSukurtiNaujaPaskyra();
        String randomName = UtilsTest.getRandomName();
        registerPage.fillPrisijungimoVardas(randomName);
        registerPage.fillSlaptazodis(password);
        registerPage.confirmSlaptazodis(password);
        registerPage.clickSukurti();
        Assertions.assertTrue(registerPage.isButtonSkaiciuotiDisplayed());
        log.info("'goToLoginPageTest' completed. Credentials: " + randomName + "/" + password + "/" + password);
    }

    @Test
    void userWrongRegistrationTest() {
        log.info("'userWrongRegistrationTest' initialized");
        loginPage.clickSukurtiNaujaPaskyra();
        String randomName = UtilsTest.getRandomName();
        registerPage.fillPrisijungimoVardas(randomName);
        registerPage.fillSlaptazodis(password);
        registerPage.confirmSlaptazodis(confirmPassword);
        registerPage.clickSukurti();
        Assertions.assertEquals("Įvesti slaptažodžiai nesutampa", registerPage.getErrorSlaptazodzioPatvirtinimasText(), "No error message");
        log.info("'userWrongRegistrationTest' completed. Credentials: " + randomName + "/" + password + "/" + confirmPassword);
    }
}


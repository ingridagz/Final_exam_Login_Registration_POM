package lt.techin.tests;

import lt.techin.pages.LoginPage;
import lt.techin.pages.RegisterPage;
import lt.techin.pages.UserPage;
import lt.techin.tests.BasePageTest;
import lt.techin.tests.utils.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class UserPageTest extends BasePageTest {

    protected static final Logger log = getLogger(lookup().lookupClass());
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected UserPage userPage;

    private final String password = "666666";

    @BeforeEach
    void setUpRegisterPage() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        userPage =new UserPage(driver);
    }

    @Test
    void logautTest() {
        log.info("'logautTest' initialized");
        loginPage.clickSukurtiNaujaPaskyra();
        String randomName = UtilsTest.getRandomName();
        registerPage.fillPrisijungimoVardas(randomName);
        registerPage.fillSlaptazodis(password);
        registerPage.confirmSlaptazodis(password);
        registerPage.clickSukurti();
        userPage.clickLogout(randomName);
        log.info("'logautTest' compleated");
    }
}



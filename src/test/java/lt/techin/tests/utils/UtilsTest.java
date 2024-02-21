package lt.techin.tests.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilsTest {
    public static String getRandomName() {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return RandomStringUtils.random(1, uppercase)
                + RandomStringUtils.random(6, lowercase);
    }

}

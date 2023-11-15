package tests;

import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.SplashScreen;
public class LoginTests extends AppiumConfig {

    @Test
    public void loginPositive() throws ClassNotFoundException {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("skrydj1984@mail.com")
                .fillPassword("Ll12345$")
                .submitLogin();
    }

}





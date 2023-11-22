



package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginPositive() {
        Assert.assertTrue(
                new SplashScreen(driver)
                        .gotoAuthenticationScreen()
                        .fillEmail("skrydj1984@mail.com")
                        .fillPassword("Ll12345$")
                        .submitLogin()
                        .isContactListActivityPresent()
        );
    }

    @Test
    public void loginPositiveModel() {
        Assert.assertTrue(
                new SplashScreen(driver)
                        .gotoAuthenticationScreen()
                        .login(
                                Auth.builder()
                                        .email("skrydj1984@mail.com")
                                        .password("Ll12345$")
                                        .build()
                        )
                        .isContactListActivityPresent()
        );
    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }

}
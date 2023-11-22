package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    int i;

    @BeforeMethod
    public void precondition() {
        i = new Random().nextInt(1000) + 1000;
    }


    @Test
    public void registrationPositive() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("skrydj" + i + "@mail.com")
                .fillPassword("Ll12345$")
                .submitRegistration()
                .assertContactListActivityPresent();
    }

    @Test
    public void registrationPositiveModel() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(
                        Auth.builder()
                                .email("skrydj" + i + "@mail.com")
                                .password("Ll12345$")
                                .build()
                )
                .isContactListActivityPresent();
    }

    @Test
    public void registrationWrongEmail(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("skrydj" + i + "mail.com")
                .fillPassword("Ll12345$")
                .submitRegistrationNegative()
                .isErrorMessageContainsText("email address");
    }

    @Test
    public void registrationWrongPassword() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registrationNegative(
                        Auth.builder()
                                .email("skrydj" + i + "@mail.com")
                                .password("Ll12345")
                                .build()
                )
//                .isErrorMessageContainsText("password");
                .isErrorMessageContainsTextInAlert("password");
    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }
}
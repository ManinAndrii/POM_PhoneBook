package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import static config.AppiumConfig.driver;
import static jdk.nashorn.internal.objects.NativeJava.type;

public class AuthenticationScreen extends BaseScreen{

        public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
            super(driver);
        }

        @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
        MobileElement editTextEmail;

        @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
        MobileElement editTextPassword;

        @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
        MobileElement registrationButton;

        @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
        MobileElement loginButton;

        public AuthenticationScreen fillEmail(String email) throws ClassNotFoundException {
            waitElement(editTextEmail, 5);
            type(editTextEmail, email);
            return this;
        }

    public AuthenticationScreen fillPassword(String password) throws ClassNotFoundException {
            waitElement(editTextPassword, 5);
            type(editTextPassword, password);
            return this;
        }

        public ContactListScreen submitLogin(){
            loginButton.click();
            pause(3000);
            return new ContactListScreen(driver);
        }
    }


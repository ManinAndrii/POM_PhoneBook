package tests;

import config.AppiumConfig;
import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    int i;

    @BeforeSuite
    public void precondition(){
        i = new Random().nextInt(1000) + 1000;
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("skrydj1984@mail.com")
                .fillPassword("Ll12345$")
                .submitLogin();
    }

    @Test
    public void addNewContactPositive(){
        Contact contact = Contact.builder()
                .name("Kolyan" + i)
                .lastName("Bo")
                .email("Kolayn" + i + "@mail.com")
                .phone("1234567" + i)
                .address("Ashkelon")
                .description("New" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAdded(contact);
    }
    @Test
    public void addNewContactNegativeEmptyName(){
        Contact contact = Contact.builder()
                //.name("Kolyan" + i)
                .lastName("Bo")
                .email("Kolayn" + i + "@mail.com")
                .phone("1234567" + i)
                .address("Ashkelon")
                .description("New" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAdded(contact);
    }
    @Test
    public void addNewContactNegativeEmptyPhone(){
        Contact contact = Contact.builder()
                .name("Kolyan" + i)
                .lastName("Bo")
                .email("Kolayn" + i + "@mail.com")
//                .phone("1234567" + i)
                .address("Ashkelon")
                .description("New" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageContainsTextInAlert("digits");
    }
}


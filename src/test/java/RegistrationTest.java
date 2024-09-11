import back_end_api.serialization.User;
import com.github.javafaker.Faker;
import front_end_pom.LoginPage;
import front_end_pom.RegisterPage;
import settings.SpecialSetUpBrowser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends SpecialSetUpBrowser {
    private String email;
    private String password;
    private String name;


    @Test
    @DisplayName("Positive registration test")
    @Description("Positive registration test - which consists of 7 characters")
    public void userRegistrationWithEnoughCharsTest () {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        name = faker.name().firstName();
        user = new User(email, password, name);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.sendKeysRequiredRegisterFields(user);
        registerPage.registerButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.signInButtonIsDisplayed());
    }

    @Test
    @DisplayName("Positive registration test")
    @Description("Positive registration test - which consists of 6 characters")
    public void userRegistrationWithMinCharsTest () {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        name = faker.name().firstName();
        user = new User(email, password, name);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.sendKeysRequiredRegisterFields(user);
        registerPage.registerButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.signInButtonIsDisplayed());
    }

    @Test
    @DisplayName("Negative registration test")
    @Description("Negative registration with wrong password - which consists of 5 characters")
    public void userRegistrationWithNotEnoughCharsTest() {
        user = new User("gosling55@gmail.ru", "12345", "Gosling");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.sendKeysRequiredRegisterFields(user);
        Assert.assertTrue(registerPage.wrongPasswordButtonIsDisplayed());
    }

}

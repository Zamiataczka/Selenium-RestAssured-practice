import frontendpom.LoginPage;
import frontendpom.MainPage;
import frontendpom.PassRecoPage;
import frontendpom.RegisterPage;
import settings.BrowserSetUp;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BrowserSetUp {
    @Test
    @DisplayName("Login tests")
    @Description("User login with click «Войти в аккаунт» on main page")
    public void userLoginSingInButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.loginAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        Assert.assertTrue(mainPage.orderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Login tests")
    @Description("User login with click «Личный кабинет» on main page")
    public void userLoginAccountButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.accountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        Assert.assertTrue(mainPage.orderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Login tests")
    @Description("User login with click «на кнопку в форме регистрации» on main page")
    public void userLoginRegisterButtonOnMainPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.signInButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.orderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Login tests")
    @Description("User login with click «кнопку в форме восстановления пароля» on main page")
    public void userLoginPassRecoButtonOnMainPage() {
        PassRecoPage passRecoPage = new PassRecoPage(driver);
        passRecoPage.openPassRecoPage();
        passRecoPage.signInButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.orderButtonIsDisplayed());
    }
}

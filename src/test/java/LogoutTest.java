import front_end_pom.LoginPage;
import front_end_pom.MainPage;
import front_end_pom.UserProfilePage;
import settings.BrowserSetUp;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LogoutTest extends BrowserSetUp {

    @Test
    @DisplayName("User logout test")
    @Description("Positive test of user logout from profile")
    public void userLogoutFromProfileTest () {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.loginAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        mainPage.accountButtonClick();
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.logoutButtonClick();
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}

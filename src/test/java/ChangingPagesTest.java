import front_end_pom.LoginPage;
import front_end_pom.MainPage;
import front_end_pom.UserProfilePage;
import settings.BrowserSetUp;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class ChangingPagesTest extends BrowserSetUp {
    @Test
    @DisplayName("Change page test")
    @Description("Change page «по клику на «Личный кабинет»")
    public void changePageMainToProfileTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.accountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }


    @Test
    @DisplayName("Change page test")
    @Description("Change page «из личного кабинета в конструктор»")
    public void changePageProfileToConstructorTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.accountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.constructorButtonClick();
        Assert.assertTrue(mainPage.setBurgerButtonIsDisplayed());
    }

    @Test
    @DisplayName("Change page test")
    @Description("Change page «по клику на «Конструктор» и на логотип Stellar Burgers»")
    public void changePageConstructorToLogoTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.accountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysRequiredLoginFields(user);
        loginPage.signInButtonClick();
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.logoButtonClick();
        Assert.assertTrue(mainPage.setBurgerButtonIsDisplayed());
    }
}

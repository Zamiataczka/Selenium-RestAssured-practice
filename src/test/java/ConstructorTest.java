import back_end_api.serialization.User;
import front_end_pom.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ConstructorTest {
    public WebDriver driver;
    public MainPage mainPage;
    public User user;

    @Before
    public void specialSetUp() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
    }

    private WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Test
    @DisplayName("Test of ingredients button in menu")
    @Description("Choose bun button")
    public void clickOnBunButtonTest () {
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.saucesButtonClick();
        mainPage.bunsButtonClick();
        Assert.assertEquals("Булки", mainPage.getTextRecipe());
    }

    @Test
    @DisplayName("Test of ingredients button in menu")
    @Description("Choose sauce button")
    public void clickOnSauceButtonTest () {
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.saucesButtonClick();
        Assert.assertEquals("Соусы", mainPage.getTextRecipe());
    }

    @Test
    @DisplayName("Test of ingredients button in menu")
    @Description("Choose filling button")
    public void clickOnFillingButtonTest () {
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.fillingButtonClick();
        Assert.assertEquals("Начинки", mainPage.getTextRecipe());
    }

    @After
    public void close() {
        driver.quit();
    }
}

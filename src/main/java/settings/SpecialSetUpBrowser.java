package settings;

import backendapi.alluresteps.UserSteps;
import backendapi.serialization.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constantsurl.Constants.REGISTER_PAGE_URL;

public class SpecialSetUpBrowser {
    public WebDriver driver;
    public User user;
    public UserSteps userSteps;
    String accessToken;

    @Before
    public void specialSetUp() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.get(REGISTER_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userSteps = new UserSteps();
    }

    @After
    public void close() {
        driver.quit();
        if (user != null) {
            ValidatableResponse responseLogin = userSteps.loginUser(user);
            accessToken = responseLogin.extract().path("accessToken");
            if (accessToken == null) {
                return;
            }
            userSteps.deleteAfterTest(accessToken);
        }
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
}

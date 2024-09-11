package settings;

import back_end_api.allure_steps.UserSteps;
import back_end_api.serialization.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constants_url.Constants.MAIN_URL;

public class BrowserSetUp {
    public WebDriver driver;
    public UserSteps userSteps;
    public User user;
    public String accessToken;


    @Before
    public void setUpDriver() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.get(MAIN_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user = new User("goslingR1452@gmail.ru", "123456", "Gosling");
        userSteps = new UserSteps();
        ValidatableResponse validatableResponse = userSteps.createUser(user);
        accessToken = userSteps.getAccessToken(validatableResponse);
    }

    @After
    public void close() {
        userSteps.deleteAfterTest(accessToken);
        driver.quit();
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

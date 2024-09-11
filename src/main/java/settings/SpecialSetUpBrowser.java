package settings;

import back_end_api.allure_steps.UserSteps;
import back_end_api.serialization.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constants_url.Constants.REGISTER_PAGE_URL;

public class SpecialSetUpBrowser {
    public WebDriver driver;
    public User user;
    String accessToken;

    @Before
    public void specialSetUp() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.get(REGISTER_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        UserSteps userSteps = new UserSteps();
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

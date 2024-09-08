package FrontEnd_POM;

import BackEnd_API.Serialization.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ConstantsURL.Constants.LOGIN_PAGE_URL;

public class LoginPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath(".//*[text()='Вход']");
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Login page open in browser")
    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step ("Click on registerButton")
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }

    @Step ("Click on signInButton")
    public void signInButtonClick() {
        driver.findElement(signInButton).click();
    }

    @Step ("Click on required fields and sendKeys data")
    public void sendKeysRequiredLoginFields(User user) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
    }

    @Step ("Make displayed loginButton")
    public boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step ("Make displayed signInButton")
    public boolean signInButtonIsDisplayed() {
        return driver.findElement(signInButton).isDisplayed();
    }
}


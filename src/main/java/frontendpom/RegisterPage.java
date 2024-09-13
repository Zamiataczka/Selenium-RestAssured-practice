package frontendpom;

import backendapi.serialization.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constantsurl.Constants.REGISTER_PAGE_URL;

public class RegisterPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    private final By wrongPasswordButton = By.xpath(".//*[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("RegisterPage open in browser")
    public void openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
    }

    @Step ("Click on registerButton")
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }

    @Step ("Click on signInButton")
    public void signInButtonClick() {
        driver.findElement(signInButton).click();
    }

    @Step ("Make sure wrongPasswordButton is displayed")
    public boolean wrongPasswordButtonIsDisplayed() {
       return driver.findElement(wrongPasswordButton).isDisplayed();
    }

    @Step ("Click on required fields and sendKeys data")
    public void sendKeysRequiredRegisterFields(User user) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(user.getName());
    }
}

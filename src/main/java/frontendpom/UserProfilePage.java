package frontendpom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage {
    private final WebDriver driver;
    private final By logoutButton = By.xpath(".//button[text() = 'Выход']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Click on logoutButton")
    public void logoutButtonClick() {
        driver.findElement(logoutButton).click();
    }

    @Step ("Click on constructorButton")
    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }

    @Step ("Click on logoButton")
    public void logoButtonClick() {
        driver.findElement(logoButton).click();
    }

}

package frontendpom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constantsurl.Constants.MAIN_URL;

public class MainPage {
    private final WebDriver driver;
    private final By currentMenuButton = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunsButton = By.xpath(".//span[contains(text(),'Булки')]");
    private final By saucesButton = By.xpath(".//span[contains(text(),'Соусы')]");
    private final By fillingButton = By.xpath(".//span[contains(text(),'Начинки')]");
    private final By setBurgerButton = By.xpath(".//*[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Main page open in browser")
    public void openMainPage() {
        driver.get(MAIN_URL);
    }

    @Step ("Click on signInButton")
    public void loginAccountButtonClick() {
        driver.findElement(loginAccountButton).click();
    }

    @Step ("Click on bunsButton")
    public void bunsButtonClick() {
        driver.findElement(bunsButton).click();
    }

    @Step ("Click on saucesButton")
    public void saucesButtonClick() {
        driver.findElement(saucesButton).click();
    }

    @Step ("Click on fillingButton")
    public void fillingButtonClick() {
        driver.findElement(fillingButton).click();
    }

    @Step ("Click on accountButton")
    public void accountButtonClick() {
        driver.findElement(accountButton).click();
    }

    @Step ("Make sure setBurgerButton is displayed")
    public boolean setBurgerButtonIsDisplayed() {
       return driver.findElement(setBurgerButton).isDisplayed();
    }

    @Step ("Make sure orderButton is displayed")
    public boolean orderButtonIsDisplayed() {
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step ("Get recipe text")
    public String getTextRecipe() {
      return driver.findElement(currentMenuButton).getText();
    }
}

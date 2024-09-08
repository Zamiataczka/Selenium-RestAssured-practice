package FrontEnd_POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ConstantsURL.Constants.RECO_PASS_URL;

public class PassRecoPage {
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public PassRecoPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("PassRecoPage open in browser")
    public void openPassRecoPage() {
        driver.get(RECO_PASS_URL);
    }

    @Step ("Click on signInButton")
    public void signInButtonClick() {
        driver.findElement(signInButton).click();
    }
}

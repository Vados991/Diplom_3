package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constant.Constants.RECOVERY_PASSWORD_URL;

public class RecoveryPasswordPage {
    private static final By enterButtonOnRecoverPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;
    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Open recovery page")
    public RecoveryPasswordPage openRecoveryPage() {
        driver.get(RECOVERY_PASSWORD_URL);
        return this;
    }

    @Step("Click on Вход button from recovery page")
    public LoginPage clickEnterButtonOnRecoveryPage() {
        driver.findElement(enterButtonOnRecoverPage).click();
        return new LoginPage(driver);
    }
}
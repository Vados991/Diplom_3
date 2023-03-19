package pageobject;
import io.qameta.allure.Step;
import org.example.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constant.Constants.REGISTER_PAGE_URL;

public class RegisterPage {
    private static final By registerName = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By registerEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By registerPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By enterButtonOnRegistrationPage = By.xpath(".//*[text()='Войти']"); //кнопка "войти" на форме регистрации
    public static By registerWrongPasswordMessageInRegisterPage = By.xpath(".//p[text()='Некорректный пароль']");
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public RegisterPage openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
        return this;
    }

    @Step("Ввести имя на странице регистрации")
    public RegisterPage enterRegisterName(String name) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(name);
        return this;
    }
    @Step("Ввести э-мейл на странице регистрации")
    public RegisterPage enterRegisterEmail(String email) {
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(email);
        return this;
    }

    @Step("Ввести пароль на странице регистрации")
    public RegisterPage enterRegisterPassword(String password) {
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку Зарегистрироваться")
    public LoginPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new LoginPage(driver);
    }

    @Step("Клик на кнопку Вход после регистрации")
    public LoginPage clickEnterButtonOnRegistrationPage() {
        driver.findElement(enterButtonOnRegistrationPage).click();
        return new LoginPage(driver);
    }

    @Step("Регистрация нового пользователя с новыми данными")
    public RegisterPage registerNewUser(User user) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(user.getName()); //ввести имя
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(user.getEmail()); //ввести e-mail
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(user.getPassword()); // ввести пароль
        return this;
    }
}
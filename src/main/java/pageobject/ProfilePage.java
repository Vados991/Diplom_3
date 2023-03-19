package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private static final By goToConstructor = By.xpath(".//p[text()='Конструктор']"); // переход на главную страницу
    private static final By logOutButton = By.xpath(".//button[text()='Выход']");
    private static final By burgerLogo = By.className("AppHeader_header__logo__2D0X2");;

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на кнопку Конструктор на странице профиля")
    public MainPage clickConstructorButton() {
        driver.findElement(goToConstructor).click();
        return new MainPage(driver);
    }

    @Step("Клик на логотип на странице профиля")
    public MainPage clickOnLogo() {
        driver.findElement(burgerLogo).click();
        return new MainPage(driver);
    }

    @Step("Клик на кнопку Выход на странице профиля")
    public LoginPage clickLogOutButton() {
        driver.findElement(logOutButton).click();
        return new LoginPage(driver);
    }
}
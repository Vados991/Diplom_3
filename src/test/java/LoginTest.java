import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.RecoveryPasswordPage;
import pageobject.RegisterPage;

public class LoginTest extends Preconditions {
    @Test
    @DisplayName("Проверка входа по кнопке Войти в аккаунт на главной странице")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromMainePageByEnterAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Проверка входа с помощью кнопки Личный Кабинет на главной странице")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromMainPageProfileButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Проверка входа по кнопке Вход на странице регистрации")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromRegistrationPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage()
                .clickEnterButtonOnRegistrationPage()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Проверка входа по кнопке Вход на странице восстановления")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromRecoveryPage() {
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
        recoveryPasswordPage.openRecoveryPage()
                .clickEnterButtonOnRecoveryPage()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }
}
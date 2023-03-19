import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;
import java.time.Duration;
import static constant.Constants.*;

public class TransitionToPersonalAccountTest extends Preconditions {
    @Test
    @DisplayName("Перейти в личный кабинет с главной страницы по кнопке Личный кабинет")
    @Description("Утверждение что  отображается страница профиля")
    public void transferToProfileByConstructorOnManePage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton()
                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonFromAuthorizedUser();
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.urlToBe(PROFILE_URL));
        Assert.assertEquals(PROFILE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы по кнопке Личный кабинет неавторизованным пользователем")
    @Description("Утверждение что страница входа отображается")
    public void clickOnProfileByUnauthorizedUserShowsLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        Assert.assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }
}
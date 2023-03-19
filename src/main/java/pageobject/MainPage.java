package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constant.Constants.BASE_URL;

public class MainPage {

    private static final By profileManeButton = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By menuBun = By.xpath(".//span[text()='Булки']");
    private static final By menuSauce = By.xpath(".//span[text()='Соусы']");
    private static final By menuFillings = By.xpath(".//span[text()='Начинки']");
    private static final By currentMenu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private static final By enterAccountButtonMain = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Open main page")
    public MainPage openMainPage() {
        driver.get(BASE_URL);
        return this;
    }
    @Step("Click on Войти в аккаунт button")
    public LoginPage clickAccountButton() {
        driver.findElement(enterAccountButtonMain).click();
        return new LoginPage(driver);
    }

    @Step("Click on Личный Кабинет button by unauthorized user")
    public LoginPage clickProfileButton() {
        driver.findElement(profileManeButton).click();
        return new LoginPage(driver);
    }

    @Step("Click on Личный Кабинет by authorized user")
    public ProfilePage clickProfileButtonFromAuthorizedUser() {
        driver.findElement(profileManeButton).click();
        return new ProfilePage(driver);
    }

    @Step("Check main page is open from authorized user")
    public boolean isManePageOpen() {
        return driver.findElement(makeOrderButton).isDisplayed();
    }

    @Step("Switch on Bun section")
    public MainPage clickMenuBun() {
        driver.findElement(menuBun).click();
        return this;
    }

    @Step("Switch on Sauce section")
    public MainPage clickMenuSauce() {
        driver.findElement(menuSauce).click();
        return this;
    }

    @Step("Switch on Fillings section")
    public MainPage clickMenuFillings() {
        driver.findElement(menuFillings).click();
        return this;
    }
    @Step("Check current section")
    public String getTextFromSelectedMenu() {
        return driver.findElement(currentMenu).getText();
    }

}
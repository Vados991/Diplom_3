import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;
import java.time.Duration;

public class SiteSectionsTest {
    WebDriver driver;
    private MainPage mainPage;
    @Before
    @Step("Предусловия для тестов")
    public void setUp() {
        System.setProperty("web-driver.http.factory", "jdk-http-client");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Утверждение что раздел соус активен")
    @Description("Сравнить название выбранного раздела")
    public void menuSauceIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Утверждение что раздел Булки активен")
    @Description("Сравнить название выбранного раздела")
    public void menuBunIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce()
                .clickMenuBun();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Утверждение что раздел Начинки активен")
    @Description("Сравнить название выбранного раздела")
    public void menuFillingsIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuFillings();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

    @After
    @Step("Закрыть браузер")
    public void tearDown() {
        driver.quit();
    }
}
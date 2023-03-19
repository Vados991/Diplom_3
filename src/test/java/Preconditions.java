import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.RequestCreateUser;
import org.example.User;
import org.example.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public abstract class Preconditions {
    User user;
    String accessToken;
    WebDriver driver;
    RequestCreateUser userClient;

    @Before
    @Step("Предусловия для тестов")
    public void setUp() {
        System.setProperty("web-driver.http.factory", "C:\\WebDriver\\bin\\chromedriver_win32\\chromedriver");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = UserGenerator.usersRandomCreate();
        userClient = new RequestCreateUser();
        ValidatableResponse responseCreateUser = userClient.createUser(user);
        accessToken = responseCreateUser.extract().path("accessToken").toString().substring(7);
    }

    @After
    @Step("Удаление тестового пользователя и закрыть браузер")
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}
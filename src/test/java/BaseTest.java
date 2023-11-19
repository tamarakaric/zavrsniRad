import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;


public class BaseTest {
    public static WebDriver driver;
    Faker faker = new Faker();

    @BeforeClass
    public static void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
    public String randomUsername(){
        return faker.name().username();
    }
    public String randomPassword(){
        return faker.name().name();
    }
    public String randomFirstName(){
        return faker.name().firstName();
    }
    public String randomLastName(){
        return faker.name().lastName();
    }
    public String randomZipCode(){
        return faker.address().zipCode();
    }
}

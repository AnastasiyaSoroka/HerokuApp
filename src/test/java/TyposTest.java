import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TyposTest {
    WebDriver driver;
    ReadUrlFileData url = new ReadUrlFileData();

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void checkTyposTextTest() {

        driver.get(url.returnURL("url_typos"));
        String result = driver.findElement(By.xpath("//p[2]")).getText();
        String expected = "Sometimes you'll see a typo, other times you won't";
        Assert.assertTrue(expected.equals(result), "Text has typos");
    }

    @AfterMethod
    public void tearDown() {
         driver.quit();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputTest {

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
    public void checkInputDifferentValuesKeysTest() {

        driver.get(url.returnURL("url_inputs"));
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("2");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "3","Number 3 is next to 2.");
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "2","Number 2 is before 3.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
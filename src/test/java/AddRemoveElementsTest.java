import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTest {

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
    public void checkElementsTest() {

        driver.get(url.returnURL("url_add_remove_elements"));

        WebElement btnAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        btnAdd.click();
        btnAdd.click();
        WebElement btnDelete = driver.findElement(By.xpath("//button[text()='Delete']"));
        btnDelete.click();
        int buttonCount = driver.findElements(By.tagName("button")).size();
        Assert.assertEquals(buttonCount, 2);


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
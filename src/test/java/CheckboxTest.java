import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxTest {

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
    public void checkCheckboxSelectionTest() {

        driver.get(url.returnURL("url_checkboxes"));
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        Assert.assertFalse(checkboxes.get(0).isSelected(),"Checkbox 1 should NOT be selected");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(),"Checkbox 1 should be selected");
        Assert.assertTrue(checkboxes.get(1).isSelected(),"Checkbox 2 should NOT be selected");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(),"Checkbox 2 should NOT be selected");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

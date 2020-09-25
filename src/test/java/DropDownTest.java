import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownTest {

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

        driver.get(url.returnURL("url_dropdown"));
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropDownOptions = dropDown.getOptions();
        boolean counterBoolean = false;

        if (dropDownOptions.size() != 0) {
            counterBoolean = true;
        }

        Assert.assertTrue(counterBoolean, "There should be some options in the dropdown");

        dropDown.selectByIndex(1);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 1", "Option 1 should be selected.");

        dropDown.selectByIndex(2);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 2", "Option 2 should be selected.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

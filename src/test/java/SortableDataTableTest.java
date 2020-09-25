import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableDataTableTest {
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
    public void checkLastNamesTest() {

        driver.get(url.returnURL("url_tables"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println(rows.size());
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 1; i <= rows.size(); i++) {

            String child_xpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[1]";
            WebElement child = driver.findElement(By.xpath(child_xpath));
            result.add(child.getText());
        }

        Collections.sort(result);

        Assert.assertEquals(result.get(0), "Bach", "First line should contain Bach value");
        Assert.assertEquals(result.get(1), "Conway", "First line should contain Conway value");
        Assert.assertEquals(result.get(2), "Doe", "First line should contain Doe value");
        Assert.assertEquals(result.get(3), "Smith", "First line should contain Smith value");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

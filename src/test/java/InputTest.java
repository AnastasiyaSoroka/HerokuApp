import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTest extends BaseTest {

    private String endpoint = "inputs";

    @Test
    public void checkInputDifferentValuesKeysTest() {

        driver.get(URL + endpoint);
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("2");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "3", "Number 3 is next to 2.");
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "2", "Number 2 is before 3.");
    }

}
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    private String endpoint = "dynamic_controls";
    private By checkbox = By.xpath("//*[@id='checkbox']/input");
    private By remove_button = By.xpath("//button[contains(text(),'Remove')]");
    private By message_checkbox = By.id("message");
    private By input = By.xpath("//* [@id='input-example']/input[@type='text']");
    private By enable_button = By.xpath("//button[contains(text(),'Enable')]");
    private By message_input = By.xpath("//* [@id='input-example']/*[@id='message']");

    @Test
    public void checkDifferentControls() {

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        driver.get(URL + endpoint);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
        driver.findElement(remove_button).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(message_checkbox));
        waiter.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        Assert.assertFalse(driver.findElement(input).isEnabled(), "Input is not disabled");
        driver.findElement(enable_button).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(message_input));
        Assert.assertTrue(driver.findElement(input).isEnabled(), "Input is not enabled");

    }

}

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    private String endpoint = "context_menu";
    private By element = By.id("hot-spot");

    @Test
    public void checkAlertText() {

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        driver.get(URL + endpoint);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(element)).perform();
        waiter.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Alert's text is not correct");
        alert.accept();
    }

}

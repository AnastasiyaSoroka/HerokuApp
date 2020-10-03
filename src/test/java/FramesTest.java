import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    private String endpoint = "frames";
    private By iframe_link = By.linkText("iFrame");
    private By iframe_element = By.id("mce_0_ifr");

    @Test
    public void checkFrames() {

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        driver.get(URL + endpoint);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(iframe_link));
        driver.findElement(iframe_link).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(iframe_element));
        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"Your content goes here.","Incorrect text returned");

    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    private String endpoint = "upload";
    private By choose_button = By.name("file");
    private By upload_button = By.id("file-submit");
    private By message = By.xpath("//*[text()='File Uploaded!']");
    private By file_name = By.id("uploaded-files");

    @Test
    public void checkUploadedNameFile() {

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        driver.get(URL + endpoint);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(choose_button));
        String filePath = System.getProperty("user.dir") + "/src/test/java/FileUploadTest.java";
        driver.findElement(By.name("file")).sendKeys(filePath);
        driver.findElement(upload_button).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(message));
        Assert.assertEquals(driver.findElement(file_name).getText(), "BaseTest.java", "File's name is incorrect");
    }

}

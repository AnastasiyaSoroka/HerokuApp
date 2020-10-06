import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownLoadTest extends BaseTest {

    private String endpoint = "download";
    private By header = By.xpath("//*[contains(text(),'Downloader')]");
    private By first_file = By.xpath("//*[text()='File Downloader']/../a[1]");

    @Test
    public void checkUploadedNameFile() {

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        driver.get(URL + endpoint);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(header));

        String fileName = driver.findElement(first_file).getText();
        driver.findElement(first_file).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        boolean isfound = false;
        File folder = new File(downloadPath);
        String[] files = folder.list();

        for (String file : files) {
            System.out.println("File: " + file);
            if (file.equals(fileName)) {
                isfound = true;
            }
        }
        Assert.assertTrue(isfound, "Downloaded document is not found");

    }

}

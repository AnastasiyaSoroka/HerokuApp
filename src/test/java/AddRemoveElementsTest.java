import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {

    private String endpoint = "add_remove_elements/";

    @Test
    public void checkElementsTest() {

        driver.get(URL + endpoint);

        WebElement btnAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        btnAdd.click();
        btnAdd.click();
        WebElement btnDelete = driver.findElement(By.xpath("//button[text()='Delete']"));
        btnDelete.click();
        int buttonCount = driver.findElements(By.tagName("button")).size();
        Assert.assertEquals(buttonCount, 2, "The number of elements should be 2. ");
    }

}
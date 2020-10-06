import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxTest extends BaseTest {

    private String endpoint = "checkboxes";

    @Test
    public void checkCheckboxSelectionTest() {

        driver.get(URL + endpoint);
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        Assert.assertFalse(checkboxes.get(0).isSelected(), "Checkbox 1 should NOT be selected");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox 1 should be selected");
        Assert.assertTrue(checkboxes.get(1).isSelected(), "Checkbox 2 should NOT be selected");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(), "Checkbox 2 should NOT be selected");
    }

}

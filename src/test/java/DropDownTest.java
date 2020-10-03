import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownTest extends BaseTest {

    private String endpoint = "dropdown";

    @Test
    public void checkCheckboxSelectionTest() {

        driver.get(URL + endpoint);
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

}

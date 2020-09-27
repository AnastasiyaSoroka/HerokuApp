import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class myPageElementSearchTest extends Settings {

    @Test
    public void checkElementsOnMyPage() {

        Path sampleFile = Paths.get("src/test/resources/myPage.html");
        driver.get(sampleFile.toUri().toString());

        driver.findElement(By.xpath("//p"));
        driver.findElement(By.id("myTable"));
        driver.findElement(By.name("selectedFirst"));

        Select dropDown = new Select(driver.findElement(By.id("genderOne")));
        List<WebElement> dropDownOptions = dropDown.getOptions();
        boolean counterBoolean = false;

        if (dropDownOptions.size() != 0) {
            counterBoolean = true;
        }
        Assert.assertTrue(counterBoolean, "dropdown should not be empty");
    }

}

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest {

    private String endpoint = "typos";

    @Test
    public void checkTyposTextTest() {

        driver.get(URL + endpoint);
        String result = driver.findElement(By.xpath("//p[2]")).getText();
        String expected = "Sometimes you'll see a typo, other times you won't";
        Assert.assertTrue(expected.equals(result), "Text has typos");
    }
}

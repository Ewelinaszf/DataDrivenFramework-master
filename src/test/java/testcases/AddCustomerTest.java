package testcases;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utilities.TestUtil;

import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider="dp")
    public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

        if(!data.get("runmode").equals("Y")) {
            throw new SkipException(("Skipping the test case as the Run mode for test"));
        }
        click("addCustomerButton_CSS");
        type("firstName_CSS", data.get("firstname"));
        type("lastName_CSS", data.get("lastname"));
        type("postalCode_CSS", data.get("postcode"));
        click("addButton_CSS");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
        alert.accept();
        Thread.sleep(2000);
    }

}

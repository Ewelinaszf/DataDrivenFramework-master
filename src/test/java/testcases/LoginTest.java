package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsBankManager() {

        log.info("Inside Login Test");
        driver.findElement(By.cssSelector((OR.getProperty("bankManagerLoginButton")))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomerButton", "Login not successful"))));
        log.info("Login successfully executed");

        Assert.fail("Login not successfull");
    }
}

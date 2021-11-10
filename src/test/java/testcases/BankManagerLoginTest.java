package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws IOException, InterruptedException {

        verifyEquals("abc", "xyz");
        Thread.sleep(3000);
        log.info("Inside Login Test");
        driver.findElement(By.cssSelector((OR.getProperty("bankManagerLoginButton_CSS")))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomerButton_CSS", "Login not successful"))));
        log.info("Login successfully executed");

     // Assert.fail("Login not successfull");
    }
}


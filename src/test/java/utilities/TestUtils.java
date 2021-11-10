package utilities;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils extends TestBase {
    public static String screenshotName;
    public static String screenshotName2;

    public static void captureScreenshot() throws IOException {
        screenshotName2 = new SimpleDateFormat("yyyy-MM-dd,hh-mm-ss").format(new Date())+".jpg";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName2));
    }
}

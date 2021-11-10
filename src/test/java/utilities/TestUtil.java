package utilities;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;

public class TestUtil extends TestBase {
    public static String screenshotName;

    public static void captureScreenshot() throws IOException {
        screenshotName = new SimpleDateFormat("yyyy-MM-dd,hh-mm-ss").format(new Date()) + ".jpg";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
    }

    @DataProvider(name = "dp")
    public Object[][] getData(Method m) {

        String sheetName = m.getName();
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][1];

        Hashtable<String,String> table = null;
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new Hashtable<String, String>();
            for (int colNum = 0; colNum < cols; colNum++) {
                table.put(excel.getCellData(sheetName,colNum,1), excel.getCellData(sheetName,colNum,rowNum));
                data[rowNum - 2][0] = table;
            }
        }

        return data;
    }


    public static boolean isTestRunnable(String testName, ExcelReader excel) {
        String sheetName = "test_suite";
        int rows = excel.getRowCount(sheetName);
        for (int rNum = 2; rNum < rows; rNum++) {
            String testCase =
                    excel.getCellData(sheetName, "TCID", rNum);
            if (testCase.equalsIgnoreCase(testName)) {
                String runmode = excel.getCellData(sheetName, "Runmode", rNum);
                if (runmode.equalsIgnoreCase("Y")) {
                    return true;
                } else return false;

            }
        }
        return false;
    }

}

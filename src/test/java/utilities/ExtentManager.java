package utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    protected static final String filePath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\extent.html";
    protected static final String reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\ReportsConfig.xml";
    private static boolean replaceExisting = true;
    protected static final DisplayOrder displayOrder = DisplayOrder.NEWEST_FIRST;

    public static ExtentReports getInstance() {

        if (extent == null) {
            extent = new ExtentReports(filePath, replaceExisting, displayOrder);
            extent.loadConfig(new File(reportPath));
        }
        return extent;
    }
}

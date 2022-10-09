package com.amazon.tests;

import com.amazon.utils.DriverManager;
import com.amazon.utils.PropertyManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest implements ITestListener {

    WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getInstance().getDriver();
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        System.out.println(System.getProperty("user.dir"));
        htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/reports/Reports_" + dateName + ".html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "local");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("user", "Nirmith");
    }

    public void navigateToAmazonPage() throws IOException {
        driver.navigate().to(PropertyManager.getValue("AmazonURL"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        extent.flush();
    }


}

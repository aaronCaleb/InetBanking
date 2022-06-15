package inetbanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentManager {
        public static ExtentSparkReporter sparkReporter;
        public static ExtentReports extent;
        public static ExtentTest test;

        public static void setExtent() throws IOException {
            //Reporter object - Spark and Klov Reporters are open source| Others such as Avent
            // and Email Reporters are pro versions
            //Path must be initialised wth the reporter.
            sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+
                    "/test-output/ExtentReport/"+"Report.html");
            sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

            //Create Object for Extent Report -Main Engine that drives Extent Reporting
            extent = new ExtentReports();

            //The choice of reporter that needs to be attached
            extent.attachReporter(sparkReporter);


            extent.createTest("ScreenCapture")
                    .addScreenCaptureFromPath("extent.png")
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

            extent.createTest("LogLevels")
                    .info("info")
                    .pass("pass")
                    .warning("warn")
                    .skip("skip")
                    .fail("fail");

            extent.createTest("ParentWithChild")
                    .createNode("Child")
                    .pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");

            extent.createTest("Authors")
                    .assignAuthor("TheAuthor")
                    .pass("This test 'Authors' was assigned by a special kind of author tag.");

            extent.createTest("Tags")
                    .assignCategory("MyTag")
                    .pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");

            extent.createTest("Devices")
                    .assignDevice("TheDevice")
                    .pass("This test 'Devices' was assigned by a special kind of devices tag.");

            extent.createTest("Exception! <i class='fa fa-frown-o'></i>")
                    .fail(new RuntimeException("A runtime exception occurred!"));

            extent.setSystemInfo("HostName", "MyHost");
            extent.setSystemInfo("ProjectName", "inetbanking");
            extent.setSystemInfo("Tester", "Nireekshan");
            extent.setSystemInfo("OS", "Win10");
            extent.setSystemInfo("Browser", "Chrome");
        }
        public static void endReport() throws IOException {
            extent.flush();
            //To automatically open the generated HTML file
            Desktop.getDesktop().browse(new File("Report.html").toURI());
        }
}



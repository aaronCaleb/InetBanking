package inetbanking.base;

import inetbanking.utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties properties;
    public static InputStream inputStream;

    //Declare ThreadLocal Driver
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    //Load Configuration properties
    @BeforeSuite(groups = {"Smoke","Sanity","Regression"})
    public RemoteWebDriver loadConfig() throws IOException {
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        try {
            properties = new Properties();
            inputStream = new FileInputStream(
                    System.getProperty("user.dir") + "\\com.inetbanking.configurations\\config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static WebDriver getDriver() {
        //Get Driver from threadLocalMap
        return driver.get();
    }

    public void launchBrowser(String browserName){
        //String browserName = property.getProperty("browser");
        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            //Set browser to ThreadLocalMap
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            //Set browser to ThreadLocalMap
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            //Set browser to ThreadLocalMap
            driver.set(new EdgeDriver());
        }

            //Maximise the browser screen
            getDriver().manage().window().maximize();
            //Delete All cookies
            getDriver().manage().deleteAllCookies();
            //Implicit TimeOuts
            getDriver().manage().timeouts().implicitlyWait(
                    Integer.parseInt(properties.getProperty("implicitWait")), TimeUnit.SECONDS);
            //PageLoad TimeOuts
            getDriver().manage().timeouts().pageLoadTimeout(
                    Integer.parseInt(properties.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
            //Launch the browser
            getDriver().get(properties.getProperty("url"));

    }
    @AfterSuite(groups = {"Smoke", "Sanity", "Regression"})
    public void afterSuite() throws IOException {
        ExtentManager.endReport();
    }
}

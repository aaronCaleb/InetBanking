package testcases;

import inetbanking.base.BaseClass;
import inetbanking.pageobjects.AddNewCustomer;
import inetbanking.pageobjects.HomePage;
import inetbanking.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        driver.get(getValue("url"));
        driver.manage().window().maximize();
        /**
         * Login to Demo Site
         */
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(getValue("userID"),getValue("pswd"));
        AddNewCustomer addNewCustomer = homePage.newcustomer();
        addNewCustomer.addNewCustomer("Nireekshan","m","22061981","22 Burchelli Way", "Wyndham Vale","Victoria","375454","0416500278","nireekshan8@gmail.com","Ilovemymom23#");

        if(driver.getTitle().equals("Guru99 Bank Manager Home Page")){
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(false);
        }


    }



    }


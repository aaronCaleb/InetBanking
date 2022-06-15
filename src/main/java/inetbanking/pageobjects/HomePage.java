package inetbanking.pageobjects;

import inetbanking.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    WebDriver ldriver;
    public HomePage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(linkText = "New Customer")
    WebElement newcustomer;

    public AddNewCustomer newcustomer(){
        newcustomer.click();
        return new AddNewCustomer(ldriver);
    }



    }


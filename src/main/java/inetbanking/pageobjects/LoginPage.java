package inetbanking.pageobjects;

import inetbanking.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage extends BaseClass {
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(name = "uid")
    WebElement txtUserName;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    private void setTxtUserName(String uname){
        /**
         * what is txtUserName is not accesable
         */
        // wait till the txtUserName is loaded

        txtUserName.sendKeys(uname);
    }

    private void setTxtPassword(String pwd){

        txtPassword.sendKeys(pwd);
    }

    private void clickSubmit(){

        btnLogin.click();
    }

    public HomePage login(String user, String pwd){
        setTxtUserName(user);
        setTxtPassword(pwd);
        clickSubmit();
        return new HomePage(ldriver);
    }

}



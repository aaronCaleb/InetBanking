package inetbanking.pageobjects;

import inetbanking.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer extends BaseClass {
        WebDriver ldriver;
        public AddNewCustomer(WebDriver rdriver){
            ldriver=rdriver;
            PageFactory.initElements(rdriver,this);
        }

    /**
     * LOCATORS
     */
    @FindBy(name = "name")
    WebElement txtCustomerName;

    @FindBy(xpath = "//td/input[@value='m']")
    WebElement radGender_male;

    @FindBy(xpath = "//td/input[@value='f']")
    WebElement radGender_female;

    @FindBy(id = "dob")
    WebElement dob;

    @FindBy(name = "addr")
    WebElement txtAddress;

    @FindBy(name = "city")
    WebElement txtCity;

    @FindBy(name = "state")
    WebElement txtState;

    @FindBy(name = "pinno")
    WebElement txtPin;

    @FindBy(name = "telephoneno")
    WebElement txtMobile;

    @FindBy(name = "emailid")
    WebElement txtEmail;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "sub")
    WebElement submitElement;
    /**
     * REUSABLE FNS
     * @param cName
     * @param gender
     * @param doB
     * @param address
     */

    /** Initalisation (Constructor)
     * */

    /**public void EnterNewCustomerData(){
        PageFactory.initElements(ldriver,this);
    }**/
    private void setTxtCustomerName(String cname) {
        txtCustomerName.sendKeys(cname);
    }
    private void setRadGender(String gdr){ // pass m or f from the data
//        if(gdr.contains("male"))
//           radGender_male.click();
//        else
//            radGender_female.click();

        ldriver.findElement(By.xpath("//td/input[@value='"+gdr+"']")).click();
    }
    private void setDob(String doB){
        dob.sendKeys(doB);
    }
    private void setTxtAddress(String add){
        txtAddress.sendKeys(add);
    }
    private void setTxtCity(String cty) {
        txtCity.sendKeys(cty);
    }
    private void setTxtState(String sta){
        txtState.sendKeys(sta);
    }
    private void setTxtPin(String pn){
        txtPin.sendKeys(pn);
    }
    private void setTxtMobile(String mble){
        txtMobile.sendKeys(mble);
    }
    private void setTxtEmail(String eml){
        txtEmail.sendKeys(eml);
    }
    private void setTxtPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }
    private void clickSubmit (){
        submitElement.click();
    }

    public void addNewCustomer(String customerName, String gender, String dob, String address, String city, String state, String pin, String mobile, String email, String password){
        setTxtCustomerName(customerName);
        setRadGender(gender);
        setDob(dob);
        setTxtAddress(address);
        setTxtCity(city);
        setTxtState(state);
        setTxtMobile(mobile);
        setTxtPin(pin);
        setTxtEmail(email);
        setTxtPassword(password);
        clickSubmit();

        // vslidsate the bame is Nireekshan
       // return new AddNewCustomer(ldriver);
        }


    }


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;

public class ManageUsersClass {
	WebDriver driver;

	public ManageUsersClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement manageusers;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']")
	WebElement mainsearch;
	@FindBy(xpath = "//input[@name ='un']")
	WebElement uname;
	@FindBy(xpath = "//select[@name ='ut']")
	WebElement usertype;
	@FindBy(xpath = "//button[@class ='btn btn-block-sm btn-danger']")
	WebElement search;
	@FindBy(xpath = "//table//tr/td[1]") 
    WebElement searchResultTitle;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']")
	WebElement newuser;
	@FindBy(xpath = "//input[@name ='username']")
	WebElement newusername;
	@FindBy(xpath = "//input[@id ='password']")
	WebElement newpassword;
	@FindBy(xpath = "//select[@name ='user_type']")
	WebElement newusertype;
	@FindBy(xpath = "//button[@name ='Create']")
	WebElement submit;
	@FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']")
	WebElement alert;
	public void clickManageUsersLink() {
		manageusers.click();
	}
	public void clickMainSearchButton() {
		mainsearch.click();
	}

	public void enterUserName(String username) {
		uname.sendKeys(username);
	}
	public void selectUserTypeByValue(String user_type) {
		PageUtilities.selectOptionByValue(usertype,user_type);
	}
	public void clickSearchButton() {
		search.click();
	}
	public boolean isUserInSearchResults(String userName) {
        return searchResultTitle.getText().contains(userName);
    }
	public void clickNewUserButton() {
		newuser.click();
	}
	public void enterNewUserName(String new_username) {
		newusername.sendKeys(new_username);
	}
	public void enterNewUserPassword(String new_pwd) {
		newpassword.sendKeys(new_pwd);
	}
	public void selectNewUserTypeByValue(String new_user_type) {
		PageUtilities.selectOptionByValue(newusertype,new_user_type);
	}
	public void submitNewUser() {
		submit.click();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

	public String getAlertMessage() {
		return alert.getText();
	}

	

}

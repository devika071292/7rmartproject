package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {

	WebDriver driver;

	public LoginClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name ='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name ='password']")
	WebElement pwd;
	@FindBy(xpath = "//button[@type ='submit']")
	WebElement submit;
	@FindBy(xpath = "//p[text() ='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class ='alert alert-danger alert-dismissible']")
	WebElement alert;

	public void enterUsername(String username) {
		uname.sendKeys(username);
	}

	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}

	public void submit() {
		submit.click();
	}

	public boolean verifyDashBoard()

	{

		return dashboard.isDisplayed();

	}

	public boolean isAlertDisplayed()

	{
	
		return alert.isDisplayed();

	}
	public String getAlertMessage() {
        return alert.getText();
    }

}

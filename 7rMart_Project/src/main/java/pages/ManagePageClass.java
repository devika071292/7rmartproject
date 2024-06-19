package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileuploadUtility;
import utilities.WaitUtility;

public class ManagePageClass {
	WebDriver driver;

	public ManagePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-page')]")
	WebElement managepages;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']")
	WebElement mainsearch;
	@FindBy(xpath = "//input[@name ='un']")
	WebElement titlename;
	@FindBy(xpath = "//button[@class ='btn btn-danger btn-fix']")
	WebElement search;
	@FindBy(xpath = "//table//tr/td[1]")
	WebElement searchResultTitle;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']")
	WebElement newpage;
	@FindBy(xpath = "//input[@name ='title']")
	WebElement newtitlename;
	@FindBy(xpath = "//input[@id ='main_img']")
	WebElement imgupload;
	@FindBy(xpath = "//input[@id ='page']")
	WebElement page;
	@FindBy(xpath = "//button[@class ='btn btn-danger']")
	WebElement submit;
	@FindBy(xpath = "//div[@name ='alert alert-success alert-dismissible']")
	WebElement alert;

	public void clickManagePagesLink() {
		managepages.click();
	}

	public void clickMainSearchButton() {
		mainsearch.click();
	}

	public void enterTitle(String Titlename) {
		titlename.sendKeys(Titlename);
	}

	public void clickSearchButton() {
		search.click();
	}

	public boolean isTitleInSearchResults(String title_name) {
		return searchResultTitle.getText().contains(title_name);
	}

	public void clickAddNewPageButton() {
		newpage.click();
	}

	public void enterNewTitle(String NewTitlename) {
		newtitlename.sendKeys(NewTitlename);
	}

	public void uploadImage(String loc) {
		FileuploadUtility.fileUploadSendKey(imgupload, loc);
	}

	public void enterPageName(String NewPagename) {
		page.sendKeys(NewPagename);
	}

	public void submitPage() {
		WaitUtility.waitForElementVisiblity(driver, submit);
	    submit.click();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

	public String getAlertMessage() {
		return alert.getText();
	}

}

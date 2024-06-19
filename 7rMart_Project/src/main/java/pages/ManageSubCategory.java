package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileuploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class ManageSubCategory {

	WebDriver driver;

	public ManageSubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")
	WebElement managesubcategory;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']")
	WebElement mainsearch;
	@FindBy(xpath = "//select[@id ='un']")
	WebElement category;
	@FindBy(xpath = "//input[@name ='ut']")
	WebElement subcategname;
	@FindBy(xpath = "//button[@class ='btn btn-danger btn-fix']")
	WebElement search;
	@FindBy(xpath = "//table//tr/td[1]")
	WebElement searchResultTitle;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']")
	WebElement newsubcategory;
	@FindBy(xpath = "//select[@name ='cat_id']")
	WebElement newcategory;
	@FindBy(xpath = "//input[@id ='subcategory']")
	WebElement subcategoryname;
	@FindBy(xpath = "//input[@id ='main_img']")
	WebElement imgupload;
	@FindBy(xpath = "//button[text() ='Save']")
	WebElement submit;
	@FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']")
	WebElement alert;

	public void clickManageSubCategoryLink() {
		managesubcategory.click();
	}

	public void clickMainSearchButton() {
		mainsearch.click();
	}
	public void selectCategoryByName(String categoryname) {
		PageUtilities.selectOptionByText(category,categoryname);
	}
	public void enterSearchSubCategory(String subcategoryname) {
		subcategname.sendKeys(subcategoryname);
	}

	public void clickSearchButton() {
		search.click();
	}

	public boolean isSubCategoryInSearchResults(String categname) {
		return searchResultTitle.getText().contains(categname);
	}

	public void clickNewSubCategoryButton() {
		newsubcategory.click();
	}
	public void selectNewCategoryByName(String newcategoryname) {
		PageUtilities.selectOptionByText(newcategory,newcategoryname);
	}

	public void enterNewSubCategory(String newsubcategoryname) {
		subcategoryname.sendKeys(newsubcategoryname);
	}

	public void uploadImage(String loc) {
		FileuploadUtility.fileUploadSendKey(imgupload, loc);
	}
	public void submitSubCategory() {
		PageUtilities.scrollIntoView(driver, submit);
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


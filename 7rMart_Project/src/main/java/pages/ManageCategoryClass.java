package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileuploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class ManageCategoryClass {
	WebDriver driver;

	public ManageCategoryClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')]")
	WebElement managecategory;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']")
	WebElement mainsearch;
	@FindBy(xpath = "//input[@name ='un']")
	WebElement categname;
	@FindBy(xpath = "//button[@class ='btn btn-danger btn-fix']")
	WebElement search;
	@FindBy(xpath = "//table//tr/td[1]")
	WebElement searchResultTitle;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']")
	WebElement newcategory;
	@FindBy(xpath = "//input[@id ='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id ='134-selectable']")
	WebElement selectable;
	@FindBy(xpath = "//li[@id ='134-selection']")
	WebElement selection;
	@FindBy(xpath = "//input[@id ='main_img']")
	WebElement imgupload;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement showontop;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	WebElement showonleft;
	@FindBy(xpath = "//button[@class ='btn btn-danger']")
	WebElement submit;
	@FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']")
	WebElement alert;

	public void clickManageCategoryLink() {
		managecategory.click();
	}

	public void clickMainSearchButton() {
		mainsearch.click();
	}

	public void enterSearchCategoryName(String categoryname) {
		categname.sendKeys(categoryname);
	}

	public void clickSearchButton() {
		search.click();
	}

	public boolean isCategoryInSearchResults(String categname) {
		return searchResultTitle.getText().contains(categname);
	}

	public void clickNewCategoryButton() {
		newcategory.click();
	}

	public void enterNewCategoryName(String newcategoryname) {
		category.sendKeys(newcategoryname);
	}

	public void selectCategoryGroup() {
		PageUtilities.doubleClickToMoveSelection(driver, selectable);
	}

	public void uploadImage(String loc) {
		FileuploadUtility.fileUploadSendKey(imgupload, loc);
	}

	public void selectShowOnTopOption() {
		PageUtilities.scrollIntoView(driver, showontop);
		WaitUtility.waitForElementVisiblity(driver, showontop);
		showontop.click();

	}

	public boolean isShowOnTopOptionSelected() {
	    return showontop.isSelected();
	}


	public void selectShowOnLeftOption() {
		PageUtilities.scrollIntoView(driver, showonleft);
		WaitUtility.waitForElementVisiblity(driver, showonleft);
		
		showonleft.click();

	}

	public boolean isShowOnLeftOptionSelected() {
		return showonleft.isSelected();
	}

	public void submitCategoryForm() {
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

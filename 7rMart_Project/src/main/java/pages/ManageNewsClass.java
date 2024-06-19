package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsClass {
	WebDriver driver;

	public ManageNewsClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')]")
	WebElement managenews;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']")
	WebElement mainsearch;
	@FindBy(xpath = "//input[@name ='un']")
	WebElement news;
	@FindBy(xpath = "//button[@class ='btn btn-danger btn-fix']")
	WebElement search;
	@FindBy(xpath = "//table//tr/td[1]")
	WebElement searchResultNews;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']")
	WebElement newnews;
	@FindBy(xpath = "//textarea[@id ='news']")
	WebElement newnewsname;
	@FindBy(xpath = "//button[@class ='btn btn-danger']")
	WebElement submit;
	@FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']")
	WebElement alert;

	public void clickManageNewsLink() {
		managenews.click();
	}

	public void clickMainSearchButton() {
		mainsearch.click();
	}

	public void enterNewsName(String News) {
		news.sendKeys(News);
	}

	public void clickSearchButton() {
		search.click();
	}

	public boolean isNewsInSearchResults(String news_name) {
		return searchResultNews.getText().contains(news_name);
	}

	public void clickAddNewNewsButton() {
		newnews.click();
	}

	public void enterNewNewsName(String NewNewsname) {
		newnewsname.sendKeys(NewNewsname);
	}

	public void submitNewNews() {
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

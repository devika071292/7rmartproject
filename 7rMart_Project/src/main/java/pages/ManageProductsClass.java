package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsClass {
	WebDriver driver;

	public ManageProductsClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	WebElement manageproduct;
	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']")
	WebElement mainsearch;
	@FindBy(xpath = "//input[@name ='un']")
	WebElement title;
	@FindBy(xpath = "//button[@class ='btn btn-danger btn-fix']")
	WebElement search;
	@FindBy(xpath = "//table//tr/td[1]") 
    WebElement searchResultTitle;
	public void clickManageProductLink() {
		manageproduct.click();
	}
	public void clickMainSearchButton() {
		mainsearch.click();
	}

	public void enterProductName(String pdtname) {
		title.sendKeys(pdtname);
	}

	

	public void clickSearchButton() {
		search.click();
	}
	public boolean isProductInSearchResults(String productName) {
        return searchResultTitle.getText().contains(productName);
    }

	
}

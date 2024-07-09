package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
//import pages.LoginClass;
import pages.ManagePageClass;
import utilities.ExcelUtility;

public class ManagePageTest extends BaseClass {
	@Test(description = "To verify whether user able to search alredy existing pages")
	public void verifyTheUserAbleToSearchPages() throws IOException {

		/*
		 * String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage"); String
		 * pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		 */
		String title_name = ExcelUtility.getStringData(1, 0, "PageSearch");
		/*LoginClass loginclass = new LoginClass(driver);
		
		 * loginclass.enterUsername(usernamevalue); loginclass.enterPassword(pwdvalue);
		 * loginclass.submit();
		 */
		ManagePageClass managepageclass = new ManagePageClass(driver);
		managepageclass.clickManagePagesLink();
		managepageclass.clickMainSearchButton();
		managepageclass.enterTitle(title_name);
		managepageclass.clickSearchButton();
		boolean isTitleFound = managepageclass.isTitleInSearchResults(title_name);
		assertTrue(isTitleFound, Constants.ERRORMESSAGEFORPAGE);

	}

	@Test(description = "To verify whether user able to add new pages")
	public void verifyTheUserAbleToAddNewPages() throws IOException {

		/*
		 * String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage"); String
		 * pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		 */
		String new_title_name =ExcelUtility.getStringData(1, 0, "AddNewPage");
		String new_page_name =ExcelUtility.getStringData(1, 1, "AddNewPage");
		String location = ExcelUtility.getStringData(1, 2, "AddNewPage");
		/*
		 * LoginClass loginclass = new LoginClass(driver);
		 * loginclass.enterUsername(usernamevalue); loginclass.enterPassword(pwdvalue);
		 * loginclass.submit();
		 */
		ManagePageClass managepageclass = new ManagePageClass(driver);
		managepageclass.clickManagePagesLink();
		managepageclass.clickAddNewPageButton();
		managepageclass.enterNewTitle(new_title_name);
		managepageclass.uploadImage(location);
		managepageclass.enterPageName(new_page_name);
		managepageclass.submitPage();
		boolean isAlertDisplayed = managepageclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = managepageclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		}
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORALERT);
	}
}

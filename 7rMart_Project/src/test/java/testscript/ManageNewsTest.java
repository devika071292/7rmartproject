package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageNewsClass;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass {
	@DataProvider(name = "Credentials")
	public Object[][] testData() {
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;
	}

	@Test(dataProvider = "Credentials", description = "To verify User is able to search already existing news")
	public void verifyTheUserAbleToSearchNews(String usernamevalue, String pwdvalue) throws IOException {

		String news = ExcelUtility.getStringData(1, 0, "NewsSearch");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageNewsClass managenewsclass = new ManageNewsClass(driver);
		managenewsclass.clickManageNewsLink();
		managenewsclass.clickMainSearchButton();
		managenewsclass.enterNewsName(news);
		managenewsclass.clickSearchButton();
		boolean isTitleFound = managenewsclass.isNewsInSearchResults(news);
		assertTrue(isTitleFound, Constants.ERRORMESSAGEFORNEWS);

	}

	@Test(description = "To verify whether user able to add new news")
	public void verifyTheUserAbleToAddNewNews() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String new_news = ExcelUtility.getStringData(1, 0, "AddNewNews");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageNewsClass managenewsclass = new ManageNewsClass(driver);
		managenewsclass.clickManageNewsLink();
		managenewsclass.clickAddNewNewsButton();
		managenewsclass.enterNewNewsName(new_news);
		managenewsclass.submitNewNews();
		boolean isAlertDisplayed = managenewsclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = managenewsclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		}

		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORALERT);
	}
}

package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageUsersClass;
import utilities.ExcelUtility;

public class ManageUsersTest extends BaseClass {

	@Test(description = "To verify whether user able to search alredy existing users")
	public void verifyTheUserAbleToSearchUsers() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String username = ExcelUtility.getStringData(1, 0, "UserSearch");
		String usertype = ExcelUtility.getStringData(1, 1, "UserSearch");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageUsersClass manageusersclass = new ManageUsersClass(driver);
		manageusersclass.clickManageUsersLink();
		manageusersclass.clickMainSearchButton();
		manageusersclass.enterUserName(username);
		manageusersclass.selectUserTypeByValue(usertype);
		manageusersclass.clickSearchButton();
		boolean isUserFound = manageusersclass.isUserInSearchResults(username);
		assertTrue(isUserFound, Constants.ERRORMESSAGEFORUSER);

	}

	@Test(description = "To verify whether user able to add new users")
	public void verifyTheUserAbleToAddNewUsers() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String username = ExcelUtility.getStringData(1, 0, "AddNewUser");
		String pwd = ExcelUtility.getStringData(1, 1, "AddNewUser");
		String usertype =ExcelUtility.getStringData(1, 2, "AddNewUser");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageUsersClass manageusersclass = new ManageUsersClass(driver);
		manageusersclass.clickManageUsersLink();
		manageusersclass.clickNewUserButton();
		manageusersclass.enterNewUserName(username);
		manageusersclass.enterNewUserPassword(pwd);
		manageusersclass.selectNewUserTypeByValue(usertype);
		manageusersclass.submitNewUser();
		boolean isAlertDisplayed = manageusersclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = manageusersclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		}

		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORNEWUSER);
	}

}

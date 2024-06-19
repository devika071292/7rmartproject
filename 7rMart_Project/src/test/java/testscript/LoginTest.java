package testscript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	
	@Test(groups = {"smoke"},description = "To verify whether user able to login with valid Credentials")
	@Parameters("browser")
	public void verifyTheUserAbleToLoginValidCredentials() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(name);
		loginclass.enterPassword(password);
		loginclass.submit();
		boolean ishomepageloaded = loginclass.verifyDashBoard();
		assertTrue(ishomepageloaded, Constants.ERRORMESSAGEFORHOMEPAGE);

	}

	@Test(description = "To verify whether user able to login with invalid username and valid password")
	public void verifyTheUserAbleToLoginInvalidUsernameValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		boolean isAlertDisplayed = loginclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = loginclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		} 
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORALERT);

	}

	@Test(description = "To verify whether user able to login with valid username and invalid password")
	public void verifyTheUserAbleToLoginValidUsernameInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		boolean isAlertDisplayed = loginclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = loginclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		} 
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORALERT);

	}

	@Test(retryAnalyzer = retry.Retry.class,description = "To verify whether user able to login with invalid username and invalid password")
	@Parameters({"username", "password"})
	public void VerifyTheUserAbleToLoginInvalidUsernameInvalidPassword(String uname,String pwd) throws IOException {
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(uname);
		loginclass.enterPassword(pwd);
		loginclass.submit();
		boolean isAlertDisplayed = loginclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = loginclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		} 
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORALERT);

	}
}

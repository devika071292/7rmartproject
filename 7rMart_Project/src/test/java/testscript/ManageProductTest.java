package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageProductsClass;
import utilities.ExcelUtility;

public class ManageProductTest extends BaseClass {

	@Test(description = "To verify whether user able to search alredy existing products")
	public void verifyTheUserAbleToSearchProducts() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String productname = ExcelUtility.getStringData(1, 0, "Product");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageProductsClass manageproductclass = new ManageProductsClass(driver);
		manageproductclass.clickManageProductLink();
		manageproductclass.clickMainSearchButton();
		manageproductclass.enterProductName(productname);
		manageproductclass.clickSearchButton();
		boolean isProductFound = manageproductclass.isProductInSearchResults(productname);
		assertTrue(isProductFound, Constants.ERRORMESSAGEFORPRODUCT);
	   
	}
}

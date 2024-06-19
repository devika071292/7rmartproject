package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageSubCategory;
import utilities.ExcelUtility;

public class ManageSubCategoryTest extends BaseClass {
	@Test(description = "To verify whether user able to search alredy existing subcategory")
	public void VerifyTheUserAbleToSearchSubCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String categoryname = ExcelUtility.getStringData(1, 0, "SubCategorySearch");
		String subcategoryname = ExcelUtility.getStringData(1, 1, "SubCategorySearch");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageSubCategory managesubcategoryclass = new ManageSubCategory(driver);
		managesubcategoryclass.clickManageSubCategoryLink();
		managesubcategoryclass.clickMainSearchButton();
		managesubcategoryclass.selectCategoryByName(categoryname);
		managesubcategoryclass.enterSearchSubCategory(subcategoryname);
		managesubcategoryclass.clickSearchButton();
		boolean isSubCategoryFound = managesubcategoryclass.isSubCategoryInSearchResults(subcategoryname);
		assertTrue(isSubCategoryFound, Constants.ERRORMESSAGEFORSUBCATEGORY);

	}
	@Test(description = "To verify whether user able to add new sub category")
	public void VerifyTheUserAbleToAddNewSubCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String newcategoryname = ExcelUtility.getStringData(1, 0, "AddNewSubCategory");
		String newsubcategoryname = ExcelUtility.getStringData(1, 1, "AddNewSubCategory");
		String Location = ExcelUtility.getStringData(1, 2, "AddNewSubCategory");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageSubCategory managesubcategoryclass = new ManageSubCategory(driver);
		managesubcategoryclass.clickManageSubCategoryLink();
		managesubcategoryclass.clickNewSubCategoryButton();
		managesubcategoryclass.selectNewCategoryByName(newcategoryname);
		managesubcategoryclass.enterNewSubCategory(newsubcategoryname);		
		managesubcategoryclass.uploadImage(Location);
		managesubcategoryclass.submitSubCategory();
		boolean isAlertDisplayed = managesubcategoryclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = managesubcategoryclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		}
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORNEWCATAGORY);
	}

}


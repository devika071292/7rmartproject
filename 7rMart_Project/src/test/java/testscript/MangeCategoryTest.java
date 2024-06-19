package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageCategoryClass;
import utilities.ExcelUtility;

public class MangeCategoryTest extends BaseClass {

	@Test(description = "To verify whether user able to search alredy existing category")
	public void VerifyTheUserAbleToSearchCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String categoryname = ExcelUtility.getStringData(1, 0, "CategorySearch");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageCategoryClass managecategoryclass = new ManageCategoryClass(driver);
		managecategoryclass.clickManageCategoryLink();
		managecategoryclass.clickMainSearchButton();
		managecategoryclass.enterSearchCategoryName(categoryname);
		managecategoryclass.clickSearchButton();
		boolean isCategoryFound = managecategoryclass.isCategoryInSearchResults(categoryname);
		assertTrue(isCategoryFound, Constants.ERRORMESSAGEFORCATEGORY);

	}

	@Test(description = "To verify whether user able to add new category")
	public void VerifyTheUserAbleToAddNewCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pwdvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String newcategoryname = ExcelUtility.getStringData(1, 0, "AddNewCategory");
		String Location = ExcelUtility.getStringData(1, 1, "AddNewCategory");
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUsername(usernamevalue);
		loginclass.enterPassword(pwdvalue);
		loginclass.submit();
		ManageCategoryClass managecategoryclass = new ManageCategoryClass(driver);
		managecategoryclass.clickManageCategoryLink();
		managecategoryclass.clickNewCategoryButton();
		managecategoryclass.enterNewCategoryName(newcategoryname);
		managecategoryclass.selectCategoryGroup();
		managecategoryclass.uploadImage(Location);
		managecategoryclass.selectShowOnTopOption();
		managecategoryclass.isShowOnTopOptionSelected();
		managecategoryclass.selectShowOnLeftOption();
		managecategoryclass.isShowOnLeftOptionSelected();
		managecategoryclass.submitCategoryForm();
		boolean isAlertDisplayed = managecategoryclass.isAlertDisplayed();
		if (isAlertDisplayed) {
			String alertMessage = managecategoryclass.getAlertMessage();
			System.out.println("Alert message: " + alertMessage);
		}
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORNEWCATAGORY);
	}

}

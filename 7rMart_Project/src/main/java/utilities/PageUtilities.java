package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public static void selectOptionByValue(WebElement element,String selectvalue)
	{
		Select select = new Select(element);
		select.selectByValue(selectvalue);
	}
	public static void selectOptionByText(WebElement selectElement, String selectText) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(selectText);
    }
	public static void doubleClickToMoveSelection(WebDriver driver,WebElement selectable)
	{
		Actions action = new Actions(driver);
        action.doubleClick(selectable).perform();
	}
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		
	}
    public void clickByJS(WebDriver driver, WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;  
    	js.executeScript("arguments[0].click();",element);
    }
    public void switchToWindow(WebDriver driver, String windowHandle) {
        driver.switchTo().window(windowHandle);
    }
}

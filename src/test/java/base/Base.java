package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	WebDriver driver;
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	//This method helps for wait for element
	public void waitForElement(By locator) {
		WebDriverWait wait=(WebDriverWait)driver;
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	//This function helps for GetElement Text
	public String getElementText(By locator) {
		waitForElement(locator);
		return driver.findElement(locator).getText();
	}
	//This function help for Click Element
	public void clickElement(By locator) {
		waitForElement(locator);
		driver.findElement(locator).click();
	}
	
	//This method helps for Enter text
	public void enterText(By locator,String input) {
		waitForElement(locator);
		driver.findElement(locator).sendKeys(input);
	}
}

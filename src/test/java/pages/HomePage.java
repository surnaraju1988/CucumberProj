package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class HomePage extends Base{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By ele_From=By.id("fromCity");
	By ele_To=By.id("toCity");
	By txt_From = By.xpath("//*[@placeholder='From']");
	By txt_To = By.xpath("//*[@placeholder='To']");
	By lnk_Search = By.linkText("Search");

	public void enterSourceAndDistination(String from, String to,String date) {
		//Select source
		clickElement(ele_From);
		enterText(txt_From, from);
		clickElement(By.xpath("//*[contains(text(),'"+from+"')]"));
		
		
		//select destination
		clickElement(ele_To);
		enterText(txt_To, to);
		clickElement(By.xpath("//*[contains(text(),'"+to+"')]"));
		
		//Select date
		clickElement(By.xpath("//*[contains(text(),'"+date+"')]"));
		
		//Select search
		clickElement(lnk_Search);
	}
}

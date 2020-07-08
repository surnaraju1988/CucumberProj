package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class BookingPage extends Base{

	WebDriver driver;

	public BookingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public By btn_Continue = By.xpath("//*[text()='Continue']");
	public By radio_No = By.xpath("//*[text()='No, I do not wish to secure my trip']");
	public By ele_FlightSummary = By.xpath("//*[text()='Flight Summary']");
}

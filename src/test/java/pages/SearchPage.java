package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class SearchPage extends Base{

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By ele_Duration=By.xpath("//*[text()='Duration']");
	By btn_ViewFair=By.xpath("//*[text()='View Fares']");
	public By btn_BookNow=By.xpath("//*[text()=' Book Now ']");
	By ele_TravelTime=By.xpath("//*[@class='fli-duration']");
	By ele_Price=By.xpath("//*[@class='actual-price']");
	
	
	public void chepestFacttestFlight() {
		//Filter based on duration
		clickElement(ele_Duration);
		waitForElement(ele_TravelTime);
		String price = driver.findElement(ele_Price).getText().replace(",", "");
		int intPrice=Integer.parseInt(price);
		
		//Get Travel time
		String travelTime = driver.findElement(ele_TravelTime).getText();
		String hours=travelTime.split(" ")[0];
		String mins=travelTime.split(" ")[2];
		int intHours=Integer.parseInt(hours);
		int intmins=Integer.parseInt(mins);
		int intDuration=intHours+intmins;
		
		//Get the cheapest and fastest flight
		List<WebElement> list_TravelTimes =driver.findElements(ele_TravelTime);
		List<WebElement> list_Prices =driver.findElements(ele_Price);
		int index=0;
		for (int i=0;i<list_TravelTimes.size();i++) {
			String duration =list_TravelTimes.get(i).getText();
			String cost =list_Prices.get(i).getText().replace(",", "");
			int intCost=Integer.parseInt(cost);
			
			String hrs=duration.split(" ")[0];
			String min=duration.split(" ")[2];
			int intHrs=Integer.parseInt(hrs);
			int intMin=Integer.parseInt(min);
			int intD=intHrs+intMin;
			
			if(intDuration<intD &&intPrice<intCost) {
				index=i+1;
			}
		}
		//Select flight
		clickElement(By.xpath("(//*[text()='View Fares'])["+index+"]"));
				
	}
}

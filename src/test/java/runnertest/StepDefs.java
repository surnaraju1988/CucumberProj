package runnertest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;
import pages.HomePage;
import pages.SearchPage;

public class StepDefs {

	WebDriver driver;

	@Given("^launch browser \"([^\"]*)\" and navigate \"([^\"]*)\"$")
	public void launch_browser_something_and_navigate_something(String browser, String url) throws Throwable {
		System.out.println("Launch browser");
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecho.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
	}

	@When("Search fastest and chepest flight")
	public void search_fastest_and_chepest_flight() {
		System.out.println("Search fastest and chepest flight");
		SearchPage searchPage = new SearchPage(driver);
		searchPage.chepestFacttestFlight();
	}

	@Then("^Book the flight$")
	public void book_the_flight() throws Throwable {
		System.out.println("Book a flight");
		String parentWindow = driver.getWindowHandle();
		String childWindow=null;
		SearchPage searchPage = new SearchPage(driver);
		searchPage.clickElement(searchPage.btn_BookNow);
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if(!window.equals(parentWindow)) {
				childWindow=window;
			}
		}
		driver.switchTo().window(childWindow);
		BookingPage bookingPage=new BookingPage(driver);
		bookingPage.clickElement(bookingPage.radio_No);
		bookingPage.clickElement(bookingPage.btn_Continue);		
		Assert.assertEquals("Flight Summary", bookingPage.getElementText(bookingPage.ele_FlightSummary));
	}

	@And("^Enter source \"([^\"]*)\" and distination \"([^\"]*)\"$")
	public void enter_source_something_and_distination_something(String strArg1, String strArg2) throws Throwable {
		System.out.println("Enter source and distination");
		HomePage homePage = new HomePage(driver);
		homePage.enterSourceAndDistination("Mumbai", "Delhi", "20");
	}

}
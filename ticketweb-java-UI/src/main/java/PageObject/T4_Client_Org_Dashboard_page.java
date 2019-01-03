package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tools.DateTimeManager;
import Tools.MyDriver;
import Tools.PropertiesManager;

public class T4_Client_Org_Dashboard_page {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"j_idt22\"]")
	@CacheLookup
	WebElement TopHome;

	@FindBy(xpath = "//*[@id=\"j_idt28\"]")
	@CacheLookup
	WebElement TopEvents;
	
	@FindBy(xpath = "//*[@id=\"j_idt34\"]")
	@CacheLookup
	WebElement TopAttractions;
	
	@FindBy(xpath = "//*[@id=\"j_idt40\"]")
	@CacheLookup
	WebElement TopMarketing;
	
	@FindBy(xpath = "//*[@id=\"j_idt46\"]")
	@CacheLookup
	WebElement TopItems;
	
	@FindBy(xpath = "//*[@id=\"j_idt52\"]")
	@CacheLookup
	WebElement TopReports;
	
	@FindBy(xpath = "//*[@id=\"j_idt60\"]")
	@CacheLookup
	WebElement TopCustomer;
	
	@FindBy(xpath = "//*[@id=\"j_idt66\"]")
	@CacheLookup
	WebElement TopSetup;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/ul/li[7]/a")
	@CacheLookup
	WebElement TopBoxOffice;
	
	@FindBy(id = "signOutId")
	@CacheLookup
	WebElement SignOut;
	
	@FindBy(id = "signoutForm:btn-signout")
	@CacheLookup
	WebElement SignOutConfirm;
	
	
//	public enum TopName {
//	    Home(0,"Home"),Events,Attractions,Marketing,Items, Reports, BoxOffice,Customer,Setup
//	}

	public T4_Client_Org_Dashboard_page(WebDriver driver) {
		this.driver = driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("T4_Client_Org_Dashboard_page load fail");
			e.printStackTrace();
		}
	}
	
	public void T4_Client_Org_Dashboard_default_page(WebDriver driver) {
		this.driver = driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("T4_Client_Org_Dashboard_page load fail");
			e.printStackTrace();
		}
		this.driver.get(PropertiesManager.GetValueByKey("T4_org_dashboard_Url"));
	}
	public void ClickSingOut() {
		DateTimeManager.WaitSecond(2);
		SignOut.click();
		SignOutConfirm.click();
		DateTimeManager.WaitSecond(2);
		
	}

	public Object AccessTop(String TopName) {
		
		if ("Home".equals(TopName)) {
			TopHome.click();
			return new T4_Client_Org_Dashboard_page(driver);
		}
		else if ("Events".equals(TopName)) {
			TopEvents.click();
			return new T4_Event_list_page(driver);
		}
		else if ("Attractions".equals(TopName)) {
			TopAttractions.click();
//			return new T4_Event_list_page(driver);
		}
		else if ("Marketing".equals(TopName)) {
			TopMarketing.click();
//			return new T4_Event_list_page(driver);
		}
		else if ("Items".equals(TopName)) {
			TopItems.click();
//			return new T4_Event_list_page(driver);
		}
		else if ("Reports".equals(TopName)) {
			TopReports.click();
//			return new T4_Event_list_page(driver);
		}
		else if ("BoxOffice".equals(TopName)) {
			TopBoxOffice.click();
//			return new T4_Event_list_page(driver);
		}
		else if ("Customer".equals(TopName)) {
			TopCustomer.click();
//			return new T4_Event_list_page(driver);
		}
		else if ("Setup".equals(TopName)) {
			TopSetup.click();
//			return new T4_Event_list_page(driver);
		}
		else 
			System.out.println("access Top Name is incorrect , TopName is "+ TopName);
			return null;

	}

	// ticketweb version

	public static void main(String[] args) {
		WebDriver driver = MyDriver.MyChromeDriver();
		T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
		T4_Client_Org_Dashboard_page od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
//		od.AccessTop("event");
//		od.AccessTop("Home");
//		od.AccessTop("Attractions");
//		od.AccessTop("Marketing");
//		od.AccessTop("Items");
//		od.AccessTop("Reports");
//		od.AccessTop("BoxOffice");
//		od.AccessTop("Customer");
//		od.AccessTop("Setup");
//		od.T4_Client_Org_Dashboard_default_page(driver);
		
		od.ClickSingOut();

	}

}

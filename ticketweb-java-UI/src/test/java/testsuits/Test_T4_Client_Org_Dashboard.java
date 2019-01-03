package testsuits;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.T4_Client_Org_Dashboard_page;
import PageObject.T4_login_page;
import Tools.DateTimeManager;
import Tools.MyDriver;
import Tools.PropertiesManager;

public class Test_T4_Client_Org_Dashboard {
	
	public static Logger log = Logger.getLogger(Test_T4_Client_Org_Dashboard.class.getName());
	private WebDriver driver;
	private T4_Client_Org_Dashboard_page od;

	@BeforeClass
	public void beforeClass() {
		driver = MyDriver.MyChromeDriver();
		T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
		this.od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
		log.info(" ================ Test_T4_Client_Org_Dashboard init ================ ");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		DateTimeManager.WaitSecond(2);
	}
	
	@Test
	public void VerifyTopHome() {
		od.AccessTop("Home");
		log.info(" ================ VerifyTopHome ================ ");
	}
	@Test
	public void VerifyTopEvents() {
		od.AccessTop("Events");
		log.info(" ================ VerifyTopEvents ================ ");
	}
	@Test
	public void VerifyTopAttractions() {
		od.AccessTop("Attractions");
		log.info(" ================ VerifyTopAttractions ================ ");
	}
	@Test
	public void VerifyTopMarketing() {
		od.AccessTop("Marketing");
		log.info(" ================ VerifyTopMarketing ================ ");
	}
	@Test
	public void VerifyTopItems() {
		od.AccessTop("Items");
		log.info(" ================ VerifyTopItems ================ ");
	}
	@Test
	public void VerifyTopReports() {
		od.AccessTop("Reports");
		log.info(" ================ VerifyTopReports ================ ");
	}
//	@Test
//	public void VerifyTopBoxOffice() {
//		od.AccessTop("BoxOffice");
//	}
	@Test
	public void VerifyTopCustomer() {
		od.AccessTop("Customer");
		log.info(" ================ VerifyTopCustomer ================ ");
	}
	@Test
	public void VerifyTopSetup() {
		od.AccessTop("Setup");
//		System.out.println("od.AccessTop(\"Setup\");");
		log.info(" ================ VerifyTopSetup ================ ");
	}
	
	@AfterMethod
	public void afterMethod() {
		od.T4_Client_Org_Dashboard_default_page(driver);
		DateTimeManager.WaitSecond(2);
	}
	@AfterClass
	public void afterClass() {
		driver.close();
		log.info(" ================ Test_T4_Client_Org_Dashboard over ================ ");
	}
}

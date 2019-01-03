package testsuits;

import org.testng.annotations.Test;

import PageObject.T4_event_create_page;
import PageObject.T4_login_page;
import Tools.MyDriver;
import Tools.PropertiesManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class Test_T4_Create_Event {

	public static Logger log = Logger.getLogger(Test_T4_Create_Event.class.getName());
	private WebDriver driver;
	private T4_event_create_page cp;

	@BeforeClass
	public void beforeClass() {
		driver = MyDriver.MyChromeDriver();
		T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
		log.info(" ================ Test_T4 login ================ ");
	}

	@BeforeMethod
	public void beforeMethod() {
		cp = PageFactory.initElements(driver, T4_event_create_page.class);
		log.info(" ================ T4_event_create_page init ================ ");
	}

	@Test
	public void Verify_Simple_Event() {
		cp.inputBasicEventInformation();
		log.info(" ================ Verify_Simple_Event ================ ");
		/*
		 * WebDriver driver = MyDriver.MyChromeDriver();
			T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
			lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
			T4_event_create_page cp = PageFactory.initElements(driver, T4_event_create_page.class);
			cp.inputBasicEventInformation();
		 */
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		log.info(" ================ Test_T4_Create_Event over ================ ");
	}

}

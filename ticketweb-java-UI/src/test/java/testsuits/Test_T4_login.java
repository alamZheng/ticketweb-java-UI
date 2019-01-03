package testsuits;

import org.testng.annotations.Test;

import PageObject.T4_Client_Org_Dashboard_page;
import PageObject.T4_login_page;
import Tools.MyDriver;
import Tools.PropertiesManager;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.apache.log4j.Logger;

public class Test_T4_login {
	
	public static Logger log = Logger.getLogger(Test_T4_login.class.getName());
	private WebDriver driver;
	private T4_login_page lg;

	@BeforeClass
	public void beforeClass() {
		driver = MyDriver.MyChromeDriver();
		log.info(" ================ open chrome ================ ");
	}
	@BeforeMethod
	public void beforeMethod() {
		lg = PageFactory.initElements(driver, T4_login_page.class);
		log.info(" ================ init T4_login_page.class ================ ");
	}
    
	@Test
	public void Login_MasterUser() {
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
		T4_Client_Org_Dashboard_page od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
		assertEquals(lg.getWarnContentText(), lg.getWarnContentText());
		od.ClickSingOut();
//		BasicConfigurator.configure();
		log.info(" ================ Login_MasterUser ================ ");
	}
	
	@Test
	public void Login_BasicUser() {
		lg.loginFor("alamBasic@ticketweb.com", PropertiesManager.GetValueByKey("T4_login_PWD"));
		T4_Client_Org_Dashboard_page od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
		assertEquals(lg.getWarnContentText(), lg.getWarnContentText());
		od.ClickSingOut();
		log.info(" ================ Login_BasicUser ================ ");
	}
	
	@Test
	public void Login_ClientHighUser() {
		lg.loginFor("alamH@ticketweb.com", PropertiesManager.GetValueByKey("T4_login_PWD"));
		T4_Client_Org_Dashboard_page od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
		assertEquals(lg.getWarnContentText(), lg.getWarnContentText());
		od.ClickSingOut();
		log.info(" ================ Login_ClientHighUser ================ ");
	}
	
	@Test
	public void Login_incorrect_PWD() {
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), "222222");
		assertEquals(lg.getWarnContentText(), "Login or password incorrect!");
		log.info(" ================ Login_incorrect_PWD ================ ");
	}
	
	@Test
	public void Login_incorrect_UserName() {
		lg.loginFor("alamNone@ticketweb.com", PropertiesManager.GetValueByKey("T4_login_PWD"));
		assertEquals(lg.getWarnContentText(), "Login or password incorrect!");
		log.info(" ================ Login_incorrect_UserName ================ ");
	}

	@AfterClass
	public void afteClass() {
		driver.close();
		log.info(" ================ Login_driver.close(); ================ ");
	}

}

package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tools.MyDriver;
import Tools.PropertiesManager;

public class T4_Event_list_page {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"j_idt114:basic\"]")
	@CacheLookup
	WebElement CreateEventBtn;
	
	public T4_Event_list_page(WebDriver driver) {
		this.driver =driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public T4_event_create_page ClickCreateEventBtn() {

		CreateEventBtn.click();
		return new T4_event_create_page(driver);
	}

	public static void main(String[] args) {
		WebDriver driver = MyDriver.MyChromeDriver();
		T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
		T4_Client_Org_Dashboard_page od = PageFactory.initElements(driver, T4_Client_Org_Dashboard_page.class);
		od.AccessTop("event");
		T4_Event_list_page ep = PageFactory.initElements(driver, T4_Event_list_page.class);
		ep.ClickCreateEventBtn();
	}

}

package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Tools.MyDriver;
import Tools.PropertiesManager;


public class T4_login_page {

	WebDriver driver;

	@FindBy(how = How.ID, using = "userName")
	@CacheLookup
	WebElement userName;

	@FindBy(how = How.ID, using = "password")
	@CacheLookup
	WebElement passWord;

	@FindBy(how = How.ID, using = "signIn")
	@CacheLookup
	WebElement signIn;
	
	@FindBy(xpath = "//*[@id=\"errors:msgs_list\"]/li/div")
	@CacheLookup
	WebElement warnContentText;

	public T4_login_page(WebDriver driver) {
//		this.driver = new MyDriver();
		driver.get(PropertiesManager.GetValueByKey("T4_login_Url"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("T4_login_page load fail");
			e.printStackTrace();
		}
	}

	public T4_Client_Org_Dashboard_page loginFor(String username, String password) {
		userName.clear();
		userName.sendKeys(username);
		passWord.clear();
		passWord.sendKeys(password);
		signIn.click();
//		System.out.println(driver.getCurrentUrl());
		return new T4_Client_Org_Dashboard_page(driver);

	}
	
	public String getWarnContentText() {

		String warnText;
		try {
			warnText = warnContentText.getText();
		} catch (Exception e) {
			// TODO: handle exception
			warnText = null;
		}
		return warnText;
		
	}

	//ticketweb version
	public T4_Client_Org_Dashboard_page login(String userName, String password) {
		for (int i = 0; i < 3; i++) {
			try {
				if (this.userName.isDisplayed()) {
					this.userName.clear();
					this.userName.sendKeys(userName);
					this.passWord.clear();
					this.passWord.sendKeys(password);
					this.signIn.click();
//                  WindowUtil.waitPageLoaded();
//                  WaitTimeUtil.waitTimeInSeconds(5);
				} else {
					System.out.println("this.userName.isDisplayed()="+this.userName.isDisplayed());
					break;
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println(e.getMessage());
				break;
			}
		}
		return new T4_Client_Org_Dashboard_page(driver);
	}

	public static void main(String[] args) {
		WebDriver driver = MyDriver.MyChromeDriver();
//		driver.get(Tools.GetValueByKey("T4_login_Url"));
		T4_login_page lg = PageFactory.initElements(driver, T4_login_page.class);
//		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), PropertiesManager.GetValueByKey("T4_login_PWD"));
//		System.out.println(lg.getWarnContentText());
		
//		/*test getWarnContentText()
		lg.loginFor(PropertiesManager.GetValueByKey("T4_login_name"), "22222");
		System.out.println(lg.getWarnContentText());
//		*/
		driver.close();

	}

}

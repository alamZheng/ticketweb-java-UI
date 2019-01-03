package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver = null;

//    @Autowired
//    public Header header;

    public BasePage(WebDriver driver) {

//        BrowserDriver.getCurrentDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PageFactory.initElements(driver, this);
    }

    public void loadSite(String URL) {
    	this.driver.get(URL);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("loadSite fail");
			e.printStackTrace();
		}
//        WindowUtil.waitPageLoaded();
    }

}

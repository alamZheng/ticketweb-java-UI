package Tools;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
	static WebDriver driver = null;
	public static WebDriver MyChromeDriver() {
    	System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkspace\\zhengAlam\\Lib\\chromedriver.exe");
    	driver = new ChromeDriver();
    	return driver;
	}
    
    public static WebDriver MyCustomerDriver(String driverName) {
    	if("chrome".equals(driverName)) {
    		System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkspace\\zhengAlam\\Lib\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
		return driver;
	}
    
    public static void main(String [] args) throws IOException{
        WebDriver myDriver = MyDriver.MyChromeDriver();
        myDriver.get("http://www.baidu.com");

    }


}

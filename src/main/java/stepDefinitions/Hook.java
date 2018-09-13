package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil {

	private BaseUtil base;

	public Hook(BaseUtil base) {
		this.base = base;
	}
	
	
	@Before
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		base.Driver = new ChromeDriver();
	}

	@After
	public void tearDownTest() {
		base.Driver.quit();
	}
	
}

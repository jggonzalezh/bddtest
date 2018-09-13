package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OutComePage {

	@FindBy(name = "fechas")
	public WebElement inputFechaSalida;

	@FindBy(how = How.CLASS_NAME, className = "btn")
	public WebElement buttonSalida;

	public OutComePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void fillDateTimeInput(String date, String time) {

		inputFechaSalida.sendKeys(date);
		inputFechaSalida.sendKeys(Keys.TAB);
		inputFechaSalida.sendKeys(time);

		waitforaFew(3000);
	}

	public void btnClick() {
		buttonSalida.click();
	}

	public void waitforaFew(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

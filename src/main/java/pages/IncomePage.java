package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IncomePage {

	@FindBy(name = "fecha")
	public WebElement inputFechaIngreso;

	@FindBy(how = How.NAME, using = "placa")
	public WebElement inputPlaca;

	@FindBy(how = How.NAME, using = "tipo")
	public WebElement inputTipoVehiculo;

	@FindBy(how = How.NAME, using = "cilindraje")
	public WebElement inputCilindraje;

	@FindBy(how = How.CLASS_NAME, className = "btn")
	public WebElement buttonIngresar;

	public IncomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void fillDateTimeInput(String date, String time) {

		inputFechaIngreso.sendKeys(date);
		inputFechaIngreso.sendKeys(Keys.TAB);
		inputFechaIngreso.sendKeys(time);

		waitforaFew(3000);
	}

	public void fillVehicleInputs(String placa, String tipo, String cilindraje) {

		inputPlaca.sendKeys(placa);
		waitforaFew(3000);
		inputTipoVehiculo.sendKeys(tipo);
		waitforaFew(3000);
		inputCilindraje.sendKeys(cilindraje);
		waitforaFew(3000);
	}

	public void btnClick() {
		buttonIngresar.click();
	}

	public void waitforaFew(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

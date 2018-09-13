package stepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.IncomePage;
import pages.OutComePage;

public class RegisterSteps extends BaseUtil {

	private BaseUtil base = new BaseUtil();
	

	public RegisterSteps(BaseUtil base) {
		this.base=base;
	}
	

	@Given("the parking attendant is on the  Income page")
	public void attendantOnIncomePage() {

		base.Driver.get("http://localhost:4200/registroparqueo/registroentrada");

	}

	@When("the parking attendant register the Income info")
	public void attendantRegisterIncomeInfo() {

		IncomePage page = new IncomePage(base.Driver);

		page.fillDateTimeInput("09092013", "0245PM");
		page.fillVehicleInputs("BCH321", "MOTO", "600");
		page.btnClick();

	}

	@Then("the parking attendant should see a Success message")
	public void attendantSeeSuccessMessage() {

		waitforaFew(5000);

		String msj = base.Driver.findElement(By.xpath("html/body")).getText();
		assertTrue(msj.contains("Registro Entrada Exitoso"));

		waitforaFew(3000);

	}

	@Given("the parking attendant is on the  outcome page")
	public void attendantOnOutcomePage() {
		base.Driver.get("http://localhost:4200/registroparqueo/registrosalida/HZJ505");
	}

	@When("the parking attendant register the outcome info")
	public void attendantRegisterOutcomeInfo() {

		OutComePage oPage = new OutComePage(base.Driver);
		
		oPage.fillDateTimeInput("14082018","0245PM");
	
		waitforaFew(3000);
		
		oPage.btnClick();
	}

	@Then("the parking attendant should see an exit Success message")
	public void attendantSeeExitSuccessMessage() {

		waitforaFew(5000);

		String msj = base.Driver.findElement(By.xpath("html/body")).getText();
		assertTrue(msj.contains("Registro Salida"));

		waitforaFew(3000);

	}

	@Given("the parking attendant is on the  list page")
	public void attendantOnListcomePage() {
		base.Driver.get("http://localhost:4200/registroparqueo");
	}

	@Then("the parking attendant should see an List")
	public void attendantSeeList() {

		waitforaFew(5000);

		String msj = base.Driver.findElement(By.xpath("html/body")).getText();
		assertTrue(msj.contains("Vehiculos Actualmente en el Parqueadero"));

		waitforaFew(3000);

	}

	public void waitforaFew(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
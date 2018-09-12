package stepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterSteps {

	WebDriver webDriver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		webDriver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	@Given("the parking attendant is on the  Income page")
	public void attendantOnIncomePage() {
		webDriver.get("http://localhost:4200/registroparqueo/registroentrada");
	}

	@When("the parking attendant register the Income info")
	public void attendantRegisterIncomeInfo() {
		
		WebElement dateBox = webDriver.findElement(By.name("fecha"));
		dateBox.sendKeys("09092013");
		dateBox.sendKeys(Keys.TAB);
		dateBox.sendKeys("0245PM");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.findElement(By.name("placa")).sendKeys("BCH321");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.findElement(By.name("tipo")).sendKeys("MOTO");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.findElement(By.name("cilindraje")).sendKeys("600");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.findElement(By.className("btn")).click();
	}

	@Then("the parking attendant should see a Success message")
	public void attendantSeeSuccessMessage() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		String msj =webDriver.findElement(By.xpath("html/body")).getText();
		assertTrue(msj.contains("Registro Entrada Exitoso"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Given("the parking attendant is on the  outcome page")
	public void attendantOnOutcomePage() {
		webDriver.get("http://localhost:4200/registroparqueo/registrosalida/HZJ505");
	}

	@When("the parking attendant register the outcome info")
	public void attendantRegisterOutcomeInfo() {
		
		
		WebElement dateBox = webDriver.findElement(By.name("fechas"));
		dateBox.sendKeys("14082018");
		dateBox.sendKeys(Keys.TAB);
		dateBox.sendKeys("0245PM");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.findElement(By.className("btn")).click();
	}

	@Then("the parking attendant should see an exit Success message")
	public void attendantSeeExitSuccessMessage() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		String msj =webDriver.findElement(By.xpath("html/body")).getText();
		assertTrue(msj.contains("Registro Salida"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}@Given("the parking attendant is on the  list page")
	public void attendantOnListcomePage() {
		webDriver.get("http://localhost:4200/registroparqueo");
	}



	@Then("the parking attendant should see an List")
	public void attendantSeeList() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		String msj =webDriver.findElement(By.xpath("html/body")).getText();
		assertTrue(msj.contains("Vehiculos Actualmente en el Parqueadero"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

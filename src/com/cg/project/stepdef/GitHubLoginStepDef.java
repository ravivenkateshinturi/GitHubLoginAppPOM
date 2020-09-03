package com.cg.project.stepdef;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.pagebeans.GitHubLoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class GitHubLoginStepDef {
	private WebDriver driver;
	private GitHubLoginPage loginPage;	
	@Before
	public void setupStepEnv() {
		System.setProperty("webdriver.chrome.driver", "C:\\SatishTrainingData\\TrainingsTopicsWise\\SDET\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);	
		loginPage = PageFactory.initElements(driver, GitHubLoginPage.class); 
	}

	@Given("^User is on GitHub login Page$")
	public void user_is_on_GitHub_login_Page() throws Throwable {
	   driver.get("https://www.github.com/login");
	}

	@When("^user enter Invalid username and password$")
	public void user_enter_Invalid_username_and_password() throws Throwable {
	   loginPage.setLogin("satishmahajan");
	   loginPage.setPassword("saomepassword");
	   loginPage.singIn();
	  
	}

	@Then("^'Incorrect username or password\\.' Message should display$")
	public void incorrect_username_or_password_Message_should_display() throws Throwable {
		 	String expectedErrorMessage ="Incorrect username or password.";	   
		   Assert.assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
	}

	@When("^user enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
		
	}

	@Then("^user should successfully Sigin on his Github Account$")
	public void user_should_successfully_Sigin_on_his_Github_Account() throws Throwable {
		Assert.fail("Some Assertion Message");
	}
	@After
	public void tearDownStepEnv() {
		driver.close();
		driver = null;
	}


}

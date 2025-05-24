package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.PageObject_Elements;

public class Steps {

	

	 public WebDriver driver;
	 public PageObject_Elements pgelement;

	@Given("User Launch Browser")
	public void user_launch_browser() {
	    
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  pgelement = new PageObject_Elements(driver);
		  driver.manage().window().maximize();
		
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@Then("user is redirected to the HomePage")
	public void user_is_redirected_to_the_home_page() {
	String actualTile	= driver.getTitle();
	String expectedTitle = "The Internet";
	
	Assert.assertEquals(actualTile, expectedTitle);
		
	}
	
	//----------------- A/B Testing Link ---------------------//


@Then("click on A\\/B link")
public void click_on_a_b_link() {
 
	 pgelement.linkClick();
}

@Then("user landed on A\\/B homepage")
public void user_landed_on_a_b_homepage() throws InterruptedException {
	
	
	String actualText = pgelement.ABtextName();
	
	Assert.assertTrue(actualText.equals("A/B Test Control") || actualText.equals("A/B Test Variation 1"),
           "Unexpected variation text: " + actualText);
	
	
	
	
	pgelement.returnToHomePage();
}

@Then("click on dropdown")
public void click_on_dropdown() {

	pgelement.clickondropdown();
}

@Then("select the Option1")
public void select_the_option1() throws InterruptedException {
 
	Assert.assertEquals(pgelement.selectOption(), "Option 1");
	pgelement.returnToHomePage();
}

@Then("click frames link")
public void click_frames_link() {
   pgelement.clickOnFrames();
}

@Then("user landed on famespage and verifying the hyperlinks")
public void user_landed_on_famespage_and_verifying_the_hyperlinks() throws InterruptedException {
	
	for (WebElement link : pgelement.allHyperLinks) {
	   
		
		
		
		if(link.getText().contains("Nested Frames"))
		{
			System.out.println("Nested Frame");
		}
		else if (link.getText().contains("iFrame"))
		{
			System.out.println("iFrame");
		}		
	    
		pgelement.returnToHomePage();
	}

	
  }

	
}

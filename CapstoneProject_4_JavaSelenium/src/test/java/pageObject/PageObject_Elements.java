package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject_Elements {
	
	
	public WebDriver pagedriver;

	public PageObject_Elements(WebDriver pdriver) {
		
		this.pagedriver = pdriver;
		PageFactory.initElements(pdriver, this);
		
	}
   
	@FindBy (xpath = "//a[text()='A/B Testing']")
	WebElement ablink;
	
	@FindBy (tagName  = "h3" )
	WebElement textName;
	
	@FindBy (xpath = "//a[text() ='Dropdown']")
	WebElement dropdown;
	
	@FindBy (id = "dropdown")
	WebElement options;
	
	@FindBy (xpath = "//a[text() = 'Frames']")
	WebElement frameslink;
	
	@FindBy (xpath = "//a")
	public List<WebElement> allHyperLinks;
	
			
	public void returnToHomePage() throws InterruptedException {
		
		Thread.sleep(2000);
		
		pagedriver.navigate().back();
	}
	
	public void linkClick() {
		ablink.click();
	}
		
	public String ABtextName() {
		return textName.getText();
	}
		
	public void clickondropdown() {
		
		dropdown.click();	
	}
	
	public String selectOption() {
		
		Select value = new Select(options);
		value.selectByIndex(1);
		String option = value.getFirstSelectedOption().getText();
		return option;
	}
	
	public void clickOnFrames()
	{
		frameslink.click();
	}
	
	public String hyperlinks() {
		return allHyperLinks.toString();
		
		
	}


}

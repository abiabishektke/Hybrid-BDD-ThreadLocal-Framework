
package pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class SuccessMessage {
	
	WebDriver driver;
	public SuccessMessage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Added to cart')]") 
	WebElement successMessage;
	
	public String successMessage() {

	    WebDriverWait wait = new WebDriverWait(
	            BrowserUtil.getDriver(),
	            Duration.ofSeconds(20));

	    WebElement message = wait.until(
	            ExpectedConditions.visibilityOf(successMessage));

	    return message.getText();
	}
}

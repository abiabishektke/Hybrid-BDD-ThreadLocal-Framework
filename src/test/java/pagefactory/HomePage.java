
package pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@data-action-type='DISMISS']")
	public WebElement dismiss;//used xpath
	@FindBy(xpath="//a[text()=\"Today's Deals\"]")
	WebElement todaysDeals;
	//used xpath with OR operator...

	
	public void dismiss() {
		try {
			dismiss.click();
		}catch(Exception e) {
			
		}
	}
	
	public void todaysDeal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(todaysDeals));
		todaysDeals.click();
	}
	
	
	
}

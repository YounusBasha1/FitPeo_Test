package FitPeo__Package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeo_Class {
	public static void main(String[] args) throws Exception {

		// Launching the WebDriver.

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1 :- Navigate to the FitPeo Homepage.
		driver.get("https://fitpeo.com/");

		// 2 :- Click on Revenue Calculator Page:
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
		Thread.sleep(2000);
		// 3 :- Scroll Down to the Slider section :- Using the JSE to scroll down page
		// to visible the Element.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		// 4 :- Adjust the Slider:
		// Using the Xpath to locate the Slider element

		WebElement slider = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-j7qwjs']//span)[4]"));

		// Using the Actions class to drag the slider to the range of 820,
		// but the exact range of 820 is not draggable, so I have dragged it to 816 and
		// used the right arrow key.

		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(93, 0).release().perform();
		Thread.sleep(2000);

		// Locating the output field.
		WebElement actualElement = driver.findElement(By.xpath("//input[@type='number']"));
		String expectedValue = "820";

		// Using a while loop to press the right arrow key until the actual value
		// matches the expected value.
		while (true) {

			String actualValue = actualElement.getAttribute("value");
			System.out.println("Current Value: " + actualValue);
			if (actualValue.equals(expectedValue)) {
				System.out.println("Expected value reached: " + actualValue);
				break;

				// Exiting the loop when the expected value is reached

			} else {
				action.sendKeys(Keys.ARROW_RIGHT).build().perform();
				Thread.sleep(500);
			}
		}

		// 5 :- Update the Text Field:
		actualElement.click();
		actualElement.sendKeys(Keys.BACK_SPACE);
		actualElement.sendKeys(Keys.BACK_SPACE);
		actualElement.sendKeys(Keys.BACK_SPACE);
		System.out.println("-----------------");

		// Sending the value of 560

		actualElement.sendKeys("560");
		Thread.sleep(2000);
		System.out.println("Entered the value for :- 560");

		// 6 :- Validate Slider Value:

		WebElement slider1 = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-j7qwjs']//span)[4]//input"));
		String value = slider1.getAttribute("aria-valuenow");
		System.out.println("Actual range :- " + value);

		String Expectedvalue = "560";
		// Verifying the slider has been changed as expected or not

		if (value.equals(Expectedvalue)) {
			System.out.println("Slider has been changed accorindly as expected");

		} else {
			System.out.println("Slider has not changed");
		}
		System.out.println("");

		// 7 :- Select CPT Codes: selecting the checkboxes

		// CPT-99091, CPT-99453, CPT-99454, and CPT-99474.

		driver.findElement(By.xpath("(//div[@class='MuiBox-root css-1p19z09']//div//label//span//input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='MuiBox-root css-1p19z09']//div//label//span//input)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='MuiBox-root css-1p19z09']//div//label//span//input)[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='MuiBox-root css-1p19z09']//div//label//span//input)[8]")).click();
		Thread.sleep(2000);

		// Navigating back to the range of 820

		jse.executeScript("window.scrollBy(0,-1500)");
		Thread.sleep(5000);

		action.clickAndHold(slider).moveByOffset(40, 0).release().perform();
		Thread.sleep(2000);

		while (true) {
			String actualValue = actualElement.getAttribute("value");
			System.out.println("Current Value: " + actualValue);
			if (actualValue.equals(expectedValue)) {
				System.out.println("Expected value reached: " + actualValue);
				break;

				// Exiting the loop when the expected value is reached

			} else {
				action.sendKeys(Keys.ARROW_LEFT).build().perform();
				Thread.sleep(500);
			}
		}
		System.out.println("");

		// 8 :- Validate Total Recurring Reimbursement:

		WebElement FinalRecurring = driver
				.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));
		System.out.println("Total Recurring Reimbursement :-" + FinalRecurring.getText());

		// 9 :-Verify that the header displaying
		String ActualRecurring = FinalRecurring.getText();
		String ExpectedRecurring = "$110700";

		if (ActualRecurring.equals(ExpectedRecurring)) {
			System.out.println("Verified Total Recurring Reimbursement.");
		} else {
			System.out.println("Not Verified");
		}
		driver.quit();

	}
}

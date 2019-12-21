package cm.cm.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass extends TestBase{

	public void customVisibleWait(WebElement element) {
		wait = new WebDriverWait(driver, 20) ;
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element)) ;
	}

	public void customClickableWait(WebElement element) {
		wait = new WebDriverWait(driver, 20) ;
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element)) ;
	}

	public void writeText(WebElement element, String value) {
		customVisibleWait(element) ;
		element.clear() ;
		element.sendKeys(value) ;
	}

	public void searchTableData(String path, String userOption) {
		List<WebElement> options = driver.findElements(By.xpath(path));
		for(WebElement str : options) {
			String appOption = str.getText();
			if(userOption.equalsIgnoreCase(appOption)) {
				str.click();
				break ;
			}
		}		
	}

	public String getDropDownValue(WebElement element) {
		String appOption = null ;
		sleep(2000);
		clickElement(element);
		List<WebElement> lst = driver.findElements(By.xpath("//mat-option[@role='option']/span"));
		for(WebElement itr : lst) {
			appOption = itr.getText();
			itr.click();
			break ;
		}
		return appOption ;
	}

	public void selectDropDownOption(WebElement element, String userOption) {
		sleep(2000);
		clickElement(element);
		String path = "//mat-option[@role='option']/span" ;
		searchTableData(path, userOption);		
	}
	
	public void searchAndSelect(WebElement element, String searchKeyword) {
		sleep(2000);
		writeText(element, searchKeyword);
		String path = "//mat-option[@role='option']/span" ;
		searchTableData(path, searchKeyword);		
	}

	public void selectLocation(WebElement element, String value) {
		customVisibleWait(element) ;
		element.clear() ;
		element.sendKeys(value) ;
		sleep(1000);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
	}

	public void clickElement(WebElement element) {
		customClickableWait(element);
		element.click();
	}

	public void scrollIntoView(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void sleep(long duration) {
		try {
			Thread.sleep(duration);
		}
		catch(InterruptedException ae) {
			ae.printStackTrace();
		}
	}

	//This method will set given string to system's clip board
	public void setClipboardData(String imagePath) {
		StringSelection strSelection = new StringSelection(imagePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
	}

	//This method will upload any file
	public void uploadFile(String imagePath) {
		try {
			setClipboardData(imagePath);
			Robot robot = new Robot();
			robot.delay(2000); 
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(4000);
		}
		catch(AWTException e) {
			e.printStackTrace();
		}
	}

	//This method is used to Click on an element using JavaScript
	public void clickElementUsingJS(WebElement element) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();", element);
	}

/*	public void myFluentWait() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(45))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
	}*/

}

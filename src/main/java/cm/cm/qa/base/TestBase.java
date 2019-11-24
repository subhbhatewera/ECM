package cm.cm.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver ;
	public static Properties prop ;
	String projectpath = System.getProperty("user.dir") ;
	WebDriverWait wait ;
	JavascriptExecutor js ;
	Actions builder ;


	public TestBase() {
		try {
			prop = new Properties() ;
			FileInputStream ip = new FileInputStream(projectpath+"/src/main/java/com/cm/qa/config/config.properties") ;
			prop.load(ip);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void initializeBrowser() {
		String browserName = prop.getProperty("browser") ;
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectpath+"/driver/firefox/geckodriver.exe") ;
			driver = new FirefoxDriver() ;
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath+"/driver/chrome/chromedriver.exe") ;
			driver = new ChromeDriver() ;
		}
		else {
			System.out.println("Either browser is not present in Properties File or Wrong browser name");
		}
		driver.manage().window().maximize() ;
		driver.manage().deleteAllCookies() ;
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
	}

	public void customVisibleWait(WebElement element) {
		wait = new WebDriverWait(driver, 10) ;
		wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(element)) ;
	}

	public void customClickableWait(WebElement element) {
		wait = new WebDriverWait(driver, 20) ;
		wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(element)) ;
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

	public void selectDropDownOption(WebElement element, String userOption) {
		sleep(2000);
		clickElement(element);
		String path = "//mat-option[@role='option']/span";
		searchTableData(path, userOption);
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
			sleep(5000);
		}
		catch(AWTException e) {
			e.printStackTrace();
		}
	}
}

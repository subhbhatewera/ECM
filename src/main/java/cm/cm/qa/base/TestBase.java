package cm.cm.qa.base;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cm.qa.pages.CommercialsPage;
import com.cm.qa.pages.ContactPersonsPage;
import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.DocSearchPage;
import com.cm.qa.pages.DocumentsPage;
import com.cm.qa.pages.GeneralInformationPage;
import com.cm.qa.pages.NotificationPage;
import com.cm.qa.pages.OtherCommercialTermsPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.ProfilePage;
import com.cm.qa.pages.SLAPage;
import com.cm.qa.pages.TermPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public String projectpath = System.getProperty("user.dir");
	public String browserName = System.getProperty("browser");
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions builder;
	public UsernamePage uName;
	public PasswordPage pwd;
	public Utills utills;
	public DashboardPage dashboard;
	public ContractListPage contractList;
	public DocSearchPage docSearch ;
	public GeneralInformationPage generalInformation;
	public TermPage term;
	public CommercialsPage commercials;
	public OtherCommercialTermsPage otherCommercials;
	public SLAPage sla;
	public ContactPersonsPage contactPersons;
	public DocumentsPage document;
	public NotificationPage notification;
	public ProfilePage profile ;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(projectpath + "/src/main/java/resources/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void initializeBrowser() {
		// String browserName = prop.getProperty("browser");
		// Read browserName from Jenkins/Maven
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectpath + "/driver/firefox/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath + "/driver/chrome/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("headless chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath + "/driver/chrome/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Either browser is not present in Properties File or Wrong browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}

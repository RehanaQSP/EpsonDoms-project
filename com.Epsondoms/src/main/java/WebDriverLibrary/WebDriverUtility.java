package WebDriverLibrary;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class provide the Reusuable Method To Perform All Browser Related Actions
 * @author rehana23*/
public class WebDriverUtility {

	public static WebDriver driver_static;
	public WebDriver driver;
	public static Select selectobj;
	public static Actions actionsobj;
	public static Robot robotobj;
	public WebDriverWait wait;

	/**
	 * This Method Used To Launch The Specific Browser
	 * 
	 * @param String Browser Name
	 *@return void*/
	public void launchBrowser(String browser) {

		// Step1: Launch the Browser-----> Chrome, Edge, safari
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver_static = driver;
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver_static = driver;
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver_static = driver;
			break;

		default:
			System.out.println("Entered incorrect browser name stupid");
			break;
		}
		Reporter.log("Step1: Successully launched");
	}

	
	/**
	 * This Method Used To Navigate The Specific Browser
	 * 
	 * @param String url
	 *@return void*/
	public void NavigateToApplication(String url) {
		driver.get(url);
	}

	
	/**
	 * This Method Used To Maximize The Specific Browser
	 * 
	 *@return void*/
	public void maximizeTheBrowser() {
		driver.manage().window().maximize();
	}

	
	/**
	 * This Method Used To Close The Specific Browser
	 * 
	 *@return void*/
	public void closeTheBrowser() {
		driver.close();
	}

	/**
	 * This Method Used To Close All The Specific Browser
	 * 
	 *@return void*/
	public void closeAllBrowser() {
		driver.quit();
	}

	
	/**
	 * This Method Used To Waiting Implicitly The Specific Browser
	 * 
	 * @param long duration
	 *@return void*/
	public void waitImplicitly(long duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	
	/**
	 * This Method Used To Waiting Explicitly The Specific Browser
	 * 
	 * @param long duration, WebElement element
	 *@return void*/
	public void waitExplicitily(long duration, WebElement element) {
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	/**
	 * This Method Used To Select Options From The Specific Dropdown Are By Using Index Value
	 * 
	 * @param WebElement element, int index
	 *@return void*/
	public void selectOptionInDropdown(WebElement element, int index) {
		selectobj.selectByIndex(index);
	}
	
	/**
	 * This Method Used To Select Options From The Specific Dropdown Are By Using VisibleText
	 * 
	 * @param WebElement element, String visibletext
	 *@return void*/
	public void selectOptionInDropdown(WebElement element, String visibletext) {
	selectobj.selectByVisibleText(visibletext);
	}
	
	/**
	 * This Method Used To Select Options From The Specific Dropdown Are By Using VisibleText
	 * 
	 * @param String value, WebElement element
	 *@return void*/
	public void selectOptionInDropdown(String value, WebElement element) {
		selectobj.selectByVisibleText(value);
	}
	
	
	/**
	 * This Method Used To Perform Mouse Related Actions On The Specific WebElement
	 * 
	 * @param WebElement element
	 *@return void*/
	public void mouseHovering(WebElement element) {
		actionsobj.moveToElement(element).perform();
	}
	
	/**
	 * This Method Used To Perform Keyboard Related Actions With The Help Of Robot Class On
	 * The Specific WebElefment With The Help Of KeyPress
	 * 
	 *@return void*/
	public void pressTheKey_pageDown() {
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	
	/**
	 * This Method Used To Perform Keyboard Related Actions With The Help Of Robot Class On
	 * The Specific WebElement With The Help Of KeyRelease
	 * 
	 *@return void*/
	public void ReleaseTheKey() {
		robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}
	
	/**
	 * This Method Used For Handling PopUps For The Specific Dialogue Box With Respect To Accept method
	 * 
	 *@return void*/
	public void alertPopupAccept() {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This Method Used For Not Hanlding PopUps For The Specific Dialogue Box With Respect To Dismiss method
	 * 
	 *@return void*/
	public void alertPopupDismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This Method Used To Switch The Control From One Window To Another Widnow or One Frame To Another Frame
	 * With The Help Of Index Value
	 * 
	 * @param int index
	 *@return void*/
	public void switchControlToFrame(int index) {
		driver.switchTo().frame(0);
	}
	
	
	/**
	 * This Method Used To Switch The Control From One Window To Another Window or One Frame To Another Frame
	 * With The Help Of element Value
	 * 
	 * @param WebElement element
	 *@return void*/
	public void switchControlToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This Method Used To Switch Back The Control From One Window To Another Window
	 * With the Help Of DefaultContent
	 * 
	 *@return void*/
	public void switchBackControlToMain() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This Method Used To Switch The Control From One Window To Another Window
	 * 
	 * @param String windowaddress
	 *@return void*/
	public void switchControlToWindow(String windowaddress) {

		driver.switchTo().window(windowaddress);
	}

}

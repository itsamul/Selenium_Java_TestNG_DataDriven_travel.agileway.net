package agiletravelproject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.TestExcelReader;

public class BaseTest {

	private static WebDriver driver;
	public static TestExcelReader excel = new TestExcelReader("./src/test/resources/excel/testdata.xlsx");
	private static FileInputStream fis;
	private static Properties config = new Properties();
	private static Properties OR = new Properties();
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger(BaseTest.class);

	public void click(String locatorKey) {
		if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_PARTIALLINKTEXT")) {
			driver.findElement(By.partialLinkText(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_CLASSNAME")) {
			driver.findElement(By.className(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_TAGNAME")) {
			driver.findElement(By.tagName(OR.getProperty(locatorKey))).click();
		}
		log.info("Element clicked : " + locatorKey);
		Reporter.log("Element clicked : " + locatorKey);
	}

	public void type(String locatorKey, String value) {
		if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.name(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.linkText(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_PARTIALLINKTEXT")) {
			driver.findElement(By.partialLinkText(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.partialLinkText(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_CLASSNAME")) {
			driver.findElement(By.className(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.className(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_TAGNAME")) {
			driver.findElement(By.tagName(OR.getProperty(locatorKey))).clear();
			driver.findElement(By.tagName(OR.getProperty(locatorKey))).sendKeys(value);
		}
		log.info("Element found : " + locatorKey + " | value typed in the element : " + value);
		Reporter.log("Element found : " + locatorKey + " | value type in the element :  " + value);

	}

	public void select(String locatorKey, String value) {
		WebElement dropDown = null;
		try {
			if (locatorKey.endsWith("_ID")) {
				dropDown = driver.findElement(By.id(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_XPATH")) {
				dropDown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				dropDown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_NAME")) {
				dropDown = driver.findElement(By.name(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_LINKTEXT")) {
				dropDown = driver.findElement(By.linkText(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_PARTIALLINKTEXT")) {
				dropDown = driver.findElement(By.partialLinkText(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CLASSNAME")) {
				dropDown = driver.findElement(By.className(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_TAGNAME")) {
				dropDown = driver.findElement(By.tagName(OR.getProperty(locatorKey)));
			}
			Select select = new Select(dropDown);
			select.selectByVisibleText(value);
		} catch (Throwable e) {
			log.info("Element not found : " + locatorKey);
			Reporter.log("Element not found : " + locatorKey);
		}
		log.info("Element found : " + locatorKey + " | Value selected in the element : " + value);
		Reporter.log("Element found : " + locatorKey + " | Value selected in the element :" + value);
	}

	public boolean isElementPresent(String locatorKey) {
		try {
			if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_NAME")) {
				driver.findElement(By.name(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_LINKTEXT")) {
				driver.findElement(By.linkText(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_PARTIALLINKTEXT")) {
				driver.findElement(By.partialLinkText(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CLASSNAME")) {
				driver.findElement(By.className(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_TAGNAME")) {
				driver.findElement(By.tagName(OR.getProperty(locatorKey)));
			}
		} catch (Throwable e) {
			log.error("Element not found : " + locatorKey);
			Reporter.log("Element not found : " + locatorKey);
			return false;
		}
		log.info("Element present : " + locatorKey);
		Reporter.log("Element present : " + locatorKey);
		return true;
	}

	public String getElementText(String locatorKey) {
		String text = null;
		try {
			if (locatorKey.endsWith("_ID")) {
				text = driver.findElement(By.id(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_XPATH")) {
				text = driver.findElement(By.xpath(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_CSS")) {
				text = driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_NAME")) {
				text = driver.findElement(By.name(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_LINKTEXT")) {
				text = driver.findElement(By.linkText(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_PARTIALLINKTEXT")) {
				text = driver.findElement(By.partialLinkText(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_CLASSNAME")) {
				text = driver.findElement(By.className(OR.getProperty(locatorKey))).getText();
			} else if (locatorKey.endsWith("_TAGNAME")) {
				text = driver.findElement(By.tagName(OR.getProperty(locatorKey))).getText();
			}
		} catch (Throwable e) {
			log.error("Element not found : " + locatorKey);
			Reporter.log("Element not found : " + locatorKey);
			return "";
		}
		log.info("Element Found : " + locatorKey + " | Element Text : " + text);
		Reporter.log("Element Found : " + locatorKey + " | Element Text : " + text);
		return text;
	}

	public void selectFlightNo(String value) {
		driver.findElement(By.xpath("//td[text()='" + value + "']//preceding-sibling::th")).click();
		log.info("Clicked on an flight number : " + value);
		Reporter.log("Clicked on an flight number : " + value);
	}

	public String getElementValue(String locatorKey) {
		String text = null;
		try {
			if (locatorKey.endsWith("_ID")) {
				text = driver.findElement(By.id(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_XPATH")) {
				text = driver.findElement(By.xpath(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_CSS")) {
				text = driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_NAME")) {
				text = driver.findElement(By.name(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_LINKTEXT")) {
				text = driver.findElement(By.linkText(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_PARTIALLINKTEXT")) {
				text = driver.findElement(By.partialLinkText(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_CLASSNAME")) {
				text = driver.findElement(By.className(OR.getProperty(locatorKey))).getAttribute("value");
			} else if (locatorKey.endsWith("_TAGNAME")) {
				text = driver.findElement(By.tagName(OR.getProperty(locatorKey))).getAttribute("value");
			}
		} catch (Throwable e) {
			log.error("Element not found : " + locatorKey);
			Reporter.log("Element not found : " + locatorKey);
		}
		log.info("Element found : " + locatorKey + " | value : " + text);
		Reporter.log("Element found : " + locatorKey + " | value : " + text);
		return text;
	}

	@BeforeSuite
	public void setUp() {
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("File loaded : log4j.properties");
		Reporter.log("File loaded : log4j.properties");
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("File not found : OR.properties");
			Reporter.log("File not found : OR.properties");
		}
		try {
			OR.load(fis);
			log.info("File loaded : OR.properties");
			Reporter.log("File loaded : OR.properties");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Unable to open File : OR.properties");
			Reporter.log("Unable to open File : OR.properties");
		}
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("File not found : config.properties");
			Reporter.log("File not found : config.properties");
		}
		try {
			config.load(fis);
			log.info("File loaded : config.properties");
			Reporter.log("File loaded : config.properties");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Unable to open File : config.properties");
			Reporter.log("Unable to open File : config.properties");
		}
		
		if (config.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			log.info(config.getProperty("browser") + " browser launched.");
			Reporter.log(config.getProperty("browser") + " browser launched.");
		} else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			log.info(config.getProperty("browser") + " browser launched.");
			Reporter.log(config.getProperty("browser") + " browser launched.");
		} else if (config.getProperty("browser").equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			log.info(config.getProperty("browser") + " browser launched.");
			Reporter.log(config.getProperty("browser") + " browser launched.");
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicitWait"))));
		driver.get(config.getProperty("testSiteUrl"));
		log.info("Navigated to : " + config.getProperty("testSiteUrl"));
		Reporter.log("Navigated to : " + config.getProperty("testSiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait"))));
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		log.info("Test execution completed.");
		Reporter.log("Test execution completed.");
	}

}
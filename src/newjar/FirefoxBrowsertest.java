package newjar;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirefoxBrowsertest {

	public static void main(String[] args) throws InterruptedException, IOException  {
		
		String url = "http://128.96.133.16:8080/iws/Login/";
		System.setProperty("webdriver.gecko.driver","C:\\Softwares\\Selenium jars\\latestsel\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Selenium jars\\NewChromedriver2.37\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.get(url);
		System.out.println("Entering url");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		TakesScreenshot srcshot = ((TakesScreenshot)driver);
		File srcfile = srcshot.getScreenshotAs(OutputType.FILE);
		File dstfile = new File("C:/Softwares/Selenium jars/latestsel/Test.png");
		FileUtils.copyFile(srcfile, dstfile);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("upadmin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("upadmin");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//System.out.println("Before firing");
		//EventFiringWebDriver eventfiringwebdriver = new EventFiringWebDriver(driver);
		//System.out.println("Inside firing");
		
		//eventfiringwebdriver.executeScript("document.querySelector('.appIcons.eb_scrollbar').scrollTop= 100");
		WebElement element = driver.findElement(By.xpath("//span[text()='IWS - Management ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//System.out.println("Outside firing");
		driver.manage().window().maximize();
		element.click();
		//driver.findElement(By.xpath("//span[text()='IWS - Management ']")).click();
		//System.out.println("After actions");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("SPRINT"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		//Clicking on Install service
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@translate='FLOW_MANAGER.PLACE_ORDER.NEW_INSTALL_SERVICE']"))));
		
		driver.findElement(By.xpath("//span[@translate='FLOW_MANAGER.PLACE_ORDER.NEW_INSTALL_SERVICE']")).click();
		
		//Selecting PO and searching
		
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("productType"))));
		
		driver.findElement(By.name("productType")).click();
		
		driver.findElement(By.xpath("//li[text()='HFC']")).click();
		
		WebDriverWait wait4 = new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	/*	WebDriverWait checkboxwait = new WebDriverWait(driver,60);
		checkboxwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ebCheckbox-inputStatus"))));
		driver.findElement(By.className("ebCheckbox-inputStatus")).click();;*/
		
		
		//Add PO to cart
				
		WebElement from = driver.findElement(By.xpath("//span[@class='format-item-name']/span"));
		WebElement to = driver.findElement(By.xpath("//tree[@items='shoppingCart.items']/div"));
		
	/*	Actions cartitem = new Actions(driver);
		System.out.println("Before Actions");
		Action dragCartItem = cartitem.clickAndHold(from).moveToElement(to, 850, 0).release(to).build();
		System.out.println("After actions");
		dragCartItem.perform();*/
		
		to.click();
		
		driver.findElement(By.xpath("//span[text()='Select All']")).click();
		
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
		
		WebDriverWait CheckCart = new WebDriverWait(driver, 60);
		CheckCart.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NEW']")));
		
		System.out.println("Element is added to cart");
		
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
		WebElement elementNext = driver.findElement(By.xpath("//button[text()='Next ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementNext);
		
		/*
		
		WebDriverWait waitForNext = new WebDriverWait(driver, 60);
		waitForNext.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='onNext()']")));
		
		*/
				
		System.out.println("Before Click");
		elementNext.click();
		
		//Configure Order Screen
		
		driver.findElement(By.xpath("//b[text()='Program Name']/ancestor::label/following-sibling::div")).click();
		driver.findElement(By.xpath("//li[text()='DO']")).click();
		
		driver.findElement(By.xpath("//b[text()='Prov Vendor']/ancestor::label/following-sibling::div")).click();
		driver.findElement(By.xpath("//li[text()='Sprint']")).click();
		
		driver.findElement(By.xpath("//b[text()='Cascade']/ancestor::label/following-sibling::div/div/input")).sendKeys("KC90XS10B");
		
		
		WebDriverWait handlingdrpdown = new WebDriverWait(driver, 20);
		handlingdrpdown.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[text()='Handling']/ancestor::label/following-sibling::div")));
		
		driver.findElement(By.xpath("//b[text()='Handling']/ancestor::label/following-sibling::div")).click();
		driver.findElement(By.xpath("//li[text()='Auto']")).click();
		
		driver.findElement(By.xpath("//b[text()='Number of Mini Macros']/ancestor::label/following-sibling::div")).click();
		driver.findElement(By.xpath("//li[text()='1']")).click();
		
		driver.findElement(By.xpath("//b[text()='Skip CIC']/ancestor::label/following-sibling::div")).click();
		driver.findElement(By.xpath("//li[text()='Yes']")).click();
		
		driver.findElement(By.xpath("//b[text()='Skip CIQ']/ancestor::label/following-sibling::div")).click();
		driver.findElement(By.xpath("//li[text()='Yes']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("02/22/2019");
		
		driver.findElement(By.xpath("//button[text()='Validate Cascade']")).click();
		
		Thread.sleep(10000);
			
		WebElement ConfigOrderNext = driver.findElement(By.xpath("//button[text()='Next ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ConfigOrderNext);
		ConfigOrderNext.click();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement PlaceOrder = driver.findElement(By.xpath("//button[text()='Place Order']"));
		//WebDriverWait placeorder = new WebDriverWait(driver, 30);
		//placeorder.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next ']")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PlaceOrder);
		PlaceOrder.click();
		
		String message = driver.findElement(By.className("modal-body")).getText();
		System.out.println("Message is :"+message);
		
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
		
	
	}

}

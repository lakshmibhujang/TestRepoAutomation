package newjar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestGmail {

	public static void main(String[] args) throws InterruptedException, Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Selenium jars\\NewChromedriver2.37\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com/");
		
		WebElement userElement = driver.findElement(By.id("identifierId"));
        userElement.sendKeys("lakshmisbhujang");

        driver.findElement(By.id("identifierNext")).click();

        Thread.sleep(1000);

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("lb0051170");
        driver.findElement(By.id("passwordNext")).click();
        
        Thread.sleep(10000);
        
        WebElement composeElement = driver.findElement(By.xpath("//*[@role='button' and (.)='Compose']"));
        composeElement.click();
        Thread.sleep(5000);
        
        WebElement attachIcon = driver.findElement(By.xpath("//div[@data-tooltip='Attach files']/div"));
        
       // Actions selectFile = new Actions(driver);
        //selectFile.moveToElement(attachIcon);
        //selectFile.click();
        //Thread.sleep(3000);
        //selectFile.sendKeys("C:\\SprintNIMS\\IT_Ph1.5\\Testfile.txt");
        //selectFile.build().perform();
        
        driver.findElement(By.xpath("//div[@data-tooltip='Attach files']/div/div/div")).click();
        
        Thread.sleep(5000);
        
        //File attachment
        
        Runtime.getRuntime().exec("C:\\Softwares\\AutoITfiles\\FileUpload.exe");
        
        //driver.findElement(By.xpath("//div[@data-tooltip='Attach files' and @role='button']")).sendKeys("C:\\SprintNIMS\\IT_Ph1.5\\Testfile.txt");
      //  driver.findElement(By.xpath("//div[@data-tooltip='Attach files']/div")).sendKeys("C:\\SprintNIMS\\IT_Ph1.5\\Testfile.txt");
      /*  driver.findElement(By.xpath("//a[text()='Inbox']")).click();
        driver.findElement(By.xpath("//span[@class='bog']/*[text()='Test24']")).click();
    	Thread.sleep(10000);
    	System.out.println("Opening the mail");
    	String subInMail = driver.findElement(By.xpath("//div[@class='ha']/h2")).getText();
    	String textInMail = driver.findElement(By.xpath("//div[@id=':ny']/div")).getText();
    	System.out.println("Subject and Text in mail is "+textInMail+""+subInMail);
    	//assertEquals("Test24", subInMail);*/
    	System.out.println("Success");

	}

}

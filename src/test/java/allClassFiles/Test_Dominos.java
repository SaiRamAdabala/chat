package allClassFiles;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Dominos {
	WebDriver driver;

	@BeforeMethod
	public void setup_Chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void test_Stores_near_me() throws InterruptedException {
		driver.get("https://pizzaonline.dominos.co.in/");
		driver.manage().window().maximize();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//li[text()='Disclaimer']/following::*[41]")).click();
		/*
		 * WebElement chat=new WebDriverWait(driver,Duration.ofSeconds(60)).
		 * until(ExpectedConditions. presenceOfElementLocated(By.xpath(
		 * "//li[text()='Disclaimer']/following::*[41]"))); chat.click();
		 */
		Thread.sleep(5000);
		driver.switchTo().frame(1);

		Thread.sleep(5000);
		// User Click On Stores near me
		driver.findElement(By.xpath("//strong[text()='Stores near me']")).click();
		Thread.sleep(5000);
		// User Click on Enter location
		driver.findElement(By.xpath("//strong[text()='Enter location']")).click();
		Thread.sleep(5000);
		// User Enter City Name
		driver.findElement(By.xpath("//input[@id='ymMsgInput']")).sendKeys("Guntur");
		Thread.sleep(5000);
		// User Click on Send
		driver.findElement(By.xpath("//i[@id='sendIcon']")).click();
		Thread.sleep(5000);
		// User Enter Area Name
		driver.findElement(By.xpath("//input[@id='ymMsgInput']")).sendKeys("RTC Colony");
		Thread.sleep(5000);
		// User Click on Send
		driver.findElement(By.xpath("//i[@id='sendIcon']")).click();
		Thread.sleep(5000);
		// User Select Area
		driver.findElement(By.xpath("//i[@id='sendIcon']/preceding::*[16]")).click();
		Thread.sleep(5000);
		// User Click on Order Now
		driver.findElement(By.xpath("//strong[text()='Order Now']")).click();
		Thread.sleep(5000);
		// Close 0th Tab
		driver.close();
		// Handle Tabs
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);
		Thread.sleep(5000);
//Switch from 0th Tab to 1st Tab
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(5000);
		// Verify Order Menu Page
		String ExpURL = "https://dpizzaonline.dominos.co.in/menu";
		String ActURL = driver.getCurrentUrl();
		Assert.assertEquals(ActURL, ExpURL);
	}

	/*
	 * @Test(priority=2) public void test_Queries_feedback() throws
	 * InterruptedException { driver.get("https://pizzaonline.dominos.co.in/");
	 * driver.manage().window().maximize(); // Thread.sleep(12000);
	 * 
	 * 
	 * 
	 * 
	 * //
	 * driver.findElement(By.xpath("//li[text()='Disclaimer']/following::*[41]")).
	 * click();
	 * 
	 * WebElement chat=new WebDriverWait(driver,Duration.ofSeconds(60)).
	 * until(ExpectedConditions. presenceOfElementLocated(By.xpath(
	 * "//li[text()='Disclaimer']/following::*[41]"))); chat.click();
	 * 
	 * Thread.sleep(5000); driver.switchTo().frame(1);
	 * 
	 * Thread.sleep(5000); //User Click On Queries & feedback
	 * driver.findElement(By.xpath("//strong[text()='Queries & feedback']")).click()
	 * ; Thread.sleep(5000); //User Enter Mobile Number
	 * driver.findElement(By.xpath("//input[@id='ymMsgInput']")).sendKeys(
	 * "9900877665"); Thread.sleep(5000); //User Click on Send
	 * driver.findElement(By.xpath("//i[@id='sendIcon']")).click();
	 * Thread.sleep(5000);
	 * 
	 * 
	 * //Verify OTP Text String
	 * ExpOTPmsg="Please enter the 6 digit OTP sent to your mobile number."; String
	 * ActOTPmsg=driver.findElement(By.
	 * xpath("//div[contains(text(),'Please enter the 6')]")).getText();
	 * Assert.assertEquals(ActOTPmsg, ExpOTPmsg); Thread.sleep(5000); //User Click
	 * on Home
	 * driver.findElement(By.xpath("//input[@id='ymMsgInput']/following::*[20]")).
	 * click(); Thread.sleep(5000); }
	 * 
	 * @Test(priority=3) public void test_Track_current_order() throws
	 * InterruptedException { driver.get("https://pizzaonline.dominos.co.in/");
	 * driver.manage().window().maximize(); Thread.sleep(9000);
	 * driver.findElement(By.xpath("//li[text()='Disclaimer']/following::*[41]")).
	 * click();
	 * 
	 * WebElement chat=new WebDriverWait(driver,Duration.ofSeconds(60)).
	 * until(ExpectedConditions. presenceOfElementLocated(By.xpath(
	 * "//li[text()='Disclaimer']/following::*[41]"))); chat.click();
	 * 
	 * Thread.sleep(5000); driver.switchTo().frame(1);
	 * 
	 * Thread.sleep(5000); //User Click On Track current order
	 * driver.findElement(By.xpath("//strong[text()='Track current order']")).click(
	 * ); Thread.sleep(5000); //User Enter Mobile Number
	 * driver.findElement(By.xpath("//input[@id='ymMsgInput']")).sendKeys(
	 * "9900877665"); Thread.sleep(5000); //User Click on Send
	 * driver.findElement(By.xpath("//i[@id='sendIcon']")).click();
	 * Thread.sleep(5000);
	 * 
	 * 
	 * //Verify OTP Text String
	 * ExpOTPmsg="Please enter the 6 digit OTP sent to your mobile number."; String
	 * ActOTPmsg=driver.findElement(By.
	 * xpath("//div[contains(text(),'Please enter the 6')]")).getText();
	 * Assert.assertEquals(ActOTPmsg, ExpOTPmsg); Thread.sleep(5000); //User Click
	 * on Home
	 * driver.findElement(By.xpath("//input[@id='ymMsgInput']/following::*[20]")).
	 * click(); Thread.sleep(5000); }
	 * 
	 * @Test(priority=4) public void test_Contact_store() throws
	 * InterruptedException { driver.get("https://pizzaonline.dominos.co.in/");
	 * driver.manage().window().maximize(); Thread.sleep(9000);
	 * driver.findElement(By.xpath("//li[text()='Disclaimer']/following::*[41]")).
	 * click();
	 * 
	 * WebElement chat=new WebDriverWait(driver,Duration.ofSeconds(60)).
	 * until(ExpectedConditions. presenceOfElementLocated(By.xpath(
	 * "//li[text()='Disclaimer']/following::*[41]"))); chat.click();
	 * 
	 * Thread.sleep(5000); driver.switchTo().frame(1);
	 * 
	 * Thread.sleep(5000); //User Click On Contact store
	 * driver.findElement(By.xpath("//strong[text()='Contact store']")).click();
	 * Thread.sleep(5000); //User Enter Mobile Number
	 * driver.findElement(By.xpath("//input[@id='ymMsgInput']")).sendKeys(
	 * "9900877665"); Thread.sleep(5000); //User Click on Send
	 * driver.findElement(By.xpath("//i[@id='sendIcon']")).click();
	 * Thread.sleep(5000);
	 * 
	 * 
	 * //Verify OTP Text String
	 * ExpOTPmsg="Please enter the 6 digit OTP sent to your mobile number."; String
	 * ActOTPmsg=driver.findElement(By.
	 * xpath("//div[contains(text(),'Please enter the 6')]")).getText();
	 * Assert.assertEquals(ActOTPmsg, ExpOTPmsg); Thread.sleep(5000); //User Click
	 * on Home
	 * driver.findElement(By.xpath("//input[@id='ymMsgInput']/following::*[20]")).
	 * click(); Thread.sleep(5000);
	 * 
	 * }
	 * 
	 */

	@AfterMethod
	public void tearDown_Chrome() {
		driver.close();
	}
}

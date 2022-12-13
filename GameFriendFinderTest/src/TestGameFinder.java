import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGameFinder {
	   private WebDriver driver;
	   private boolean acceptNextAlert = true;
	   private StringBuffer verificationErrors = new StringBuffer();

	   @Before
	   public void setUp() throws Exception {
	      System.setProperty("webdriver.chrome.driver", //
	              "lib\\win\\chromedriver.exe");
	      driver = new ChromeDriver();
	      // driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   }
	   
	   @Test
	   public void testHomePage() throws Exception {
		  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
		  String expected = "Game Friend Finder";
		  String result = driver.findElement(By.xpath("//body/div/div/div/h2")).getText();
		  Assert.assertEquals(expected, result);
	   }
	   
	   @Test
	   public void testRegister() throws Exception {
		   	  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
			  driver.manage().window().maximize();
			  driver.findElement(By.xpath("//div[@class='user']/a[@href='/GameFriendFinder/register.html']")).click();
			  Thread.sleep(2000);
			  
			  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Suraj");
			  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Poudel");
			  driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("Suraj");
			  driver.findElement(By.xpath("//input[@name='Console']")).sendKeys("Poudel");
			  driver.findElement(By.xpath("//input[@name='Games']")).sendKeys("VALORANT, FORTNITE");
			  driver.findElement(By.xpath("//input[@value='Submit']")).click();
			  Thread.sleep(2000);
		 }
	   
	   @Test
	   public void testSeeUsers() throws Exception {
		   	  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
			  driver.manage().window().maximize();
			  driver.findElement(By.xpath("//div[@class='user']/a[@href='/GameFriendFinder/SimpleSearchHB.html']")).click();
			  Thread.sleep(2000);
			  
			  driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("S");
			  driver.findElement(By.xpath("//input[@value='Search']")).click();
			  Thread.sleep(2000);
			  String expected = "ALL USERS";
			  String result = driver.findElement(By.xpath("//body/h1")).getText();
			  Assert.assertEquals(expected, result);
		   }

	   @After
	   public void tearDown() throws Exception {
	      driver.quit();
	      String verificationErrorString = verificationErrors.toString();
	      if (!"".equals(verificationErrorString)) {
	         fail(verificationErrorString);
	      }
	   }
	   
}

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGameFinder {
	   private WebDriver driver;
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
		  Thread.sleep(2000);
		  Assert.assertEquals(expected, result);
	   }
	   
	   @Test
	   public void testAboutPage() throws Exception {
		  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='menu']/a[@href='/GameFriendFinder/about.html']")).click();
		  Thread.sleep(2000);
		  String expected = "ABOUT GAME FRIEND FINDER....";
		  String result = driver.findElement(By.xpath("//body/h1")).getText();
		  Thread.sleep(2000);
		  Assert.assertEquals(expected, result);
		  driver.findElement(By.xpath("//a")).click();
		  String expected2 = "Game Friend Finder";
		  String result2 = driver.findElement(By.xpath("//body/div/div/div/h2")).getText();
		  Thread.sleep(2000);
		  Assert.assertEquals(expected2, result2);
	   }
	   
	   @Test
	   public void testServiceAndContactPage() throws Exception {
		  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='menu']/a[@href='/GameFriendFinder/service.html']")).click();
		  Thread.sleep(2000);
		  String expected = "SIMPLY CONNECTING GAMERS....";
		  String result = driver.findElement(By.xpath("//body/h1")).getText();
		  Thread.sleep(2000);
		  Assert.assertEquals(expected, result);
		  driver.findElement(By.xpath("//a")).click();
		  String expected2 = "Game Friend Finder";
		  String result2 = driver.findElement(By.xpath("//body/div/div/div/h2")).getText();
		  Thread.sleep(2000);
		  Assert.assertEquals(expected2, result2);
		  driver.findElement(By.xpath("//div[@class='menu']/a[@href='/GameFriendFinder/contact.html']")).click();
		  Thread.sleep(2000);
		  String expected3 = "CONTACT US VIA EMAIL. 1234@UNOMAHA.EDU";
		  String result3 = driver.findElement(By.xpath("//body/h1")).getText();
		  Thread.sleep(2000);
		  Assert.assertEquals(expected3, result3);
		  driver.findElement(By.xpath("//a")).click();
		  String expected4 = "Game Friend Finder";
		  String result4 = driver.findElement(By.xpath("//body/div/div/div/h2")).getText();
		  Thread.sleep(2000);
		  Assert.assertEquals(expected4, result4);
	   }
	   
	   @Test
	   public void testRegister() throws Exception {
		   	  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
			  driver.manage().window().maximize();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//div[@class='user']/a[@href='/GameFriendFinder/register.html']")).click();
			  Thread.sleep(2000);
			  
			  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Suraj");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Poudel");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("SurajPoudel");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@name='Console']")).sendKeys("Xbox, PS5");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@name='Games']")).sendKeys("VALORANT, FORTNITE");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Submit']")).click();
			  Thread.sleep(2000);
			  String expected = "Database Result";
			  String result = driver.findElement(By.xpath("//body/h1")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(expected, result);
			  driver.findElement(By.xpath("//a")).click();
			  String expected2 = "Game Friend Finder";
			  String result2 = driver.findElement(By.xpath("//body/div/div/div/h2")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(expected2, result2);
		 }
	   
	   @Test
	   public void testGames() throws Exception {
		   	  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
			  driver.manage().window().maximize();
			  driver.findElement(By.xpath("//div[@class='user']/a[@href='http://ec2-52-14-70-5.us-east-2.compute.amazonaws.com:8080/game-page/GamePage']")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@name='search']")).sendKeys("V");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Search Game']")).click();
			  Thread.sleep(2000);
			  String expected = "VALORANT";
			  String result = driver.findElement(By.xpath("//div[@style='text-align: center;']/div")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(expected, result);			  
			  driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Stardew");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Search Game']")).click();
			  Thread.sleep(2000);
			  String expected1 = "Stardew Valley";
			  String result1 = driver.findElement(By.xpath("//div[@style='text-align: center;']/div")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(expected1, result1);
			  driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Among");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Search Game']")).click();
			  Thread.sleep(2000);
			  String expected2 = "Among Us";
			  String result2 = driver.findElement(By.xpath("//div[@style='text-align: center;']/div")).getText();
			  Assert.assertEquals(expected2, result2);
			  driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Fort");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Search Game']")).click();
			  Thread.sleep(2000);
			  String expected3 = "Fortnite";
			  String result3 = driver.findElement(By.xpath("//div[@style='text-align: center;']/div")).getText();
			  Assert.assertEquals(expected3, result3);
			  driver.findElement(By.xpath("//input[@name='search']")).sendKeys("I");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Search Game']")).click();
			  Thread.sleep(2000);
		 }
	   
	   @Test
	   public void testSeeUsers() throws Exception {
		   	  driver.get("http://ec2-3-21-129-247.us-east-2.compute.amazonaws.com:8080/GameFriendFinder/MainPage.html"); 
			  driver.manage().window().maximize();
			  driver.findElement(By.xpath("//div[@class='user']/a[@href='/GameFriendFinder/SimpleSearchHB.html']")).click();
			  Thread.sleep(2000);
			  
			  driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("S");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@value='Search']")).click();
			  Thread.sleep(2000);
			  String expected = "ALL USERS";
			  String result = driver.findElement(By.xpath("//body/h1")).getText();
			  Thread.sleep(2000);
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

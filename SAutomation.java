package BasecSeleniumCodeforAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.*;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class SAutomation {
	public static WebDriver driver;

	public void SAutomation() throws Exception {

		// Specify the path of file

		// load file

	}

	@BeforeTest
	public void PreReq() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\siddh\\Downloads\\SeleniumAUtomationJava\\Chromedriver\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");

	}

	@Test
	public void TestCase1() throws Exception {

		File src = new File("C:\\Users\\siddh\\Desktop\\seleniuminput.xlsx");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		XSSFWorkbook wb = new XSSFWorkbook(fis);

	
		XSSFSheet sh1 = wb.getSheetAt(0);

	
		String min = (sh1.getRow(0).getCell(0).getRawValue());

		String max = (sh1.getRow(0).getCell(1).getRawValue());

		wb.close();


		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/div/a/span[2]")))
				.build().perform();
		Thread.sleep(300);
		Screen screen = new Screen();
		Pattern electronics = new Pattern("C:\\Seleniumworkspace\\sikuli screenshot\\Electronics.JPG");
		screen.hover(electronics);
		a.moveToElement(
				driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[4]/div[4]/div[2]/span[10]/span")))
				.build().perform();
	
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/div[1]/header/div/div[1]/div[4]/div[4]/div[3]/div[10]/div[2]/div/a[1]/span"))
				.click();
	

		driver.findElement(By
				.xpath("/html/body/div[2]/div[2]/div[4]/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div/div/p[1]/a/img"))
				.click();

		a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/header/div/div[4]/a[3]/span[1]"))).build()
				.perform();

		driver.findElement(
				By.xpath("/html/body/div[2]/header/div/div[1]/div[4]/div[6]/div[2]/div/div[1]/ul[1]/li[2]/a")).click();

		

		WebElement minBox = driver.findElement(By.xpath("//*[@id='low-price']"));

		minBox.sendKeys(min);

		WebElement maxBox = driver.findElement(By.xpath("//*[@id='high-price']"));

		maxBox.sendKeys(max);

		driver.findElement(By
				.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[2]/div/ul[31]/div/li[7]/span/form/span[3]/span/input"))
				.click();

	

		Thread.sleep(1000);
		
		

		Boolean isPresent = driver
				.findElements(By
						.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[1]/div/div/div/div[2]"))
				.size() > 0;

		if (isPresent == true) {
			System.out.println("Testcase passed - there are products in range 1000-1200");
		}
	
		else {
			System.out.println("Testcase Failed no products are there");
		}

	}

	@Test
	public void TestCase2() throws Exception {

		driver.get("https://www.amazon.com/");
		Screen screen = new Screen();
		Pattern Movies = new Pattern("C:\\Seleniumworkspace\\sikuli screenshot\\Movies, Music & Games.JPG");

		Pattern second = new Pattern("C:\\Seleniumworkspace\\sikuli screenshot\\2nd.JPG");

		Pattern third = new Pattern("C:\\Seleniumworkspace\\sikuli screenshot\\3rd.JPG");

		Pattern fourth = new Pattern("C:\\Seleniumworkspace\\sikuli screenshot\\4th.JPG");

		Pattern fifth = new Pattern("C:\\Seleniumworkspace\\sikuli screenshot\\5th.JPG");

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/div/a/span[2]")))
				.build().perform();

		Thread.sleep(2000);

		screen.hover(Movies);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[4]/div[4]/div[3]/div[10]/div/a[1]/span"))
				.click();

		Thread.sleep(3000);
		JavascriptExecutor scroller = (JavascriptExecutor) driver;
		scroller.executeScript("window.scrollBy(0,450)", "");

		Thread.sleep(1000);

		screen.click(third);

		Thread.sleep(1000);

		screen.click(fourth);

		Thread.sleep(1000);

		screen.click(fifth);

	}

	@Test
	public void TestCase3() {

		driver.get("https://www.amazon.com/");

		driver.findElement(By.linkText("Today's Deals")).click();

		driver.findElement(By.linkText("70% Off or More")).click();

		driver.findElement(By
				.xpath("/html/body/div[1]/div[6]/div/div[2]/div/div[2]/div/div/div/div[37]/div/div[2]/div/a/div/div/div[2]"))
				.click();
		;

		driver.quit();

	}

}

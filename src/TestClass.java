import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestClass {

	public static void main(String[] args) throws IOException {

	/*	System.setProperty("webdriver.gecko.driver",
		         "C:\\Users\\MY LAPTOP\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:5500/index.html");
    */  
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\MY LAPTOP\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		
		
/****************************  process use screen shot      ******************************************/
/*
		Date currentDate = new Date();
		String theAcutalDate = currentDate.toString().replace(":", "-");
		TakesScreenshot src = ((TakesScreenshot) driver);
		File ScrFile = src.getScreenshotAs((OutputType.FILE));
		File Dest = new File(".//mypictures/" + theAcutalDate + ".png");
		FileUtils.copyFile(ScrFile, Dest);
*/
/****************************  process how to remove item    ******************************************/
		List<WebElement> theStudents = driver.findElements(By.tagName("option"));

		int theTotalNumberOfStudents = theStudents.size();

		System.out.println("this is the orginal number : " + theTotalNumberOfStudents);

		// I need to remove one items --------------

		int howManyRemoveItems = 1;

		System.out.println("this is the number of items i want removed : " + howManyRemoveItems);

		for (int i = 0; i < howManyRemoveItems; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}

		List<WebElement> theStudentsAfterRemove = driver.findElements(By.tagName("option"));
		int actualNumber = theStudentsAfterRemove.size();

		System.out.println("this is the new actual number : " + actualNumber);

		int expectedItems = theTotalNumberOfStudents - howManyRemoveItems;

		System.out.println("this is the number i have expected " + expectedItems);

		Assert.assertEquals(actualNumber, expectedItems);

/*********************************************  remove all items *********************************************************/

/*                         ------------------ I need to remove all items --------------

		for (int i = 0; i <theStudents.size(); i++) {
			
		driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

*/	}

	
		

		
		

	}



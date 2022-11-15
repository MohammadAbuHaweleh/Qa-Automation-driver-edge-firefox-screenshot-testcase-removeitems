import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Remove_even_odd {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\MY LAPTOP\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://127.0.0.1:5500/index.html");

		/*****************************************
		 * remove the odd items
		 ********************************************************/

		List<WebElement> myOptions = driver.findElements(By.tagName("option"));

		for (int i = 0; i < myOptions.size(); i++) {

			if (i % 2 == 0) {

				myOptions.get(i).click();
				System.err.println("sorry i will remove " + myOptions.get(i).getText());
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
			} else {
				System.out.println("I will keep " + myOptions.get(i).getText());

			}

		}

	}

}

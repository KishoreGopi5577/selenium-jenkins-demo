package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void verifySeleniumWebsite() throws InterruptedException {

    	String browser = System.getProperty("browser", "chrome");

    	WebDriver driver;

    	if (browser.equalsIgnoreCase("chrome")) {

    	    WebDriverManager.chromedriver().setup();

    	    ChromeOptions options = new ChromeOptions();
    	    options.addArguments("--headless");
    	    options.addArguments("--window-size=1920,1080");

    	    driver = new ChromeDriver(options);

    	} else if (browser.equalsIgnoreCase("firefox")) {

    	    WebDriverManager.firefoxdriver().setup();

    	    FirefoxOptions options = new FirefoxOptions();
    	    options.addArguments("-headless");

    	    driver = new FirefoxDriver(options);

    	} else if (browser.equalsIgnoreCase("edge")) {

    	    WebDriverManager.edgedriver().setup();

    	    EdgeOptions options = new EdgeOptions();
    	    options.addArguments("-headless");

    	    driver = new EdgeDriver(options);

    	} else {

    	    throw new IllegalArgumentException(
    	            "Unsupported browser: " + browser);
    	}
        try {

            driver.get("https://www.selenium.dev/");

            String title = driver.getTitle();

            System.out.println("Page Title: " + title);
            
            System.out.println("HomePageTest - Browser: " + browser);
            System.out.println("HomePageTest - Thread: "
                    + Thread.currentThread().getId());

            Thread.sleep(5000);

            Assert.assertTrue(title.contains("Selenium"),
                    "Title does not contain Selenium");

        } finally {

            driver.quit();
        }
        
        System.out.println("The test is successful");
    }
}
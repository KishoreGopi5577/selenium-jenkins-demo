package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {

    @Test
    public void verifyHomePage() throws InterruptedException {

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

            System.out.println("HomePageTest - Browser: " + browser);
            System.out.println("HomePageTest - Thread: "
                    + Thread.currentThread().getId());

            Thread.sleep(5000);

            Assert.assertTrue(driver.getTitle().contains("Selenium"));

        } finally {

            driver.quit();
        }
    }
}
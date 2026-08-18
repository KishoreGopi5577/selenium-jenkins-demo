package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

    @Test
    public void verifySearchPage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {

            driver.get("https://www.selenium.dev/");

            System.out.println("SearchTest - Thread: "
                    + Thread.currentThread().getId());

            Thread.sleep(5000);

            Assert.assertTrue(driver.getTitle().contains("Selenium"));

        } finally {

            driver.quit();
        }
    }
}
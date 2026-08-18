package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void verifySeleniumWebsite() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {

            driver.get("https://www.selenium.dev/");

            String title = driver.getTitle();

            System.out.println("Page Title: " + title);

            Assert.assertTrue(title.contains("Selenium"),
                    "Title does not contain Selenium");

        } finally {

            driver.quit();
        }
    }
}
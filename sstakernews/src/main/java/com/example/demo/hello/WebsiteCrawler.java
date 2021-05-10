package com.example.demo.hello;

import java.io.File;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebsiteCrawler {

    private WebDriver driver;

    public WebsiteCrawler() {
        // Define the location of the chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\soham\\chromedriver.exe");
        // Use headless mode for the ChromeDriver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        this.driver = new ChromeDriver(chromeOptions);
    }

    public void crawl(String url) {
        try {
            // Navigate to the specified directory
            driver.navigate().to(url);
            // Sleep for 5 seconds in case the website has not fully loaded 
            Thread.sleep(5000);
            // Take the screenshot and copy to the specified directory
            TakesScreenshot scrShot =((TakesScreenshot)driver);

            File src= scrShot.getScreenshotAs(OutputType.FILE);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            FileUtils.copyFile(src, new File("C:\\Users\\soham\\Pictures\\test-image.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        // Close after completion
        driver.close();
    }
    
}
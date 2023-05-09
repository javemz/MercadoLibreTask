package org.jmunoz.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        WebDriverManager
                .chromedriver()
                .avoidResolutionCache()
                .setup();

        createWebDriver();
    }

    private void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1200");

        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

}

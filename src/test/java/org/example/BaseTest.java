package org.example;

import org.example.Utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest  {
    WebDriver webDriver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().browserVersion("114").setup();
//        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.get(Constants.HOME_URL);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}

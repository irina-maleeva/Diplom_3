package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By textMessage = By.xpath(".//*[text()='В этом разделе вы можете изменить свои персональные данные']");

    private final By nameField = By.xpath(".//li[1]//input");
    private final By emailField = By.xpath(".//li[2]//input");

    public void waitForPageLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(textMessage));
    }

    public String getEmailText(){
        String email = webDriver.findElement(emailField).getAttribute("value");
        return email;
    }

    public String getNameText(){
        String name = webDriver.findElement(nameField).getAttribute("value");
        return name;
    }
}

package org.example.pageObject;

import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By enterFormHeading = By.xpath("//*[text()='Вход']");
    private final By emailInputField = By.xpath("//fieldset[1]//input");
    private final By passwordInputField = By.xpath("//fieldset[2]//input");

    private final By enterButton = By.xpath("//button[text()='Войти']");

    public void waitForPageLoad(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterFormHeading));
    }
    public void fillInUserData() {
        webDriver.findElement(emailInputField).sendKeys(Constants.USER_EMAIL);
        webDriver.findElement(passwordInputField).sendKeys(Constants.USER_PASSWORD);
    }
    public void clickEnterButton(){
        webDriver.findElement(enterButton).click();
    }
}

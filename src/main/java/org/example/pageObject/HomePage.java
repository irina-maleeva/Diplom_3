package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver webDriver;
//    Кнопка "Войти в аккаунт"
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By registerOrderButton = By.xpath(".//*[text()='Оформить заказ']");

    private final By personalProfileButton = By.xpath(".//*[text()='Личный Кабинет']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickEnterAccountButton() {
        webDriver.findElement(enterAccountButton).click();
    }
    public void waitForEnterAccountButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
    }

    public void waitForRegisterOrderButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(registerOrderButton));
    }

    public void waitForPersonalProfileButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(personalProfileButton));
    }

    public void enterPersonalProfile(){
        webDriver.findElement(personalProfileButton).click();
    }
}

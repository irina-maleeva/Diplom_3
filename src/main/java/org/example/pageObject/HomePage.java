package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver webDriver;
//    Кнопка "Войти в аккаунт"
    private final By enterAccountButton = By.xpath("//button[text()='Войти в аккаунт']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickEnterAccountButton() {
        webDriver.findElement(enterAccountButton).click();
    }
}

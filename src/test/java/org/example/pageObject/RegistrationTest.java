package org.example.pageObject;


import Utils.Constants;
import org.junit.Assert;
import org.junit.Test;

import static Utils.RandomString.randomString;

public class RegistrationTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    ProfilePage profilePage;

    String name =  randomString(10);
    String email = randomString(7) + "@yandex.ru";

    String correctPassword = randomString(6);

    String wrongPassword = randomString(5);

    @Test
    public void testRegistrationCorrectPassword(){
        homePage = new HomePage(webDriver);
        homePage.waitForPersonalProfileButton();
        homePage.enterPersonalProfile();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.clickRegistrationLink();
        registrationPage = new RegistrationPage(webDriver);
        registrationPage.waitForPageLoad();
        registrationPage.fillInRegistrationForm(name, email, correctPassword);
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        Assert.assertEquals(webDriver.getCurrentUrl(), Constants.LOGIN_URL);
        loginPage.fillInUserData(email, correctPassword);
        loginPage.clickEnterButton();
        homePage.waitForPersonalProfileButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        Assert.assertEquals(profilePage.getNameText(), name);
        Assert.assertEquals(profilePage.getEmailText(), email);
    }

    @Test
    public void testRegistrationShortPassword(){
        homePage = new HomePage(webDriver);
        homePage.waitForPersonalProfileButton();
        homePage.enterPersonalProfile();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.clickRegistrationLink();
        registrationPage = new RegistrationPage(webDriver);
        registrationPage.waitForPageLoad();
        registrationPage.fillInRegistrationForm(name, email, wrongPassword);
        Assert.assertEquals(registrationPage.getPasswordFieldErrorText(), "Некорректный пароль");
        Assert.assertEquals(webDriver.getCurrentUrl(), Constants.REGISTER_URL);
    }
}

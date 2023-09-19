package org.example.pageObject;

import Utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Utils.RandomString.randomString;

public class AuthorizationTest extends BaseTest {
 HomePage homePage;
 LoginPage loginPage;
 ProfilePage profilePage;

 RegistrationPage registrationPage;

 RestorePasswordPage restorePasswordPage;

// Написать тут создание пользователя


    String email = Constants.USER_EMAIL;

    String password = Constants.USER_PASSWORD;


 @Test
 public void testEnterViaEnterAccountButton() {
     homePage = new HomePage(webDriver);
     homePage.waitForEnterAccountButton();
     homePage.clickEnterAccountButton();
     loginPage = new LoginPage(webDriver);
     loginPage.waitForPageLoad();
     loginPage.fillInUserData(email, password);
     loginPage.clickEnterButton();
     homePage.waitForRegisterOrderButton();
     Assert.assertEquals(webDriver.getCurrentUrl(), Constants.HOME_URL);
     homePage.enterPersonalProfile();
     profilePage = new ProfilePage(webDriver);
     profilePage.waitForPageLoad();
     Assert.assertEquals(profilePage.getEmailText(), email);
 }

 @Test
     public void testEnterViaPersonalProfileButton(){
      homePage = new HomePage(webDriver);
      homePage.waitForPersonalProfileButton();
      homePage.enterPersonalProfile();
      loginPage = new LoginPage(webDriver);
      loginPage.waitForPageLoad();
      loginPage.fillInUserData(email, password);
      loginPage.clickEnterButton();
      homePage.waitForRegisterOrderButton();
      homePage.enterPersonalProfile();
      profilePage = new ProfilePage(webDriver);
      profilePage.waitForPageLoad();
      Assert.assertEquals(profilePage.getEmailText(), email);
 }

 @Test
    public void testEnterViaLinkInRegistrationForm(){
     homePage = new HomePage(webDriver);
     homePage.waitForEnterAccountButton();
     homePage.clickEnterAccountButton();
     loginPage = new LoginPage(webDriver);
     loginPage.waitForPageLoad();
     loginPage.clickRegistrationLink();
     registrationPage = new RegistrationPage(webDriver);
     registrationPage.waitForPageLoad();
     registrationPage.clickAlreadyRegisteredLink();
     loginPage.waitForPageLoad();
     loginPage.fillInUserData(email, password);
     loginPage.clickEnterButton();
     homePage.waitForRegisterOrderButton();
     homePage.enterPersonalProfile();
     profilePage = new ProfilePage(webDriver);
     profilePage.waitForPageLoad();
     Assert.assertEquals(profilePage.getEmailText(), email);
 }

 @Test
    public void testEnterViaLinkInRestorePasswordForm(){
     homePage = new HomePage(webDriver);
     homePage.waitForEnterAccountButton();
     homePage.clickEnterAccountButton();
     loginPage = new LoginPage(webDriver);
     loginPage.waitForPageLoad();
     loginPage.clickRestorePasswordLink();
     restorePasswordPage = new RestorePasswordPage(webDriver);
     restorePasswordPage.waitForPageLoad();
     restorePasswordPage.clickRememberedPassword();
     loginPage.waitForPageLoad();
     loginPage.fillInUserData(email,password);
     loginPage.clickEnterButton();
     homePage.waitForRegisterOrderButton();
     homePage.enterPersonalProfile();
     profilePage = new ProfilePage(webDriver);
     profilePage.waitForPageLoad();
     Assert.assertEquals(profilePage.getEmailText(), email);
 }
}
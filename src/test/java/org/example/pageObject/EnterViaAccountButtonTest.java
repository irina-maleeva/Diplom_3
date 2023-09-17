package org.example.pageObject;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnterViaAccountButtonTest extends BaseTest {
 HomePage homePage;
 LoginPage loginPage;
 @Test
    public void testEnterViaEnterAccountButton() {
     homePage = new HomePage(webDriver);
     homePage.clickEnterAccountButton();
     loginPage.waitForPageLoad();
     loginPage.fillInUserData();
     loginPage.clickEnterButton();

 }


}
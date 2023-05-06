package com.docker.test;

import com.docker.base.StepImplementations;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.docker.constant.LoginConstants.*;

/**
 * Created by Fatih Can Oklay
 * Date: 23.04.2023
 */

public class LoginTest extends StepImplementations {

    public static final By ACCEPT_COOKIES = By.id("onetrust-accept-btn-handler");
    public static final By ACCOUNT_LIST = By.cssSelector("div[class='link account-user']");
    public static final By ACCOUNT_LIST_LOGIN_BUTTON = By.cssSelector(".login-button");
    public static final By EMAIL_INPUT = By.id("login-email");
    public static final By PASSWORD_INPUT = By.id("login-password-input");
    public static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    public static final By LOGIN_TITLE = By.cssSelector("div[class='lr-title'] > h1");
    public static final By HOME_PAGE_TITLE = By.cssSelector("a[title='trendyol']");
    public static final By ERROR_MESSAGE = By.cssSelector("span[class='message']");
    public static final By PASSWORD_EYE_ICON = By.cssSelector(".i-eye-close");
    public static final By PASSWORD_VALUE = By.cssSelector("input[value='Can12345.!']");
    public static final By FORGOT_PASSWORD_BUTTON = By.cssSelector("div[class='forgot-password'] > a");
    public static final By FORGOT_PASSWORD_TITLE = By.cssSelector("span[class='title']");
    public static final By FORGOT_PASSWORD_PREVIOUS_PAGE_BUTTON = By.cssSelector("button[type='button']");
    public static final By RENEW_PASSWORD_BUTTON = By.cssSelector("button[type='submit']");
    public static final By FORGOT_PASSWORD_ERROR_MESSAGE = By.cssSelector("span[class='ty-text ty-color-red ty-font-sm ty-font-w-bold']");
    public static final By FORGOT_PASSWORD_EMAIL_INPUT = By.name("email");
    public static final By FORGOT_PASSWORD_LOGIN_BUTTON = By.cssSelector("button[class='ty-font-w-semi-bold ty-button ty-bordered ty-transition ty-input-small ty-primary']");
    public static final By FORGOT_PASSWORD_EMAIL_SENT_TITLE = By.cssSelector("form[class='ty-form change-password-success-form'] > div > p");

    @Test(testName = "User should login successfully")
    public void user_should_login_successfully() {
        click(ACCEPT_COOKIES);
        hover(ACCOUNT_LIST);
        click(ACCOUNT_LIST_LOGIN_BUTTON);
        verifyText(LOGIN_TITLE, LOGIN_TITLE_TEXT);
        writeText(EMAIL_INPUT, EMAIL_TEXT);
        writeText(PASSWORD_INPUT, PASSWORD_TEXT);
        click(LOGIN_BUTTON);
        isElementDisplayed(HOME_PAGE_TITLE);
    }
}
package com.docker.base;

import com.docker.log.Logs;
import com.docker.report.ExtentLogger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.docker.constant.LoginConstants.LOGIN_TITLE_TEXT;
import static com.docker.test.LoginTest.*;

/**
 * Created by Fatih Can Oklay
 * Date: 23.04.2023
 */

public class StepImplementations extends BasePage {

    Logger logger = LogManager.getLogger(Logs.class.getName());

    public void hover(By by) {
        try {
            hoverElement(by);
            ExtentLogger.info("Hovered element: " + by);
            logger.info("Hovered element: " + by);
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            logger.error(e.getMessage());
            ExtentLogger.info("Can not hovered element: " + by);
            logger.info("Can not hovered element: " + by);
            assertFail();
        }
    }

    public void click(By by) {
        try {
            clickElement(by);
            ExtentLogger.info("Clicked element: " + by);
            logger.info("Clicked element: " + by);
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            logger.error(e.getMessage());
            ExtentLogger.info("Can not clicked element: " + by);
            logger.info("Can not clicked element: " + by);
            assertFail();
        }
    }

    public void clickIfExists(By by) {
        try {
            if (findElement(by).isDisplayed()) {
                clickElement(by);
                ExtentLogger.info("Clicked element: " + by);
            }
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Can not clicked element: " + by);
        }
    }

    public void writeText(By by, String text) {
        try {
            clear(by);
            sendKeys(by, text);
            ExtentLogger.info(text + " text is written successfully");
            logger.info(text + " text is written successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            logger.error(e.getMessage());
            ExtentLogger.info(text + " text could not be written!");
            logger.info(text + " text could not be written!");
            assertFail();
        }
    }

    public void verifyText(By by, String text) {
        try {
            assertEquals(getText(by), text);
            ExtentLogger.info(by + " text is checked successfully");
            logger.info(by + " text is checked successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            logger.error(e.getMessage());
            ExtentLogger.info(by + " text is not checked successfully");
            logger.info(by + " text is not checked successfully");
            assertFail();
        }
    }

    public void verifyTextWithAttribute(By by, String text) {
        try {
            getAttribute(by, text);
            ExtentLogger.info(by + " text is checked successfully");
            logger.info(by + " text is checked successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            logger.error(e.getMessage());
            ExtentLogger.info(by + " text is not checked successfully");
            logger.info(by + " text is not checked successfully");
            assertFail();
        }
    }

    public void isElementDisplayed(By by) {
        try {
            isDisplayed(by);
            ExtentLogger.info("Element is checked successfully");
            logger.info("Element is checked successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            logger.error(e.getMessage());
            ExtentLogger.info("Element is not checked successfully");
            logger.info("Element is not checked successfully");
            assertFail();
        }
    }

    public void loginWithVariousAccounts(By by, By by2, String email, String password) {
        try {
            click(ACCEPT_COOKIES);
            hover(ACCOUNT_LIST);
            click(ACCOUNT_LIST_LOGIN_BUTTON);
            verifyText(LOGIN_TITLE, LOGIN_TITLE_TEXT);
            writeText(by, email);
            writeText(by2, password);
            pressEnter(LOGIN_BUTTON);
            isElementDisplayed(HOME_PAGE_TITLE);
            ExtentLogger.info("Logged in successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Could not login successfully");
            assertFail();
        }
    }

    public void pressEnter(By by) {
        try {
            enter(by);
            ExtentLogger.info("Pressed enter successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Can not pressed enter successfully");
            assertFail();
        }
    }
}

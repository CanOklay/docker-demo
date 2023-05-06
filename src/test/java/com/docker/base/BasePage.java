package com.docker.base;

import com.docker.test.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.docker.util.WaitElementUtils.*;

/**
 * Created by Fatih Can Oklay
 * Date: 23.04.2023
 */

public abstract class BasePage extends BaseTest {

    public WebElement findElement(By by) {
        waitUntilPresenceOfElementLocatedBy(by);
        waitUntilVisibilityOfElementLocatedBy(by);
        waitUntilElementStale(by);
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        waitUntilPresenceOfElementLocatedBy(by);
        waitUntilVisibilityOfElementLocatedBy(by);
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void clickElement(By by) {
        waitUntilClickableOfElementLocatedBy(by);
        findElement(by).click();
    }

    public void hoverElement(By by) {
        WebElement element = findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void wait(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void scrollElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findElement(by));
    }

    public void isDisplayed(By by) {
        findElement(by).isDisplayed();
    }

    public void assertEquals(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertFail() {
        Assert.fail();
    }

    public void getAttribute(By by, String text) {
        findElement(by).getAttribute(text);
    }

    public void clear(By by) {
        findElement(by).clear();
    }

    public void enter(By by) {
        findElement(by).sendKeys(Keys.ENTER);
    }

    public void screenShot(String text) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        String date = dateFormat.format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/report/screenshot/" + text + "(" + date + ")" + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

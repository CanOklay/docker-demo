package com.docker.util;

import com.docker.manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Fatih Can Oklay
 * Date: 23.04.2023
 */

public final class WaitElementUtils extends DriverFactory {

    private WaitElementUtils() {
    }

    public static void waitUntilPresenceOfElementLocatedBy(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitUntilVisibilityOfElementLocatedBy(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilClickableOfElementLocatedBy(By by) {
        webDriverWait.until(elementToBeClickable(by));
    }

    public static void waitUntilElementStale(By by) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
    }

}

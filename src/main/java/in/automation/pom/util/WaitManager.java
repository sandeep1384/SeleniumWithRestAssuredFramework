package in.automation.pom.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitManager {

    public static void waitForElementToBeLocated(WebDriver wd, By elementToBeLocated){

        FluentWait wait = new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(elementToBeLocated));

    }

    public static void waitForAlertToBePresent(WebDriver wd){
        FluentWait wait = new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent());

    }

    public static void waitForElementToHaveAttributeWithSpecificValue(WebDriver wd, WebElement webElementToLocate, String attributeName, String attributeValue){
        FluentWait wait = new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.attributeContains(webElementToLocate, attributeName, attributeValue));

    }
}

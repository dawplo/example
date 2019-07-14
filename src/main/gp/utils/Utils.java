package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverFactory.EXPLICIT_TIMEOUT;
import static utils.DriverFactory.driver;

public class Utils {
    protected WebDriverWait wait;
    Actions action = new Actions(DriverFactory.driver);
    public Utils(){
        this.wait = new WebDriverWait(DriverFactory.driver, EXPLICIT_TIMEOUT);
    }

    public void clickAndWait(WebElement clickElement) {
        Actions action = new Actions(DriverFactory.driver);
        action.moveToElement(clickElement).build().perform();
    }
}

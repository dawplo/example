package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAction {

    private WebDriverWait wait;

    public PageAction(){
        wait = new WebDriverWait(DriverFactory.driver, 15);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void waitForAjax() {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void insertText(WebElement element, String text) {
//        element.clear();
        element.sendKeys(text);
    }

}

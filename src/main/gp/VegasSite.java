import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import utils.PageAction;
import utils.Utils;

import static org.junit.Assert.assertEquals;
import static utils.DriverFactory.driver;

public class VegasSite {
    private Utils utils;
    Actions assigner = new Actions(DriverFactory.driver);
    PageAction action = new PageAction();


    public VegasSite() {
        PageFactory.initElements(DriverFactory.driver, this);
        utils = new Utils();
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div/div[1]/div[1]/div/div[3]/div[1]/div/div/div[2]/div[2]/div/button")
    private WebElement clickSearch;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/div[3]/div[3]/div/div[1]/div[2]/button[1]")
    private WebElement playNow;

    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div")
    private WebElement textInput;

    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[1]")
    private WebElement mayfairRoulette;

    @FindBy(xpath = "/html/body/div[5]/div/div/button")
    private WebElement closeGame;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[3]/div/button[2]/div")
    private WebElement more;

    @FindBy(xpath = "//*[@id='root']/div/div/div/div[1]/div[4]/div/div[1]/div[3]/div[2]/div[2]/ul/li[2]/div/div/div[1]/div/img")
    private WebElement hoverGame;

    @FindBy (xpath = "/html/body/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div/div[2]")
    private WebElement prewiev;

    @FindBy(id = "login-form-username")
    private WebElement login;

    @FindBy(id = "login-form-password")
    private WebElement password;

    @FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[3]/section/form/div[3]/button")
    private WebElement executeLogin;

    String url = driver.getTitle();

    String title = driver.getTitle();

    public VegasSite gotoMainPage() {
        driver.get("https://vegas.williamhill.com");
        return this;
    }

    public VegasSite clickSearch() {
        clickSearch.click();
        String title = driver.getTitle();
        assertEquals(title, "Play Vegas Games online today | William Hill");
        return this;
    }

    public VegasSite insertGame(String text) throws InterruptedException {
        assigner.moveToElement(textInput);
        assigner.click();
        assigner.sendKeys(text);
        assigner.build().perform();
        return this;
    }

    public VegasSite setGame() {
        action.waitForElement(mayfairRoulette);
        mayfairRoulette.click();
        return this;
    }

    public VegasSite closeWindow() {
        action.waitForElement(closeGame);
        closeGame.click();
        return this;
    }

      public VegasSite preview(String nameGame) {
          Actions action = new Actions(DriverFactory.driver);
          WebElement we = DriverFactory.driver.findElement(By.xpath("//img[@alt='" + nameGame + "']"));
          action.moveToElement(we).perform();
          return this;
    }

    public VegasSite clickMore() {
        action.waitForElement(more);
        more.click();
        return this;
    }

    public VegasSite playNow() {
        action.waitForElement(playNow);
        playNow.click();
        return this;
    }

    public VegasSite checkTheForm(){
        utils.isWebElementVisible(login);
        utils.isWebElementVisible(password);
        utils.isWebElementVisible(executeLogin);
        Assert.assertTrue(utils.isWebElementVisible(login));
        Assert.assertTrue(utils.isWebElementVisible(password));
        Assert.assertTrue(utils.isWebElementVisible(executeLogin));
        return this;
    }
}

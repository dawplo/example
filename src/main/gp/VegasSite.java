import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(xpath = "//*[@id='root']/div/div/div/div/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div")
    private WebElement textInput;

    @FindBy(xpath = "/html/body/div[5]/div/div/ul/li[1]")
    private WebElement mayfairRoulette;

    @FindBy(xpath = "/html/body/div[5]/div/div/button")
    private WebElement closeGame;

    @FindBy(xpath = "//*[@id='root']/div/div/div/div[1]/div[4]/div/div[1]/div[3]/div[2]/div[2]/ul/li[2]/div/div/div[1]/div/img")
    private WebElement hoverGame;

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

    public VegasSite hoverOnGame() {
        utils.clickAndWait(hoverGame);
        hoverGame.click();
        return this;
    }
}

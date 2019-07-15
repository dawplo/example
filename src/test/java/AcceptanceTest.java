import org.junit.Test;
import utils.DriverFactory;

public class AcceptanceTest extends DriverFactory {

    VegasSite vegasSite = new VegasSite();
    private String game = "Mayfair Roulette";

    @Test
    public void SearchSelectAndCloseGame() throws InterruptedException {
        vegasSite.gotoMainPage()
                .clickSearch()
                .insertGame(game)
                .setGame()
                .closeWindow();
    }

    @Test
    public void checkDetailGame() {
        vegasSite.gotoMainPage();
        vegasSite.preview();
        vegasSite.clickMore();
        vegasSite.playNow();
        vegasSite.checkTheForm();
    }


}

import org.junit.Test;
import utils.DriverFactory;
import utils.PageAction;

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
    public void FindAndPlayGame() {
        vegasSite.gotoMainPage()
                .hoverOnGame();
    }
}

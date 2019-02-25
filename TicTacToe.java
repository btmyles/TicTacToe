import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class TicTacToe extends Application
{
    private Game game;
    protected static Player p2;
    protected static Player p1;

    protected static ArrayList<Button> buttons = new ArrayList<Button>(9);

    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage mainStage) throws Exception
    {
        // Create menubar and menus within it
        MenuBar menu = new MenuBar();

        // Create menus within menu bar
        Menu newTab = new Menu("New Game");
        Menu themeTab = new Menu("Theme");
        
        // Add menus to the menuBar
        menu.getMenus().add(newTab);
        menu.getMenus().add(themeTab);

        // Add items to the newTab menu
        MenuItem singlePlayer = new MenuItem("Single Player");
        MenuItem twoPlayer = new MenuItem("Two Player");
        newTab.getItems().add(singlePlayer);
        newTab.getItems().add(twoPlayer);
        
        // Run methods when clicked
        singlePlayer.setOnAction(this::processSinglePlayer);
        twoPlayer.setOnAction(this::processTwoPlayer);

        // Create buttons
        for (int i=0; i<9; i++)
        {
            Button butt = new Button();
            butt.setMnemonicParsing(true);
            butt.setPrefSize(100, 100);
            butt.setOnAction(this::processButton);

            buttons.add(butt);
        }

        // Create gridPane
        GridPane mainGrid = new GridPane();
        
        mainGrid.add(buttons.get(0), 0, 0);
        mainGrid.add(buttons.get(1), 1, 0);
        mainGrid.add(buttons.get(2), 2, 0);
        mainGrid.add(buttons.get(3), 0, 1);
        mainGrid.add(buttons.get(4), 1, 1);
        mainGrid.add(buttons.get(5), 2, 1);
        mainGrid.add(buttons.get(6), 0, 2);
        mainGrid.add(buttons.get(7), 1, 2);
        mainGrid.add(buttons.get(8), 2, 2);

        mainGrid.setHgap(10);
        mainGrid.setVgap(10);

        VBox mainPane = new VBox(menu, mainGrid);

        mainStage.setTitle("TicTacToe");
        mainStage.setScene(new Scene(mainPane, 320, 320));
        mainStage.show();
    }

    private void processSinglePlayer(ActionEvent event)
    {
        game = new SingleGame();
    }

    private void processTwoPlayer(ActionEvent event)
    {
        game = new TwoGame();
    }

    public void processButton(ActionEvent event)
    {
        if (game != null)
        {
            game.playTurns(event);

            int win = game.detectWin(buttons);
            if (win == 1)
            {
                Alert alert = new Alert(AlertType.INFORMATION, "P1 WIN", ButtonType.OK);
                alert.showAndWait();
            }
            else if (win == 2)
            {
                Alert alert = new Alert(AlertType.INFORMATION, "P2 WIN", ButtonType.OK);
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(AlertType.INFORMATION, "Start a game before making a move", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
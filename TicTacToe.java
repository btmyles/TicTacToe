import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class TicTacToe extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage mainStage)
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

        // Create buttons
        ArrayList<Button> buttons = new ArrayList<Button>();

        for (int i=0; i<9; i++)
        {
            Button butt = new Button();
            butt.setText("X");
            butt.setPrefSize(100, 100);
            buttons.add(butt);
        }

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
        mainStage.setScene(new Scene(mainPane, 400, 400));
        mainStage.show();
    }
}
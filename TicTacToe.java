import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

public class TicTacToe extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage mainStage)
    {
        Button b11 = new Button();
        b11.setText("Test");

        GridPane mainGrid = new GridPane();
        mainGrid.add(b11, 1, 1);

        mainStage.setTitle("TicTacToe");
        mainStage.setScene(new Scene(mainGrid, 400, 400));
        mainStage.show();
    }
}
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
public class SingleGame extends Game
{
    public SingleGame()
    {
        super();
        p1 = new Human(p1Token);
        p2 = new Computer(p2Token);
    }

    public void playTurns(ActionEvent event)
    {
        if (((Button) event.getSource()).getText().equals("-"))
        {        
            p1.play(event);
            p2.play(event);
        }
    }
}
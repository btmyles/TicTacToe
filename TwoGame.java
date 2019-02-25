import javafx.event.ActionEvent;
import javafx.scene.control.Button;
public class TwoGame extends Game
{
    Boolean p1Turn;

    public TwoGame()
    {
        super();
        p1Turn = true;
        p1 = new Human(p1Token);
        p2 = new Human(p2Token);
    }

    public void playTurns(ActionEvent event)
    {
        // Only make a move if the button has not been pressed yet
        if (((Button) event.getSource()).getText().equals("-"))
        {
            if (p1Turn)
            {
                p1.play(event);
            }
            else
            {
                p2.play(event);
            }
            p1Turn = !p1Turn;

        }
    }
}
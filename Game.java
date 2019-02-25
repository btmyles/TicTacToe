import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Game
{
    Player p1;
    Player p2;

    String p1Token;
    String p2Token;

    Boolean p1Turn;

    public Game()
    {
        p1Token = "X";
        p2Token = "O";

        newTwoGame();
    }

    public Game(String cpu)
    {
        p1Token = "X";
        p2Token = "O";

        newSingleGame();
    }

    public void setP1Token(String token) throws BadTokenException
    {
        if (token.length() > 1)
            throw new BadTokenException();

        p1Token = token;
        p1 = new Human(p1Token);
    }

    public void setP2Token(String token) throws BadTokenException
    {
        if (token.length() > 1)
            throw new BadTokenException();

        p2Token = token;
        p2 = new Human(p2Token);
    }

    public void newTwoGame()
    {
        p1Turn = true;
        p1 = new Human(p1Token);
        p2 = new Human(p2Token);

        for (int i=0; i<9; i++)
            TicTacToe.buttons.get(i).setText("-");
    }

    public void newSingleGame()
    {
        p1Turn = true;
        p1 = new Human(p1Token);
        p2 = new Computer(p2Token);

        for (int i=0; i<9; i++)
            TicTacToe.buttons.get(i).setText("-");
    }

    public void playTurns(ActionEvent event)
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
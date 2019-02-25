import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.util.ArrayList;

abstract public class Game
{
    Player p1;
    Player p2;

    String p1Token;
    String p2Token;

    // Constructor
    public Game()
    {
        p1Token = "X";
        p2Token = "O";

        for (int i=0; i<9; i++)
            TicTacToe.buttons.get(i).setText("-");
    }

    // Set p1 token to new character
    public void setP1Token(String token) throws BadTokenException
    {
        if (token.length() > 1)
            throw new BadTokenException();

        p1Token = token;
        p1 = new Human(p1Token);
    }

    // Set p2 token to new character
    public void setP2Token(String token) throws BadTokenException
    {
        if (token.length() > 1)
            throw new BadTokenException();

        p2Token = token;
        p2 = new Human(p2Token);
    }

    abstract public void playTurns(ActionEvent event);

    // -1: no win
    //  0: tie
    //  1: p1 win
    //  2: p2 win
    public int detectWin(ArrayList<Button> buttons)
    {
        int ret = -1;

        // Check for row-win
        for (int i=0; i<9; i+=3)
        {
            if (buttons.get(i).getText() == buttons.get(i+1).getText() &&
                buttons.get(i).getText() == buttons.get(i+2).getText() )
            {
                if (buttons.get(i).getText().equals(p1Token))
                {
                    ret = 1;
                }
                else if (buttons.get(i).getText().equals(p2Token))
                {
                    ret = 2;
                }
            }
        }
        
        // Check for col-win
        for (int i=0; i<3; i++)
        {
            if (buttons.get(i).getText() == buttons.get(i+3).getText() &&
                buttons.get(i).getText() == buttons.get(i+6).getText())
            {
                if (buttons.get(i).getText().equals(p1Token))
                {
                    ret = 1;
                }
                else if (buttons.get(i).getText().equals(p2Token))
                {
                    ret = 2;
                }
            }
        }

        // Check for dia-win
        for (int i=0; i<3; i+=3)
        {
            if (true)
            {

            }
        }

        return ret;
    }
}
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

class Human extends Player
{
    String token;

    public Human(String token)
    {
        this.token = token;
    }

    public void play(ActionEvent event)
    {
        ((Button) event.getSource()).setText(token);        
    }
}
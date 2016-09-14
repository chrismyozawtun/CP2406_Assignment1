import java.util.ArrayList;
import java.lang.reflect.Array;


/**
 * Created by Mick White #12862610 on 12/09/16.
 */

public class Player {
    private String name;
    private ArrayList <Card> hand;

    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    //retrieve cards for players game play
    public ArrayList getHand(){
        hand = new ArrayList<>();
        return hand;
    }
}

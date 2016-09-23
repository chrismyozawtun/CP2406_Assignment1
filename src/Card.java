/**
 * Created by Mick White #12862610 on 12/09/16.
 */

public abstract class Card {
    protected String name;

    public Card() {
    }

    //create a card
    public Card(String name) {
        this.name = name;
    }

    public abstract String getName();
}
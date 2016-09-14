/**
 * Created by Michael White, #12862610 on 14/09/16.
 */
public class compareHardness {static Deck deck;

//create deck of cards, randomly select 2 adjacent cards and compare their hardness
    public static void main(String[] args) {
//make deck
        deck = new Deck();

//select the first card position number
        int number = getNumber();

        double value = ((MineralCard) deck.cards[number]).getHardness(); //get hardness value of first card
        double value1 = ((MineralCard) deck.cards[number + 1]).getHardness(); //get hardness value of second card

//if value of hardness of first card equals second card
        if(value == value1){

            System.out.println((deck.cards[number]).getName() + " has the same value \"" +
                    ((MineralCard) deck.cards[number]).getHardness() + "\" of Hardness as " + (deck.cards[number + 1]).getName() +
                    " whose value is \"" + ((MineralCard) deck.cards[number + 1]).getHardness() + "\"");

//if value of hardness of first card > than second  card
        } else if (value > value1){

            System.out.println(deck.cards[number].getName() + " has a greater value \"" +
                    ((MineralCard) deck.cards[number]).getHardness() + "\" of Hardness than " + deck.cards[number + 1].getName() +
                    " whose value is \"" + ((MineralCard) deck.cards[number + 1]).getHardness() + "\"");

//if value of hardness of second card > than first card

        } else {

            System.out.println((deck.cards[number + 1]).getName() + " has a greater value \"" +
                    ((MineralCard) deck.cards[number + 1]).getHardness() + "\" of Hardness than " + deck.cards[number].getName() +
                    " whose value is \"" + ((MineralCard) deck.cards[number]).getHardness() + "\"");
        }
    }
    //select 2 adjacent mineral cards in the deck, skip trump cards

    public static int getNumber(){

        int number = 1 + (int)(Math.random() * 59);


        while(deck.cards[number].getName().startsWith("The ") ||
                deck.cards[number + 1].getName().startsWith("The ")){ //make sure there are no trump cards


            ++number;
            if(number > 59) {
                number = 50;
            }
        }
        System.out.println("Card number: " + number);
        return number;
    }

}

import java.util.Arrays;

/**
 * Created by Michael White, #12862610 on 14/09/16.
 */
public class compareCleavage {
    static Deck deck;

    public static void main(String[] args) {
        String[] cleavageHeirarchy = {"none", "poor/none", "1 poor", "2 poor", "1 good",
                "1 good, 1 poor", "2 good", "3 good", "1 perfect", "1 perfect, 1 good",
                "1 perfect, 2 good", "2 perfect, 1 good", "3 perfect", "4 perfect",
                "6 perfect"};

        deck = new Deck();
        int number = getNumber();

        int index1 = Arrays.asList(cleavageHeirarchy).indexOf(((SupertrumpsCard) deck.cards[number]).getCleavage());
        int index2 = Arrays.asList(cleavageHeirarchy).indexOf(((SupertrumpsCard) deck.cards[number + 1]).getCleavage());

// if locations of value in crustal abundance array are equal
        if (index1 == index2){


            System.out.println((deck.cards[number]).getName() + " has the same value \"" +
                    ((SupertrumpsCard) deck.cards[number]).getCleavage() + "\" of Cleavage as " + (deck.cards[number + 1]).getName() +
                    " whose value is \"" + ((SupertrumpsCard) deck.cards[number + 1]).getCleavage() + "\"");

//if locations of value in crustal abundance of first card > than second card
        } else if (index1 > index2){


            System.out.println(deck.cards[number].getName() + " has a greater value \"" +
                    ((SupertrumpsCard) deck.cards[number]).getCleavage() + "\" of Cleavage than " + deck.cards[number + 1].getName() +
                    " whose value is \"" + ((SupertrumpsCard) deck.cards[number + 1]).getCleavage() + "\"");

//if locations of value in crustal abundance of second card > than first card
        } else {


            System.out.println((deck.cards[number + 1]).getName() + " has a greater value \"" +
                    ((SupertrumpsCard) deck.cards[number + 1]).getCleavage() + "\" of Cleavage than " + deck.cards[number].getName() +
                    " whose value is \"" + ((SupertrumpsCard) deck.cards[number]).getCleavage() + "\"");
        }
    }
    //select 2 adjacent mineral cards in the deck, skip trump cards
    public static int getNumber(){


        int number = 1 + (int)(Math.random() * 59);


        while((deck.cards[number]).getName().startsWith("The ") ||
                //make sure there are no trump cards
                (deck.cards[number + 1]).getName().startsWith("The ")){


            ++number;
            if(number > 59) {
                number = 50;
            }
        }
        System.out.println("Card number: " + number);
        return number;
    }
}
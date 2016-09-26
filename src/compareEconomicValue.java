import java.util.Arrays;

/**
 * Created by Michael White, #12862610 on 14/09/16.
 */
public class compareEconomicValue {
    static Deck deck;


    public static void main(String[] args) { //create deck of cards, randomly select 2 adjacent cards and compare their economic value locations in the array


        String [] economicValueHierarchy = {"trivial", "low", "moderate", "high", "very high", "I'm rich!"}; //make economic value array - low to high


        deck = new Deck(); //make deck


        int number = getNumber(); //select the first card position number


        int index1 = Arrays.asList(economicValueHierarchy).indexOf(((SupertrumpsCard) deck.cards[number]).getEconomicValue()); //get index number of 1st card in array
        int index2 = Arrays.asList(economicValueHierarchy).indexOf(((SupertrumpsCard) deck.cards[number + 1]).getEconomicValue()); //get index number of 2nd card in array


        if (index1 == index2){ // if locations of value in economic value array are equal


            System.out.println((deck.cards[number]).getName() + " has the same value \"" +
                    ((SupertrumpsCard) deck.cards[number]).getEconomicValue() + "\" of Economic Value as " + (deck.cards[number + 1]).getName() +
                    " whose value is \"" + ((SupertrumpsCard) deck.cards[number + 1]).getEconomicValue() + "\"");


        } else if (index1 > index2){ //if locations of value in crustal abundance of first card > than second card


            System.out.println(deck.cards[number].getName() + " has a greater value \"" +
                    ((SupertrumpsCard) deck.cards[number]).getEconomicValue() + "\" of Economic Value than " + deck.cards[number + 1].getName() +
                    " whose value is \"" + ((SupertrumpsCard) deck.cards[number + 1]).getEconomicValue() + "\"");


        } else { //if locations of value in crustal abundance of second card > than first card


            System.out.println((deck.cards[number + 1]).getName() + " has a greater value \"" +
                    ((SupertrumpsCard) deck.cards[number + 1]).getEconomicValue() + "\" of Economic Value than " + deck.cards[number].getName() +
                    " whose value is \"" + ((SupertrumpsCard) deck.cards[number]).getEconomicValue() + "\"");
        }
    }
    public static int getNumber(){ //select 2 adjacent mineral cards in the deck, skip trump cards


        int number = 1 + (int)(Math.random() * 59);


        while((deck.cards[number]).getName().startsWith("The ") ||
                (deck.cards[number + 1]).getName().startsWith("The ")){ //make sure there are no trump cards


            ++number;
            if(number > 59) {
                number = 50;
            }
        }
        System.out.println("Card number: " + number);
        return number;
    }

}

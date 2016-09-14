import com.sun.codemodel.internal.JOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.*;

/**
 * Created by Mick White #12862610 on 12/09/16.
 */
public class Play {

    static String [] playerNames;
    static String playerOrder;
    static ArrayList <Card> hand;
    static ArrayList <Card> discardedCards;
    static Card activeCard;
    static Scanner input;
    static StringBuilder stringBuilder;
    static Player playerOne;
    static Player playerNameOne;
    static Player playerTwo;
    static Player playerNameTwo;
    static Player playerThree;
    static Player playerNameThree;
    static Player playerFour;
    static Player playerNameFour;
    static Player playerFive;
    static Player playerNameFive;
    static int playerNumber, numberOfPlayers;
    static int playerPosition, gos, compare, playGame;
    static int handCards, category, question, card;
    static String choice, activeCategory;
    static String activeCardNotice, menu;
    static Card[] hold;
    static final int NUMBER_OF_CARDS_PER_HAND = 8;
    static final int MAX_NUMBER_OF_PLAYERS = 5;
    static final double DECK_SIZE = 59;
    static ArrayList <Card> shuffledDeck = new ArrayList<>();
    static Player [] players = new Player [MAX_NUMBER_OF_PLAYERS];
    static String [] cleavageHeirarchy = {"none", "poor/none", "1 poor", "2 poor", "1 good",
            "1 good, 1 poor", "2 good", "3 good", "1 perfect", "1 perfect, 1 good", "1 perfect, 2 good",
            "2 perfect, 1 good", "3 perfect", "4 perfect", "6 perfect"};
    static String [] crustalAbundanceHeirarchy = {"ultratrace", "trace", "low", "moderate", "high", "very high"};
    static String [] economicValueHeirarchy = {"trivial", "low", "moderate", "high", "very high", "i'm rich"};
    static String [] categories = {"Hardness", "Specific gravity", "Cleavage", "Crustal Abundance", "Economic Value"};

    public static void main(String[] args){

        //play or not
        playGame = playGameMenu();
        if(playGame ==2){
            //end game
            System.exit(0);
        }

        Deck deck = new deck();
        for (int i= 0;
                i<Deck.DECK_SIZE;
                ++i){
            shuffledDeck.add(deck.cards[i]);
        }

        //Shuffle the deck
        Collections.shuffle(shuffledDeck);

        //enter how many players
        do{
            try{
                System.out.print("Enter the number of players(3-5): ");
                Scanner input = new Scanner(System.in);
                numberOfPlayers = input.nextInt();
            }
            //make sure entry is a valid number
            catch (Exception e){
                System.out.print("You must enter a number - ");
            }
        }
        while(numberOfPlayers !=3 && numberOfPlayers !=4 && numberOfPlayers!=5);
        playerNames = new String [numberOfPlayers];
        discardedCards = new ArrayList<>();

        gos = 0;

        //build hands of eight cards for each player
        switch(numberOfPlayers{
            case 3:
                //enter first 3 player names
                enterFirstThreePlayersNames();
                //choose player to go first at random
                playerNumber = (int)(Math.random()*numberOfPlayers);

                //select remaining player sequence
                buildFirstThreePlayers();
                for(int i=0;
                        i<NUMBER_OF_CARDS_PER_HAND;
                        ++i) {
                    fillThreeHands();
                }
                //first player plays
                if (gos==0){
                    displayPlayerSequence();
                    playerWaitToStart();
                    do {
                        category = selectFirstCategory(players[playerNumber]);
                        question = checkCategory(category);
                    }
                    while(question !=0);

                    activeCategory = categories[category];
                    card = selectFirstCard();
                    discardedCards.add(0, hand.get(card));
                    hand.remove(card);
                    activeCard = discardedCards.get(0);
                    activeCardNotice = getActiveCardValues();

                    gos = 1
                    }
                    do{
                        compare = 0;
                        incrementPlayerNumber();
                        playerWaitToStart();

                        do{
                            card = selectPlayerCard(players[playerNumber]);
                            if (card==players[playerNumber].getHand().size())
                                if (shuffledDeck.size() == 0){
                                hold = new Card[1];
                                    hold[0] = discardedCards.get(0);
                                    discardedCards.remove(0);

                                    for(int i = discardedCards.size() -1;
                                            i>0;
                                            --1;
                                    {
                                        shuffledDeck.add(discardedCards.get(i));
                                        discardedCards.remove(i);
                                    }
                                    Collections.shuffle(shuffledDeck);
                                    discardedCards.add(hold[0]);
                                }

                                players[playerNumber].getHand().add(shuffledDeck.get(0));
                            shuffledDeck.remove(0);
                            compare = 1;
                        }
                        else{
                            if (card == players[playerNumber].getHand().size() + 1) {
                                compare = 1;
                            } else {
                                compare = compareValues(hand.get(card), activeCategory);
                                if (compare == 1) {
                                    discardedCards.add(0, hand.get(card));
                                    hand.remove(card);
                                }
                            }
                        }
                    }
                    while(compare == 0);
                activeCard = discardedCards.get(0);
                activeCardNotice = getActiveCardValues();
        }
        while(compare ==0);

        activeCard = discardedCards.get(0);
        activeCardNotice = getActiveCardValues();

        while(playerOne.getHand().size() > 0 &&
                playerTwo.getHand().size()>0 &&
                playerThree.getHand().size()>0);

        if(playerOne.getHand().size() == 0){
            JOptionPane.showMessageDialog(null, "yay!! Congrats on your win!" + playerOne.getName());
        }
        else if(playerTwo.getHand().size()==0){
            JOptionPane.showMessageDialog(null, "yay!! Congrats on your win!" + playerTwo.getName());

        else if(playerThree.getHand().size()==0) {
                JOptionPane.showMessageDialog(null, "yay!! Congrats on your win!" + playerOne.getName());
            }
            System.exit(0);
            break;

        case 4:
            enterFirstThreePlayersNames();
            System.out.print("Enter fourth player name: ");
            input = new Scanner(System.in);
            playerNameFour = input.nextLine();
            playerNames [3] = playerNameFour;

            playerNumber = (int)(Math.random()*numberOfPlayers);

            buildFirstThreePlayers();

            playerFour = new Player(playerNames[playerNumber]);

            for(int i=0;
            i < NUMBER_OF_CARDS_PER_HAND;
            ++i){
                fillThreeHands();
                playerFour.getHand().add(shuffledDeck.get(0);
                shuffledDeck.remove(0);
            }
            break;

        case 5:

            enterFirstThreePlayersNames();
            System.out.print("Enter fourth player name: ");
            input = new Scanner(System.in);
            playerNameFour = input.nextLine();
            playerNames[3] = playerNameFour;

            System.out.print("Enter fifth player name: ");
            input = new Scanner(System.in);
            playerNameFive = input.nextLine();
            playerNames[4] = playerNameFive;

            playerNumber = (int)(Math.random()*numberOfPlayers);

            buildFirstThreePlayers();

            playerFour = new Player(playerNames[playerNumber]);
            players[5] = playerFive;
            incrementPlayerNumber();
            playerFive = new Player(playerNames[playerNumber]);

            for(int i=0;
                    i < NUMBER_OF_CARDS_PER_HAND;
                    ++i){

                fillThreeHands();
                playerFour.getHand().add(shuffledDeck.get(0));
                shuffledDeck.remove(0);
                playerFive.getHand().add(shuffledDeck.get(0);
                shuffledDeck.remove(0);
            }
            break;
        }
    }
    public static int playGameMenu() {
        int number = 0;
        do {
            try {
                menu = JOptionPane.showInputDialog(null, "THE RULES\nThe number of players and your names " +
                        "are enetered firstplease" + "\nThe first player is randomly chosen and the player " +
                        "sequence will be displayed..." + "\nThe first player must select one of the 5 " +
                        "categories then select a card to discard to begin play" + "\nThe active cardname, " +
                        "category and leading vaue are listed at the top of the console" +
                        "\nCategories to choose from are: hardness, Specific Gravity, Cleavage, " +
                        "Crustal Abundance, and economic value" + "\nIf there is no category value, " +
                        "you can discard any card" + "\nValues of Hardness and Specific Gravity are " +
                        "numberical and you can only discard a card with value higher than the one " +
                        "displayed in play" + "\n\n Values of Cleavage from low to high: \"none\", \"poor/none\"," +
                        " \"1 poor\", \"2 poor\", \"1 good\", \"1 good, 1 poor\", \"2 good\", \"3 good\", \n' " +
                        "+ \"1 perfect\" + \"1 perfect, 1 good\", \"1 perfect, 2 good\", \"2 perfect, 1 good\", \"3 perfect\", " +
                        "\"4 perfect\", \"6 perfect\"" + "\n\nValues of Crustal Abundance for low to high: \"ultratrace\", " +
                        "\"trace\", \"low\", \"moderate\", \"high\", \"very high\", \" i'm rich\"" + "\n\nFamiliarise youself " +
                        "with the listed sequences for a moment before play" + "\nTrump Cards reset the category and value"
                        + "\nMake your coice by enetring the number besdie your choice in the slection panel" + "\nIf you " +
                        "cannot throw a card you must pick up" + "\nThen you discard, you must state your card name, active " +
                        "category and value" + "\nIf your sleectionis out of tange or discard is calculated to be smaller " +
                        "than the active value, you will need to choose again" + "\n\nDo you wish to 1.Play Game\n2. Quit Game");

                number = Integer.parseInt(menu);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You must select either 1 or 2.");
            }
        }
        while (number != 1 && number != 2);
        return number;
    }
    //keep cards hidden until each player responds in turn
    public static void playerWaitToStart(){
        JOptionPane.showMessageDialog(null, playerNames[playerNumber] + " press OK when you are ready to play");
    }

    public static void displayPlayerSequence() {
        if (numberOfPlayers == 3) {
            String playerSequence = "The order of play is " +
                    playerNames[playerNumber] + "," +
                    playerNames[incrementPlayerNumber()] + ", " +
                    playerNames[incrementPlayerNumber()];
            JOptionPane.showMessageDialog(null, playerSequence);

        } else if (numberOfPlayers == 4) {
            String playerSequence = "The order of play is " +
                    playerNames[playerNumber] + ", " +
                    playerNames[incrementPlayerNumber()] + ", " +
                    playerNames[incrementPlayerNumber()] + ", " +
                    playerNames[incrementPlayerNumber()];
            JOptionPane.showMessageDialog(null, playerSequence);
        } else if (numberOfPlayers == 5) {
            String playerSequence = "The order of play is " +
                    playerNames[playerNumber] + ", " +
                    playerNames[incrementPlayerNumber()] + ", " +
                    playerNames[incrementPlayerNumber()] + ", " +
                    playerNames[incrementPlayerNumber()] + ", " +
                    playerNames[incrementPlayerNumber()];
            JOptionPane.showMessageDialog(null, playerSequence);
        }
        incrementPlayerNumber();
    }
    //fill first three hands
    public static void fillThreeHands() {
        playerOne.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
        playerTwo.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
        playerThree.getHand().add(shuffledDeck.get(0));
        shuffledDeck.remove(0);
    }

    //player to select card for play
    public static int selectPlayerCard(Player player) {
        hand = player.getHand();
        handCards = player.getHand().size();
        int count = 1;
        int number = 0;
        StringBuilder message = new StringBuilder();

        for (int i = 0;
             i < handCards;
             ++i) {
            String script = "\n" + count + ".  " + player.getHand().get(i);
            message.append(script);
            ++count;
        }
        message.append("\n");
        message.append(count);
        message.append(". Pick a card from the deck");
        message.append(count);
        message.append("\n");
        message.append(++count);
        message.append(". Pass");
        message.append("\n");
        message.append("Please enter a number 1-");
        message.append(count);

        do {
            try {
                choice = JOptionPane.showInputDialog(null, activeCardNotice + "\n" + playerNames[playerNumber] + "'s cards are: " + message);
                number = Integer.parseInt(choice);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You must eneter a number between 1 and " + (handCards + 2));
            }
        }
        while (number < 1 || number > handCards + 2);
        return number - 1;
    }

    //add the names for first three players
    public static void enterFirstThreePlayersNames(){
        System.out.print("Enter player one name: ";
        input = new Scanner(System.in);
        playerNameOne = input.nextLine();
        playerNames[0] = playerNameOne;

        System.out.print("Enter player two name: ";
        input = new Scanner(System.in);
        playerNameTwo = input.nextLine();
        playerNames[1] = playerNameTwo;

        System.out.print("Enter player three name: ";
        input = new Scanner(System.in);
        playerNameThree = input.nextLine();
        playerNames[2] = playerNameThree;


    }

    public static int incrementPlayerNumber() {
        ++playerNumber;
        if (playerNumber > numberOfPlayers - 1) {
            playerNumber = 0;
        }
        return playerNumber;
    }

    public static void buildFirstThreePlayers(){

        playerOne = new Player(playerNames[playerNumber]);
        players[0] = playerOne;
        playerOrder[0] = playerOne.getName();
        incrementPlayerNumber();

        playerTwo = new Player(playerNames[playerNumber]);
        players[1] = playerTwo;
        playerOrder[1] = playerTwo.getName();
        incrementPlayerNumber();

        playerThree = new Player(playerNames[playerNumber]);
        players[2] = playerThree;
        playerOrder[2] = playerThree.getName();
        incrementPlayerNumber();

    }

    public static int selectFirstCategory(Player player) {
        int number = 0;
        hand = player.getHand();
        handCards = player.getHand().size();
        StringBuilder message = new StringBuilder();

        for (int i = 0;
             i < handCards;
             ++i) {
            String script = "\n" + hand.get(i);
            message.append(script);
        }
        message.append("\nPlease choose a category (1-5): \n");
        int count = 1;
        for (int i = 0;
             i < categories.length;
             ++i) {
            message.append(count);
            message.append("  ");
            message.append(categories[i]);
            message.append("  ");
            ++count;
        }
        do {
            try {
                choice = JOptionPane.showInputDialog(null, playerNames[playerNumber] + "'s cards are: " + message);
                number = Integer.parseInt(choice);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please choose a category (1-5): ");
            }
            if (number < 0 || number > categories.length) {
                JOptionPane.showMessageDialog(null, "please enter a number between 1 and " + categories.length);
            }
        }
        while (number < 1 || number > categories.length);
        return number - 1;
    }
    static public int checkCategory(int category){
        return JOptionPane.showConfirmDialog((null, "you have chosen " + categories[category] + "\nare you happy with this choice?","Category accept/reject",JOptionPane.YES_NO_OPTION);
    }


    public static int selectFirstCard(){
        int count = 1;
        int number = 0;
        handCards = hand.size();
        StringBuilder message = new StringBuilder();

        message.append("\nThe active category is ");
        message.append(activeCategory);
        message.append("\n");
        message.append(playerNames[playerNumber]+ "'s cards are: ");

        for(int i = 0;
            i < handCards;
            ++i) {
            String script = "\n" + count + " - " + hand.get(i);
            message.append(script);
            ++count;
        }
        message.append("\nPlease choose a card 1 - ");
        message.append(hand.size());

        do{
            try{
                choice = JOptionPane.showInputDialog(null, message);
                number = Integer.parseInt(choice);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and " +
                        hand.size());
            }
            if(number<0 || number > hand.size()){
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and " +
                        hand.size());
            }
        }
        while (number <1 || number > hand.size() + 2);
        return number - 1;
    }

    static String getActiveCardValues() {
        stringBuilder = new StringBuilder();

        if (activeCard.getName().startsWith("The ")) {
            stringBuilder.append("Active card is: ")
            stringBuilder.append(activeCard.getName());
            if (!((TrumpCard) activeCard).getCategory().equals("all")) {
                activeCategory = ((Trumpcard) activeCard).getCategory();
            }

            if (activeCard.getName().equals("The Geophysicist")) {
                stringBuilder.append("\nYou may also throw the \"Magnetite\" card");
                activeCategory = "Specific Gravity";
            } else if (activeCard.getName().equals("The Geologist")) {
                do {
                    category = selectFirstCategory(players[playerPosition]);
                    question = checkCategory(category);
                }
                while (question != 0);
                activeCategory = categories[category];
            }
            stringBuilder.append("\nThe Active category is: ");
            stringBuilder.append(activeCategory);
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        else {
            stringBuilder.append("Active car is: ");
            stringBuilder.append(activeCard.getName());
            stringBuilder.append(". ");
            stringBuilder.append("\nThe active category is");
            stringBuilder.append(activeCategory);
            stringBuilder.append(".\n");

            if (activeCategory.equals("Hardness")) {
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append("value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getHardness());
            } else if (activeCategory.equals("Specific Gravity")) {
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append("value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getSpecificGravity());
            } else if (activeCategory.equals("Cleavage")) {
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append("value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getCleavage());
            } else if (activeCategory.equals("Crustal Abundance")) {
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append("value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getCrustalAbundance());
            } else if (activeCategory.equals("Economic Value")) {
                stringBuilder.append("Your ");
                stringBuilder.append(activeCategory);
                stringBuilder.append("value needs to be > ");
                stringBuilder.append(((MineralCard) activeCard).getEconomicValue());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


        public static int compareValues(Card card, String checkCategory) {
            if (activeCard.getName().startsWith("The ") || card.getName().startsWith("The ")) {
                compare = 1;
            }

            else if(checkCategory.equals("Hardness")) {
                if (((MineralCard)card).getHardness() > ((MineralCard)activeCard).getHardness()) {
                    compare = 1;
                }
            }
            else if(activeCategory.equals("Specific Gravity")) {
                if (((MineralCard)card).getSpecificGravity() > ((MineralCard)activeCard).getSpecificGravity() || card.getName().equals("Magnetite")){
                    compare = 1;
                }
            }
            else if(activeCategory.equals("Cleavage")) {

                int index1 = Arrays.asList(cleavageHeirarchy).indexOf(((MineralCard)card.getCleavage());
                int index2 = Arrays.asList(cleavageHeirarchy).indexOf(((MineralCard)activeCard.getCleavage());

                if(index1>index2){
                    compare = 1;
                }
            }
            else if(activeCategory.equals("Crustal Abundance")){
                int index1 = Arrays.asList(crustalAbundanceHeirarchy).indexOf(((MineralCard)card.getCrustalAbundance());
                int index2 = Arrays.asList(crustalAbundanceHeirarchy).indexOf(((MineralCard)activeCard.getCrustalAbundance());

                if(index1>index2){
                    compare = 1;
                }
            }
            else if(activeCategory.equals("Economic Value")){
                int index1 = Arrays.asList(economicValueHeirarchy).indexOf(((MineralCard)card.getEconomicValue());
                int index2 = Arrays.asList(economicValueHeirarchy).indexOf(((MineralCard)activeCard.getEconomicValue());

                if(index1>index2){
                    compare = 1;
                }
            }
            return compare;
        }
    }





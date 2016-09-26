import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

/**
 * Created by Mick MBP on 23-Sep-16.
 */

//Offer game play & Select size of game
public class PlayGame {
    public static void main(String[] args) {
        final String MENU = "Would you like to play a game? \ny or n\n>>> ";
        Scanner inputDevice = new Scanner(System.in);
        System.out.println("Welcome to Mineral Super Trumps");

        System.out.print(MENU);
        String userInput = inputDevice.next();
        while (!userInput.toLowerCase().equals("n")) {
            switch (userInput.toLowerCase()) {
                case "y":
                    System.out.print("Total number of players (3, 4 or 5) ");
                    int players = inputDevice.nextInt();
                    startGame(players);
                    break;
            }
            System.out.print(MENU);
            userInput = inputDevice.next();
        }
    }

    //access plist file and shuffle deck
    public static Deck getPlayingCards(){
        ArrayList cardList = loadCards("/Users/admin/IdeaProjects/CP2406_Ass1/MstCards_151021.plist");
        Deck playingCardList = new Deck(cardList);

        for(int i = playingCardList.length() - 1; i > 0; i--){
            SupertrumpsCard currentCard = playingCardList.getCardAtIndex(i);

            if(!currentCard.getType().equals("play") && !currentCard.getType().equals("trump")){
                playingCardList.removeCardAtIndex(i);
            }
        }

        return playingCardList;
    }

//Choose dealer at random - can be machine or earthling
    public static void startGame(int players){
        Random randomGenerator = new Random();
        Deck playingCards = getPlayingCards();
        playingCards.shuffle();

        ArrayList<String> atList = new ArrayList<>();

        for (int i = 0; i < playingCards.length(); i++){
            System.out.println(playingCards.getCardAtIndex(i).getType() + " " + playingCards.getCardAtIndex(i).getTitle());
            if (playingCards.getCardAtIndex(i).getSpecificGravity() != null) {
                if (!atList.contains(playingCards.getCardAtIndex(i).getSpecificGravity())) {
                    atList.add(playingCards.getCardAtIndex(i).getSpecificGravity());
                }
            }
        }
        System.out.println("");
        for(String val : atList){
            System.out.println(val);
        }

        //Create players
        ArrayList<Object>playerList = new ArrayList<>();


        //Add the dealer (random)
        int dealerType = randomGenerator.nextInt(2);
        Boolean humanPlayerCreated = false;
        switch (dealerType){
            case 0:
                playerList.add(new Machine(true));
                break;
            case 1:
                playerList.add(new Earthling(true));
                humanPlayerCreated = true;
                break;
        }
//Add other players
        int humanPlayerPosition = randomGenerator.nextInt(players-1);
        for(int i = 0; i < players - 1; i++){
            if(i != humanPlayerPosition || humanPlayerCreated == true){
                playerList.add(new Machine());
            }else{
                playerList.add(new Earthling());
                humanPlayerCreated = true;
            }
        }


//Random selection of 1 card from card list to each player, 8 times
        if(playerList.get(0) instanceof Machine){
            Machine currentPlayer = (Machine)playerList.get(0);
            Object[] returned = currentPlayer.dealCards(playerList,playingCards);
            playerList = (ArrayList<Object>) returned[0];
            playingCards = (Deck) returned[1];
        }else{
            Earthling currentPlayer = (Earthling)playerList.get(0);
            Object[] returned = currentPlayer.dealCards(playerList,playingCards);
            playerList = (ArrayList<Object>) returned[0];
            playingCards = (Deck) returned[1];
        }
        System.out.println(playerList.size());
        for(int i = 0; i < playerList.size(); i++){
            System.out.println(playerList.get(i).toString());
        }


//PlayGame game
        Boolean EndGame = false;
        Deck playedCards = new Deck();
        int playerPosition = 1;
        String category = "";

        if (playerList.get(playerPosition) instanceof Machine){
            Machine initialPlayer = (Machine)playerList.get(playerPosition);

            Object[] returned = initialPlayer.takeInitialTurn(playedCards);
            playedCards = (Deck)returned[0];
            category = (String)returned[1];

            playerList.set(playerPosition, initialPlayer);
        }else{
            Earthling initialPlayer = (Earthling)playerList.get(playerPosition);

            Object[] returned = initialPlayer.takeInitialTurn(playedCards);
            playedCards = (Deck)returned[0];
            category = (String)returned[1];

            playerList.set(playerPosition, initialPlayer);
        }

        playerPosition += 1;

//check to continue game
        while (EndGame == false){
            if(playerList.get(playerPosition) instanceof Machine){
                Machine currentPlayer = (Machine)playerList.get(playerPosition);

                Object[] returned = currentPlayer.takeTurn(playedCards, playingCards, category);
            }else{
                Earthling currentPlayer = (Earthling)playerList.get(playerPosition);

                Object[] returned = currentPlayer.takeTurn(playedCards,playingCards,category);
                playedCards = (Deck)returned[0];
                playingCards = (Deck)returned[1];
                category = (String)returned[2];
            }

            if (playerPosition == playerList.size() -1){
                playerPosition = 0;
            }else{
                playerPosition += 1;
            }
        }
    }
//Set aside remaining cards for pla

    public static ArrayList loadCards(String xmlPath){

        try{
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(inputFile);
            xmlDocument.getDocumentElement().normalize();

            ArrayList cardList = new ArrayList();

//Get cards from XML
            NodeList cards = xmlDocument.getElementsByTagName("dict");

            for (int i = 1; i < cards.getLength(); i++){
                Node currentItem = cards.item(i);
                NodeList cardAttributeList = currentItem.getChildNodes();

                Map<String, String> cardAttributeDictionary = new HashMap<String, String>();

                for (int j = 0; j < cardAttributeList.getLength() - 2; j++){
                    Node currentAttribute = cardAttributeList.item(j);
                    Node nextAttribute = currentAttribute;

                    for (int h = (j+1); h < cardAttributeList.getLength(); h++){
                        if(cardAttributeList.item(h).getNodeType() == Node.ELEMENT_NODE){
                            nextAttribute = cardAttributeList.item(h);
                            break;
                        }
                    }
//choose category for play, select and display card for play

                    if(currentAttribute.getNodeType() == Node.ELEMENT_NODE){
                        if(currentAttribute.getNodeName().equals("key") && !nextAttribute.getNodeName().equals("key")){

                            if(nextAttribute.getNodeName().equals("string")){
                                cardAttributeDictionary.put(currentAttribute.getTextContent(),nextAttribute.getTextContent());

                            }else if(nextAttribute.getNodeName().equals("array")){
                                NodeList arrayItems = nextAttribute.getChildNodes();
                                String arrayString = "";

                                for (int h = 0; h < arrayItems.getLength(); h++){
                                    if(arrayItems.item(h).getNodeType() == Node.ELEMENT_NODE) {
                                        arrayString += arrayItems.item(h).getTextContent() + ",";
                                    }
                                }

                                arrayString = arrayString.substring(0,arrayString.length()-1);

                                cardAttributeDictionary.put(currentAttribute.getTextContent(), arrayString);
                            }
                        }else if(currentAttribute.getNodeName().equals("key") && currentAttribute.getTextContent().equals("card_type")){
                            cardAttributeDictionary.put(currentAttribute.getTextContent(),nextAttribute.getTextContent());
                        }
                    }
                }
                cardList.add(cardAttributeDictionary);
            }

            return cardList;
        }catch (Exception e){
            System.out.println("Something went wrong while loading the cards.");
            return new ArrayList();
        }
    }
}
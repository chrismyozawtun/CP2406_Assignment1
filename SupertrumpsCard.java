import java.util.Map;

/**
 * Created by Mick MBP on 23-Sep-16.
 */
public class SupertrumpsCard {

    Map<String, String> cardAttributes;

    public SupertrumpsCard(Map<String, String> cardDetails) {
        cardAttributes = cardDetails;
    }

    public String getType() {
        return cardAttributes.get("card_type");
    }

    public String getTitle() {
        return cardAttributes.get("title");
    }


    public String getHardness() {
        return cardAttributes.get("hardness");
    }

    public String getSpecificGravity() {
        return cardAttributes.get("specific_gravity");
    }

    public String getCleavage() {
        return cardAttributes.get("cleavage");
    }

    public String getEconomicValue() {
        return cardAttributes.get("economic_value");
    }

    public String getCrustalAbundance() {
        return cardAttributes.get("crustal_abundance");
    }

    public String getSubtitle() {
        return cardAttributes.get("subtitle");
    }

    public String toString() {
        String occurenceTest = "";
        if (cardAttributes.containsKey("occurrence")) {
            for (int i = 0; i < cardAttributes.get("occurrence").split(",").length; i++) {
                occurenceTest += cardAttributes.get("occurrence").split(",")[i];
            }
        }
        return occurenceTest;
    }
}
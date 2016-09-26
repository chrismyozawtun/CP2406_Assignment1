/**
 * Created by Mick White #12862610 on 12/09/16.
 */
//inherit title from card with other info
public class SupertrumpsCard extends Card {

    private String formula;
    private String classification;
    private String crystalSystem;
    private String occurrence;
    private Double hardness;
    private Double specificGravity;
    private String cleavage;
    private String crustalAbundance;
    private String economicValue;

    //this constructs 10 attributes of each card
    public SupertrumpsCard(String name, String formula, String classification,
                           String crystalSystem, String occurrence, Double hardness,
                           Double specificGravity, String cleavage,
                           String crustalAbundance, String economicValue) {

        super(name);
        this.formula = formula;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrence = occurrence;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
    }
    // retrieve card info
    public String getFormula(){
        return formula;
    }
    public String getClassification(){
        return classification;
    }
    public String getCrystalSystem(){
        return crystalSystem;
    }
    public String getOccurrence(){
        return occurrence;
    }
    public Double getHardness(){
        return hardness;
    }
    public Double getSpecificGravity(){
        return specificGravity;
    }
    public String getCleavage(){
        return cleavage;
    }
    public String getCrustalAbundance(){
        return crustalAbundance;
    }
    public String getEconomicValue(){
        return economicValue;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    //this will print card info
    public String toString(){
        return"Name: " + super.name + ", " + "Hardness: " + hardness +
                ", " + "Specific Gravity: " + specificGravity + ", " +
                "cleavage: " +cleavage + ", " + "Crustal Abundance: " +
                crustalAbundance + ", " + "Economic Value: " +economicValue + '\n';
    }
}

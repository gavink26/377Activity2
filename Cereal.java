import java.util.List;  
import java.util.ArrayList;

public class Cereal {
    private String name;
    private int calories;
    private int protein;
    private int fat;          
    private int sodium;
    private int fiber;
    private int carbohydrates;
    private int sugar;
    private int potassium;
    private int vitamins;
    private int shelf;
    private int weight;
    private double cups;
    private double rating;

    // constructor for initializing cereal details
    public Cereal(String name, int calories, int protein, int fat, int sodium, int fiber, int carbohydrates, 
                  int sugar, int potassium, int vitamins, int shelf, int weight, 
                  double cups, double rating) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;          
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
        this.potassium = potassium;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.rating = rating;
    }
    
    public String getName() {
        return name;
    }

    // Getter for calories
    public int getCalories() {
        return calories;
    }

    // Getter for protein
    public int getProtein() {
        return protein;
    }

    // Getter for fat
    public int getFat() {
        return fat;
    }

    // Getter for sodium
    public int getSodium() {
        return sodium;
    }

    // Getter for fiber
    public int getFiber() {
        return fiber;
    }

    // Getter for carbohydrates
    public int getCarbohydrates() {
        return carbohydrates;
    }

    // Getter for sugar
    public int getSugar() {
        return sugar;
    }

    // Getter for potassium
    public int getPotassium() {
        return potassium;
    }

    // Getter for vitamins
    public int getVitamins() {
        return vitamins;
    }

    // Getter for shelf
    public int getShelf() {
        return shelf;
    }

    // Getter for weight
    public int getWeight() {
        return weight;
    }

    // Getter for cups
    public double getCups() {
        return cups;
    }

    // Getter for rating
    public double getRating() {
        return rating;
    }

    // method to calculate the health score of the cereal
    public double calculateHealthScore() {
        double healthScore = 0;
        healthScore += fiber * 1.5;
        healthScore -= sugar * 2.0;
        healthScore -= calories * 0.05;
        healthScore += protein * 1.0;
        healthScore -= fat * 2.0; 
        healthScore -= sodium * 0.5;
        healthScore += potassium * 0.5;
        healthScore += vitamins * 1.0;

        return healthScore;
    }

    // healthiest cereal method
    public static Cereal getHealthiestCereal(List<Cereal> cereals) {
        Cereal healthiest = cereals.get(0);
        for (Cereal cereal : cereals) {
            if (cereal.calculateHealthScore() > healthiest.calculateHealthScore()) {
                healthiest = cereal;
            }
        }
        return healthiest;
    }

    // unhealthiest cereal method
    public static Cereal getUnhealthiestCereal(List<Cereal> cereals) {
        Cereal unhealthiest = cereals.get(0);
        for (Cereal cereal : cereals) {
            if (cereal.calculateHealthScore() < unhealthiest.calculateHealthScore()) {
                unhealthiest = cereal;
            }
        }
        return unhealthiest;
    }

    // override toString method to display cereal information
    @Override
    public String toString() {
        return "Cereal{name='" + name + "', calories=" + calories + ", protein=" + protein + ", fat=" + fat + ", sodium=" + sodium +
               ", fiber=" + fiber + ", carbohydrates=" + carbohydrates + ", sugar=" + sugar + ", potassium=" + potassium +
               ", vitamins=" + vitamins + ", shelf=" + shelf + ", weight=" + weight + ", cups=" + cups + ", rating=" + rating + '}';
    }

    // main method
    public static void main(String[] args) {
        // Instantiate Cereal objects
        Cereal cereal1 = new Cereal("100% Bran", 70, 4, 1, 130, 10, 5, 6, 280, 25, 3, 1, 0.33, 68.4);
        Cereal cereal2 = new Cereal("Cheerios", 110, 6, 2, 290, 2, 17, 1, 105, 25, 1, 1, 1.25, 50.8);
        Cereal cereal3 = new Cereal("Cocoa Puffs", 110, 1, 1, 180, 0, 12, 13, 55, 25, 2, 1, 1.0, 22.7);

        // add cereals to a list
        List<Cereal> cereals = new ArrayList<>();
        cereals.add(cereal1);
        cereals.add(cereal2);
        cereals.add(cereal3);

        // print details of each cereal and its health score
        for (Cereal cereal : cereals) {
            System.out.println(cereal);
            System.out.println("Health Score: " + cereal.calculateHealthScore());
            System.out.println("====================================");
        }

        // find the healthiest and unhealthiest cereals
        Cereal healthiest = Cereal.getHealthiestCereal(cereals);
        Cereal unhealthiest = Cereal.getUnhealthiestCereal(cereals);

        // output the healthiest and unhealthiest cereals
        System.out.println("The healthiest cereal is: " + healthiest.getName());
        System.out.println("The unhealthiest cereal is: " + unhealthiest.getName());
    }
}

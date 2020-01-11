package entity;

import javax.persistence.Entity;

@Entity(name = "washingmachines")
public class WashingMachine extends ElectricityItem {
    int maxClothesWeight;

    public WashingMachine() { }

    public WashingMachine(String name, int power, int maxClothesWeight, double rentCost, double totalCost) {
        super(power, totalCost);
        super.name = name;
        this.maxClothesWeight = maxClothesWeight;
    }

    public int getMaxClothesWeight() {
        return maxClothesWeight;
    }
}

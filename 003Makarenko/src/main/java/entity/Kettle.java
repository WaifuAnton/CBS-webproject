package entity;

import javax.persistence.Entity;

@Entity(name = "kettles")
public class Kettle extends ElectricityItem {
    int liters;

    public Kettle() { }

    public Kettle(String name, int power, int liters, double rentCost, double totalCost) {
        super(power, totalCost);
        super.name = name;
        this.liters = liters;
    }

    public int getLiters() {
        return liters;
    }
}

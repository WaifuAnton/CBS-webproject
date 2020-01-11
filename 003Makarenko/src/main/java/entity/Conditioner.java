package entity;

import javax.persistence.Entity;

@Entity(name = "conditioners")
public class Conditioner extends ElectricityItem {
    private int minTemperature, maxTemperature;

    public Conditioner() { }

    public Conditioner(String name, int power, int minTemperature, int maxTemperature, double rentConst, double totalCost) {
        super(power, totalCost);
        super.name = name;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}

package entity;

import javax.persistence.*;

@Entity(name = "items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ElectricityItem implements Comparable<ElectricityItem> {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id = 0;
    private int power = 0;
    protected String name = "unknown";
    private double rentCost = 0;
    private String type = getClass().getName();
    private String usedBy = "none";

    public ElectricityItem() {
        type = type.substring(type.lastIndexOf('.') + 1);
    }

    public ElectricityItem(int power, double rentCost) {
        this.power = power;
        this.rentCost = rentCost;
        type = type.substring(type.lastIndexOf('.') + 1);
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double totalCost) {
        this.rentCost = totalCost;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(String usedBy) {
        this.usedBy = usedBy;
    }

    @Override
    public int compareTo(ElectricityItem o) {
        return power - o.power;
    }

    public String getType() {
        return type;
    }
}

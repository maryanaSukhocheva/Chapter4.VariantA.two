package chapter4.varianta.two.entities;

import chapter4.varianta.two.action.Utils;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Wheel extends CarPart {
    private final static String PART_TYPE = "Колесо";
    private int diam;    // diam in inches
    private int spokes;  // number of spokes
   private String type; // casted, hammered,

    /**
    * Empty constructor. Constructs some wheel
    * TODO replace with WheelBuilder.class
    */
    public Wheel() {
        super();
    }
    
    /**
     * Copy constructor. Creates another copy of wheel
     * @param other - given Wheel to copy
     */
    public Wheel(Wheel other) {
        super();
        super.setBrand(other.brand)
                .setDescription(other.description)
                .setPartNumber(other.partNumber)
                .setPrice(other.price)
                .setWeight(other.weight);
        this.diam = other.diam;
        this.spokes = other.spokes;
        this.type = other.type;
    }   
    // Setters
    public Wheel setBrand(String brand) {
        super.setBrand(brand);
        return this;
    }

    public Wheel setPartNumber(String partNumber) {
        super.setPartNumber(partNumber);
        return this;
    }

    public Wheel setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    public Wheel setWeight(float weight) {
        super.setWeight(weight);
        return this;
    }

    public Wheel setPrice(float price) {
        super.setPrice(price);
        return this;
    }

    public Wheel setDiam(int diam) {
        Utils.checkIfMoreThanZero(diam,"wheel diameter should be more them zero! Actually given: ");
        this.diam = diam;
        return this;
    }

    public Wheel setSpokes(int spokes) {
        Utils.checkNotNegative(spokes, "spokes number can not be negative! Actually given: ");
        this.spokes = spokes;
        return this;
    }

    public Wheel setType(String type) {
        this.type = type;
        return this;
    }

    // Getters
    public int getDiam() {
        return diam;
    }

    public int getSpokes() {
        return spokes;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Wheel wheel = (Wheel) o;
        return (diam == wheel.diam) && (spokes == wheel.spokes) && (type.equals(wheel.type));
    }

    @Override
    public int hashCode() {
        int result = diam;
        result = 13 * result + spokes;
        result = 13 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(String.format("%-15s","Колесо: "))
                .append(super.toString())
                .append(String.format(", диаметр:%3d\", %2d спиц, %7s",diam,spokes,type));
        return sb.toString();
    }

     
}

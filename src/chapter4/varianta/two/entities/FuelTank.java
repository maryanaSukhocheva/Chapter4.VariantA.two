package chapter4.varianta.two.entities;

import chapter4.varianta.two.action.Utils;

/**
 *
 * @author Sukhocheva Maryana
 */
public class FuelTank extends CarPart {
    private int volume;
    private int filledTo;

    /**
     * Empty constructor. Creates new fuel tank
     * TODO replace with FuelTankBuilder.class
     */
    public FuelTank(int volume) {
        super();
        Utils.checkIfMoreThanZero(volume, "volume of tank should be more them zero! Actually given: ");
        this.volume = volume;
        this.filledTo = 0;
    }

    // Setters
    public FuelTank setBrand(String brand) {
        super.setBrand(brand);
        return this;
    }

    public FuelTank setPartNumber(String partNumber) {
        super.setPartNumber(partNumber);
        return this;
    }

    public FuelTank setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    public FuelTank setWeight(float weight) {
        super.setWeight(weight);
        return this;
    }

    public FuelTank setPrice(float price) {
        super.setPrice(price);
        return this;
    }

    public void setFilledTo(int filledTo) {
        this.filledTo = filledTo;
    }

   



    // Getters
    public int getVolume() {
        return volume;
    }

    public int getFilledTo() {
        return filledTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FuelTank fuelTank = (FuelTank) o;

        if (getVolume() != fuelTank.getVolume()) return false;
        return getFilledTo() == fuelTank.getFilledTo();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + getVolume();
    result = 37 * result + getFilledTo();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(String.format("%-15s","Топливный бак: "))
                .append(super.toString())
                .append(String.format(", объем %-1d литров", volume));
        return sb.toString();
    }   
}

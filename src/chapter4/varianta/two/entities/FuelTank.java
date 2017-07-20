package chapter4.varianta.two.entities;

import chapter4.varianta.two.action.Utils;

/**
 *
 * @author SLAVA
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

   

    /**
     * Fills tank with given quantity if it's possible
     * @param fuelQuantity - given int quantity in liters to fill
     * @return - int resulting quantity after filling (or the same if filling didn't happened)
     */
    public int fill (int fuelQuantity) {
        if (filledTo + fuelQuantity <= volume) {
            filledTo +=fuelQuantity;
            System.out.println("Топливо заправлено. Теперь в баке " + filledTo + " литров топлива.");
            return filledTo;
        } else {
            System.out.println("Такое количество топлива не поместится в бак. Можно залить только " + String.valueOf(volume-filledTo));
            return filledTo;
        }
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

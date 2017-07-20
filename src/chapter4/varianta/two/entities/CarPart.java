package chapter4.varianta.two.entities;

import chapter4.varianta.two.action.Utils;

/**
 *
 * @author SLAVA
 */
public class CarPart {
     //protected int id;
    protected String brand;
    protected String partNumber;
    protected String description;
    protected float weight;
    protected float price;

    /**
     * Empty constructor
     * TODO replace with CarPartBuilder.class
     */
    public CarPart( ) {
        this.brand = new String();
        this.partNumber = new String();
        this.description = new String();
        this.weight = +0.0f;
        this.price = +0.0f;
    }

    /**
     * BEGIN of builder-like Setters FOR ALL FIELDS of carPart
     * TODO replace with by CarPartBuilder class
     */
    public CarPart setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarPart setPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public CarPart setDescription(String description) {
        this.description = description;
        return this;
    }

    public CarPart setWeight(float weight) {
        Utils.checkNotNegative(weight, "Weight cannot be negative! Actually given: ");
        this.weight = weight;
        return this;
    }

    public CarPart setPrice(float price) {
        Utils.checkNotNegative(price, "Price cannot be negative. Actually given: ");
        this.price = price;
        return this;
    }
 
    public String getBrand() {
        return brand;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getDescription() {
        return description;
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }
    /**
     * END of getters
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPart carPart = (CarPart) o;

        if (Float.compare(carPart.weight, weight) != 0) return false;
        if (Float.compare(carPart.price, price) != 0) return false;
        if (!brand.equals(carPart.brand)) return false;
        if (!partNumber.equals(carPart.partNumber)) return false;
        return description.equals(carPart.description);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 7 * result + partNumber.hashCode();
        result = 7 * result + description.hashCode();
        result = 7 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 7 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Арт№:%10s | Бренд:%10s | Вес:%10.2f | Цена:%10.2f | Описание:%s",brand,partNumber,weight,price,description));
        return sb.toString();
    }
}

package chapter4.varianta.two.entities;

import chapter4.varianta.two.action.ActionWithCar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Car {
     public static final String NEW_LINE = System.getProperty("line.separator");
    private String brand;
    private String model;
    List<CarPart> carParts = new ArrayList<CarPart>(0);
    private int engineIndex;                                // Index of engine in list of parts
    private int fuelTankIndex;                              // Index of fuel tank in list of parts
    private int fuelLevel;                                  // Current quatity of fuel

    /**
     * Default constructor
     * @param brand - String with given brand of car
     * @param model - String with given model of car
     */
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart> carParts) {
        this.carParts = carParts;
    }

    public int getEngineIndex() {
        return engineIndex;
    }

    public void setEngineIndex(int engineIndex) {
        this.engineIndex = engineIndex;
    }

    public int getFuelTankIndex() {
        return fuelTankIndex;
    }

    public void setFuelTankIndex(int fuelTankIndex) {
        this.fuelTankIndex = fuelTankIndex;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (!brand.equals(car.brand)) return false;
        if (!model.equals(car.model)) return false;
        return getCarParts().equals(car.getCarParts());

    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 13 * result + model.hashCode();
        result = 13 * result + getCarParts().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Автомобиль. Марка: ");
        sb.append(String.format("Автомобиль. Марка:%-10s, модель:%-10s, всего деталей: %-3s",brand,model,ActionWithCar.getTotalPartsQuantity(this)));
        for (CarPart carPart : carParts) {
            sb.append(NEW_LINE).append(carPart.toString());
        }
        return sb.toString();
    }
}

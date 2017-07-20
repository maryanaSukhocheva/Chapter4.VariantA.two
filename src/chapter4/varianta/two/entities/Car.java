package chapter4.varianta.two.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SLAVA
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

    /**
     * Adds CarPart to list of parts
     * @param part - given CarPart obj to add
     */
    public void addPart (CarPart part) {
        // TODO need to check if maxQuantity will not be exceeded
        this.carParts.add(part);
    }

    /**
     * Finds fist part of given type in car
     * @param part - given CarPart to find
     * @return - first CarPart obj in list with the same type as given, or null is no such part
     */
    public CarPart findPartByType (CarPart part) {
        for (CarPart carPart : carParts) {
            if (carPart.getClass().isInstance(part)){
                return carPart;
            }
        }
        return null;
    }
    //TODO need findAllByType(CarPart carpart) to make possible to change specific part of several

    /**
     * Removes some given part in car with other
     * @param oldPart - CarPart obj is car's part list to replace with new one
     * @param newPart - new CarPart obj to replace the old one with
     */
    public void replacePart(CarPart oldPart, CarPart newPart) {
        if (!oldPart.getClass().isInstance(newPart)) {
            throw new IllegalArgumentException("can not replace parts of different types.");
        }
        if (!this.hasAPart(oldPart)) {
            throw new IllegalArgumentException("given part not found on this car.");
        }
        if (this.findPartByType(oldPart) != null) {
            int index = carParts.indexOf(oldPart);
            this.carParts.set(index,newPart);
        }
    }

    /**
     * Checks if part of given type is present in car's part list
     * @param part - given CarPart obj to check presence
     * @return - true if there is at least 1 part in the list
     */
    public boolean hasAPart(CarPart part) {
        if (this.carParts.contains(part)) {
            return true;
        }
        for (CarPart carPart : carParts) {
            if (carPart.getClass().isInstance(part)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates quantity of parts of given type in the car's part list
     * @param part - given CarPart obj
     * @return - int quantity of parts of given type in the list
     */
    public int getCurPartQuantity (CarPart part){
        int result = 0;
        for (CarPart carPart : carParts) {
            if (carPart.getClass().isInstance(part)){
                result++;
            }
        }
        return result;
    }

    /**
     * Getter for the whole part list
      * @return list of CarParts of car
     */
    public List<CarPart> getCarParts() {
        return carParts;
    }

    /**
     * Getter of total quantity of parts
     * @return - int total quantity
     */
    public int getTotalPartsQuantity() {
        return carParts.size();
    }

    /**
     * Makes car go if all conditions allowing
     */
    public void go() {
        Wheel wheel = new Wheel();
        if (getCurPartQuantity(wheel) == 0){
            System.out.println("На данном автомобиле нет колес. Установите сначала!");
            return;
        }
        if (fuelTankEmpty()) return;
        Engine engine = (Engine) carParts.get(engineIndex);
        if (!engine.isRuning()) {
            System.out.println("Двигатель выключен. Заведите сначала!");
            return;
        }
        System.out.println("Автомобиль поехал");
    }

    /**
     * Starts engine if all conditions allowing
     */
    public void startEngine (){
        Engine engine = new Engine();
        if (this.hasAPart(engine)) {
            if (fuelTankEmpty()) {
                System.out.println("Не заводится");
                return;
            }
            for (CarPart carPart : carParts) {
                if (carPart instanceof Engine){
                    engine = (Engine) carPart;
                    engine.start();
                    engineIndex = carParts.indexOf(engine);
                }
            }
        } else {
            System.out.println("На данном автомобиле отсутствует двигатель. Установите сначала!");
        }
    }

    /**
     * Checks if fuel tank is empty
     * @return true quantity of fuel in fuel tank is zero
     */
    private boolean fuelTankEmpty() {
        if (fuelLevel == 0) {
            System.out.println("В баке недостаточно топлива! Заправьте сначала!");
            return true;
        }
        return false;
    }

    /**
     * Fills fuel tank if all conditions allowing
     * @param fuelQauntity given quantity of fuel to fill tank with
     */
    public void fillFuelTank (int fuelQauntity) {
        FuelTank fuelTank = new FuelTank(1);
        if (this.hasAPart(fuelTank)) {
            for (CarPart carPart : carParts) {
                if (carPart instanceof FuelTank){
                    fuelTank = (FuelTank) carPart;
                    fuelLevel = fuelTank.fill(fuelQauntity);
                    fuelTankIndex = carParts.indexOf(fuelTank);
                }
            }
        } else {
            System.out.println("На данном автомобиле отсутствует топливный бак. Установите сначала!");
        }
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
        sb.append(String.format("Автомобиль. Марка:%-10s, модель:%-10s, всего деталей: %-3s",brand,model,getTotalPartsQuantity()));
        for (CarPart carPart : carParts) {
            sb.append(NEW_LINE).append(carPart.toString());
        }
        return sb.toString();
    }
}

package chapter4.varianta.two.action;

import chapter4.varianta.two.entities.Car;
import chapter4.varianta.two.entities.CarPart;
import chapter4.varianta.two.entities.Engine;
import chapter4.varianta.two.entities.FuelTank;
import chapter4.varianta.two.entities.Wheel;
import java.util.List;

/**
 *
 * @author Sukhocheva Maryana
 */
public class ActionWithCar {
    /**
     * Adds CarPart to list of parts
     * @param part - given CarPart obj to add
     */
    public static void addPart (Car car,CarPart part) {
        // TODO need to check if maxQuantity will not be exceeded
        car.getCarParts().add(part);
    }

    /**
     * Finds fist part of given type in car
     * @param part - given CarPart to find
     * @return - first CarPart obj in list with the same type as given, or null is no such part
     */
    public static CarPart findPartByType (Car car, CarPart part) {
        for (CarPart carPart : car.getCarParts()) {
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
    public static void replacePart(Car car, CarPart oldPart, CarPart newPart) {
        if (!oldPart.getClass().isInstance(newPart)) {
            throw new IllegalArgumentException("can not replace parts of different types.");
        }
        if (!hasAPart(car, oldPart)) {
            throw new IllegalArgumentException("given part not found on car car.");
        }
        if (findPartByType(car,oldPart) != null) {
            int index = car.getCarParts().indexOf(oldPart);
            car.getCarParts().set(index,newPart);
        }
    }

    /**
     * Checks if part of given type is present in car's part list
     * @param part - given CarPart obj to check presence
     * @return - true if there is at least 1 part in the list
     */
    public static boolean hasAPart(Car car, CarPart part) {
        if (car.getCarParts().contains(part)) {
            return true;
        }
        for (CarPart carPart : car.getCarParts()) {
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
    public static int getCurPartQuantity (Car car, CarPart part){
        int result = 0;
        for (CarPart carPart : car.getCarParts()) {
            if (carPart.getClass().isInstance(part)){
                result++;
            }
        }
        return result;
    }


    /**
     * Getter of total quantity of parts
     * @return - int total quantity
     */
    public static int getTotalPartsQuantity(Car car) {
        return car.getCarParts().size();
    }

    /**
     * Makes car go if all conditions allowing
     */
    public static void go(Car car) {
        Wheel wheel = new Wheel();
        if (getCurPartQuantity(car, wheel) == 0){
            System.out.println("На данном автомобиле нет колес. Установите сначала!");
            return;
        }
        if (fuelTankEmpty(car)) return;
        Engine engine = (Engine) car.getCarParts().get(car.getEngineIndex());
        if (!engine.isRunning()) {
            System.out.println("Двигатель выключен. Заведите сначала!");
            return;
        }
        System.out.println("Автомобиль поехал");
    }

    /**
     * Starts engine if all conditions allowing
     */
    public static void startEngine (Car car){
        Engine engine = new Engine();
        if (hasAPart(car, engine)) {
            if (fuelTankEmpty(car)) {
                System.out.println("Не заводится");
                return;
            }
            for (CarPart carPart : car.getCarParts()) {
                if (carPart instanceof Engine){
                    engine = (Engine) carPart;
                    ActionWithEngine.start(engine);
                    car.setEngineIndex(car.getCarParts().indexOf(engine));
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
    private static boolean fuelTankEmpty(Car car) {
        if (car.getFuelLevel() == 0) {
            System.out.println("В баке недостаточно топлива! Заправьте сначала!");
            return true;
        }
        return false;
    }

    /**
     * Fills fuel tank if all conditions allowing
     * @param fuelQauntity given quantity of fuel to fill tank with
     */
    public static void fillFuelTank (Car car, int fuelQauntity) {
        FuelTank fuelTank = new FuelTank(1);
        if (hasAPart(car, fuelTank)) {
            for (CarPart carPart : car.getCarParts()) {
                if (carPart instanceof FuelTank){
                    fuelTank = (FuelTank) carPart;
                    car.setFuelLevel(ActionWithFuelTank.fill(fuelTank, fuelQauntity));
                    car.setFuelTankIndex(car.getCarParts().indexOf(fuelTank));
                }
            }
        } else {
            System.out.println("На данном автомобиле отсутствует топливный бак. Установите сначала!");
        }
    }

}

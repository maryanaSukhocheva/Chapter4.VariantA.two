
package chapter4.varianta.two.action;

import chapter4.varianta.two.entities.FuelTank;

/**
 *
 * @author Sukhocheva Maryana
 */
public class ActionWithFuelTank {
        /**
     * Fills tank with given quantity if it's possible
     * @param fuelQuantity - given int quantity in liters to fill
     * @return - int resulting quantity after filling (or the same if filling didn't happened)
     */
    public static int fill (FuelTank fuelTank,int fuelQuantity) {
        
        if (fuelTank.getFilledTo() + fuelQuantity <= fuelTank.getVolume()) {
            fuelTank.setFilledTo(fuelTank.getFilledTo() + fuelQuantity);
            System.out.println("Топливо заправлено. Теперь в баке " + fuelTank.getFilledTo() + " литров топлива.");
            return fuelTank.getFilledTo();
        } else {
            System.out.println("Такое количество топлива не поместится в бак. Можно залить только " + String.valueOf(fuelTank.getVolume()-fuelTank.getFilledTo()));
            return fuelTank.getFilledTo();
        }
    }
}

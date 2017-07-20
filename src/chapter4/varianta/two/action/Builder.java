
package chapter4.varianta.two.action;

import chapter4.varianta.two.entities.Engine;
import chapter4.varianta.two.entities.FuelTank;
import chapter4.varianta.two.entities.Wheel;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Builder {
    
    //Creating engine
    public Engine buildEngine(String brand, String description, String partNumber,int price, int weight, int cylinders, float volume)  {
        Engine engine = new Engine(); 
                if (brand!=null && !brand.isEmpty() && description!=null && !description.isEmpty() && weight>=0 &&
                       cylinders>=0 && price>=0 && partNumber!=null && !partNumber.isEmpty() && volume>=0) {
                        engine.setBrand(brand);
                        engine.setDescription(description);
                        engine.setPartNumber(partNumber);
                        engine.setPrice(price);
                        engine.setWeight(weight);
                        engine.setCylinders(cylinders);
                        engine.setVolume(volume);
                } else {
             System.out.println("Parametrs incorrect");
        }

        return engine;
    }
    
    public FuelTank buildFuelTank(int volume, String brand, String partNumber,String description, int price, int weight)  {
        FuelTank tank = new FuelTank(volume);
            if (brand!=null && !brand.isEmpty() && description!=null && !description.isEmpty() && 
                    partNumber!=null && !partNumber.isEmpty() &&weight>=0 && price>=0) {
                           
                tank.setBrand(brand);                             
                tank.setDescription(description);
                tank.setPartNumber(partNumber);
                tank.setPrice(price);
                tank.setWeight(weight);  
            } else {
             System.out.println("Parametrs incorrect");
        }

        return tank;
    }
    
    public Wheel buildWheel(String brand, String description, String partNumber,int price, int weight, int diam, int spokes, String type)  {
        Wheel wheel = new Wheel();
                 if (brand!=null && !brand.isEmpty() && description!=null && !description.isEmpty() && weight>=0 &&
                       diam>=0 && price>=0 && partNumber!=null && !partNumber.isEmpty() && spokes>=0 && type!=null && !type.isEmpty()) {
                    wheel.setBrand(brand);
                    wheel.setDescription(description);
                    wheel.setPartNumber(partNumber);
                    wheel.setPrice(price);
                    wheel.setWeight(weight);
                    wheel.setDiam(diam);
                    wheel.setSpokes(spokes);
                    wheel.setType(type);
                } else {
             System.out.println("Parametrs incorrect");
        }

        return wheel;
    }
}

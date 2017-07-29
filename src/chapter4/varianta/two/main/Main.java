package chapter4.varianta.two.main;

import chapter4.varianta.two.action.ActionWithCar;
import chapter4.varianta.two.action.Builder;
import chapter4.varianta.two.entities.Car;
import chapter4.varianta.two.entities.Engine;
import chapter4.varianta.two.entities.FuelTank;
import chapter4.varianta.two.entities.Wheel;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Main {
    public static final String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        // Create car
        System.out.println("Создали автомобиль.");
        Car someCar = new Car("VW", "Golf-VII");
        // Print current state of car
        System.out.println(someCar.toString());

        // Let's try to start engine
        System.out.println(NEW_LINE + "Пробуем завести.");
        ActionWithCar.startEngine(someCar);                              

        // Create and install (just add actually:) ) engine
        System.out.println(NEW_LINE + "Создадим двигатель, установим и пробуем снова завести.");
        Builder builder = new Builder();
        Engine v6engine = builder.buildEngine("VW", "Motor engine", "010101", 1000, 125, 6, 2.6f);
        ActionWithCar.addPart(someCar, v6engine);

        // Print current state of car
        System.out.println(someCar.toString());

        // Let's try to start engine
        System.out.println(NEW_LINE + "Пробуем завести.");
        ActionWithCar.startEngine(someCar);                            

        // Let's try to fill fuel tank
        System.out.println(NEW_LINE + "Пробуем заправить.");
        //someCar.fillFuelTank(-5);                       
        ActionWithCar.fillFuelTank(someCar, 5);                          

        // Create and install (just add actually:) ) fuel tank
        System.out.println(NEW_LINE + "Создадим топливный бак, установим и пробуем заправить.");
        FuelTank tank = builder.buildFuelTank(65,"-", "Fuel tank VW Golf VI-VII", "0103422424", 300, 5);
        ActionWithCar.addPart(someCar, tank);
        
        // Print current state of car
        System.out.println(someCar.toString());

        // Let's try to fill tank with quantity exceeding volume of tank
        System.out.println(NEW_LINE + "Пробуем заправить 75 литров.");
        ActionWithCar.fillFuelTank(someCar,75);                          
        // 20 liters should be OK
        System.out.println("Пробуем заправить 20 литров.");
        ActionWithCar.fillFuelTank(someCar,20);

        // Let's try to drive
        System.out.println(NEW_LINE + "Вроде все - пробуем поехать.");
        ActionWithCar.go(someCar);                                       

        // Create 4 wheels
        System.out.println(NEW_LINE + "Создадим колесо и установим 4 штуки на авто.");
        Wheel wheel = builder.buildWheel("BBS", "модель RW", "0103RW17", 150, 11, 17, 5, "casted");
        ActionWithCar.addPart(someCar, wheel);           
        ActionWithCar.addPart(someCar, new Wheel(wheel));
        ActionWithCar.addPart(someCar, new Wheel(wheel));
        ActionWithCar.addPart(someCar, new Wheel(wheel));

        System.out.println(someCar.toString());

        // Let's change 1 wheel
        Wheel otherWheel = builder.buildWheel("BBS", "модель SR", "03443SR17", 300, 10, 17, 0, "casted");
        System.out.println(NEW_LINE + "Сменим одно колесо на другое.");

        // Replacing Wheel as a CarPart
        ActionWithCar.replacePart(someCar, wheel,otherWheel);

        // Print current state of car
        System.out.println(someCar.toString());

        // Let's try to drive
        System.out.println(NEW_LINE + "Пробуем поехать.");
        ActionWithCar.go(someCar);                                     

        // Let's try to start engine and drive
        System.out.println(NEW_LINE +"Пробуем завести.");
        ActionWithCar.startEngine(someCar);
        ActionWithCar.go(someCar);                                     

    }

}

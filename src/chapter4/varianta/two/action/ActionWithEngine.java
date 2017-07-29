package chapter4.varianta.two.action;

import chapter4.varianta.two.entities.Engine;

/**
 *
 * @author Sukhocheva Maryana
 */
public class ActionWithEngine {
     /**
     * Starts engine if it's not running yet
     */
    public static void start(Engine engine) {
        if (!engine.isRunning()) {
            System.out.println("Работает двигатель.");
            engine.setIsRunning(true);
        } else {
            System.out.println("Двигатель УЖЕ работает. Заводить не нужно.");
        }
    }

 

    /**
     * Stops engine if it was running
     */
    public static void stop(Engine engine){
        if (engine.isRunning()) {
            System.out.println("Двигатель остановлен");
            engine.setIsRunning(false);
        } else {
            System.out.println("Двигатель не был заведен - останавливать не нужно.");
        }
    }
}

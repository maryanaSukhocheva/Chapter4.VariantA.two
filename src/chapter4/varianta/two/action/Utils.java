package chapter4.varianta.two.action;

/**
 *
 * @author Sukhocheva Maryana
 */
final public class Utils {
   public Utils(){}

   public static void checkNotNegative(int arg, String message) {
        if (arg < 0) {
            throw new IllegalArgumentException(message + arg);
        }
    }

   
    public static void checkNotNegative(float arg, String message) {
        if (arg < +0.0f) {
            throw new IllegalArgumentException(message + arg);
        }
    }

    public static void checkIfMoreThanZero(int arg, String message) {
        if (arg <= 0) {
            throw new IllegalArgumentException(message + arg);
        }
    }

    public static void checkIfMoreThanZero (float arg, String message) {
        if (arg <= +0.0f) {
            throw new IllegalArgumentException(message + arg);
        }
    }
}

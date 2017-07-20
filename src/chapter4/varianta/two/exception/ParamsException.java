package chapter4.varianta.two.exception;

/**
 *
 * @author Sukhocheva Maryana
 * Исключение, возникающее при некорректно введенных параметрах
 */

public class ParamsException extends Exception{
    public ParamsException()    {
    }

    public ParamsException(String msg) {
       System.err.println(msg);
    }

    public ParamsException(String msg, int typeMessage) {
        if (typeMessage>0 && typeMessage<=3) {
        switch(typeMessage) {
               case 1 :
                        System.out.println(msg);
                        break;
		case 2 :
                        System.err.println(msg);
                        break;
            }
            } else {
                System.err.println("Incorrect type of message");
            }
     }
 }

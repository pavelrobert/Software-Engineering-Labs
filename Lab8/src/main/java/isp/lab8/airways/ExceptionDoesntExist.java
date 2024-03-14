package isp.lab8.airways;

public class ExceptionDoesntExist extends Exception {
    private String message;
    ExceptionDoesntExist(String message)
    {
        super(message);

    }

}

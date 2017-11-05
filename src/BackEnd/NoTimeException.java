package BackEnd;

public class NoTimeException extends Exception {

    private final static String message = "No se puede agregar una clase al mismo tiempo que otra";

    public NoTimeException(){
        super(message);
    }
}
package exceptions;

public class NotInInventoryException extends Exception{
    public NotInInventoryException(String s){
        super(s);
    }
}

public class CannotLoginException extends Exception{
    public CannotLoginException() {}
    
    public CannotLoginException(String error){
        super(error);
        System.out.println(error);
    }
}
public class InvalidPinException extends Exception {
    public InvalidPinException() {}
    
    public InvalidPinException(String s){
        super(s);
        System.out.println(s);
    }
}
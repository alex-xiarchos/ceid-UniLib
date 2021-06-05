 public class NoReceiverException extends Exception{
    public NoReceiverException() {}
    
    public NoReceiverException(String s){
        super(s);
        System.out.println(s);
    }
}
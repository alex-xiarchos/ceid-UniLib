public class InvalidEmailDomainException extends Exception{
    public InvalidEmailDomainException() {}
    
    public InvalidEmailDomainException(String error, Throwable err){
        super(error, err);
        System.out.println(error);
    }
}
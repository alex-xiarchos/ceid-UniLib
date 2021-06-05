public class AlreadyUsedAccountException extends Exception{
    public AlreadyUsedAccountException() {}
    
    public AlreadyUsedAccountException(String error, Throwable err){
        super(error, err);
        System.out.println(error);
    }
}
public class AlreadyUsedAccountException extends Exception{
    public AlreadyUsedAccountException() {}
    
    public AlreadyUsedAccountException(String error){
        super(error);
        System.out.println(error);
    }
}
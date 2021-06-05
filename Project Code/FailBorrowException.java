public class FailBorrowException extends Exception{
    public FailBorrowException() {}
    
    public FailBorrowException(String s){
        super(s);
        System.out.println(s);
    }
}
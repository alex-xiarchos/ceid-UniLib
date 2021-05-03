import java.util.*;

public class BorrowedBook extends book{

    private int user;
    private Date borrow_start_date, borrow_expire_date;
	    
    public BorrowedBook(String idBook,/* String type, String author, String publisher,*/ int user){  
        super(idBook/*, type, author, publisher*/);
        this.user = user;  
        this.borrow_start_date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(borrow_start_date);
        c.add(Calendar.DATE, 15);
        this.borrow_expire_date = c.getTime();
    }  


    public String getIdBook(){
        return idBook;
    }

    public int getUser(){
        return user;
    }

    public Date getBorrowStartDate(){
        return borrow_start_date;
    }

    public Date getBorrowExpireDate(){
        return borrow_expire_date;
    }


    /*public void setIdBook(String idBook){
        this.idBook = idBook;
    }

    public void setUser(int user){
        this.user = user;
    }

    public void setBorrowStartDate(Date borrow_start_date){
        this.borrow_start_date = borrow_start_date;
    }

    public void setBorrowExpireDate(Date borrow_expire_date){
        this.borrow_expire_date = borrow_expire_date;
    }*/
}
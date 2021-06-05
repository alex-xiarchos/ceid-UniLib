public class SearchWarningException extends Exception {
    public SearchWarningException() {

}
    public SearchWarningException(String s) {
        super(s);
        System.out.println(s);
    }
}

abstract class User {
    private String user_name;
    private String user_password;
    private String user_email;

    public User(String user_name, String user_password, String user_email){
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
    }

    public String getName() {
        return user_name;
    }

    public String getPassword() {
        return user_password;
    }

    public String getuEmail() {
        return user_email;
    }
}
public class UniStaff extends User {
    private int staff_id;
    private String department;

    public UniStaff(String staff_name, String staff_password, String staff_email, int staff_id, String department) {
        super(staff_name, staff_password, staff_email);
        this.staff_id = staff_id;
        this.department = department;
    }
}

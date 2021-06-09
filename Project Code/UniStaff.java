public class UniStaff extends User {
    private int staff_id;
    private String department;

    public UniStaff(String staff_name, String staff_email, String staff_password, int staff_id, String department) {
        super(staff_name, staff_email, staff_password);
        this.staff_id = staff_id;
        this.department = department;
    }
}

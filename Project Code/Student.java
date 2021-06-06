public class Student extends User {
    private int student_id;
    private String department;
    private int academic_year;
    private User user;

    public Student(String user_name, String user_email, String user_password, int student_id, String department, int academic_year) {
        super(user_name, user_email, user_password);
        this.student_id = student_id;
        this.department = department;
        this.academic_year = academic_year;
    }

    public int getStudentId() {
        return student_id;
    }

    public String getStudentDepartment() {
        return department;
    }

    public int getStudentAcadYear() {
        return academic_year;
    }
}

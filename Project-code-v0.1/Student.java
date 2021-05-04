public class Student extends User {
    private int student_id;
    private String department;
    private int academic_year;

    public Student(String student_name, String student_password, String student_email, int student_id, String department, int academic_year) {
        super(student_name, student_password, student_email);
        this.student_id = student_id;
        this.department = department;
        this. academic_year = academic_year;
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

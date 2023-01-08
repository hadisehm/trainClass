import tamrin.service.StudentService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentService studentService=new StudentService();
        studentService.getStudentById();
        studentService.getAllStudents();
        studentService.saveStudent();
        studentService.editStudent();
        studentService.removeStudent();

    }
}

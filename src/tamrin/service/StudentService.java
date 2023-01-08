package tamrin.service;

import tamrin.repository.StudentRepository;

public class StudentService {

    public void getStudentById() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.findById();
    }
    public void getAllStudents() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.findAll();
    }
    public void saveStudent() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.insert();
    }
    public void editStudent() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.update();
    }
    public void removeStudent() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.delete();
    }
}

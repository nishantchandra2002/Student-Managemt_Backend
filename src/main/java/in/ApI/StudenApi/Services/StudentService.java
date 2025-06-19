package in.ApI.StudenApi.Services;

import in.ApI.StudenApi.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(String id);

    Student updateStudent(String id, Student student);

    void deleteStudent(String id);
}

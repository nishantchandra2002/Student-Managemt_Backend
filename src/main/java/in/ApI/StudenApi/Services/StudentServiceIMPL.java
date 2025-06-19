package in.ApI.StudenApi.Services;

import in.ApI.StudenApi.Model.Student;
import in.ApI.StudenApi.Repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import in.ApI.StudenApi.Services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceIMPL implements StudentService {
    @Autowired
    private studentRepository sr;

    @Override
    public Student saveStudent(Student student){
        return sr.save(student);
    }
    @Override
    public List<Student> getAllStudents(){
        return sr.findAll();
    }
    @Override
    public Optional<Student>getStudentById(String id){
        return sr.findById(id);
    }
    @Override
    public void deleteStudent(String id) {
        sr.deleteById(id);
    }
    @Override
    public Student updateStudent(String id, Student updatedStudent) {
        Optional<Student> optionalStudent = sr.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            return sr.save(student);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

}

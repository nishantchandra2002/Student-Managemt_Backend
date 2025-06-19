package in.ApI.StudenApi.Controller;
import in.ApI.StudenApi.Model.Student;
import in.ApI.StudenApi.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService ss;


    @PostMapping
    public ResponseEntity<Student>createStudent(@RequestBody Student student){
        Student saved=ss.saveStudent(student);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(ss.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = ss.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        try {
            Student updated = ss.updateStudent(id, student);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        ss.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}

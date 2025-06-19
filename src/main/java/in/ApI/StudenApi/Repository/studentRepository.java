package in.ApI.StudenApi.Repository;

import in.ApI.StudenApi.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentRepository extends MongoRepository<Student, String> {
}
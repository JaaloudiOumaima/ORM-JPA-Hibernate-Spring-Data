package my.university.university.Web;

import my.university.university.entities.Student;
import my.university.university.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsRestService {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/Students")
    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    @GetMapping("/Student/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentsRepository.findById(id).get();
    }

}

package my.university.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import my.university.university.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContains(String c);
    List<Student> findByAgeGreaterThan(double Age);
    @Query("select s from Student s where s.name like :c")
    List<Student> search(@Param("c") String c);
}

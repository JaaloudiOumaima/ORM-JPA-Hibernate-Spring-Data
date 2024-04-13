package my.university.university;

import my.university.university.entities.Student;
import my.university.university.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
	@Autowired
	private StudentsRepository studentsRepository;
	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentsRepository.save(new Student(null,"Oumaima",24,"Women","Tangier"));
		//studentsRepository.save(new Student(null,"Hamza",26,"Men","Casablanca"));
		//studentsRepository.save(new Student(null,"Yassine",28,"Men","Marrakesh"));
		List<Student> studentList= studentsRepository.findAll();
		studentList.forEach(s->{
			System.out.println(s.toString());
		});
		Student student=studentsRepository.findById(Long.valueOf(1)).get();
		System.out.println("**********************");
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println(student.getGender());
		System.out.println(student.getCity());

		System.out.println("********** Test Function findByNameContains ************");
		List<Student> studentList2=studentsRepository.findByNameContains("O");
		studentList2.forEach(s->{
			System.out.println(s.toString());
		});
		System.out.println("********** Test Function Search ************");
		List<Student> studentList3=studentsRepository.search("%H%");
		studentList3.forEach(s->{
			System.out.println(s.toString());
		});
		System.out.println("********** Test Function findByAgeGreaterThan ************");
		List<Student> studentList4=studentsRepository.findByAgeGreaterThan(26);
		studentList4.forEach(s->{
			System.out.println(s.toString());
		});


	}
}

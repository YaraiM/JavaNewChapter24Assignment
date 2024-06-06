package raisetech.student.management.services;

import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourse;
import raisetech.student.management.repository.StudentRepository;

@Service
public class StudentService {

  // 単一のコンストラクタインジェクションであれば@Autowired不要
  private final StudentRepository repository;

  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> search30sStudentList() {
    // 課題：年齢が30代の人のみを年齢降順で取得する
    return repository.search().stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
        .sorted(Comparator.comparingInt(Student::getAge).reversed())
        .toList();
  }

  public List<StudentCourse> searchStudentsJavaCourseList() {
    // 課題：Javaコースの情報のみを受講生ID昇順で取得する
    return repository.searchStudentsCourses().stream()
        .filter(studentCourse -> studentCourse.getCourseName().equals("Java"))
        .sorted(Comparator.comparingInt(StudentCourse::getStudentId))
        .toList();
  }

}

import org.example.Student;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KelasUji {

    private static List<Student> students;

    @BeforeAll
    public static void initClass() {
        students = new ArrayList<>();
        System.out.println("before all is called");
    }

    @AfterAll
    public static void cleanClass() {
        students.clear();
        System.out.println("after all is called");
    }

    @BeforeEach
    public void initMethod() {
        Student student = new Student("fina", 20);
        students.add(student);
        System.out.println("before each is called");
    }

    @AfterEach
    public void cleanMethod() {
        students.clear();
        System.out.println("after each is called");
    }

    @Test
    public void testDataCreation() {
        Student student = students.get(0);
        assertEquals("fina", student.getName());
        assertEquals(20, student.getAge());
        System.out.println("test data creation - passed");
    }

    @Test
    public void testStudentEnrolment() {
        Student student = students.get(0);
        student.enrollCourse("Kimia");
        assertTrue(student.getEnrolledCourses().contains("Kimia"));
        System.out.println("test student enrolment - berhasil");
    }

    @Test
    public void testStudentGrade() {
        Student student = students.get(0);
        student.setGrade("Kimia", "A");
        assertEquals("A", student.getGrade("Kimia"));
        System.out.println("test student grade - berhasil");
    }
}

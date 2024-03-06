import org.example.Calculator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCase {
    public int result = 0;
    @BeforeAll
    public void initialize(){
        System.out.println("before all is called");
    }
    @BeforeEach
    public void setup(){
        System.out.println("before each is called");
    }

    @AfterEach
    public void methodCleanup(){
        System.out.println("after each is called");
    }

    @AfterAll
    public void classCleanup(){
        System.out.println("after all is called");
    }

    @Test
    public void testTambah10(){
        int angka = 10;
        Calculator calculator = new Calculator(result, angka);
        result = calculator.tambah();
        System.out.println("test method 1");
//        Assertions.assertEquals(10, result);
    }

    @Test
    public void testKali10(){
        int kali = 10;
        Calculator calculator = new Calculator(result, kali);
        result = calculator.kali();
        System.out.println("test method 2");
//        Assertions.assertEquals(100, result);
    }
}

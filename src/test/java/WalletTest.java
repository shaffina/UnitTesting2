import org.example.Wallet;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all is called");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all is called");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each is called");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after all is called");
    }
    @Test
    public void testAddMoney() {
        Wallet dompet = new Wallet("anton");
        dompet.addMoney(10000);
        dompet.addMoney(5000);

        assertEquals(1, dompet.getMoneys().get(10000).intValue());
        assertEquals(1, dompet.getMoneys().get(5000).intValue());

        System.out.println("jumlah uang 10000: " + dompet.getMoneys().get(10000));
        System.out.println("jumlah uang 5000: " + dompet.getMoneys().get(5000));

    }

    @Test
    public void testAddCoin() {
        Wallet dompet = new Wallet("anton");
        dompet.addCoin(500);
        dompet.addCoin(100);

        assertEquals(1, dompet.getCoins().get(500).intValue());
        assertEquals(1, dompet.getCoins().get(100).intValue());

        System.out.println("jumlah uang 100: " + dompet.getCoins().get(100));
        System.out.println("jumlah uang 500: " + dompet.getCoins().get(500));

    }

    @Test
    public void testAddCard() {
        Wallet dompet = new Wallet("anton");
        dompet.addCard("Debit");
        dompet.addCard("Tapcash");

        assertEquals(2, dompet.getCards().size());
        assertTrue(dompet.getCards().contains("Tapcash"));
        assertTrue(dompet.getCards().contains("Debit"));

        System.out.println("daftar Kartu: " + dompet.getCards());

    }

    @Test
    public void testTakeMoneys() {
        Wallet dompet = new Wallet("anton");

        dompet.addMoney(1000);
        dompet.addMoney(50000);
        dompet.addMoney(100000);

        dompet.takeMoneys(1000);
        dompet.takeMoneys(50000);

        assertEquals(0, dompet.getMoneys().get(1000).intValue());
        System.out.println("jumlah uang setelah pengambilan: " + dompet.getMoneys());

    }
    @Test
    public void testTakeCoins() {
        Wallet dompet = new Wallet("anton");

        dompet.addCoin(100);
        dompet.addCoin(500);
        dompet.addCoin(1000);

        dompet.takeCoins(100);
        dompet.takeCoins(1000);

        assertEquals(0, dompet.getCoins().get(100).intValue());
        System.out.println("jumlah koin setelah pengambilan: " + dompet.getCoins());
    }

    @Test
    public void testTakeCard() {
        Wallet dompet = new Wallet("anton");


        dompet.addCard("Credit");
        dompet.addCard("Debit");
        dompet.addCard("Tapcash");

        dompet.takeCard("Debit");

        assertEquals(2, dompet.getCards().size());
        assertTrue(dompet.getCards().contains("Credit"));
        assertFalse(dompet.getCards().contains("Debit"));
        assertTrue(dompet.getCards().contains("Tapcash"));

        System.out.println("daftar kartu setelah pengambilan: " + dompet.getCards());
    }
    @Test
    public void testCalculateCoins() {
        Wallet dompet = new Wallet("anton");

        dompet.addCoin(200);
        dompet.addCoin(500);
        dompet.addCoin(1000);

        assertEquals(1700, dompet.calculateCoins());
        System.out.println("total koin: " + dompet.calculateCoins());
    }

    @Test
    public void testCalculateMoneys() {
        Wallet dompet = new Wallet("anton");

        dompet.addMoney(20000);
        dompet.addMoney(5000);
        dompet.addMoney(10000);

        assertEquals(35000, dompet.calculateMoneys());
        System.out.println("total uang kertas: " + dompet.calculateMoneys());
    }

    @Test
    public void testGetMoneyAvailable() {
        Wallet dompet = new Wallet("anton");

        dompet.addCoin(100);
        dompet.addCoin(500);
        dompet.addCoin(1000);
        dompet.addCard("Tapcash");
        dompet.addMoney(1000);
        dompet.addMoney(50000);
        dompet.addMoney(100000);

        assertEquals(152600, dompet.getMoneyAvailable());
        System.out.println("isi dompet " + dompet.getOwner() +": " + dompet.getMoneyAvailable() + " rupiah");
        System.out.println("daftar kartu " + dompet.getOwner()+ ": " + dompet.getCards());
    }
}



import static org.junit.Assert.*;

public class CalcTest {

    @org.junit.Test
    public void sumTest( ) {
        assertEquals(4, new Calc().Sum(2,2));
    }
}
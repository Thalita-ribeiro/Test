import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniTest1Test {

    @Test
    public void test() {
        UniTest1 test = new UniTest1();
        int result = test.addNumber(7, 2);
        assertEquals(9, result);
    }

    @Test
    public void testString() {
        UniTest1 test2 = new UniTest1();
        String result2 = test2.addString("Thalita", "Ribeiro");
        assertEquals("ThalitaRibeiro", result2);
    }
}
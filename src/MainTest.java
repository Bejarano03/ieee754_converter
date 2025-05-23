import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // Normal cases

    @Test
    void testToBinaryZero() {
        String expected = "00000000000000000000000000000000";
        assertEquals(expected, Main.toBinary(0.0f));
    }

    @Test
    void testToBinaryPositiveNumber() {
        // 1.5f in IEEE 754: 0 01111111 10000000000000000000000
        String expected = "00111111110000000000000000000000";
        assertEquals(expected, Main.toBinary(1.5f));
    }

    @Test
    void testToBinaryNegativeNumber() {
        // -2.0f in IEEE 754: 1 10000000 00000000000000000000000
        String expected = "11000000000000000000000000000000";
        assertEquals(expected, Main.toBinary(-2.0f));
    }

    // Edge cases

    @Test
    void testToBinaryNaN() {
        float nan = 0.0f / 0.0f;
        // NaN: sign=0, exponent=all 1s, mantissa!=0
        String bits = Main.toBinary(nan);
        assertTrue(bits.startsWith("011111111"), "NaN should have all exponent bits set");
        assertNotEquals("01111111100000000000000000000000", bits, "NaN mantissa should not be all zeros");
    }

    @Test
    void testToBinaryPositiveInfinity() {
        float posInf = 1.0f / 0.0f;
        String expected = "01111111100000000000000000000000";
        assertEquals(expected, Main.toBinary(posInf));
    }

    @Test
    void testToBinaryNegativeZero() {
        float negZero = -0.0f;
        String expected = "10000000000000000000000000000000";
        assertEquals(expected, Main.toBinary(negZero));
    }
}
/**
 *
 *
 * @author Marco Bejarano
 * @version 4/27/2025
 */

public class Main {
    public static void main(String[] args) {
        arithmetic();
        specialValues();
        rounding();
        flow();
    }

    public static String toBinary(float num) {
        int bits = Float.floatToRawIntBits(num);
        return String.format("%32s", Integer.toBinaryString(bits)).replace(' ', '0');
    }

    private static void arithmetic() {
        System.out.println("---Arithmetic Conversion---");
        float a = 0.1f, b = 0.2f;
        float sum = a + b;
        float div = 1.0f / 3.0f;

        System.out.printf("0.1f + 0.2f = %.20f bits=%s%n", sum, toBinary(sum));
        System.out.printf("1.0f/3.0f = %.20f bits=%s%n", div, toBinary(div));
        System.out.println();
    }

    private static void specialValues() {
        System.out.println("---Special Values Conversion---");
        float posInf = 1.0f / 0.0f;
        float negInf = -1.0f / 0.0f;
        float nan = 0.0f / 0.0f;

        System.out.printf("+∞  bits=%s%n", toBinary(posInf));
        System.out.printf("-∞  bits=%s%n", toBinary(negInf));
        System.out.printf("NaN bits=%s  (nan==nan? %b)%n%n",
                toBinary(nan), nan == nan);
    }

    private static void rounding() {
        System.out.println("---Rounding Demo (BigDecimal)---");
        java.math.BigDecimal x = new java.math.BigDecimal("1.005");
        System.out.println("HALF_UP   : " + x.setScale(2, java.math.RoundingMode.HALF_UP));
        System.out.println("HALF_EVEN : " + x.setScale(2, java.math.RoundingMode.HALF_EVEN));
        System.out.println("DOWN      : " + x.setScale(2, java.math.RoundingMode.DOWN));
        System.out.println();
    }

    private static void flow() {
        System.out.println("---Underflow / Overflow Conversion---");
        float tiny  = Float.MIN_VALUE;     // smallest POSITIVE sub-normal
        float under = tiny / 2.0f;         // → 0.0

        float big   = Float.MAX_VALUE;
        float over  = big * 2.0f;          // → +∞

        System.out.printf("tiny  %e  bits=%s%n", (double)tiny,  toBinary(tiny));
        System.out.printf("under %e  bits=%s%n", (double)under, toBinary(under));
        System.out.printf("big   %e  bits=%s%n", (double)big,   toBinary(big));
        System.out.printf("over  %s    bits=%s%n%n", over,       toBinary(over));
    }
}
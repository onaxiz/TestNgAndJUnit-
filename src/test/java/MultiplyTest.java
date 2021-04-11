import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MultiplyTest {
    private int a;
    private long b;
    private double expectedResult;

    @Parameterized.Parameters
    public static Collection paramsForMultiply() {
        return Arrays.asList(new Object[][]{
                {2, 3_000_000_000L, 6_000_000_000L},
                {-2, 3_000_000_000L, -6_000_000_000L},
                {-2, -3_000_000_000L, 6_000_000_000L},
                {0, -3_000_000_000L, 0},
                {2, 0, 0},
                { 2_147_483_400L,1, 2_147_483_400L},
                {2_147_483_647, 9_223_372_036_854_775_807L, 19_807_040_619_342_712_359_383_728_129D}
        });
    }

    public MultiplyTest(int a, long b, double expected) {
        this.a = a;
        this.b = b;
        this.expectedResult = expected;
    }

    @Test
    public void testMultiply() {
        final String message = "Muliply test failed";
        double actualResult = ToRemove.multiply(a, b);
        assertEquals(actualResult, expectedResult, 0);
    }
}

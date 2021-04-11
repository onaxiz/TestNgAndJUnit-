import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class ToRemoveTest {
    @Test
    @DisplayName("testToUpperCase")
    void toUpperCase() {
        final String testString = "test";
        String actualResult = ToRemove.toUpperCase(testString);
        String expectedResult = testString.toUpperCase(Locale.ROOT);
        assertEquals(expectedResult, actualResult, () -> "The upper case test failed");
    }

    @Test
    @DisplayName("testMultiply")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 1, 2",
            "2, 3_000_000_000, 6_000_000_000D",
            "0, 3_000_000_000, 0",
            "2, 0, 0",
            "0, 2, 0",
            "-2, 1, -2",
            "2, -1, -2",
    })
    void multiply(int a, long b, double expected) {
        assertEquals(ToRemove.multiply(a, b),expected, () -> "Muliply test failed");
    }

    @Test
    @DisplayName("testJoinMethod")
    void join() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = ToRemove.join(testStrings);
        String expectedResult = "apple banana orange mango";
        assertEquals(actualResult, expectedResult, () -> "joining failed: ");
    }
}

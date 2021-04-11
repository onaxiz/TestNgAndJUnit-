import org.junit.Test;;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ToRemoveTest {
    @Test
    public void isWordInUpperCase() {
        final String TEST_STRING = "test";
        String actualResult = ToRemove.toUpperCase(TEST_STRING);
        String expectedResult = TEST_STRING.toUpperCase(Locale.ROOT);
        String message = "The upper case test failed";
        assertEquals(message, expectedResult, actualResult);
    }

    @Test
    public void testJoin() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = ToRemove.join(testStrings);
        String expectedResult = "apple banana orange mango";
        final String message = "joining failed: ";
        assertEquals(actualResult, expectedResult, message);
    }
}

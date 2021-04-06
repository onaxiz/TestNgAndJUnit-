import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

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
    public void multiply() {
        int a = 4_000_000;
        int b = 3;

    }

    @Test
    public void sortDesc() {
    }

    @Test
    public void sortAsc() {
    }

    @Test
    public void join() {
    }

    @Test
    public void toPersonDto() {
    }

    @org.junit.Test
    public void toPerson() {
    }
}

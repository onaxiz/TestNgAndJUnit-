import org.junit.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testMultiply() {
        int a = 2;
        long b = 3_000_000;
        final String message = "Muliply test failed";
        assertTrue(message, ToRemove.multiply(a, b) == a * b);
    }

    @Test
    public void testSortDesc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {144, 144, 89, 45, 39, 36, 34, 30, 30, -21};
        final String message = "DESC sorting failed: ";
        ToRemove.sortDesc(testArray);
        assertEquals(message, testArray, expectedArray);
    }

    @Test
    public void testSortAsc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {-21, 30, 30, 34, 36, 39, 45, 89, 144, 144};
        final String message = "ASC sorting failed: ";
        ToRemove.sortAsc(testArray);
        assertEquals(message, testArray, expectedArray);
    }

    @Test
    public void testJoin() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = ToRemove.join(testStrings);
        String expectedResult = "apple banana orange mango";
        final String message = "joining failed: ";
        assertEquals(actualResult, expectedResult, message);
    }

    @Test
    public void toPersonDto() {
        ToRemove.Person testPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.now());
        ToRemove.PersonDto actualPersonDto = ToRemove.toPersonDto(testPerson);
        ToRemove.PersonDto expectedPersonDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        final String message = "toPersonDto method failed: ";
        assertEquals(message, actualPersonDto, expectedPersonDto);
    }

    @org.junit.Test
    public void toPerson() {
        ToRemove.PersonDto personDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        ToRemove.Person actualPerson = ToRemove.toPerson(personDto);
        ToRemove.Person expectedPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.now());
        final String message = "toPerson method failed: ";
        assertEquals(message, actualPerson, expectedPerson);
    }
}

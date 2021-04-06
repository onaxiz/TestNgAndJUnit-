import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class ToRemoveTest extends ToRemove {

    @Test
    public void testTestToUpperCase() {
        String testString = "test";
        String actualResult = toUpperCase(testString);
        String expectedResult = "TEST";
        final String message = "The text of the line feed to uppercase failed: ";

        assertEquals(actualResult, expectedResult, message);
    }

    @Test
    public void testTestMultiply() {
        int a = 2;
        long b = 3_000_000L;
        double actualResult = multiply(a, b);
        double expectedResult = 6_000_000L;
        final String message = "Multiply failed: ";
        assertEquals(actualResult, expectedResult, message);
    }


    @Test
    //assertEqualsNoOrder?
    public void testTestSortDesc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {144, 144, 89, 45, 39, 36, 34, 30, 30, -21};
        final String message = "DESC sorting failed: ";
        sortDesc(testArray);
        assertEquals(testArray, expectedArray, message);
    }

    @Test
    public void testTestSortAsc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {-21, 30, 30, 34, 36, 39, 45, 89, 144, 144};
        final String message = "ASC sorting failed: ";
        sortDesc(testArray);
        assertEquals(testArray, expectedArray, message);
    }

    @Test
    public void testTestJoin() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = join(testStrings);
        String expectedResult = "apple banana orange mango";
        final String message = "joining failed: ";
        assertEquals(actualResult, expectedResult, message);
    }


    @Test
    public void testToPersonDto() {
        Person testPerson = new Person(1L, "a", "b", "fd", LocalDate.now());
        PersonDto actualPersonDto = toPersonDto(testPerson);
        PersonDto expectedPersonDto = new PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        final String message = "toPersonDto method failed: ";
        assertEquals(actualPersonDto, expectedPersonDto, message);
    }

    @Test
    public void testToPerson()  {
        PersonDto personDto = new PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        Person actualPerson = toPerson(personDto);
        Person expectedPerson = new Person(1L, "a", "b", "fd", LocalDate.now());
        final String message = "toPerson method failed: ";
        assertEquals(actualPerson, expectedPerson, message);
    }
}

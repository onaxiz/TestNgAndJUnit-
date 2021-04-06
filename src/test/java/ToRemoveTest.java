import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ToRemoveTest {

    @Test
    @DisplayName("testToUpperCase")
    void toUpperCase() {
        final String TEST_STRING = "test";
        String actualResult = ToRemove.toUpperCase(TEST_STRING);
        String expectedResult = TEST_STRING.toUpperCase(Locale.ROOT);
        assertEquals(expectedResult, actualResult, () -> "The upper case test failed");
    }

    @Test
    @DisplayName("testMultiply")
    void multiply() {
        int a = 2;
        long b = 3_000_000;
        assertTrue(ToRemove.multiply(a, b) == a * b, () -> "Muliply test failed");
    }

    @Test
    @DisplayName("testSortDesc")
    void sortDesc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {144, 144, 89, 45, 39, 36, 34, 30, 30, -21};
        ToRemove.sortDesc(testArray);
        assertEquals(testArray, expectedArray, () -> "DESC sorting failed: ");
    }

    @Test
    @DisplayName("testSortAscMethod")
    void sortAsc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {-21, 30, 30, 34, 36, 39, 45, 89, 144, 144};
        ToRemove.sortAsc(testArray);
        assertEquals(testArray, expectedArray, () -> "ASC sorting failed: ");
    }

    @Test
    @DisplayName("testJoinMethod")
    void join() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = ToRemove.join(testStrings);
        String expectedResult = "apple banana orange mango";
        assertEquals(actualResult, expectedResult, () -> "joining failed: ");
    }

    @Test
    @DisplayName("testToPersonDtoMethod")
    void toPersonDto() {
        ToRemove.Person testPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.now());
        ToRemove.PersonDto actualPersonDto = ToRemove.toPersonDto(testPerson);
        ToRemove.PersonDto expectedPersonDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        assertEquals(actualPersonDto, expectedPersonDto, () -> "toPersonDto method failed: ");
    }

    @Test
    @DisplayName("testToPersonMethod")
    void toPerson() {
        ToRemove.PersonDto personDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        ToRemove.Person actualPerson = ToRemove.toPerson(personDto);
        ToRemove.Person expectedPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.now());
        assertEquals(actualPerson, expectedPerson, () -> "toPerson method failed: ");
    }
}

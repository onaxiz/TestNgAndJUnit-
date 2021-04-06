import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

public class ToRemoveTest extends ToRemove implements TestPriority {


    @BeforeMethod
    public void displayingTestDescription(Method testMethod){
        String description = testMethod.getAnnotation(Test.class).description();
        System.out.println("Start test: " + description);
    }

    @Test(description = "verify that string is in UpperCase", priority = LOW)
    public void testTestToUpperCase() {
        String testString = "test";
        String actualResult = toUpperCase(testString);
        String expectedResult = "TEST";
        final String message = "The text of the line feed to uppercase failed: ";

        assertEquals(actualResult, expectedResult, message);
    }


    @Test(description = "checking multiplication result", priority = HIGH)
    public void testMultiply() {
        int a = 2;
        long b = 3_000_000L;
        double actualResult = multiply(a, b);
        double expectedResult = 6_000_000L;
        final String message = "Multiply failed: ";
        assertEquals(actualResult, expectedResult, message);
    }

    @Test(description = "verify DESC order", priority = MEDIUM)
    public void testSortDesc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {144, 144, 89, 45, 39, 36, 34, 30, 30, -21};
        final String message = "DESC sorting failed: ";
        sortDesc(testArray);
        assertEquals(testArray, expectedArray, message);
    }

    @Test(description = "verify ASC order", priority = MEDIUM)
    public void testSortAsc() {
        int[] testArray = {144, 30, 30, 34, 36, 144, 39, 45, -21, 89};
        int[] expectedArray = {-21, 30, 30, 34, 36, 39, 45, 89, 144, 144};
        final String message = "ASC sorting failed: ";
        sortDesc(testArray);
        assertEquals(testArray, expectedArray, message);
    }

    @Test(description = "verify concatenation string with space ", priority = LOW)
    public void testJoin() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = join(testStrings);
        String expectedResult = "apple banana orange mango";
        final String message = "joining failed: ";
        assertEquals(actualResult, expectedResult, message);
    }

    @Test(description = "verify casting to PersonDto class object ", priority = HIGH)
    public void testToPersonDto() {
        ToRemove.Person testPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.now());
        ToRemove.PersonDto actualPersonDto = toPersonDto(testPerson);
        ToRemove.PersonDto expectedPersonDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        final String message = "toPersonDto method failed: ";
        assertEquals(actualPersonDto, expectedPersonDto, message);
    }

    @Test(description = "verify casting to Person class object ", priority = HIGH)
    public void testToPerson()  {
        ToRemove.PersonDto personDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                LocalDate.now().toString());
        ToRemove.Person actualPerson = toPerson(personDto);
        ToRemove.Person expectedPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.now());
        final String message = "toPerson method failed: ";
        assertEquals(actualPerson, expectedPerson, message);
    }
}

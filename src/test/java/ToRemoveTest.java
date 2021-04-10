import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;

public class ToRemoveTest extends ToRemove implements TestPriority {

    @BeforeMethod
    public void displayingTestDescription(Method testMethod){
        String description = testMethod.getAnnotation(Test.class).description();
        System.out.println("Start test: " + description);
    }

    @Test(description = "verify that string is in UpperCase", priority = LOW)
    public void testTestToUpperCase() {
        final String testString = "test";
        String actualResult = toUpperCase(testString);
        final String expectedResult = "TEST";
        final String message = "The text of the line feed to uppercase failed: ";

        assertEquals(actualResult, expectedResult, message);
    }

    @DataProvider(name = "multiplyData")
    public Object[][] dataForMultiply() {
        return new Object[][]{
                {2, 3_000_000_000L, 6_000_000_000D},
                {-2, -3_000_000_000L, 6_000_000_000D},
                {-2,  3_000_000_000L, -6_000_000_000D},
                { 2,  -3_000_000_000L, -6_000_000_000D},
                { 0,  -3_000_000_000L, 0},
                { 2, 0, 0},
                { 2_147_483_400L,1, 2_147_483_400L},
                {2_147_483_647, 9_223_372_036_854_775_807L, 19_807_040_619_342_712_359_383_728_129D}
        };
    }

    @Test(dataProvider = "multiplyData", priority = HIGH, description = "testMultiply")
    public void testTMultiply(int a,long b, double expected) {
        double actualResult = multiply(a, b);;
        final String message = "Multiply failed: ";
        assertEquals(actualResult, expected, message);
    }

    @DataProvider(name = "DESC")
    public Object[][] dataForDESC() {
        return new Object[][]{
                { new int[]{2, 4, 3, 1}, new int[]{4, 3, 2, 1}},
                { new int[]{2, 0, 2, 0}, new int[]{2, 2, 0, 0}},
                { new int[]{2, -4, 3, -1}, new int[]{3, 2, -1, -4}}
        };
    }

    @Test(dataProvider = "DESC", description = "verify DESC order", priority = MEDIUM)
    public void testTestSortDesc(int[] testArray, int[] expectedArray) {
        final String message = "DESC sorting failed: ";
        sortDesc(testArray);
        assertEquals(testArray, expectedArray, message);
    }

    @DataProvider(name = "ASC")
    public Object[][] dataForASC() {
        return new Object[][]{
                { new int[]{2, 4, 3, 1}, new int[]{1, 2, 3, 4}},
                { new int[]{2, 0, 2, 0}, new int[]{0, 0, 2, 2}},
                { new int[]{2, -4, 3, -1}, new int[]{-4, -1, 2, 3}}
        };
    }

    @Test(dataProvider = "ASC", description = "verify ASC order", priority = MEDIUM)
    public void testTestSortAsc(int[] testArray, int[] expectedArray) {
        final String message = "ASC sorting failed: ";
        sortDesc(testArray);
        assertEquals(testArray, expectedArray, message);
    }

    @Test(description = "verify concatenation string with space ", priority = LOW)
    public void testTestJoin() {
        String[] testStrings = {"apple", "banana", "orange", "mango"};
        String actualResult = join(testStrings);
        String expectedResult = "apple banana orange mango";
        final String message = "joining failed: ";
        assertEquals(actualResult, expectedResult, message);
    }

    @Test(description = "verify casting to PersonDto class object ", priority = HIGH)
    public void testToPersonDto() {
        ToRemove.Person testPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.parse("2021-04-10"));
        ToRemove.PersonDto actualPersonDto = toPersonDto(testPerson);
        ToRemove.PersonDto expectedPersonDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                "2021-04-10");
        final String message = "toPersonDto method failed: ";
        assertThat(actualPersonDto)
                .isEqualToComparingFieldByFieldRecursively(expectedPersonDto);
    }

    @Test(description = "verify casting to Person class object ", priority = HIGH)
    public void testToPerson()  {
        ToRemove.PersonDto personDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
                "2021-04-10");
        ToRemove.Person actualPerson = toPerson(personDto);
        ToRemove.Person expectedPerson = new ToRemove.Person(1L, "a", "b", "fd", LocalDate.parse("2021-04-10"));
        final String message = "toPerson method failed: ";
        assertThat(actualPerson)
                .isEqualToComparingFieldByFieldRecursively(expectedPerson);
    }
}

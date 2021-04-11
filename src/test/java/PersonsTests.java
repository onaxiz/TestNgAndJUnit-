import org.junit.Rule;
import org.junit.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class PersonsTests {
    @Rule
    ToRemove.Person simplePerson = new ToRemove.Person(1L, "a", "b", "fd",
            LocalDate.parse("2021-04-10"));
    @Rule
    ToRemove.PersonDto personDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b", "fd",
            "2021-04-10");

    @Test
    public void toPersonDto() {
        ToRemove.PersonDto actualPersonDto = ToRemove.toPersonDto(simplePerson);
        ToRemove.PersonDto expectedPersonDto = personDto;
        final String message = "toPersonDto method failed: ";
        assertThat(actualPersonDto).usingRecursiveComparison().isEqualTo(expectedPersonDto);
    }

    @org.junit.Test
    public void toPerson() {
        ToRemove.Person actualPerson = ToRemove.toPerson(personDto);
        ToRemove.Person expectedPerson = simplePerson;
        final String message = "toPerson method failed: ";
        assertEquals(message, actualPerson, expectedPerson);
    }
}

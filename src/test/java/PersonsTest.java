import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonsTest {
    @Rule
    ToRemove.Person simplePerson = new ToRemove.Person(1L, "a", "b", "fd",
            LocalDate.parse("2021-04-10"));

    @Rule
    ToRemove.PersonDto personDto = new ToRemove.PersonDto(Long.valueOf(1L).toString(), "a", "b",
            "fd", "2021-04-10");
    @Test
    @DisplayName("testToPersonDtoMethod")
    void toPersonDto() {
        ToRemove.PersonDto actualPersonDto = ToRemove.toPersonDto(simplePerson);
        assertThat(actualPersonDto).usingRecursiveComparison().isEqualTo(personDto);
    }

    @Test
    @DisplayName("testToPersonMethod")
    void toPerson() {
        ToRemove.Person actualPerson = ToRemove.toPerson(personDto);
        assertThat(actualPerson).usingRecursiveComparison().isEqualTo(simplePerson);
    }

}

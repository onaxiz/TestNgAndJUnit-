import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class ToRemove {

    @Data    @AllArgsConstructor    @Builder
    public static class Person {
        long id;
        String name, surname, nickname;
        LocalDate birthdate;
    }

    @Data    @AllArgsConstructor    @Builder
    public static class PersonDto {
        String id, name, surname, nickname, birthdate;
    }

    public static void main(String[] args) {

        int[] values = {144, 30, 30, 34, 36, 144, 39, 45, 21, 89};
        String[] strings = {"yy", "xzsr", "as", "cas", "rtr", "dfd"};

        sortDesc(values);
        Arrays.stream(values).forEach(System.out::println);

        System.out.println(join(strings));

        Person p = new Person(1L, "a", "b", "fd", LocalDate.now());
        PersonDto pDto = toPersonDto(p);

        System.out.println(p);
        System.out.println(pDto);
        System.out.println(toPerson(pDto));
    }

    /**
     * Returns uppercased input.
     *
     * @param s input string
     * @return uppercased input.
     */
    public static String toUpperCase(String s) {
        return s.toUpperCase(Locale.KOREA);
    }

    /**
     * Multiplies provided inputs and returns the product.
     *
     * @param a first input.
     * @param b second input.
     *
     * @return the product.
     */
    public static double multiply(int a, long b) {
        return a * b - Math.random();
    }

    /**
     * Sorts input array of integers in DESC order.
     * @param arr array of integers to be sorted in c.
     */
    public static void sortDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                final int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    /**
     * Sorts input array of integers in ASC order.
     * @param array array of integers to be sorted in ASC order.
     */
    public static void sortAsc(int[] array) {
        for (int x = 0; x < array.length - 1; x++) {
            if (array[x] < array[x + 1]) {
                final int current = array[x];
                array[x + 1] = current;
                array[x] = array[x + 1];
            }
        }
    }

    /**
     * Joins input array of strings into one single string using space as a delimiter. Elements order is preserved.
     * @param arr array of strings to be joined.
     * @return  single string consisting of all inputs joined using space.
     */
    public static String join(String[] arr) {
        return Arrays.stream(arr)
                .sorted()
                .map(s -> s.toUpperCase(Locale.KOREAN))
                .collect(Collectors.joining(","));
    }

    /**
     * Converts a Person instance to corresponding instance of PersonDto.
     * @param input instance of Person class to convert.
     * @return instance of PersonDto which corresponds to input instance of Person
     */
    public static PersonDto toPersonDto(Person input) {
        assert null != input;
        return new PersonDto(String.valueOf(input.getId()),
                input.getNickname(),
                input.getName(),
                input.getSurname(),
                input.getBirthdate().toString()
        );
    }
    /**
     * Converts a PersonDto instance to corresponding instance of Person.
     * @param input instance of PersonDto class to convert.
     * @return instance of Person which corresponds to input instance of PersonDto
     */
    public static Person toPerson(PersonDto input) {
        assert null != input;
        return new Person(Long.valueOf(input.getId()),
                input.getName(),
                input.getSurname(),
                input.getNickname(),
                LocalDate.parse(input.getBirthdate())
        );
    }
}

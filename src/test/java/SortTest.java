import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

    static Stream<Arguments> setDescParams () {
        return Stream.of(
                Arguments.of((new int[] { 2, 1, 2, 3, 4 }), (new int[] { 4, 3, 2, 2, 1 })),
                Arguments.of((new int[] { 2, 2, 0 }), (new int[] { 2, 2, 0 })),
                Arguments.of((new int[]{1, -3, -5} ), (new int[] { 1, -3, -5})),
                Arguments.of((new int[]{0, -3, 5} ), (new int[] { 5, 0, -3}))
        );
    }

    @Test
    @DisplayName("testSortDesc")
    @ParameterizedTest(name = "{index} => array   = {0} ),  expected = {1} ")
    @MethodSource("setDescParams")
    void sortDesc(int[] testArray, int[] expectedArray) {
        ToRemove.sortDesc(testArray);
        assertArrayEquals(testArray, expectedArray, () -> "DESC sorting failed: ");
    }


    static Stream<Arguments> setAscParams () {
        return Stream.of(
                Arguments.of((new int[] { 2, 1, 2, 3, 4 }), (new int[] { 1, 2, 2, 3, 4 })),
                Arguments.of((new int[] { 2, 2, 0 }), (new int[] { 0, 2, 2 })),
                Arguments.of((new int[]{1, -3, -5} ), (new int[] { -5, -3, 1})),
                Arguments.of((new int[]{0, -3, 5} ), (new int[] { -3, 0, 5}))
        );
    }

    @Test
    @DisplayName("testSortAsc")
    @ParameterizedTest(name = "{index} => array   = {0} ),  expected = {1} ")
    @MethodSource("setAscParams")
    void sortAsc(int[] testArray, int[] expectedArray) {
        ToRemove.sortAsc(testArray);
        assertArrayEquals(testArray, expectedArray, () -> "ASC sorting failed: ");
    }
}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class DescSortTest {
    private int[] testArray;
    private int[] expectedArray;

    @Parameterized.Parameters
    public static Collection paramsForDescSort() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3, 1,  4}, new int[]{4, 3, 2,  1}},
                {new int[]{3, 2, 3,  4}, new int[]{4, 3, 3,  2}},
                {new int[]{0, 3, 1,  0}, new int[]{3, 1, 0,  0}},
                {new int[]{4, -3, -1,  2}, new int[]{4, 2, -1, -3}},
        });
    }

    public DescSortTest(int[] testArray, int[] expectedArray) {
        this.testArray = testArray;
        this.expectedArray = expectedArray;
    }

    @Test
    public void testMultiply() {
        final String message = "ASC sorting failed: ";
        ToRemove.sortDesc(testArray);
        assertArrayEquals(message, testArray, expectedArray);
    }
}

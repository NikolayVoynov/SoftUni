package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void when_notSortedArrayPassedToSort_then_arraySortedAsc() {
        int[] array = new int[]{3, -7, 9, 20, 0, 18};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-7, 0, 3, 9, 18, 20};
        Assert.assertEquals(expectedArray.length, array.length);
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void when_sortedArrayPassedToSort_then_arrayStaysInitiallySortedAsc() {
        int[] array = new int[]{-7, 0, 3, 9, 18, 20};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-7, 0, 3, 9, 18, 20};
        Assert.assertEquals(expectedArray.length, array.length);
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void when_emptyArrayPassedToSort_then_emptyArray() {
        int[] array = new int[]{};
        Bubble.sort(array);
        int[] expectedArray = new int[]{};
        Assert.assertEquals(expectedArray.length, array.length);
        Assert.assertArrayEquals(expectedArray, array);
    }
}

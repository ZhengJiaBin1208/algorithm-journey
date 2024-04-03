package mimetic.class004.test;

import mimetic.class004.SelectBubbleInsert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @ClassName SelectBubbleInsertTest
 * @Description TODO
 * @Author zhengjiabin
 * @Date 2024/3/29 14:57
 * @Version 1.0
 **/
public class SelectBubbleInsertTest {
    @Test
    void insertionSort() {
        // 测试空数组
        int[] arr1 = new int[0];
        assertDoesNotThrow(() -> SelectBubbleInsert.insertionSort(arr1));

        // 测试数组长度小于2
        int[] arr2 = new int[]{1};
        assertDoesNotThrow(() -> SelectBubbleInsert.insertionSort(arr2));

        // 测试升序数组
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        assertDoesNotThrow(() -> SelectBubbleInsert.insertionSort(arr3));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr3);

        // 测试降序数组
        int[] arr4 = new int[]{5, 4, 3, 2, 1};
        assertDoesNotThrow(() -> SelectBubbleInsert.insertionSort(arr4));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr4);

        // 测试乱序数组
        int[] arr5 = new int[]{3, 1, 4, 1, 5};
        assertDoesNotThrow(() -> SelectBubbleInsert.insertionSort(arr5));
        assertArrayEquals(new int[]{1, 1, 3, 4, 5}, arr5);
    }



    @Test
    public void testSelectionSort() {
        int[] arr1 = new int[]{3, 2, 1};
        int[] arr2 = new int[]{5, 4, 3, 2, 1};
        int[] arr3 = new int[]{};
        int[] arr4 = new int[]{1};

        SelectBubbleInsert.selectionSort(arr1);
        assertArrayEquals(new int[]{1, 2, 3}, arr1);

        SelectBubbleInsert.selectionSort(arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr2);

        SelectBubbleInsert.selectionSort(arr3);
        assertArrayEquals(new int[]{}, arr3);

        SelectBubbleInsert.selectionSort(arr4);
        assertArrayEquals(new int[]{1}, arr4);
    }

    @Test
    void testBubbleSort() {
        // 测试空数组
        int[] arr1 = new int[]{};
        assertDoesNotThrow(() -> SelectBubbleInsert.bubbleSort(arr1));

        // 测试数组长度小于2
        int[] arr2 = new int[]{1};
        assertDoesNotThrow(() -> SelectBubbleInsert.bubbleSort(arr2));

        // 测试升序数组
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        assertDoesNotThrow(() -> SelectBubbleInsert.bubbleSort(arr3));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr3);

        // 测试降序数组
        int[] arr4 = new int[]{5, 4, 3, 2, 1};
        assertDoesNotThrow(() -> SelectBubbleInsert.bubbleSort(arr4));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr4);

        // 测试乱序数组
        int[] arr5 = new int[]{3, 1, 4, 1, 5};
        assertDoesNotThrow(() -> SelectBubbleInsert.bubbleSort(arr5));
        assertArrayEquals(new int[]{1, 1, 3, 4, 5}, arr5);
    }
}

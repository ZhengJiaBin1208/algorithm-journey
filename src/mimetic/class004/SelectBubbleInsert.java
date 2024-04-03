package mimetic.class004;

/**
 * @ClassName SelectBubbleInsert
 * @Description 三大傻瓜排序-选择、插入、冒泡
 * @Author zhengjiabin
 * @Date 2024/3/29 11:36
 * @Version 1.0
 **/
public class SelectBubbleInsert {


    /**
     * 交换数组中指定位置的两个元素。
     * @param arr 要进行交换的数组
     * @param i 要交换的第一个元素的索引
     * @param j 要交换的第二个元素的索引
     */
    public static void swap(int[] arr, int i, int j){
        // 临时变量用于保存第一个元素的值
        int temp = arr[i];
        // 将第二个元素的值赋给第一个元素的位置
        arr[i] = arr[j];
        // 将保存的第一个元素的值赋给第二个元素的位置
        arr[j] = temp;
    }

    /**
     * 选择排序
     * 1.如果数组为空或者数组长度小于2直接返回
     * 2.从0-n-1循环比较，默认第i位最小，然后如果找到更小的位数标记为最小位
     * 3.交换最小的位数和i位
     * 通义灵码注释
     * 选择排序算法对数组进行排序。
     * 该算法首先找到数组中最小的元素，然后将其与数组的第一个元素交换位置，
     * 接着再在剩余数组中寻找次小元素，与数组的第二个元素交换，依此类推。
     * 注意：该方法不返回任何值，而是直接对输入的数组进行排序操作。
     * @param arr 要进行选择排序的数组
     */
    public static void selectionSort(int[] arr){
        // 如果数组为空或者数组长度小于2直接返回
        if (null == arr && arr.length < 2) {
            return;
        }
        // 遍历整个数组
        for (int i = 0; i < arr.length; i++) {
            /**
             * i~n-1，找到最小值，放到i位置
             * 0~n-1
             * 1~n-1
             * ...
             */
            // 假设当前位是最小值的索引
            int minIndex = i;
            // 在剩余未排序部分中寻找最小值的索引
            for (int j = i + 1; j < arr.length; j++){
                /**
                 * i i+1 ... i+4 ... i+16
                 * min       min      min
                 */
                // 如果找到更小的值，则更新最小值索引
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // 如果最小值不在当前位置，则交换最小值和当前位置的元素
            if (i != minIndex){
                swap(arr,i,minIndex);
            }
        }

    }


    /**
     * @author zhengjiabin
     * @description 冒泡排序
     * 外层控制排序好的位数，第一次排序把最大的放到最后一位，第二次排序把次大的放到倒数第二位，依此类推。
     * 内层循环找到本次最大的数，放到最后的位置
     * @date 2024/3/29 14:44
     * @param arr 需要排序的整型数组。该参数不能为空且数组长度必须大于等于2。
     * @return void
     **/
    public static void bubbleSort(int[] arr) {
        // 如果数组为空或者数组长度小于2直接返回
        if (null == arr && arr.length < 2) {
            return;
        }
        /**
         * 0~n-1
         * 0~n-2
         * 0~n-3
         * 0~end-1
         * 0~0
         */
        for (int end = arr.length - 1; end > 0; end --) {
            /**
             * 0~end
             * 0 1  i=0 i+1=1
             * 1 2  i=1 i+1=2
             * 2 3  i=2 i+1=3
             * 3 4
             * 4 5
             * end+1 end
             */
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    /**
     * @author zhengjiabin
     * @description 插入排序
     * 外层循环控制0~n-1有序
     * 内层循环控制新来的数有序(抓牌插入)
     * @date 2024/3/29 14:52
     * @param arr 需要排序的整型数组。该参数不能为空且数组长度必须大于等于2。
     * @return void
     **/
    public static void insertionSort(int[] arr) {
        // 如果数组为空或者数组长度小于2直接返回
        if (null == arr && arr.length < 2) {
            return;
        }
        /**
         * 0~0
         * 0~1
         * 0~2
         * 0~3
         * 0~4
         * 0~n-1
         **/
        for (int i = 1; i < arr.length; i++) {
            /**
             * 0~i-1有序了！新来的数是[i],向左看,向左比较
             */
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1];j--) {
                swap(arr,j,j+1);
            }
        }
    }


}

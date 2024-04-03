package mimetic.class005;

/**
 * @ClassName Validator
 * @Description TODO
 * @Author zhengjiabin
 * @Date 2024/3/29 15:42
 * @Version 1.0
 **/
public class Validator {

    /**
     * @author zhengjiabin
     * @description 检查两个整型数组是否相同。
     * @date 2024/3/29 16:55
     * @param arr1 第一个整型数组。
     * @param arr2 第二个整型数组。
     * @return 如果两个数组都为null，或者长度相同且对应元素相同，则返回true；否则返回false。
     **/
    public static boolean sameArray(int[] arr1, int[] arr2)
    {
        // 先行判断两个数组是否都为null，或者其中之一为null
        if (arr1 == null && arr2 == null)
        {
            return true;
        }
        if (arr1 == null || arr2 == null)
        {
            return false;
        }
        // 比较两个数组的长度
        if (arr1.length != arr2.length)
        {
            return false;
        }
        // 遍历数组，比较对应元素
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * @author zhengjiabin
     * @description 生成一个包含n个随机整数的数组。
     * @date 2024/3/29 16:55
     * @param n 数组的长度。
     * @param v 生成随机数的范围上限（不包含此上限）。
     * @return 一个包含n个范围在[0, v-1]之间随机整数的数组。
     **/
    public static int[] randomArray(int n, int v)
    {
        int[] arr = new int[n]; // 初始化一个长度为n的整型数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.random() * v; // 为数组中的每个位置生成一个[0, v-1]范围内的随机整数
        }
        return arr; // 返回生成的随机数数组
    }

    /**
     * @author zhengjiabin
     * @description 复制一个整型数组。
     * @date 2024/3/29 16:54
     * @param arr 需要被复制的原始整型数组。如果此参数为null，则函数返回null。
     * @return 一个新的整型数组，它是原始数组的复制品。如果输入为null，返回null。
     **/
    public static int[] copyArray(int[] arr)
    {
        // 检查输入数组是否为null
        if (arr == null)
        {
            return null;
        }
        // 创建一个新数组，长度与输入数组相同
        int[] res = new int[arr.length];
        // 遍历原始数组，将每个元素复制到新数组中
        for (int i = 0; i < arr.length; i++)
        {
            res[i] = arr[i];
        }
        return res;
    }
}

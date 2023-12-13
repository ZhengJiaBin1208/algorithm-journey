package class084;

// 统计特殊整数
// 给定正整数n，返回在[1, n]范围内每一位都互不相同的正整数个数
// 测试链接 : https://leetcode.cn/problems/count-special-integers/
public class Code03_CountSpecialIntegers {

	public static int countSpecialNumbers(int n) {
		int len = 1;
		int offset = 1;
		int tmp = n / 10;
		while (tmp > 0) {
			len++;
			offset *= 10;
			tmp /= 10;
		}
		int ans = 0;
		if (len >= 2) {
			ans = 9;
			for (int i = 2, a = 9, b = 9; i < len; i++, b--) {
				a *= b;
				ans += a;
			}
		}
		int[] cnt = new int[len];
		cnt[0] = 1;
		for (int i = 1, cur = 1, base = 10 - len + 1; i < len; i++, base++) {
			cur *= base;
			cnt[i] = cur;
		}
		int first = n / offset;
		ans += (first - 1) * cnt[len - 1];
		ans += f(cnt, n, len - 1, offset / 10, 1 << first);
		return ans;
	}

	public static int f(int[] cnt, int num, int len, int offset, int status) {
		if (len == 0) {
			return 1;
		}
		int ans = 0;
		int first = (num / offset) % 10;
		for (int cur = 0; cur < first; cur++) {
			if ((status & (1 << cur)) == 0) {
				ans += cnt[len - 1];
			}
		}
		if ((status & (1 << first)) == 0) {
			ans += f(cnt, num, len - 1, offset / 10, status ^ (1 << first));
		}
		return ans;
	}

}
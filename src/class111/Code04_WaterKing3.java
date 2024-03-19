package class111;

import java.util.Arrays;

// 查询一段范围上的水王数
// 设计一个数据结构，找到给定子数组的水王数
// 子数组的水王数首先必须是该子数组上出现次数最多的数
// 其次出现次数要大于等于t，t是给定的要求
// 实现MajorityChecker类及其如下方法
// 1) MajorityChecker(int[] arr)
//   用数组arr对MajorityChecker初始化
// 2) int query(int l, int r, int t) 
//   返回子数组arr[l...r]上的水王数，t是给定的要求
//   如果没有满足条件的水王数，返回-1
// 测试链接 : https://leetcode.cn/problems/online-majority-element-in-subarray/
public class Code04_WaterKing3 {

	// 用java语言自带的动态数组可以让常数时间更快
	// 但是其他语言的同学改写难度就大了
	// 所以本实现不用任何动态结构
	// 就用所有语言都有的简单数组实现
	// 这样所有语言的同学都能看懂
	// 时间复杂度也保证了是最优的
	class MajorityChecker {

		public int n;

		public int[][] nums;

		public int[] cand;

		public int[] hp;

		public MajorityChecker(int[] arr) {
			n = arr.length;
			nums = new int[n][2];
			buildCnt(arr, n);
			cand = new int[n << 2];
			hp = new int[n << 2];
			buildTree(arr, 1, n, 1);
		}

		public int query(int l, int r, int t) {
			int[] ch = query(l + 1, r + 1, 1, n, 1);
			int candidate = ch[0];
			return cnt(l, r, candidate) >= t ? candidate : -1;
		}

		private void buildCnt(int[] arr, int n) {
			for (int i = 0; i < n; i++) {
				nums[i][0] = arr[i];
				nums[i][1] = i;
			}
			Arrays.sort(nums, 0, n, (a, b) -> a[0] != b[0] ? (a[0] - b[0]) : (a[1] - b[1]));
		}

		private int cnt(int l, int r, int v) {
			return bs(v, r) - bs(v, l - 1);
		}

		private int bs(int v, int i) {
			int left = 0, right = n - 1, mid;
			int find = -1;
			while (left <= right) {
				mid = (left + right) / 2;
				if (nums[mid][0] < v || (nums[mid][0] == v && nums[mid][1] <= i)) {
					find = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			return find + 1;
		}

		private void buildTree(int[] arr, int l, int r, int i) {
			if (l == r) {
				cand[i] = arr[l - 1];
				hp[i] = 1;
			} else {
				int mid = (l + r) / 2;
				buildTree(arr, l, mid, i << 1);
				buildTree(arr, mid + 1, r, i << 1 | 1);
				int lc = cand[i << 1], rc = cand[i << 1 | 1];
				int lh = hp[i << 1], rh = hp[i << 1 | 1];
				if (lc == rc) {
					cand[i] = lc;
					hp[i] = lh + rh;
				} else {
					cand[i] = lh >= rh ? lc : rc;
					hp[i] = Math.abs(lh - rh);
				}
			}
		}

		private int[] query(int jobl, int jobr, int l, int r, int i) {
			if (jobl <= l && r <= jobr) {
				return new int[] { cand[i], hp[i] };
			} else {
				int mid = (l + r) / 2;
				if (jobr <= mid) {
					return query(jobl, jobr, l, mid, i << 1);
				}
				if (jobl > mid) {
					return query(jobl, jobr, mid + 1, r, i << 1 | 1);
				}
				int[] lch = query(jobl, jobr, l, mid, i << 1);
				int[] rch = query(jobl, jobr, mid + 1, r, i << 1 | 1);
				int lc = lch[0]; int lh = lch[1];
				int rc = rch[0]; int rh = rch[1];
				int c = lc == rc || lh >= rh ? lc : rc;
				int h = lc == rc ? (lh + rh) : Math.abs(lh - rh);
				return new int[] { c, h };
			}
		}
	}

}

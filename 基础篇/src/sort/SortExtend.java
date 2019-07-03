package sort;

/**
 * O(n) 时间复杂度内求无序数组中的第 K 大元素。比如，4， 2， 5， 12， 3 这样一组数据，第 3 大元素就是 4。
 *
 * @author yongkang.zhang
 * created at 2019-07-03
 */
public class SortExtend {

	public static int find(int[] arr, int start, int end, int k) {
		if (start == end) {
			return arr[start];
		}

		int i = start, j = start;
		int pivot = arr[end];
		while (j < end) {
			if (arr[j] > pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
			j++;
		}

		int tmp = arr[i];
		arr[i] = pivot;
		arr[end] = tmp;

		if (i + 1 == k) {
			return pivot;
		}

		if (i + 1 < k) {
			return find(arr, i + 1, end, k - i);
		} else {
			return find(arr, start, i - 1, k);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{5, 2, 12, 4, 3};
		System.out.println(find(a, 0, 4, 5));
	}
}

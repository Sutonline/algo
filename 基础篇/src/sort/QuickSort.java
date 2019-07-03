package sort;

import java.util.Arrays;

/**
 * @author yongkang.zhang
 * created at 2019-07-03
 */
public class QuickSort {

	public static void sort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int i = start, j = start;
		int pivot = arr[end];
		while (j <= end - 1) {
			if (arr[j] < pivot) {
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

		sort(arr, start, i - 1);
		sort(arr, i + 1, end);
	}

	public static void main(String[] args) {
		int[] src = new int[]{5, 7, 3, 1, 2, 4};
		sort(src, 0, 5);
		System.out.println(Arrays.toString(src));
	}
}

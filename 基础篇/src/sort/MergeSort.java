package sort;

import java.util.Arrays;

/**
 * @author yongkang.zhang
 * created at 2019-07-02
 */
public class MergeSort {

	private int[] mergeSort(int[] src, int start, int end) {
		if (src.length == 1) {
			return src;
		}

		int mid = end / 2;
		int[] a = mergeSort(src, start, mid);
		int[] b = mergeSort(src, mid + 1, end);

		return merge(a, b);
	}

	private int[] merge(int[] a, int[] b) {
		int[] tmpArr = new int[a.length + b.length];
		int idx = 0, i = 0,j = 0;
		while (i < a.length && j < b.length) {
			int tmp;
			if (a[i] <= b[j]) {
				tmp = a[i];
				i++;
			} else {
				tmp = b[j];
				j++;
			}
			tmpArr[idx] = tmp;
			idx++;
		}

		// a中有剩余数组
		if (i < a.length) {
			while (i < a.length) {
				tmpArr[idx] = a[i];
				i++;
			}
		}

		// b有剩余的值
		if (j < b.length) {
			while (j < b.length) {
				tmpArr[idx] = b[j];
				j++;
			}
		}


		return tmpArr;
	}
}

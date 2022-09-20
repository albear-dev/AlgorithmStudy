package algorithm.sort.strategy;

import algorithm.sort.SortStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class QuickSort2 implements SortStrategy {

  @Override
  public int[] doSort(int[] arr) {
    int[] result = Arrays.stream(arr).toArray();
    l_pivot_sort(result, 0, result.length-1);
    return result;
  }

  private void l_pivot_sort(int[] a, int lo, int hi) {
		if(lo >= hi) {
			return;
		}
		int pivot = partition(a, lo, hi);

		l_pivot_sort(a, lo, pivot - 1);
		l_pivot_sort(a, pivot + 1, hi);
	}

  private int partition(int[] a, int left, int right) {

		int lo = left;
		int hi = right;
		int pivot = a[left];

		while(lo < hi) {

			while(a[hi] > pivot && lo < hi) {
				hi--;
			}

			while(a[lo] <= pivot && lo < hi) {
				lo++;
			}

			swap(a, lo, hi);
		}

		swap(a, left, lo);

		return lo;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}


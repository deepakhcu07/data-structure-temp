package com.deepak.datastructure.sorting.algorithm;

public class SortingUtil {
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void exchange(Comparable []a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

}

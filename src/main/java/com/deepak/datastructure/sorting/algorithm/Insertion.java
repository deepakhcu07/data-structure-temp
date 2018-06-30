package com.deepak.datastructure.sorting.algorithm;

public class Insertion {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable []a) {
		int n = a.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j>=0;j--) {
				if(SortingUtil.less(a[j],a[j-1])) {
					SortingUtil.exchange(a, j-1, j);
				}else {
					break;
				}
			}
		}
	}
	
	public static void main(String []args) {
		String []str = {"S","O","R","T","I","N","G","A"};
		
		Selection.sort(str);
		
		for(String s: str) {
			System.out.print(s+" ");
		}
	}
}

package com.deepak.datastructure.sorting.algorithm;

/**
 * 
 * @author deepak
 * 
 *
 */
public class Selection {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable []a) {
		for(int i=0;i<a.length;i++) {
			int min = i;
			for(int j= i+1;j<a.length;j++) {
				if(SortingUtil.less(a[j], a[min])) {
					min = j;
				}
			}
			SortingUtil.exchange(a, i, min);
		}
	}
	
	public static void main(String []args) {
		String []str = {"Z","B","K","C","P","J","S","O"};
		
		Selection.sort(str);
		
		for(String s: str) {
			System.out.print(s+" ");
		}
	}

}

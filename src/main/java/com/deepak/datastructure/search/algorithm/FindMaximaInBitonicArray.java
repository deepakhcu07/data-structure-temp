package com.deepak.datastructure.search.algorithm;

public class FindMaximaInBitonicArray {

	public static void main(String []args) {
		int []a = {1,5,7,8,22,20,18,15};
		
		int index = getIndexOfMaximaElement(a);
		
		if(index==-1) {
			System.out.println("No Maxima Found");
		}else {
			System.out.println("Maxima = " + a[index]);
		}
		
	}
	
	public static int getIndexOfMaximaElement(int []array) {
		int start = 0;
		int end = array.length -1;
		int mid;
		int index = -1;
		while(start<= end) {
			mid = (start+end)/2;
			
			if(array[mid]>array[mid-1] && array[mid] > array[mid+1]) {
				index = mid;
				break;
			}else if(array[mid] > array[mid-1] && array[mid] < array[mid+1]) {
				start = mid + 1;
			}
			else if(array[mid] < array[mid-1] && array[mid] > array[mid+1]) {
				end = mid - 1;
			}
		}
		return index;
	}
}

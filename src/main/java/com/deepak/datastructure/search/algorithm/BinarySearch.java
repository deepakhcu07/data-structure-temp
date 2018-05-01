package com.deepak.datastructure.search.algorithm;

public class BinarySearch {

	public static void main(String []args) {
		int []a = {1,5,7,8,20,28,35};
		
		int index = find(a,0,a.length-1,5);
		
		if(index==-1) {
			System.out.println("No Key Found");
		}else {
			System.out.println("Key found at index = " +index);
		}
		
	}
	
	public static int find(int []array, int low, int high, int key) {
		if(high<low) {
			return -1;
		}
		
		int mid = low +(high-low)/2;
		
		if(array[mid] == key) {
			return mid;
		} else if(array[mid] < key) {
			return find(array, mid+1, high,key);
		}else {
			return find(array, low, mid-1,key);
		}
	}
	
}

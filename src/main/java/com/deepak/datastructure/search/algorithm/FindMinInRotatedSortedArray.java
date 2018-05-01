/**
 * 
 */
package com.deepak.datastructure.search.algorithm;

/**
 * 
 * 
 * If we pick the middle element, we can compare the middle element with the leftmost (or rightmost) element.
 * If the middle element is less than leftmost, the left half should be selected; if the middle element 
 * is greater than the leftmost (or rightmost), 
 * the right half should be selected. Using recursion or iteration, this problem can be solved in time log(n).
 * @author aditya
 *
 */
public class FindMinInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,5,6,7,0,1,2};
		
		int min = findMin(nums);
		
		System.out.println("Minimum = " + min);

	}
	
	
	public static int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        return findMin(nums,start,end);
    }
	
	private static int findMinimum(int []nums) {
		
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int i=0;
		int j = nums.length -1;
		
		while(i<=j) {
			if(nums[i] <= nums[j]) {
				return nums[i];
			}
			
			int mid = (i+ j)/2;
			
			if(nums[mid] < nums[i]) {
				j= mid;
			}else {
				i=mid+1;
			}
		}
		
		return -1;
	}
	
	private static int findMin(int []nums, int start, int end) {
		if(end < start) {
			return nums[0];
		}
		
		if(end==start) {
			return nums[start];
		}
		
		int mid = start + (end-start)/2;
		
		if(mid < end && nums[mid+1] < nums[mid]) {
			return nums[mid+1];
		}
		
		if(mid > start && nums[mid] < nums[mid-1]) {
			return nums[mid];
		}
		
		if(nums[end] > nums[mid]) {
			return findMin(nums, start, end-1);
		}
		return findMin(nums,mid+1, end);
	}

}

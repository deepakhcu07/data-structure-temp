package com.deepak.datastructure.search.algorithm;

public class FindInRoteatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {5,1,3};
        int target = 3;
        
        int ret = search(nums, target);
        
        System.out.println(ret);

	}
	
	
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int m = i + (j-i)/2;
			
			if(nums[m] == target) {
				return m;
			}
			
			if(nums[i] <= nums[m]) {
				if(nums[i] <=target && target< nums[m]) {
					j = m -1;
				}
				else {
					i = m + 1;
				}
			} else {
				if(nums[m] <  target && target < nums[j]) {
					i = m+ 1;
					
				}else {
					j = m-1;
				}
			}
			

		}

		return -1;
	}

}

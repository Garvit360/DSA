/*
75. Sort Colors
Solved
Medium

Topics
premium lock icon
Companies

Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

*/

//solution 1:
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0; int count1 = 0;int count2 = 0;
        for(int i=0; i < nums.length;i++){
            if (nums[i]==0)
                count0++;
            else if (nums[i]==1)
                count1++;
            else
                count2++;    
        }
        int idx = 0;
        for(int j=0;j<count0;j++){
            nums[idx]=0;
            idx++;
        }
        for(int j=0;j<count1;j++){
            nums[idx]=1;
            idx++;
        }
        for(int j=0;j<count2;j++){
            nums[idx]=2;
            idx++;
        }
        
    }
}

//solution 2:
class Solution {
    public static void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high = nums.length -1;
        while(mid<=high){
            if (nums[mid]==0){
                swap(nums,low, mid);
                low++;
                mid++;
            }else if (nums[mid]==1){
                mid++;
            }else{
                swap(nums, high, mid);
                high--;
            }
        }
    }
}
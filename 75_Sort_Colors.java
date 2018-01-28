/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/


class Solution {
    
//////////////////////one pass/////////////////////////////////
    public void sortColors(int[] nums) {
      if(nums == null || nums.length == 0){
       return; 
      }
      int red = 0; int blue = nums.length - 1;
      int i = 0;  
      while(i <= blue){
          if(nums[i] == 0){
              nums[i] = nums[red];
              nums[red] = 0;
              i++;
              red++;
          } else if(nums[i] == 2){
              nums[i] = nums[blue];
              nums[blue] = 2;
              blue --;
          } else {
              i++;
          }
      }  
    }    
    
    
////////////////////////iterate twice/////////////////////////    
    // public void sortColors(int[] nums) {
    //   if(nums == null || nums.length == 0){
    //       return; 
    //   } 
    //   int[] arr = new int[3];
    //   for(int i = 0; i < nums.length; i++){
    //      arr[nums[i]]++; 
    //   }
    //   int count = 0;  
    //   for(int i = 0; i < 3; i++){
    //       for(int j = 0; j < arr[i]; j++){
    //          nums[count ++] = i; 
    //       }
    //   }  
    // }
}
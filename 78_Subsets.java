/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    ///////////////////iteration 经典解法，like 46////////////////////////
     public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return res;
            }
            res.add(new ArrayList<>());
            for(int i = 0; i < nums.length; i++){
                int size = res.size();
                for(int j = 0; j < size; j++){
                   List<Integer> path = new ArrayList<>(res.get(j));
                   path.add(nums[i]);
                   res.add(path);
                }
            }
         return res;
     }    
    ///////////////////backtrace////////////////////////
    // public List<List<Integer>> subsets(int[] nums) {
    //     Arrays.sort(nums);
    //     List<List<Integer>> res = new ArrayList<>();
    //     if(nums == null || nums.length == 0){
    //         return res;
    //     }
    //     helper(nums,res, new ArrayList<>(), 0);
    //     res.add(new ArrayList<Integer>());  //don't forget to add a blank
    //     return res;
    // }
    // private void helper(int[] nums,List<List<Integer>> res, List<Integer> path, int start){
    //     for(int i = start; i < nums.length; i++){
    //         path.add(nums[i]);
    //         res.add(new ArrayList<>(path));
    //         helper(nums, res, path, i + 1);
    //         path.remove(path.size() - 1);     
    //     }
    // }
}
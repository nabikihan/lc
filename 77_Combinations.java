/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
       public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if(n == 0 || k == 0){
                return res;
            }   
            List<Integer> path = new ArrayList<>(Collections.nCopies(k,0));
            int i = 0;
            while(i >= 0){
                  int value = path.get(i);
                  path.set(i, ++value);
                  if(path.get(i) > n){
                      i--;
                  } else if(i == k - 1){
                      res.add(new ArrayList<>(path));
                  } else {
                      i++;
                      path.set(i, path.get(i - 1));
                  }
            }
            return res;  
       }       
    
    
////////////////////自己写出的backtrace方法//////////////////
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> res = new ArrayList<>();
//         if(n == 0 || k == 0){
//             return res;
//         }

//         helper(n, k, res, new ArrayList<>(), 1);
//         return res;
//     }

//     private static void helper(int n, int k, List<List<Integer>> res, List<Integer> path, int start){
//         if(path.size() == k){
//             res.add(new ArrayList<>(path));
//             return;
//         }

//         for(int i = start; i <= n; i++){
//             path.add(i);
//             helper(n, k, res, path, i + 1);
//             path.remove(path.size() - 1);    
//         }   
//     }
}  
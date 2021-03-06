class Solution {
///////////////////using string.split/////////////////////////////////// 
    public String simplifyPath(String path) {
        
        Stack<String> s = new Stack<String>();
        String[] strs = path.split("/");
        for(String elem : strs){
            if(!s.isEmpty() && elem.equals("..")){  //"/../" 这种情况要考虑
                s.pop();
            } else if(!elem.equals("..") && !elem.equals(".") && !elem.equals("")){
                s.push(elem);
            }
        }
        String res = "";
        while(!s.isEmpty()){
            res = "/" + s.pop() + res;
        }
  
        return res.isEmpty() ? "/" : res;
    }
    ///////////////////////basic solution with stack ,without s.split//////////   
//     public String simplifyPath(String path) {
//         if(path == null || path.length() == 0){
//             return  null;    //这个并不需要写，会直接由res返回“／”
//         }
        
//         Stack<String> s = new Stack<String>();
//         int j = 0;
//         for(int i = 0; i < path.length(); i++){
//             if(path.charAt(i) == '/'){
//                 j = i;
//             } else if(i == path.length() - 1 || path.charAt(i + 1) == '/'){
//                 String sub = path.substring(j + 1, i + 1);
//                // if(!s.isEmpty() && sub.equals("..")){  错，这里不能这么写 见例子“／../” 
//               if(sub.equals("..")){
//                   if(! s.isEmpty()){
//                      s.pop(); 
//                   }                         
//                 } else if( !sub.equals(".")){
//                     s.push(sub);
//                 }
//             }
//         }
//         String res = "";
//         while(!s.isEmpty()){
//             res = "/" + s.pop() + res;
//         }

//         if(res.length() == 0){
//             return "/";
//         }
//         return res;
//     }
}
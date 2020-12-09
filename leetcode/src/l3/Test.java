package l3;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring1("pwwkew"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //双指针
        //用一个数组记录已经访问的情况
        int length = s.length();
        if(length == 0) return 0;
        int char_num = 300;
        int[] visited = new int[char_num];
        int index_f = 0;
        int index_e = 0;

        int ans = 0;
        int ans_tmp = 0;
        while (index_e < length){
            int visit_now = s.charAt(index_e);
            ans_tmp ++;
            if(visited[visit_now] == 0){
                visited[visit_now] ++;
            }
            else{
                while(s.charAt(index_f) != s.charAt(index_e)) {
                    visited[s.charAt(index_f)] --;
                    index_f++;
                    ans_tmp--;
                }
                index_f++;
                ans_tmp--;
            }
            ans = Math.max(ans, ans_tmp);
            index_e ++;
        }
//        System.out.println(ans);
        return ans;
    }



    public int lengthOfLongestSubstring1(String s) {
        // 双指针判断字串的边界
        // 用HashMap来存<char-出现的位置>
        if(s.length() <= 1)
            return s.length();
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap();
        int maxLength = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                while(left<right){
                    if(s.charAt(left) == s.charAt(right)){
                        map.remove(s.charAt(left));
                        left++;
                        break;
                    }
                    map.remove(s.charAt(left));
                    left++;
                }
            }else{
                map.put(s.charAt(right), right);
                right++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        // map.add()
        return maxLength;
    }


    public int lengthOfLongestSubstring2(String s){
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        int ans = 0;
        int right = -1;
        for(int i = 0; i < n; i++){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(right + 1 < n && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}





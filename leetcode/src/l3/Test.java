package l3;

public class Test {
    public static void main(String[] args){
        Solution s = new Solution();
        s.lengthOfLongestSubstring(" ");
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
}
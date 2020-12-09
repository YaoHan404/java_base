package l5;

/**
 *
 * 从每一个字符串的中心字符开始遍历
 * 分为奇数/偶数个情况
 *
 * @author han yao
 * @date 2020/12/4 15:05
 */
public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "ac";
        System.out.println(solution.longestPalindrome(s));
    }
}


class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length==0)
            return s;
        int maxLength = 0;
        String ans = "";
        for (int i = 0; i < length; i++) {
            // 奇数个
            for (int j = 0; j < length; j++) {
                if(i-j<0 || i+j>=length) break;
                if(s.charAt(i-j) != s.charAt(i+j)) break;
                if( 2*j+1 > maxLength){
                    maxLength = 2*j+1;
                    ans = s.substring(i-j, i+j+1);
                }
            }
            // 偶数个
            for (int j = 0; j < length; j++) {
                if(i-j<0 || i+j+1>=length) break;
                if(s.charAt(i-j) != s.charAt(i+j+1)) break;
                if( 2*(j+1) > maxLength){
                    maxLength = 2*(j+1);
                    ans = s.substring(i-j, i+j+2);
                }
            }
        }
        return ans;
    }
}
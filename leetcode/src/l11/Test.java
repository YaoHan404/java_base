package l11;

/**
 * @author han yao
 * @date 2020/12/4 19:06
 */
public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] t = new int[]{1,2};
        System.out.println(solution.maxArea(t));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right){
            int nowArea = (right - left)*Math.min(height[left], height[right]);
            ans = Math.max(ans, nowArea);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }
}
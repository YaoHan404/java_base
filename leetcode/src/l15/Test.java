package l15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * 这里的代码写的不好
 * 不需要set来去重
 * 一开始写入答案的时候就可以判断
 *
 * @author han yao
 * @date 2020/12/4 21:03
 */
public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] t = new int[]{1,2,3,4};
        System.out.println(solution.threeSum(t));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        遍历每一个数字nums[i], 题目变为n次的两数之和，两数和为-nums[i]
        而两数之和有两种方式，用set或者双指针
        这里将nums排序后用双指针
        */
        Arrays.sort(nums);
        List ans = new ArrayList();
        // 对于重复的答案，用set处理
        int length = nums.length;
        for(int i = 0; i < length; i++){
            // 减少遍历的可能，防止超时
            if(i>0 && nums[i]==nums[i-1])continue;
            int tmpSum = nums[i];
            int left = 0;
            int right = length-1;
            while(left < right){
                if(left == i){
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }
                if(nums[left] + nums[right] == -tmpSum){
                    List tmpAns = new ArrayList(Arrays.asList(tmpSum, nums[left], nums[right]));
                    Collections.sort(tmpAns);
                    ans.add(tmpAns);
                    left++;
                }
                else if(nums[left] + nums[right] > -tmpSum)
                    right--;
                else
                    left++;
            }
        }
        HashSet set = new HashSet(ans);
        ans = new ArrayList(set);
        return ans;
    }
}
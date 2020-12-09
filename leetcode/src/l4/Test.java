package l4;

/**
 * 寻找两个排序数组的第k个数字
 *
 * @author han yao
 * @date 2020/11/30 22:53
 */
public class Test {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] num1 = new int[]{3};
        int[] num2 = new int[]{1,2,4,5,6};
        System.out.println(s.findMedianSortedArrays(num1, num2));
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 利用二分，每次删除一半的数字
        // 既然二分，那么就用递归
        int ansLeft = findMedian(nums1, 0, m-1, nums2, 0, n-1, (n+m-1)/2);
        int ansRight = findMedian(nums1, 0, m-1, nums2, 0, n-1, (n+m)/2);
        return (ansLeft + ansRight)*0.5;
    }

    // 在寻找第k个数过程中进行划分
    public int findMedian(int[] nums1, int mBegin, int mEnd, int[] nums2, int nBegin, int nEnd, int k){
        int median = (k-1)/2;
        // 永远让nums1剩余的数字少于nums2, 这样就可以免去后面分别对nums1、nums2判断
        if(mEnd - mBegin > nEnd - nBegin)
            return findMedian(nums2, nBegin, nEnd, nums1, mBegin, mEnd, k);
        // 若nums1已经完全删除, 则直接返回nums2的第k个数字
        if(mEnd < mBegin) return nums2[nBegin + k];
        // 若k已经等于0，则返回两个数组中最小的一个数字
        if(k == 0) return Math.min(nums1[mBegin], nums2[nBegin]);

        // 若nums1剩余的数字不够删除
        if(mEnd - mBegin + 1 < median + 1) {
            if(nums1[mEnd] < nums2[nBegin + median])
                return findMedian(nums1, mEnd + 1, mEnd, nums2, nBegin, nEnd, k - (mEnd - mBegin + 1));
            else
                return findMedian(nums1, mBegin, mEnd, nums2, nBegin + median + 1, nEnd, k - median -1);
        }else{
            // nums1 较小，删除nums1的部分
            if(nums1[mBegin + median] < nums2[nBegin + median])
                return findMedian(nums1, mBegin + median + 1, mEnd, nums2, nBegin, nEnd, k - median -1);
            else
                return findMedian(nums1, mBegin, mEnd, nums2, nBegin + median + 1, nEnd, k - median -1);
        }

    }
}
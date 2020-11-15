package week215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author han yao
 * @date 2020/11/15 上午10:35
 */
public class Test {
    public static void main(String[] args){
        Solution s = new Solution();
//        int[] a = new int[5];
        int[] a = {1,1};
        System.out.println(s.minOperations(a, 3));
    }
}


/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
class OrderedStream {
    String[] all;
    int index;
    int length;
    public OrderedStream(int n) {
        all = new String[n];
        index = 0;
        length = n;
    }

    public List<String> insert(int id, String value) {
        all[id-1] = value;
        List<String> tmp = new ArrayList<String>();
        if(all[index]!=null){
            while(index<length && all[index]!=null) {
                tmp.add(all[index]);
                index++;
            }
        }
        return tmp;
    }
}


class Solution2 {
    public boolean closeStrings(String word1, String word2) {
        //长度不一样，有不一样的char，直接false
        if(word1.length() != word2.length())
            return false;
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            w1[word1.charAt(i)-'a'] ++;
            w2[word2.charAt(i)-'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if((w1[i] != 0 && w2[i]==0)||(w1[i]==0&&w2[i]!=0))
                return false;
        }

        //char的种类一样，并且在不考虑具体char时，数量应该一样
        Arrays.sort(w1);
        Arrays.sort(w2);
        for (int i = 0; i < 26; i++) {
            if(w1[i] != w2[i])
                return false;
        }
        return true;
    }
}


class Solution {
    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        long[] sumLeft = new long[length];
        long[] sumRight = new long[length];
        long sum = 0;
        int ans = 1000000;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            sumLeft[i] = sum;
            if(sum == x)
                ans = Math.min(ans, i+1);
        }
        sum = 0;
        for (int i = length-1; i > 0 ; i--) {
            sum += nums[i];
            sumRight[i] = sum;
            if(sum == x)
                ans = Math.min(ans, length-i);
        }

        Map m = new HashMap<Integer,Integer>();
        Map r = new HashMap<Integer,Integer>();
        for (int i = 0; i < length; i++) {
            r.put(sumRight[i], i);
        }
        for (int i = 0; i < length; i++) {
            m.put(sumLeft[i], i);
            if(r.containsKey(x-sumLeft[i]) && i <  (int)r.get(x-sumLeft[i]))
                ans = Math.min(ans, i +1 + length - (int)r.get(x-sumLeft[i]));
        }

        if(ans==1000000) return -1;
        return ans;
    }
}


package l17;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.String;

/**
 * @author han yao
 * @date 2020/12/4 21:08
 */
public class Test {
    public static void main(String[] args){
        Solution s = new Solution();
        String d = "";
        List<String> ans = s.letterCombinations(d);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        // 用Map来存储数字和键值的对应关系
        HashMap<Character, List<Character>> map= new HashMap<Character, List<Character>>();
        List<String> ans = new ArrayList<String>();
        // 注意String的== 和equal() 问题
//        if(digits=="")return ans;
        if(digits.length()==0)return ans;
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        String tmpAns = "";
        traceBack(map, ans, tmpAns, digits, 0);
        return ans;
    }

    public void traceBack(HashMap<Character, List<Character>> map, List<String> ans, String tmpAns, String digits, int index){
        // 终止条件
        if(index == digits.length()-1){
            //放入最后一层
            Character charNow = digits.charAt(index);
            List<Character> chars = map.get(charNow);
            for(Character c:chars){
                ans.add(tmpAns + c);
            }
            return;
        }
        // 做选择
        Character charNow = digits.charAt(index);
        List<Character> chars = map.get(charNow);
        for(Character c:chars){
            traceBack(map, ans, tmpAns + c, digits, index+1);
        }
    }
}
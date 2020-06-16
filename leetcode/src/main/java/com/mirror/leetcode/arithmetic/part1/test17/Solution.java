package com.mirror.leetcode.arithmetic.part1.test17;


import java.util.*;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-08 20:06
 **/
public class Solution {

    public List<String> letterCombinations(String digits) {

        Map<String, String[]> map = new HashMap<>(64);
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

        TreeSet<String> resultSet = new TreeSet();

        final char[] chars = digits.toCharArray();
        final int length = chars.length;

        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String strItem = chars[i] + "";
            String[] charsItem = map.get(strItem);
            list.add(charsItem);
        }

        for (int j = 0; j < length; j++) {
            String[] chars1 = list.get(j);
            resultSet = appendStr(chars1, resultSet);
        }
        return new ArrayList<>(resultSet);
    }


    private TreeSet<String> appendStr(String[] strArr, TreeSet<String> resultSet) {
        if (resultSet.size() == 0) {
            for (String str : strArr) {
                resultSet.add(str);
            }
            return resultSet;
        } else {
            TreeSet<String> resultSetResult = new TreeSet<>();
            for (int i = 0; i < strArr.length; i++) {
                for (String strSet : resultSet) {
                    strSet = strSet + strArr[i];
                    resultSetResult.add(strSet);
                }
            }
            return resultSetResult;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

}

package com.xing.leetcode.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mystery
 */
public class StringAlgorithm {
    public static void main(String[] args) {

    }

    /**
     * 反转字符串
     * @param arr
     * @return
     */
    private static char[] reverseStringWithCharArr(char[] arr) {
        int f = 0;
        int l = arr.length - 1;
        while (f < l) {
            char temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            f++;
            l--;
        }
        return arr;
    }

    /**
     * 反转整数
     * @param x
     * @return
     */
    private static int reverseInt(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    /**
     * 字符串中的第一个唯一字符
     * @return
     */
    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.get(s.toCharArray()[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有效的字母异位词
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//        Map<Character, Integer> sMap = new HashMap<>();
//        Map<Character, Integer> tMap = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
//        }
//        for (char c : t.toCharArray()) {
//            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
//        }
//        for (Map.Entry<Character, Integer> ent : sMap.entrySet()) {
//            if ((tMap.getOrDefault(ent.getKey(), 0) == 0)
//            || !tMap.get(ent.getKey()).equals(sMap.get(ent.getKey()))) {
//                return false;
//            }
//        }
//        for (Map.Entry<Character, Integer> ent : tMap.entrySet()) {
//            if ((sMap.getOrDefault(ent.getKey(), 0) == 0)
//                || !tMap.get(ent.getKey()).equals(sMap.get(ent.getKey()))) {
//                return false;
//            }
//        }
//        return true;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int f = 0;
        int l = s.length() - 1;
        while(l > f) {
            if (Character.isLetterOrDigit(chars[l])) {
                if (Character.isLetterOrDigit(chars[f])) {
                    if (chars[l] == chars[f]) {
                        f++;
                        l--;
                    } else {
                        return false;
                    }
                } else {
                    f++;
                }
            } else {
                l--;
            }
        }
        return true;
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    private static String longestCommonPrefix(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return "";
        }
        //默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //不断的截取
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    /**
     * 字符串转整数
     * @param s
     * @return
     */
    private static int stringConvertInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        int res = 0;//最终结果
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = str.length();
        //判断符号
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }
        for (; index < length; ++index) {
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9) {
                break;
            }
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + digit;
            }
        }
        return sign * res;
    }

    /**
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     *
     * 一般字符串匹配的时候，最简单的一种方式，就是子串从头开始和主串匹配。
     *
     * 如果匹配失败，子串再次从头开始，而主串从上次匹配的下一个字符开始
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param haystack
     * @param needle
     * @return
     */
    private static int strStr(String haystack, String needle) {
        if (needle == null) {
            return -1;
        }
        int n = 0, h = 0;
        while (n < haystack.length() && h < needle.length()) {
            if (haystack.charAt(n) == needle.charAt(h)) {
                n++;
                h++;
            }
            else {
                n = n - h + 1;
                h = 0;
            }
        }
        if (h == needle.length()) {
            return n - h;
        }
        return -1;
    }

    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * 例如，数字字符串 "3322251" 的描述 ： 23321511
     * 输入：n = 4
     * 输出："1211"
     * 解释：
     * countAndSay(1) = "1"
     * countAndSay(2) = 读 "1" = 一 个 1 = "11"
     * countAndSay(3) = 读 "11" = 二 个 1 = "21"
     * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 先确立递归出口 n = 1时 为1
     * 对上一个结果进行遍历获取值
     * 设定计数器，计算同一个数字出现的次数
     * 如果数字相同，计数器加一
     * 若当前不满足，则将上次的值记录下，并重置计数器，重置需要判断是否重复的字符
     * 将最后的结果也追加到字符串上
     *
     * @param n
     * @return
     */
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 假设我们获得上一次的结果为 s = 112213
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char local = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 计算同一个数字出现的次数
            if (local == s.charAt(i)) {
                count++;
            } else {
                // 不是同一个数字就记录下来
                sb.append(count);
                sb.append(local);
                // 重置出现次数为1
                count = 1;
                local = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(local);
        return sb.toString();
    }
}

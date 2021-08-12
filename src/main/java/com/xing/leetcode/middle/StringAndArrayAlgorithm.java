package com.xing.leetcode.middle;



import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;
import java.util.Map;


/**
 * @author Mystery
 */
public class StringAndArrayAlgorithm {
    public static void main(String[] args) throws Exception {
//        FileInputStream inputStream = new FileInputStream("/Users/xingmac/Downloads/05 电商项目微服务架构拆分.pdf");
        int i = 100_0_12_000;
        System.out.println(i);
//        System.out.println(System.getenv());
        Map<String, String> env = System.getenv();
        System.out.println(env.get("LOGNAME"));
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, bytesRead);
//        }
//        int size = outputStream.size();
//        System.out.println(size);
//        String s = new String(Base64.getEncoder().encode(outputStream.toByteArray()), Charset.forName("US-ASCII"));
    }

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvpj16/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}

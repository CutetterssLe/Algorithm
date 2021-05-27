package com.xing;

import java.util.*;

/**
 * @author Mystery
 */
public class First {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.put("4", "2");
//        Set<Map.Entry<String, Object>> set = map.entrySet();
//        for (Map.Entry<String, Object> entry : set) {
//            if (entry.getKey().equals("1")) {
//                map.remove(entry.getKey());
//            }
//        }
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            if (next.getKey().equals("1")) {
                iterator.remove();
            }
        }
        System.out.println(map);
    }

    private static int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}

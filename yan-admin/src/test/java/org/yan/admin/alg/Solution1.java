package org.yan.admin.alg;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static List<String> func1(List<String> l1, List<String> l2) {
        List<String> res = new LinkedList<>();
        int length1 = l1.size();
        int length2 = l2.size();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < length1 && idx2 < length2) { // 迭代并筛选
            String s1 = l1.get(idx1);
            String s2 = l2.get(idx2);
            if (s1.compareTo(s2) == 0) {
                res.add(s1);
                idx1++;
                idx2++;
            } else if (s1.compareTo(s2) > 0) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

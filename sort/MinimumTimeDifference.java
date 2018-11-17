package sort;

import java.util.*;

/*
 * Leetcode 539 
 * 
 * Counting/Bucket sort
 */
public class MinimumTimeDifference {
    //Counting sort
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
    
    //Normal sort 
    public int findMinDifference1(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>(){
            public int compare(String s1, String s2){
                int a = Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(3));
                int b = Integer.parseInt(s2.substring(0, 2)) * 60 + Integer.parseInt(s2.substring(3));
                return a - b;
            }
        });
        int ret = Integer.MAX_VALUE;
        int pre = -1; 
        for(String s : timePoints){
            if(pre == -1){
                pre = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
                continue;
            }
            int cur = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
            ret = Math.min(ret, Math.min(cur-pre, 1440 - cur+pre));
            pre = cur;
        }
        int cur = Integer.parseInt(timePoints.get(0).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(0).substring(3));
        ret = Math.min(ret, Math.min(pre - cur, 1440 - pre + cur));
        return ret;
    }
}

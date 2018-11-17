package heap;

import java.util.*;


//不仅用到了heap， 还运用了双指针！！经典题目
public class FindKpairswithSmaleestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
         if(nums1.length==0 || nums2.length==0 || k==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]+a[1]-b[0]-b[1]));
        for(int i=0;i<k&&i<nums1.length;i++) pq.add(new int[]{nums1[i], nums2[0], 0});
        while(k-->0&& !pq.isEmpty()){
            int[] cur = pq.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2]==nums2.length-1) continue;
            pq.add(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}

package twoPointers;

import java.util.*;

public class ThreeSomClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ret = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int lo = i+1, hi = nums.length-1;
            while(lo<hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if(sum == target) return target;
                if(Math.abs(sum-target) < Math.abs(ret-target)) ret = sum;
                if(sum<target) lo++;
                else hi--;
            }
        }
        return ret;
    }
}

package twoPointers;

import java.util.*;

//Sort the array
//Fix first num, bound other two elements in range [i+1, len-1]
//Do a linear scan with that range.
//O(n^2)


//Take away: For sorted array, we can use binary search to search 
//certain element. But if we wanna find all pairs that fulfills 
//a result, we can do a two-end towards central scan. Depending
//on the comparison between sum and result, we decide either move
//left or right end pointer. 

//Similar problems: ThreeSumClosest, ContainerWithMostWater

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if(i>0 && num[i] == num[i-1]) continue;//skip duplicate
            if(num[i]+num[i+1]+num[i+2]>0) break;//too large, finish
            if(num[i]+num[num.length-1]+num[num.length-2]<0) continue;//too small, skip
           
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi])); // Note this Arrays.asList() API, very useful
                    while (lo < hi && num[lo] == num[lo+1]) lo++;   // skip dups
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } 
                //adjust ends according to comparing results
                else if (num[lo] + num[hi] < sum) {
                    while (lo < hi && num[lo] == num[lo+1]) lo++; 
                    lo++;
                }
                else {
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    hi--;
                }
           }
            
        }
        return res;
    }
}

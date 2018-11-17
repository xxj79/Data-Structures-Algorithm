package array;

import java.util.*;

public class FindAllDuplicatesinArray {
    //swapping
    public List<Integer> findDuplicates(int[] nums) {
        for(int i=0;i<nums.length;i++)  while(nums[i]!=nums[nums[i]-1]) swap(nums, i, nums[i]-1);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) if(nums[i]!=i+1) res.add(nums[i]);
        return res;
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //Marking
    public List<Integer> findDuplicatesMarking(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}

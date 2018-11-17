package backtrack;

import java.util.*;

public class Permutations {
    //No duplicates
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int[] m = new int[nums.length];
        dfs(0, m, nums, new ArrayList<>(), ret);
        
        return ret;
    }
    
    void dfs(int pos, int[] m, int[] nums, List<Integer> list, List<List<Integer>> ret){
        if(pos == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(m[i]==0){
                m[i] = 1;
                list.add(nums[i]);
                dfs(pos+1, m, nums, list, ret);
                list.remove(list.size()-1);
                m[i] = 0;
            }
        }
    }
    
    //Contain duplicates
    //Sort first, then skip duplicates
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], ret, new ArrayList<>());
        return ret;
    }
    
    void dfs(int[] nums, boolean[] visited, List<List<Integer>> ret, List<Integer> list){
        if(list.size() == nums.length) {
            ret.add(new ArrayList(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, ret, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}

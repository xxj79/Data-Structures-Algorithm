package dp;

//So assuming the sum of the array it SUM, so eventually player1 and player2 
//will split the SUM between themselves. For player1 to win, he/she has to get 
//more than what player2 gets. If we think from the prospective of one player, 
//then what he/she gains each time is a plus, while, what the other player gains 
//each time is a minus. Eventually if player1 can have a >0 total, player1 can win.

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length])>=0;
    }
    private int helper(int[] nums, int s, int e, Integer[][] mem){    
        if(mem[s][e]==null)
            mem[s][e] = s==e ? nums[e] : Math.max(nums[e]-helper(nums,s,e-1,mem),nums[s]-helper(nums,s+1,e,mem));
        return mem[s][e];
    }
}

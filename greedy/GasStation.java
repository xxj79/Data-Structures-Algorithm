package greedy;

public class GasStation {
    
  //重点：1. 如果B是第一个A不能到达的点，所有A和B之间的点都不能到达B。（反正法：如果C能到达B，我们知道A能到达C所以A不可能不能到达B，矛盾！）
    //  2. 将所有差求和，如果不小于0，则存在解。

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0;
        int j = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            } 
            
            total += gas[i] - cost[i];
        }
        return total >= 0 ? (j + 1)%gas.length : -1;
    }
}

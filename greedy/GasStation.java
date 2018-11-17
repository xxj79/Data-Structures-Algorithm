package greedy;

public class GasStation {
    
  //�ص㣺1. ���B�ǵ�һ��A���ܵ���ĵ㣬����A��B֮��ĵ㶼���ܵ���B���������������C�ܵ���B������֪��A�ܵ���C����A�����ܲ��ܵ���B��ì�ܣ���
    //  2. �����в���ͣ������С��0������ڽ⡣

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

package knapsack;
//�ٱ������⣬ѡȡ˳��ͬ�㲻ͬ�ַ�����
//���Կ���ֱ��һάdp��0�����������������ÿ��������������Ԫ�ر���

/*
Question
Given an integer array nums with all positive numbers and no 
duplicates, find the number of possible combinations that add 
up to a positive integer target.

Notice
The different sequences are counted as different combinations.

Example
Given nums = [1, 2, 4], target = 4
The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]

return 6


Solution
dp[j]��ʾ��������Ϊjʱ������nums��װ��j�ķ���������
�����뵽�ķ����Ƕ��ڵ�ǰ��������j�������������Ԫ��Ϊ��ǰ������Ԫ��i����iԪ��������ķ���
����Ϊdp[j - nums[i]]����ʱҪ��j - nums[i] >= 0����������Ԫ��ȫ����������iΪֹ��
���У���ʼ��dp[0]=1����ʾ����Ԫ�ؽ�����Ϊ0�ı���װ���ķ�����Ϊ1����ʲôԪ�ض���ȡ��һ�ַ�������

����Ⲣ���ѣ�����Ҫע��Ҫ��IV��V������IV��V�еķ�����Ԫ��λ���й�ϵ��Ԫ�ص����λ�ò��ܱ仯��
������ȡ�����Ԫ����ȡǰ���Ԫ�أ�����ͬԪ����ɵķ�������Ϊһ�ַ������������в�ͬ������dp[j]��
����Ϊǰi����Ʒװ������j�ķ����������ֻ��i֮ǰ����Ʒ��أ�����i֮�����Ʒ�޹ء��������˵����ͬ
��˳����Ϊ�ǲ�ͬ�ķ�������˺�Ԫ��λ���޹أ�������ȡ�����Ԫ����ȡǰ���Ԫ�أ�����ͬԪ�صĲ�ͬ��
�б���Ϊ��ͬ�ķ�������dp[j]��ʾ��������numsװ������j�ķ��������Ǻ�����������Ԫ���йء�

֮ǰ�����ܹ���һάdp��ʾ�ı�����ʵ����Ϊ��ǰ�е�ֵֻ����һ���йأ�����ö�̬�������о��У�
���ֱ������һ�и��µ�ǰ�е�״̬��ֻ��Ҫһ�м��ɣ�����䱾�ʾ��ǻ��Ƕ�άdp����������������һάdp��
����ǰ��������װ����ֻ��֮ǰ������װ�Ľ���йأ�ֻ����ÿ����װ��Ҫ��������nums������Ѱ����ص�֮ǰ
������״̬�����Ҫ������forѭ����
*/

public class FakeKnapsack {
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

package knapsack;

/*
Given n kind of items with size Ai and value Vi( each item 
has an infinite number available) and a backpack with size m. 
What's the maximum value can you put into the backpack?

Notice
You cannot divide item into small pieces and the total size of 
items you choose should smaller or equal to m.


Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], 
and a backpack with size 10. The maximum value is 15.


Solution
������II��˼��һ����f[j]��ʾ����Ϊj�ı�����ǰi����Ʒ��ȡ�����ֵ��������Ʒ�����ظ�ѡȡ��
����Ʒ��0������n��1��ÿ��ֻ�б�A[i]��ı����������п��ܱ����¡�
��II��ͬ���ǣ��������Ʒ�����ظ�ѡ�������ڲ����j��ʱ���С���������������Ʒ�����ظ�ѡȡ��
����һ��ʼ��j��ʱ��ȡ��i��Ȼ������j��������j'��ʱ����ȡ��i����ǡ��j = j' - A[i]��
�����������i�ͱ��ظ�ѡȡ������Ӵ���С������������Ʒֻ��ȡһ�Σ�����II���ǴӴ���С������
*/

public class KnapsackwithRepetition {
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        int[] f = new int[m + 1];

        for(int i = 0; i < A.length; i++){
            for(int j = A[i]; j <= m; j++){
            //���ڵ�ǰ��Ʒi����j��С����Ļ����ܿ�����j֮ǰ��j-A[i]ʱ�Ѿ��Ź���i����Ʒ�ˣ���jʱ�ٷž����ظ����룻��j�Ӵ�С����j֮ǰ�����������û�и��¹��������ܷŹ���i����Ʒ�����Բ����ظ����롣
                if(f[j - A[i]] + V[i] > f[j]){
                    f[j] = f[j - A[i]] + V[i];
                }
            }
        }

        return f[m];
    }
}

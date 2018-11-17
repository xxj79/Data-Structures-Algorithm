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
这道题和II的思想一样，f[j]表示容量为j的背包对前i件物品能取的最大值，其中物品可以重复选取。
对物品从0遍历到n－1，每次只有比A[i]大的背包容量才有可能被更新。
和II不同的是，这道题物品可以重复选择，所以内层遍历j的时候从小到大遍历，这样物品可以重复选取。
比如一开始在j的时候取了i，然后随着j的增大，在j'的时候又取了i，而恰好j = j' - A[i]，
在这种情况下i就被重复选取。如果从大往小遍历则所有物品只能取一次，所以II中是从大往小遍历。
*/

public class KnapsackwithRepetition {
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        int[] f = new int[m + 1];

        for(int i = 0; i < A.length; i++){
            for(int j = A[i]; j <= m; j++){
            //对于当前物品i，若j从小到大的话，很可能在j之前的j-A[i]时已经放过第i件物品了，在j时再放就是重复放入；若j从大到小，则j之前的所有情况都没有更新过，不可能放过第i件物品，所以不会重复放入。
                if(f[j - A[i]] + V[i] > f[j]){
                    f[j] = f[j - A[i]] + V[i];
                }
            }
        }

        return f[m];
    }
}

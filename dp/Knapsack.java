package dp;
/*
 * 0/1 knapsack
 */
public class Knapsack {
    //Bottom up
    public int knapsack(int[] val, int[] w, int c){
	int n = val.length;
	int[][] dp = new int[n+1][c+1]; //choose among first i items with weight <= j 
	
	for(int i=1;i<=n;i++){
	    for(int j=1;j<=c;j++){
		dp[i][j] = dp[i-1][j];
		if(j>=w[i-1])
		    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i-1]] + val[i-1]);
	    }
	}
	return dp[n][c];
    }
    
    //Optimized to 1D space
    public int knapsack1D(int[] val, int[] w, int c){
	int n = val.length;
	int[] dp = new int[c+1];
	
	//Concise way to implement this kind of problem (0/1 knapsack)
	for(int j = 1;j<=n;j++){
	    for(int i=c;i>=w[j-1];i--){
		dp[i] = Math.max(dp[i], dp[i-w[j-1]] + val[j-1]); //��Ϊ������Ҫ��һ�е������ݣ�����һάʱ�����������
								//һ��������Ҫ���е�������ʱ�����Ƕ��Ǵ�������ɨ��
	    }
	}
	
	return dp[c];
    }
    
    public static void main(String[] args){
	Knapsack obj = new Knapsack();
	int[] val = {60, 100, 120};
	int[] w = {10, 20, 30};
	int c = 50;
	System.out.println(obj.knapsack1D(val, w, c));
    }
    
    
    //Topdown memoization
    int ret = 0;
    public int knapsackMemo(int[] val, int[] w, int c){
	int n = val.length;
	int[][] dp = new int[n+1][c+1];
	for(int i=0;i<=n;i++){
	    for(int j=0;j<=c;j++){
		dp[i][j] = -1;
	    }
	}
	return dfs(dp, c, n, val, w);
    }
    
    private int dfs(int[][] dp, int c, int n, int[] val, int[] w){
	if(c==0 || n==0) return 0;
	if(dp[n][c]!=-1) return dp[n][c];
	
	int best = dfs(dp, c-1, n-1, val, w);
	if(c>=w[n-1]) best = Math.max(best, val[n-1]+dfs(dp, c-w[n-1], n-1, val, w));
	
	dp[n][c] = best;
	return dp[n][c];
    }
    
    
    
    
    //With repetition ?  (each item have infinite copies available)
    //�������������ѭ���ɴӴ�С����˴�С���󡣱�ʾ�����ظ�ѡȡ������Ϊ���濼�ǵ�������ܰ���֮ǰ�Ѿ�ѡ����ǰ��Ʒ�Ŀ��ܣ�
    public int knapsackInfiniteCopies(int[] v, int[] w, int C){
	int[] dp = new int[C+1];
	for(int i = 1;i<=C;i++){
	    for(int j = 0;j<v.length;j++){
		if(i>=w[j]) dp[i] = Math.max(dp[i], dp[i-w[j]] + v[j]);
	    }
	}
	return dp[C];
    }
}

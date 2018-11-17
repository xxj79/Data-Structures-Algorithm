package test;

import java.util.*;
import java.io.*;

public class Test {
    
    static int mod = 1000000007;
    int b = 0;
    
    public static void main(String[] args){
	int n = -2147483648;
	int[][] a = new int[][]{{17, 82}, {1, -44}};
	System.out.println(minFallingPathSum(a));
    }
    
    
    public static int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length, ret = 100000;
        int[][] dp = new int[m][n];
        for(int i = 0; i<n; i++) {
            dp[0][i] = A[0][i];
        }
        for(int i = 1; i<m; i++){
            for(int j = 0; j<n; j++){
                int can = dp[i-1][j];
                if(j-1>0) can = Math.min(can, dp[i-1][j-1]);
                if(j+1<n) can = Math.min(can, dp[i-1][j+1]);
                dp[i][j] = can + A[i][j];
            }
        }
        for(int x : dp[m-1]){ 
            ret = Math.min(ret, x);
            System.out.println(x);
        }
        
        return ret;
    }
    
    static int get(int[] a){
	
	return mod;
    }
}

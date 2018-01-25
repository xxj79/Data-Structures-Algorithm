package dp;

import java.util.*;

public class Triangle {
	//Treat it like a binary tree, solve it bottom up way

//	¡®Bottom-up¡¯ DP, on the other hand, is very straightforward: 
//	we start from the nodes on the bottom row; 
//	the min pathsums for these nodes are the values of the nodes themselves. 
//	From there, the min pathsum at the ith node on the kth row would be the 
//	lesser of the pathsums of its two children plus the value of itself, i.e.:
//
//	minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
//	Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed, we can simply set minpath as a 1D array, and iteratively update itself:
//
//	For the kth level:
//	minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 
	
	public int minimumTotal(List<List<Integer>> triangle) {
            int[] A = new int[triangle.size()+1];
            for(int i=triangle.size()-1;i>=0;i--){  // row from bottom up to the top
                for(int j=0;j<triangle.get(i).size();j++){ // horizontal traverse
                    A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
                }
            }
            return A[0];
        }
}

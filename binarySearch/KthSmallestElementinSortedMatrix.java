package binarySearch;

import java.util.*;

/*
 * Leetcode 378
 * 
 * Range Based Binary Search (Find and count position)
 */
public class KthSmallestElementinSortedMatrix {
    public int kthSmallest(int[][] matrix, int k){
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], r = matrix[m-1][n-1];
        while(l<r){
            int mid = l+(r-l)/2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count<k) l = mid+1;
            else r = mid;
        }
        return l;
    }
    
    //Use heap 
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return matrix[a[0]][a[1]] - matrix[b[0]][b[1]];
            }
        });
        
        for(int i=0;i<matrix[0].length;i++) pq.add(new int[]{0, i});
        
        for(int i=1;i<k;i++){
            int[] cur = pq.poll();
            if(cur[0]!=matrix.length-1) pq.add(new int[]{cur[0]+1, cur[1]});
        }
        
        int[] ind = pq.poll();
        return matrix[ind[0]][ind[1]];
    }
}

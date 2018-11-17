package unionFind;

/*
 * Leetcode 547. Friend Circles
 * 
 * Union Find approach
 * 
 * Almost the same code with NumberOfIslands problem
 *
 */

public class FriendCircles {
	int count;
    int[] id, rank;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        count = n;
        id = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) {
            id[i] = i;
            rank[i] = 1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j] == 1) union(i, j);
            }
        }
        return count;
    }
    
    private void union(int a,int b){
        int aR = find(a);
        int bR = find(b);
        if(aR == bR) return;
        if(rank[aR] > rank[bR]) id[bR] =aR;
        else if(rank[aR] < rank[bR]) id[aR] = bR;
        else{
            id[aR] = bR;
            rank[bR]++;
        }
        count--;
    }
    
    private int find(int a){
        return a == id[a] ? id[a] : (id[a] = find(id[a]));
    }
}

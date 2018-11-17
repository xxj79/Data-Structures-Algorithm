package test;

import java.util.*;

public class Main {
    static int[][] dir = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<String[]> list = new ArrayList<>();
        while(sc.hasNextLine())
            list.add(sc.nextLine().split(","));
        
        int m = list.size();
        int n = list.get(0).length;
        
        int[][] a = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                a[i][j] = Integer.valueOf(list.get(i)[j]);
            }
        }
        
        int[][] ret = choose(a, k);
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                System.out.print(ret[i][j]);
                if(j<n-1) System.out.print(",");
                else System.out.println("");
            }
        }
    }
    
    static int[][] choose(int[][] a, int k){
        if(a.length < 1) return null;
        int m = a.length;
        int n = a[0].length;
        int[][] ret = new int[m][n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(a[i][j] == 1 || a[i][j] == -1){
                    ret[i][j] = 0;
                } else{
                    ret[i][j] = eval(a, i, j, k);
                }
            }
        }
        return ret;
    }
    
    static int eval(int[][] a, int x, int y, int k){
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int m = a.length, n = a[0].length;
        
        q.add(new int[]{x, y});
        int dis = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int p = 0; p<size; p++){
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                if(a[r][c] == 1) return 0;
                visited.add(r*n + c);
                for(int i = 0; i<4; i++){
                    int rr = r + dir[i][0], cc = c + dir[i][1];
                    if(rr < 0 || rr >= m || cc < 0 || cc >= n 
                       || visited.contains(rr * n + cc) || a[rr][cc] == -1) continue;
                    q.add(new int[]{rr,cc});
                }
            }
            dis++;
            if(dis > k) break;
        }
        return 1;
    }
}

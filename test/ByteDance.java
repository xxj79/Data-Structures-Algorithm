package test;

import java.util.*;

public class ByteDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer>[] g = new Set[n+1];
        for(int i = 1; i<= n; i++){
            g[i] = new HashSet<>();
        }
        int[][] e = new int[m+1][2];
        for(int i = 1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        
        for(int i = 1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            e[i][0] = a;
            e[i][1] = b;
        }
        
        System.out.println(get(g, e));
    }
    
    static int get(Set<Integer>[] g, int[][] e){
        for(int i = 1; i<e.length; i++){
            int a = e[i][0];
            int b = e[i][1];
            g[a].remove(b);
            g[b].remove(a);
            boolean[] v = new boolean[g.length];
            dfs(v, g, 1);
            for(int j = 1; j<v.length; j++)
                if(!v[j]) return i;
        }
        return -1;
    }
    
    static void dfs(boolean[] v, Set<Integer>[] g, int pos){
        v[pos] = true;
        for(int n : g[pos]){
            if(!v[n])
                dfs(v, g, n);
        }
    }
}

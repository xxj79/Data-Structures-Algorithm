package unionFind;

import java.util.*;

//总结UF：初始化id数组，如果本身就存在，赋值为自身index，不存在则全初始化为-1
//遍历元素，每碰到一个存在的元素，count++，然后检查其与相邻元素的parent是否一样
//如果不一样，进行union操作，将当前元素的id变成相邻的元素的id，然后count--

public class NumberOfIslandsII {
    int[][] dir = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] id = new int[m*n];
        List<Integer> ret = new ArrayList<>();
        Arrays.fill(id, -1);
        int count = 0;
        for(int[] p : positions){
            int r = p[0], c = p[1];
            int k = r * n + c;
            id[k] = k;
            count++;
            for(int i = 0;i<4;i++){
                int rr = r + dir[i][0], cc = c + dir[i][1];
                int kn = rr * n + cc;
                if(rr<0 || rr>= m || cc < 0 || cc >= n || id[kn] == -1) continue;
                
                int idn = find(id, kn);
                if(idn != k){
                    id[k] = idn;
                    k = idn; //注意更新k值这里
                    count--;
                }
            }
            ret.add(count);
        }
        return ret;
    }
    
    public int find(int[] id, int k){
        return id[k] == k ? k : (id[k] = find(id, id[k]));
    }
}

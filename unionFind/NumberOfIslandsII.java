package unionFind;

import java.util.*;

//�ܽ�UF����ʼ��id���飬�������ʹ��ڣ���ֵΪ����index����������ȫ��ʼ��Ϊ-1
//����Ԫ�أ�ÿ����һ�����ڵ�Ԫ�أ�count++��Ȼ������������Ԫ�ص�parent�Ƿ�һ��
//�����һ��������union����������ǰԪ�ص�id������ڵ�Ԫ�ص�id��Ȼ��count--

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
                    k = idn; //ע�����kֵ����
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

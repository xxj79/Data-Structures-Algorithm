package dp;

/*
 * Almost same problem with Remove Boxes
 * 
 * Boundary same property problem:
 * 
 * Within a collection dp[i][j] if i == k (k>i && k<=j) 
 * 
 * we have dp[i][j] = dp[i+1][k-1] + dp[k][j]
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        int n=s.length();
        int[][] f=new int[n][n];
        
        //Notice the scan direction for each loop, make sure the ones that we got after breaking the subproblem should be computed in previous calculations.This is why we use such a scan direction here:
        for (int i=n-1;i>=0;i--) 
            for (int j=i;j<n;j++) 
            {
                f[i][j]=(i==j)?1:1+f[i+1][j];
                for (int k=i+1;k<=j;k++) 
                    if (s.charAt(k)==s.charAt(i)) f[i][j]=Math.min(f[i][j],f[i+1][k-1]+f[k][j]);//all the f[k][j] would be already known here
            }
        return (n==0?0:f[0][n-1]);
        
        /*Wrong scan direction example:
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                f[i][j] = (i==j)?1:1+f[i][j-1];
                for(int k=j-1;k>=i;k--)
                    if(s.charAt(k) == s.charAt(j)) f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j-1]);//f[k+1][j-1] is not calculated yet!!!
            }
        }
        return (n==0?0:f[0][n-1]);
        */
    }
}	

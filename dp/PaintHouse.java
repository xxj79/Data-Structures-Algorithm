package dp;

public class PaintHouse {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int r = costs[0][0], g = costs[0][1], b = costs[0][2];
        for(int i=1;i<n;i++){
            int rr = r, gg = g, bb = b;
            r = costs[i][0] + Math.min(gg, bb);
            g = costs[i][1] + Math.min(rr, bb);
            b = costs[i][2] + Math.min(rr, gg);
        }
        return Math.min(r, Math.min(g, b));
    }
}

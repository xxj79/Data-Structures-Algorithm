package Game;

import java.util.*;
/*
 * Classic game dp, using memo.
 * 
 * And for this kind of game problem, we have a recursion format:
 * 
 * rec{
 * 
 * 		if(!rec())
 * 			return true;
 * 
 * return false;
 * }
 */


//想用数组做key？？ 考虑两种选择： 1）如果长度小于33，用bit； 2） 不然只能用custom class， override 两个method
public class CanIWin {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        return canIWin(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }
    private boolean canIWin(int total, int n, int state, HashMap<Integer, Boolean> hashMap) {
        if (hashMap.containsKey(state)) return hashMap.get(state);
        for (int i=1;i<=n;i++) {
            if ((state&(1<<i))!=0) continue;
            if (total<=i || !canIWin(total-i, n, state|(1<<i), hashMap)) {
                hashMap.put(state, true);
                return true;
            }
        }
        hashMap.put(state, false);
        return false;
    }
}

package dp;

import java.util.*;
/*
 * Thinking process run through:
 * 
 * Obvious this is a DFS/MEMO problem:
 * 
 * We build a map that maps Needs list to min money to fulfill 
 * those needs;
 * 
 * Try every offer given, if valid, compare with the res to see
 * if it's a smaller one;
 * 
 * Notice we also need to check the price without using any offer.
 * 
 * Put the mapping into map, return the min price
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
	Map<List<Integer>,Integer> memo = new HashMap<>();
	List<Integer> zero = new ArrayList<>();
	for(int i=0;i<needs.size();i++){
	    zero.add(0);
	}
	memo.put(zero, 0);
	return dfs(needs,price,special,memo);
    }
    private int dfs(List<Integer> needs, List<Integer> price, List<List<Integer>> special, Map<List<Integer>, Integer> dp){
	if(dp.containsKey(needs)) return dp.get(needs);
        int res = Integer.MAX_VALUE;
        for(List<Integer> s : special) {
            //need the original copy for every element
            List<Integer> needsCopy = new ArrayList<>(needs);
            
            boolean valid = true;
            for(int i=0;i<needs.size();i++) {
        	//use set() to change element in list.
                needsCopy.set(i, needsCopy.get(i) - s.get(i));
                if(needsCopy.get(i) < 0) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                res = Math.min(res, s.get(needs.size()) + dfs(needsCopy, price, special, dp));
            }
        }
        
        //What if we do not use specials? specials can be deceiving,
        //perhaps buying using regular prices is cheaper.
        int noSpecial = 0;
            for(int i=0;i<needs.size();i++) {
                noSpecial += needs.get(i) * price.get(i);
            }
        res = Math.min(res, noSpecial);    

        dp.put(needs, res);
        return res;
    }
}

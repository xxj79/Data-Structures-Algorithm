package graph;

import java.util.*;

/*
 * LeetCode 399. Evaluate Division
 */

public class GraphWithWeights {

	// a/b = k as a link between node and b, the weight from a to b is k, the reverse
	// link is 1/k. Query is to find a path between two nodes.
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
		Map<String, ArrayList<String>> pairs = new HashMap<>(); // store link
		Map<String, ArrayList<Double>> valuesPair = new HashMap<>(); // store weight
		
		//How do two map maps from one to another? Well the index are mathched as we always
		//put in weight at the same time we put in links.
		
		for(int i=0;i<equations.length;i++){
			String[] equation = equations[i];
			pairs.putIfAbsent(equation[0], new ArrayList<String>());
			valuesPair.putIfAbsent(equation[0], new ArrayList<Double>());
			pairs.putIfAbsent(equation[1], new ArrayList<String>());
			valuesPair.putIfAbsent(equation[1], new ArrayList<Double>());
			
			pairs.get(equation[0]).add(equation[1]);
			pairs.get(equation[1]).add(equation[0]);
			valuesPair.get(equation[0]).add(values[i]);
			valuesPair.get(equation[1]).add(1/values[i]);
		}
		
		double[] result = new double[queries.length];
		for(int i=0;i<queries.length;i++){
			String[] query = queries[i];
			result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
			if(result[i] == 0.0) result[i] = -1.0;
		}
		return result;
	}
	
	private double dfs(String start, String end, Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> values, HashSet<String> visited, double value) {
            if (visited.contains(start) || !pairs.containsKey(start)) return 0.0;
            if (start.equals(end)) return value;
            visited.add(start);
            
            ArrayList<String> strList = pairs.get(start);
            ArrayList<Double> valueList = values.get(start);
            double tmp = 0.0;
            for (int i = 0; i < strList.size(); i++) {
                tmp = dfs(strList.get(i), end, pairs, values, visited, value*valueList.get(i));
                if (tmp != 0.0) {
                    break;
                }
            }
            visited.remove(start);
            return tmp;
        }
}

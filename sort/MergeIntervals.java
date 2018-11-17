package sort;

import java.util.*;

public class MergeIntervals {
    
    //Since the original input is not sorted, so have to be O(NlogN)
    public List<Interval> merge(List<Interval> intervals){
	if(intervals.size() <= 1) return intervals;
	
	Collections.sort(intervals, new Comparator<Interval>(){
	    public int compare(Interval a, Interval b){
		return a.start == b.start ? b.end - a.end : a.start - b.start;
	    }
	});
	
	List<Interval> ret = new ArrayList<>();
	
	int start= intervals.get(0).start;
	int end = intervals.get(0).end;
	
	for(Interval interval : intervals){
	    if(interval.start == start) continue;
	    else if(interval.start <= end) end = Math.max(end, interval.end);
	    else{
		ret.add(new Interval(start, end));
		start = interval.start;
		end = interval.end;
	    }
	}
	ret.add(new Interval(start, end));
	return ret;
    }
}

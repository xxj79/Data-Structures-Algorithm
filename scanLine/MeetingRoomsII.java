package scanLine;

import java.util.*;


public class MeetingRoomsII {
    class Interval{
	    int start;
	    int end;
	    Interval(){start = 0;end = 0;}
	}
    
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int j = 0, room = 0;
        for(int i=0;i<intervals.length;i++){
            if(start[i]<end[j])
                room++;
            else
                j++;
        }
        return room;
    }
}	

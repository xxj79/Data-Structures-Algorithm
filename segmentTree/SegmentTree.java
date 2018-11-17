package segmentTree;

/**
 * Segment tree is usually used for range query (intervals related questions)
 * 
 * Rules are: (Suppose current node -> left, right, query range -> lq, rq)
 * 
 * 1. If query range totally overlaps node range (lq<=left && rq >=right) return current node value;
 * 2. If both ranges partially overlaps, we continues to both children of current node;
 * 3. If two ranges doesn't overlap, we return a non-effective value depending on specific cases. 
 * 	  (i.e. MAX_VALUE when doning min range query) 
 * 
 * Also there are optimization techniques such as lazy propagation. (Could be realized by adding a boolean
 * member variable "modified" in node class). A pushdown() method is needed to execute the push 
 */

public class SegmentTree {

}

package twoPointers;

public class ContaineerWithMostWater {
    public int maxArea(int[] height){
	int n = height.length;
	int a = 0, l =  0, r = n-1;
	while(l<r){
	    a = Math.max(a, (r-l)*Math.min(height[l], height[r]));
	    if(height[l] < height[r]){
		int k = l;
		while(k<r && height[k]<=height[l]) k++;
		l = k;
	    }
	    else{
		int k = r;
		while(k>l && height[k]<=height[r]) k--;
		r=k;
	    }
	}
	return a;
    }
}

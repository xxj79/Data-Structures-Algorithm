package twoPointers;

//Two pointer end-to-middle linear scan

public class ContainerWithMostWater {
    public int maxArea(int[] height){
	int area = 0, l = 0, r = height.length - 1;
	while(l<r){
	    int h = Math.min(height[l], height[r]);
	    area = Math.max(area, h*(r-l));
	    while(l<r && height[l]<=h) l++;
	    while(l<r && height[r]<=h) r++;
	}
	return area;
    }
}

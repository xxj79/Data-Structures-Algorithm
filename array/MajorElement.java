package array;

import java.util.*;

/*
 * Moore's voting algorithm
 */
public class MajorElement {
    public int majorityElement(int[] num){
	int major = num[0], count = 1;
	for(int i=1;i<num.length;i++){
	    if(count == 0){
		count++;
		major = num[i];
	    }
	    else if(num[i] == major) count++;
	    else count--;
	}
	return major;
    }
    
    //Change to more than n/3??? Just add a candidate
    public List<Integer> majorityElementII(int[] nums){
	List<Integer> result = new ArrayList<>();
	int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
	for(int i=0;i<len;i++){
	    if(nums[i] == number1) count1++;
	    else if(nums[i] == number2) count2++;
	    else if(count1==0) {
		number1 = nums[i];
		count1 = 1;
	    }
	    else if(count2 == 0){
		number2 = nums[i];
		count2 = 1;
	    }
	    else{
		count1--;
		count2--;
	    }
	}
	count1 = 0;
	count2 = 0;
	for(int i=0;i<len;i++){
	    if(nums[i] == number1) count1++;
	    else if(nums[i] == number2) count2++;
	}
	if(count1>len/3) result.add(number1);
	if(count2>len/3) result.add(number2);
	
	return result;
    }
}

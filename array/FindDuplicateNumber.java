package array;

//The first approach shown here is Binary Search in Range/Value Space 
//(Pigieon Hole Theory) (Find mid and Count the # on one side) 
//Time Complexity: O(nlogn)
//
////While the second approach (commented part) is similar as find the 
//loop in the linkedlist. since he duplicated value is like the entrance 
//to the cycle. 
//Time complexity: O(n)

public class FindDuplicateNumber {
    //range based binary search
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            int count =0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=m)count++;
            }
            if(count>m)r = m;
            else l = m+1;
        }
        return l;
        
        
        
        //similar to linked list cycle detection
        
        /*int f = 0;
        int s = 0;
        do{
            f = nums[nums[f]];
            s = nums[s];
        }while(f!=s);
        
        f = 0;
        while(f!=s){
            f = nums[f];
            s = nums[s];
        }
        return s;*/
    }
}

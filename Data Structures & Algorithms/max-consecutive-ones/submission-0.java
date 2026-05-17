class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0; //count of 1
        int max=0;//maximum count of 1

        for(int i=0;i<nums.length;i++){ //array 
            if(nums[i]==1){ //max of 1

                count++; //increase with how many times 1 is printing
            }
            else{
                count=0; //back to 0
            }
            if (count>max){ //if count >maximum of other 1s
                max=count; //print that maximum as count among all
            }

        }
        return max;
        
    }
}
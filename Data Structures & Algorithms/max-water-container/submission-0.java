class Solution {
    public int maxArea(int[] height) {
        int max_water=0;
        int lp=0;
        int rp=height.length-1;

        while(lp<rp){

            int w=rp-lp;
            int h=Math.min(height[lp],height[rp]);
            int curr_water=w*h;
            max_water=Math.max(max_water,curr_water);

            if(height[lp]<height[rp]){
                lp++;
               

            }
            else{
                rp--;
            }
        }
            return max_water;
        
        
    }
}
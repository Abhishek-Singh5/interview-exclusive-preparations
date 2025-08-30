class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n-1;

        int max1 = 0;
        int max2 = 0;

        while(i < j){
            if(height[i] >= height[j]){
                int width = j - i;
                int heights = Math.min(height[i], height[j]);
                int area = width * heights;

                max1 = Math.max(max1, area);

                j--;
            
            } else if(height[i] <= height[j]) {
                int width = j - i;
                int heights = Math.min(height[i], height[j]);
                int area = width * heights;

                max2 = Math.max(max2, area);

                i++;
            }

        }


        return Math.max(max1, max2);
    }
}








*********************************************************   Simulations    ********************************************************




class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int max = 0;

        int i = 0;
        int j = n-1;

        // width = TotalLength - StartingLength
        // height = minimum of two elements
        // area = width * height;

        while(i < j){
            int width = j - i;

            int heights = Math.min(height[i], height[j]);

            int area = width * heights;

            max = Math.max(max, area);

            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }

        }

        return max;
    }
}
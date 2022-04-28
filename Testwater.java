public class Testwater {
    public int trapWater(int height[]) {
        int water = 0;
        int size = height.length;
        int leftmax[] = new int[size];
        int rightmax[] = new int[size];

        leftmax[0] = height[0];
        for(int i=1;i<size;i++){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        } 
        rightmax[size-1] = height[size-1];
        for(int i=size-2;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1],height[i]);
        }  
        for(int i=0;i<size;i++){
            water += Math.min(leftmax[i],rightmax[i]) - height[i];
        }

        return water;
    }
}
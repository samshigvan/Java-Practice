package com.company.leetcode;

public class WaterLevel {

    public static int trap(int[] height) {

        int length= height.length;
        int waterUnit = 0;

        for (int i = 0; i<= height.length; i++) {


            if( i == 0 && height[i]<=height[i+1] ) {
                System.out.println( "14. height[i]="+ height[i] + " height[i+1]="+ height[i+1]);
                i++;
            }
            int j= i+ 1;
            if(j>= length) {
                break;
            }

            System.out.println("i=" + i+ "; j=" + j);
            System.out.println( "23. height[i]="+ height[i] + " height[j]="+ height[j]);
            if (height[i]>height[j]){

                waterUnit = waterUnit + Math.abs(height[j]-height[i]);
                System.out.println("waterUnit=" + waterUnit);
                j++;

                if(j >= length) {
                    break;
                }

                System.out.println( "34. height[i]="+ height[i] + " height[j]="+ height[j]);
                while (height[i]<=height[j]){

                    System.out.println("i=" + i+ "; j=" + j);
                    System.out.println( "38. height[i]="+ height[i] + " height[j]="+ height[j]);

                    waterUnit = waterUnit + Math.abs(height[j]-height[i]);
                    System.out.println("waterUnit=" + waterUnit);

                    if (height[j]>=height[i]){
                        break;
                    }

                    j++;

                    if(j >= length) {
                        break;
                    }
                }
                i = j-1;
            }
        }
        return waterUnit;
    }

    public static int trap2(int[] height) {
        // first approach using extra space to track max in left and right
        int size = height.length;
        int[] maxL = new int[size];
        int[] maxR = new int[size];
        maxL[0] = height[0];
        maxR[size-1] = height[size-1];

        for(int i = 1;i<size;i++){
            if(height[i] >= maxL[i-1]){
                maxL[i] = height[i];
            }
            else{
                maxL[i]=maxL[i-1];
            }
        }
        for(int i = size-2 ;i>=0;i--){
            if(height[i] >= maxR[i+1]){
                maxR[i] = height[i];
            }
            else{
                maxR[i] = maxR[i+1];
            }
        }
        int res = 0;
        for(int i = 0;i<size;i++){
            res+=( Math.min(maxL[i],maxR[i])-height[i]);
        }
        return res;
    }
    public static void main(String[] args) {

        int[] h = new int[]{2,1,0,2};
        System.out.println("water level is:"+ WaterLevel.trap2(h));
    }
}

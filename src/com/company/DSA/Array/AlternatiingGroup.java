package com.company.DSA.Array;

public class AlternatiingGroup {

    public static int numberOfAlternatingGroups(int[] colors) {

        int len =colors.length;
        int count=0;
        int prev=0;
        int next=1;
        for(int end =0; end<len; end++)
        {
            if(end==0){
                prev = len-1;
            }
            if(prev>=len-1){
                prev=prev-len+1;
            }
            if(end==len-1){
                next =next-len;
            }
            if(colors[prev]==colors[next] && colors[end]!= colors[next]){
                count++;
            }
            prev++;
            next++;
        }
        return count;
    }

    public static void main(String[] args) {

        int nums[] = {0,1,0,0,1};
        System.out.println(numberOfAlternatingGroups(nums));
    }
}

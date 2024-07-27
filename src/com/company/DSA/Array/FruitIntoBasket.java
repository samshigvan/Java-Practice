package com.company.DSA.Array;

import java.util.LinkedHashMap;

public class FruitIntoBasket {

    public static int totalFruit(int[] fruits) {
        int start = 0;
        int max = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for(int end=0; end<fruits.length; end++){

            int key = fruits[end];
            map.put(key, map.getOrDefault(key,0)+1);

            while (map.size()>2){
                map.put(fruits[start], map.getOrDefault(fruits[start],0)-1);
                if(map.get(fruits[start]) == 0){
                    map.remove(fruits[start]);
                }
                start++;
            }
            max = Math.max(max, end -start +1);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] ={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
}

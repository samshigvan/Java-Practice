package com.company.DSA.Array;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {

        int profit =0;
        int buy =prices[0];

        for(int i=1; i< prices.length; i++){

            if(prices[i] < buy){
                buy= prices[i];
            }
            profit = Math.max(profit, prices[i]-buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

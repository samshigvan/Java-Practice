package com.company.DSA.Array;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

//https://leetcode.com/problems/snake-in-matrix/description/
public class SnakeInMatrix {

    public static int finalPositionOfSnake(int n, List<String> commands) {
        int i, j ;
        i=0;
        j=0;

        for (String command : commands){

            switch (command){
                case "LEFT":
                    j--;
                    break;
                case "RIGHT":
                    j++;
                    break;
                case "UP":
                    i--;
                    break;
                case "DOWN":
                    i++;
            }
        }
        return (n*i)+j;
    }

    public static void main(String[] args) {

//        int n = 2; List<String> commands= Arrays.asList("RIGHT", "DOWN");
        int n = 2; List<String> commands= Arrays.asList("DOWN");
//        int n = 3; List<String> commands= Arrays.asList("DOWN","RIGHT","UP");

        out.println(finalPositionOfSnake(n, commands));
    }
}

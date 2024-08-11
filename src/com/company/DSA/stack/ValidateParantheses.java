package com.company.DSA.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidateParantheses {

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);

            if(map.containsKey(c)){
                stack.push(c);
            } else if(map.containsValue(c)){

                if(stack.isEmpty())
                    return false;

                Character d= stack.pop();
                if(!map.get(d).equals(c)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="]";

        System.out.println(isValid(s));
    }
}

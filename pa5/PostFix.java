/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author jobindnl
 */
public class PostFix {

    ArrayList list;
    Stack<Character> stack;

    boolean lastDigit = false;
    int i = 0;

//Infix To Postfix conversion 
    public void post(char[] array) {
        stack = new Stack<Character>();
        list = new ArrayList();

        for (char c : array) {

            if (c <= '9' && c >= '0') {

                if (lastDigit) {

                    int x = Integer.parseInt(String.valueOf(list.get(i - 1)));
                    int temp = Character.getNumericValue(c);
                    int result = (x * 10) + temp;
                    list.remove(i - 1);
                    list.add(i - 1, result);

                } else {

                    list.add(c);
                    i++;
                    lastDigit = true;
                }

            } else {
                if (c != ')') { // '+' or '-' or '('

                    if (!stack.isEmpty() && c != '(') {
                        if (stack.peek() == '+' || stack.peek() == '-') {
                            list.add(stack.pop());
                            i++;
                        }
                    }
                    stack.push(c);

                    lastDigit = false;
                } else { // ')'

                    if (stack.peek() != '(') {
                        list.add(stack.pop());
                        i++;
                        stack.pop();

                    } else {
                        stack.pop();
                    }
                    lastDigit = false;
                }
            }

        }
        if(!stack.isEmpty()){
            list.add(stack.pop());
        }
        
        calculator(list);
        

    }

//PostFix to calculation     
    public void calculator(ArrayList list) {
        Stack st = new Stack();

        for (Object c : list) {
            String x = String.valueOf(c);

            if (!x.equals("-") && !x.equals("+")) {
                st.push(x);
            } else {

                if (x.equals("-")) {

                    if (st.size() > 1) {
                        int num2 = Integer.parseInt(String.valueOf(st.pop()));
                        int num1 = Integer.parseInt(String.valueOf(st.pop()));
                        int result = num1 - num2;
                        st.push(result);
                    } else {
                        int num2 = Integer.parseInt(String.valueOf(st.pop()));
                        st.push(num2 * -1);
                    }

                } else {

                    if (st.size() > 1) {
                        int num2 = Integer.parseInt(String.valueOf(st.pop()));
                        int num1 = Integer.parseInt(String.valueOf(st.pop()));
                        int result = num1 + num2;
                        st.push(result);
                    } else {
                        int num2 = Integer.parseInt(String.valueOf(st.pop()));
                        st.push(num2 * 1);
                    }

                }
            }

        }

        System.out.println("Your output is: " + st.peek());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.util.Scanner;

/**
 *
 * @author jobindnl
 */
public class PA5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Create Scanner
        Scanner scnr = new Scanner(System.in);

        //Create PostFix Object
        PostFix conversion = new PostFix();

        //Create array of char
        char array[];

        //Takes input from user
        System.out.println("Enter your equation : ");
        String input = scnr.nextLine();

        //Removes spaces from input
        String equation = input.replaceAll(" ", "");

        //Sends each character to array
        array = equation.toCharArray();

        //Send array to methods in PostFix Class
        conversion.post(array);

    }

}

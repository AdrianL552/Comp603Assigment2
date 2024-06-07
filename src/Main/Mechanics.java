/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.util.Scanner;
import GameText.Format;


/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */
public class Mechanics {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static int readInt(String text, int userChoices, String question){
        // takes 3 parameters 
        // String text used ask the player to enter input
        // int userChoices used as upperbound of users inputs
        // question is used to reprint if player inputs incorrectly
        int input;
        do{
            System.out.println(text);
            try{
                input = Integer.parseInt(scanner.nextLine());
                if(input < 1 || input > userChoices){
                   Format.ClearScreen();
                   System.out.println("Please enter a number within the options");
                   System.out.println(question);
                   // checks if input is 0 or more than allowed amount
                   // Prints error and reprints question
                }
            }
            catch(Exception e) {
                input = -1;
                Format.ClearScreen();
                System.out.println("Please enter an integer");
                System.out.println(question);
                // catches non intergers inputs
                // then sets input to -1 which ReEnters the loop
                // Prints error and reprints question
            }
            // try block used to catch errors
        }
        while(input < 1 || input > userChoices);
        // used to reEnter do loop if inputs dont meet requirments
        
        return input;
        // once input passes every check it returns the users input
        
        // reuseable int scanner method
        // only takes ints which is ideal
        // for switch cases which we used
        // mainly for getting inputs
    }

    public static void unpause(){
        System.out.println("Input any key to continue ");
        scanner.nextLine();
    }
    // allows player to read console text before printing new text
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameText;

import Main.Mechanics;

/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */
public class Format 
{
    
    public static void boarder(int n){
        for(int i = 0; i < n; i++){
            System.out.print("==");
        }
        System.out.println();
    }
    // creates boarders to seperate text'
    
    public static void printHeading(String text){
        ClearScreen();
        boarder(15);
        System.out.println(text);
        boarder(15);
        Mechanics.unpause();
    }
    // clears screen and creates
    // boarders which surrounds text
    
    public static void printQuestion(String quesion){
        ClearScreen();
        boarder(15);
        System.out.println(quesion);
        boarder(15);
    }
    // clears screen and creates
    // boarders which surrounds text
    
    public static void printOptions(String answer){
        System.out.println(answer);
        boarder(15);
    }
    // clears screen and creates
    // boarder bellow text

    
    public static void ClearScreen(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    } 
    // clears console by printing
    // new lines
}
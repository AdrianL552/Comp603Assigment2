package GameExecution;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Character.PlayerStats;
import GameText.Text;
import Character.Knight;
import Character.Mage;
import Character.Archer;
import Character.Rogue;
import GameText.Format;
import Main.Mechanics;

import java.util.Scanner;


/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */

public class PlayerCreater
{
    public PlayerStats player;
    boolean confirmName = false;
    boolean confirmClass = false;
    String playerName = "";
    
    public void CreatePlayer()
    {
        Scanner scanner = new Scanner(System.in);
        while (!confirmName)
        {
            Text.printAskPlayerName();
            playerName = scanner.nextLine();
            
            Text.printYesOrNo();
            String confrimInput = scanner.nextLine().toUpperCase();
            
            if(confrimInput.equals("YES")){
                confirmName = true;
 
            }
            else if(confrimInput.equals("NO")){
                confirmName = false;
            }
            else{
                Format.ClearScreen();
                Format.boarder(30);
                System.out.println("Please enter either Yes or No ");
                Format.boarder(30);
                Mechanics.unpause();
            } 
            // creates scanner to get user input
            // uses if statment so we can easily implement
            // error error handling involving incorrect inputs
            // where we want words to be used
        }
        while(!confirmClass){
            Format.ClearScreen();
            System.out.println(Text.ChooseClassPrint());
            int input = Mechanics.readInt("Choose Wisely: ", 4, Text.ChooseClassPrint());

            switch(input){
                case 1:
                    player = new Knight(playerName);
                    break;
                case 2:
                    player = new Mage(playerName);
                    break;
                case 3:
                    player = new Rogue(playerName);
                    break;
                case 4:
                    player = new Archer(playerName);
                    break;
                default:
                    break;
            }
            // creats new class while using 
            // what ever the player selected as thier name
            
            Text.printPlayerStats(player);
            Mechanics.unpause();
            Text.printYesOrNo();
            
            String confirmInput = scanner.nextLine().toUpperCase();
            if(confirmInput.equals("YES")){
                confirmClass = true;
                // breaks loop
            }
            else if(confirmInput.equals("NO")){
                confirmClass = false;
                // reEnters Loop
            }
            else {
                Format.ClearScreen();
                Format.boarder(30);
                System.out.println("Please enter either Yes or No ");
                Format.boarder(30);
                Mechanics.unpause();     
            }  
            // checks if player likes the stats and would like to
            // continue
        }
        // uses while loop to reEnter loop depending on player option
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameExecution;

import Character.PlayerStats;
import GameExecution.GameLoop;
import GameText.Format;
import GameText.Text;
import Main.Mechanics;

import java.util.Scanner;

/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */
public class StartGame {
    public static boolean runGame;
    
    public static void runGame() {       
    boolean game = true;
    PlayerCreater classPicker = new PlayerCreater();
    classPicker.CreatePlayer();
    PlayerStats player = classPicker.player;
    GameLoop gameLoop = new GameLoop(player, 1,1);
    // sets game loop to true
    // creates new player and opens player creater method
    // creates new gameLoop with parameters of the created
    // player and the starting path an area

    while(game) {
            Format.ClearScreen();
            if (player.getHp() <= 0) {
                System.out.println("You need to create a new character to continue.");
                Mechanics.unpause();
                runGame();
            }
            //Needed to create a new character after getting defeated
            //Otherwise it would use the dead player

            System.out.println(Text.printMenuPrint());
            int input = Mechanics.readInt("Enter your choice", 4, Text.printMenuPrint());
            switch (input) {
                case 1:
                    gameLoop.start();
                    break;
                    // starts gameLoop which is responsible
                    // for gameplay
                case 2:
                    Format.ClearScreen();
                    System.out.println(Text.PlayerStatsPrint(player));
                    int choice = Mechanics.readInt("1. return", 1, Text.PlayerStatsPrint(player));
                    if (choice == 1) {
                        break;
                    }
                    // prints player stats
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    Text.printYesOrNo();
                    String confrimInput = scanner.nextLine().toUpperCase();

                    if(confrimInput.equals("YES")){
                        game = false;
                        break;
                    }
                    else if(confrimInput.equals("NO")){
                        break;
                    }
                    else{
                        Format.ClearScreen();
                        Format.boarder(15);
                        System.out.println("Please enter either Yes or No ");
                        Format.boarder(15);
                        Mechanics.unpause();
                    }
                    // allows users to exit to main menu
                    // has error handling
                    // uses if statments instead of 
                    // switch case so we can get yes or no inputs
                    // this prevents users from accidentally quiting game
                    
                }
            // uses nested swithc case inside while loop to allow
            // users to return to this menu. once they have 
            // finished veiwing playerstats or decide they
            // dont want to quit game
        }
    }
}
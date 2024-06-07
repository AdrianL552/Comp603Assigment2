/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import GameExecution.StartGame;
import GameText.Format;
import static Main.Mechanics.scanner;
import GameText.Text;

/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */

public class MainMenu{
    public static void StartMenu(){
            while(true){
                Format.ClearScreen();
                Text.Title();
                System.out.println(Text.MainMenuPrint());

                int input = Mechanics.readInt("Enter your choice", 6, Text.MainMenuPrint());
                switch (input){
                    case 1:
                        StartGame.runGame();
                        break;
                    case 2:
                        Format.ClearScreen();
                        System.out.println(Text.RulesPrint());
                        int a = Mechanics.readInt("1. to return", 1, Text.RulesPrint());
                        if(a == 1){
                            Format.ClearScreen();
                            break;
                        }
                        // Prints game rules
                    case 3:
                        Settings settings = new Settings();
                        settings.settings();
                        Format.ClearScreen();
                        break;
                        // opens settings
                    case 4:
                        Format.ClearScreen();
                        System.out.println(Text.AchievementsPrint());
                        int c = Mechanics.readInt("1. to return", 1, Text.AchievementsPrint());
                        if(c == 1){
                            Format.ClearScreen();
                            break;
                        }
                        // achievement prints
                        
                    case 5:
                        Format.ClearScreen();
                        System.out.println(Text.CreditsPrint());
                        int d = Mechanics.readInt("1. to return", 1, Text.CreditsPrint());
                        if(d == 1){
                            Format.ClearScreen();
                            break;
                        }
                        // credits print
                    case 6:
                        boolean validResponse = false;
                        while (!validResponse) {
                            Format.ClearScreen();
                            System.out.println(Text.quitGamePrint());
                            char exit = scanner.next().charAt(0);
                            if (exit == 'y') {
                                System.out.println("Thanks for Playing!");
                                System.exit(0);
                            } else if (exit == 'n') {
                                validResponse = true; // Break out of the loop if user chooses to continue playing
                            } else {
                                System.out.println(Text.quitGameReprint());
                                Mechanics.unpause();
                            }
                        }
                        break;
                        // kills program
                    default:
                }
            }
            // uses loop to allow players to return to
            // menu when they are done in each sub section
        }
}
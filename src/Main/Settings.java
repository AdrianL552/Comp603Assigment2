/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import GameText.Format;
import GameText.Text;

import JavaDB.AchievementsDB;
import JavaDB.GameLoopConfigurationDB;

/**
 *
 * @Author David
 * @Edited by Adrian
 * @FocusedOn by David
 * @Status Commented and Finished
 */
public class Settings {
    
    public void settings() {
        
        Format.ClearScreen();
        System.out.println(Text.SettingsPrint());
        int input = Mechanics.readInt("Enter Choice", 5, Text.SettingsPrint());

        switch (input) {
            case 1:
                gameLoopEdit();
                break;
            case 2:
                resetAchievementsConfirmation();
                break;
            case 3:
                Format.ClearScreen();
                System.out.println(Text.AchievementsPrint());
                Mechanics.unpause();
                break;
            case 4:
                Format.ClearScreen();
                System.out.print("For example purposes a few achievements have been added");
                addAchievementsDemo();
                Mechanics.unpause();
                //This is only added for the purpose of demoing the achievements
                //The GUI portion has not be implemented so it is done here in CLI
            case 5:
                break;
        }
        // switch case allows users to enter options
    }

    
    public void gameLoopEdit() {
        GameLoopConfigurationDB configDB = new GameLoopConfigurationDB();
        configDB.editGameLoopPrompt();
    }
    // makes an object of game GameLoopConfiguration with name config
    // calls the method editGameLoopPrompt();
    
    public void resetAchievementsConfirmation() {
        Format.ClearScreen();
        
        System.out.println(Text.SettingsAchievemensEdit());
        int input2 = Mechanics.readInt("Enter Choice", 2, Text.SettingsAchievemensEdit());
        // Trim whitespace and convert to lowercase

        switch (input2) {
            case 1:
                Format.ClearScreen();
                System.out.println("========== Settings ==========");
                System.out.println("Achievements reset Sucessful.");
                System.out.println("==============================");
                Mechanics.unpause();
                resetAchievements(); 
                // Reset achievements if user confirms
                break;
            case 2:
                Format.ClearScreen();
                System.out.println("========== Settings ==========");
                System.out.println("Achievements reset cancelled.");
                System.out.println("==============================");
                Mechanics.unpause();
                break;
        }
    }
    
    public void resetAchievements() {
        AchievementsDB achievementsDB = new AchievementsDB();
        achievementsDB.deleteAllAchievements();
    }
    
    public void displayAchievements() {
        AchievementsDB achievementsDB = new AchievementsDB(); 
        achievementsDB.displayAllAchievements();
    }
    
    public void addAchievementsDemo() {
        System.out.print("For example purposes a few achievements have been added");
        AchievementsDB achievementsDB = new AchievementsDB(); 
        achievementsDB.greedyPunishment();
        achievementsDB.charity();
    }
}

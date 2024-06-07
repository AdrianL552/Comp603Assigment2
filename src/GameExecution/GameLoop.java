/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameExecution;

import Character.PlayerStats;
import Enemies.CodeCrashers;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

import GameText.Text;
import Enemies.CodeGoblin;
import Enemies.Enemy;
import Enemies.SyntaxSnakes;
import GameText.Format;
import Main.Mechanics;

import JavaDB.AchievementsDB;
import JavaDB.GameLoopConfigurationDB;


/**
 *
 * @Author Adrian
 * @Edited by David
 * @FocusedOn by David
 * @Status Commented and Finished
 */
public class GameLoop {
    private Random random = new Random();
    private Map<Integer, String> pathEventMap = new HashMap<>();
    
    // Video Reference https://www.youtube.com/watch?v=H62Jfv1DJlU
    // Website Tutorial Reference https://www.geeksforgeeks.org/hashmap-get-method-in-java/
    // Website Tutorial Reference https://www.geeksforgeeks.org/hashmap-containskey-method-in-java/?ref=lbp
    /*
    HashMap has Key-Value Pairs which I thought worked greatly with our
    path_number-encounterType Pairs.
    
    The 3rd for loop contains a .put() method that stores int path and String 
    encounterType for any randomly generated amount of paths with randomly 
    generated ecounterType.
    
    Using its .get() method allows to get its corresponding encounterType - 
    Used in printPaths() and handleUserInput()
    
    The .clear() method is used near the very beginning of the loop to ensure that
    previous values don't accidentally carry over and becomes selectable into the
    next section
    */

    private final PlayerStats player;
    public Enemy currentEnemy;
    private Encounters encounters;
    
    private int currentSection;
    private int currentArea;
    
    
    private final GameLoopConfigurationDB configDB = new GameLoopConfigurationDB();
    private int sectionAmount;
    private int pathAmount;
    
    
    private final AchievementsDB achievement = new AchievementsDB();
    
    public GameLoop(PlayerStats player, int currentSection, int currentArea) 
    {
        this.player = player;
        this.currentSection = currentSection;
        this.currentArea = currentArea;
        this.encounters = new Encounters(this);
    }
    
    public void gameLoopGUI(){
        int[] amounts = configDB.readConfigAmounts();
        this.sectionAmount = amounts[0];
        this.pathAmount = amounts[1];
        int area = this.currentArea;
        int section = this.currentSection;     
    }
    
    public int getRandomPaths(){
        int paths = random.nextInt(3) + 1;
        return paths;
    }
    
    public int getSections(){
        int sections = 6;
        return sections;
    }
    
    public void start() {
        int[] amounts = configDB.readConfigAmounts();
        this.sectionAmount = amounts[0];
        this.pathAmount = amounts[1];
        
        boolean playerDefeated = false; 

            for (int area = this.currentArea; area <= 3 && !playerDefeated; area++) {
                this.currentArea = area;
                pathEventMap.clear();
                for (int section = this.currentSection; section <= this.sectionAmount; section++) {
                    this.currentSection = section;
                    int paths;

                    if (section < this.sectionAmount) {
                        paths = random.nextInt(this.pathAmount) + 1;
                    } else {
                        paths = 1;
                    }

                    for (int path = 1; path <= paths; path++) {
                        String encounterType;
                        if (section == this.sectionAmount) {
                            encounterType = "Boss";
                        } else {
                            encounterType = getRandomEncounterType();
                        }

                        pathEventMap.put(path, encounterType + section);
                        System.out.println("Section:"+ section + " Path " + path + ": " + encounterType);
                        }
                    if (player.getHp() <= 0) {
                        playerDefeated = true;
                        break;
                    }

                }
            }
        }
    

    public void printPaths(int paths) {
        for (int path = 1; path <= paths; path++) {
            String encounterType = pathEventMap.get(path);
            System.out.println("Path " + path + ": " + encounterType);
            //Reprints all the existing paths and their corresponding encounterType
        }
    }
    



    public String getRandomEncounterType() {
        final int TOTAL_CHANCE = 100;
        final int ENEMY_CHANCE = 55;
        final int TREASURE_CHANCE = 15          + ENEMY_CHANCE;
        final int CAMP_CHANCE = 10              + TREASURE_CHANCE;
        final int WANDERING_HEALER_CHANCE = 10  + CAMP_CHANCE;
        //Cursed Statue takes the remaining
        //Ensure that the chances total less than 100 otherwise some encounters may be impossible
    
        int encounterChance = random.nextInt(TOTAL_CHANCE); // Generate a random number between 0 and 99
        if (encounterChance < ENEMY_CHANCE) {
            return "./resources/Enemy.png";
        } else if (encounterChance < TREASURE_CHANCE) {
            return "./resources/Treasure.png";
        } else if (encounterChance < CAMP_CHANCE) {
            return "./resources/Camp.png";
        } else if (encounterChance < WANDERING_HEALER_CHANCE) {
            return "./resources/WanderingHealer.png";
        } else{
            return "./resources/Store.png";
        }
        //Compares the encounterChance to the chances above

    }

    
    
    public void spawnEnemy() {
        final int TOTAL_CHANCE = 2;
        final int CODE_GOBLIN_CHANCE = 1;
        
        int randomEnemy = random.nextInt(TOTAL_CHANCE); 
        
        if (randomEnemy == CODE_GOBLIN_CHANCE - 1) {
            currentEnemy = new CodeGoblin(player);
        } else {
            currentEnemy = new SyntaxSnakes(player);
        }
        //Selects 1 of 2 Enemies to be used
        //Left as if statement to allow uneven selection of enemies
        
        Format.ClearScreen();
        
        player.setCurrentEnemy(currentEnemy); 
        System.out.println(Text.spawnEnemyPrint(currentEnemy));
        //Sets the current enemy and print enemy spawn
        
        Mechanics.unpause();
    }
    
    public String spawnEnemyForGUI() {
        final int TOTAL_CHANCE = 2;
        final int CODE_GOBLIN_CHANCE = 1;
        
        int randomEnemy = random.nextInt(TOTAL_CHANCE); 
        
        if (randomEnemy == CODE_GOBLIN_CHANCE - 1) {
            currentEnemy = new CodeGoblin(player);
            player.setCurrentEnemy(currentEnemy); 
            return "./resources/Goblin.png";
        } else {
            currentEnemy = new SyntaxSnakes(player);
            player.setCurrentEnemy(currentEnemy); 
            return "./resources/Snake.png";
        }

    }
    
    
    public void turnBasedCombat() {

        while (player.getHp() > 0 && currentEnemy.getHp() > 0) {
            while (player.getCurrentTimeUnit() > 0 || currentEnemy.getCurrentTimeUnit() > 0) {
                
                player.subtractTimeUnit(player.getSpeed());
                currentEnemy.subtractTimeUnit(currentEnemy.getSpeed());
                //Subtract each characters' time unit by their speed
                
                if (player.getCurrentTimeUnit() <= 0) {

 
                    //Perform action when time unit reaches 0 or less
                    //Player action is priorotized over Enemy if both reach 0 or less
                }
                
                if (currentEnemy.getCurrentTimeUnit() <= 0) 
                {
                    enemyTurn(); 
                    //Perform action when time unit reaches 0 or less
                    //Enemy action must wait for Player action if both reach 0 or less
                }
                
                if (currentEnemy.getHp() <= 0 || player.getHp() <= 0) {
                    break;
                }
                //Breaks out of while loop if either character dies
            }

            if (currentEnemy.getHp() <= 0) {
                player.addXP(random.nextInt(currentEnemy.getXpDropRange())+currentEnemy.getXpDropRangeMin());
                player.addMoney(random.nextInt(currentEnemy.getCoinDropRange())+currentEnemy.getCoinDropRangeMin());
                break;
            }
            // Check if enemy is defeated after player's turn

            if (player.getHp() <= 0) {
                break;
            }
            // Check if player is defeated after enemy's turn
        }
    }
     
    private void playerTurn(Scanner scanner) {
        player.playerAttack(scanner);
    }

    private void enemyTurn() {
        System.out.println("Enemy's turn.");
        currentEnemy.choice();
    }

    private void fightBoss() {
        System.out.println("You encounter the final boss!");
        
        currentEnemy = new CodeCrashers(player);

        player.setCurrentEnemy(currentEnemy);
        Format.ClearScreen();
        System.out.println(Text.spawnEnemyPrint(currentEnemy));
        
        Mechanics.unpause();
    }
    
    
    public void enemyAttack() {

        if (player.getHp() > 0 && currentEnemy.getHp() > 0) {
            enemyTurn(); 
        }
    }
    
        
}
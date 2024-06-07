/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

import java.util.Scanner;
import java.util.Random;

import Enemies.Enemy;
import GameText.Text;
import Main.Mechanics;

/**
 * @Author Adrian
 * @Edited by David and Adrian
 * @FocusedOn by David
 * @Status Commented and Finished
 * 
 * Printed Text Generated by ChatGPT such as
 * "Rogue performs Backstab!" or similar text instances
 */
public class Rogue extends PlayerStats {
    private Enemy currentEnemy;
    
    public Rogue(String pName) {
        super(pName, "Rogue", 20, 3, 15, 4);
    }
    //Player Name, Character Name, Health, Attack, Speed, Defense

    @Override
    public void setCurrentEnemy(Enemy enemy) {
        this.currentEnemy = enemy;
    }

    @Override
    public void playerAttack(Scanner scanner) {
        System.out.println(Text.RogueCombatPrint(this, currentEnemy));

        int chosenAttack = Mechanics.readInt("Your turn: ", 3, Text.knightCombatPrint(this, currentEnemy));
        switch (chosenAttack) {
            case 1:
                System.out.println("====================");
                System.out.println("Rogue performs Backstab!");
                performBackstab();
                break;
            case 2:
                System.out.println("====================");
                System.out.println("Rogue performs Poison Strike!");
                performPoisonStrike();
                break;
            case 3:
                System.out.println("====================");
                System.out.println("Rogue executes Swift Strike!");
                performSwiftStrike();
                break;
            default:
                System.out.println("====================");
                System.out.println("Invalid choice. Rogue hesitates.");
                break;
                //Should not print as Mechanics.readInt() has error handling built in
                //If this prints there is a bug in the code
        }
    }

    // --- Calculation of Damage ---
    
    private int calculateDamage(int offset, int increase) {
        Random random = new Random();
        
        int damage = getAttack() + offset + random.nextInt(increase + 1) - currentEnemy.getDefense();
        /*
        Damage =
            + Player Attack Value
            +/- Offset from Player Attack Value
            + Random Increase in Damage
            - Current Enemy's Defense Value
        
        Example: Damage = 3 + 0 + (0 to 3) - 2
        */
        
        if (damage < 0) {
            damage = 0;
        }
        //Prevents negative damage from accidentally healing the Enemy
        
        return damage;
    }
    
    // --- 3 Attack available for Rogue ---
    
    public void performBackstab() {
        final int RANDOM_CHANCE = 100;
        final int CRITICAL_CHANCE = 10; 
        final int FAILED_CHANCE = 10;
        
        final int CRITICAL_ATTACK_OFFSET = 17;
        final int CRITICAL_DAMAGE_RANGE = 5;
        final int FAILED_ATTACK_OFFSET = 0;
        final int FAILED_DAMAGE_RANGE = 1;
        final int NORMAL_ATTACK_OFFSET = 7;
        final int NORMAL_DAMAGE_RANGE = 5;
        final int TIME_UNIT = 80;
        
        Random random = new Random();
        int damage;
        int chance = random.nextInt(RANDOM_CHANCE);
        //Generate random chance between 0-99
        
        if (chance < CRITICAL_CHANCE) {
            damage = calculateDamage(CRITICAL_ATTACK_OFFSET, CRITICAL_DAMAGE_RANGE); 
            //Critical Damage 
        } else if (chance < CRITICAL_CHANCE + FAILED_CHANCE) { 
            damage = calculateDamage(FAILED_ATTACK_OFFSET, FAILED_DAMAGE_RANGE);
        } else { 
            damage = calculateDamage(NORMAL_ATTACK_OFFSET, NORMAL_DAMAGE_RANGE); 
        }
        //10% for Critical, 10% for Failed, 80% for Normal
        
        currentEnemy.takeDamage(damage);
        addTimeUnit(TIME_UNIT);
        poisonedCheck();
    }

    public void performPoisonStrike() {
        final int ATTACK_OFFSET = 5;
        final int DAMAGE_RANGE = 6;
        final int TIME_UNIT = 100;
        
        int damage = calculateDamage(ATTACK_OFFSET, DAMAGE_RANGE);
        
        currentEnemy.takeDamage((damage));
        addTimeUnit(TIME_UNIT);
        currentEnemy.isPoisonedTrue();
        poisonedCheck();

    }

    public void performSwiftStrike() {
        final int ATTACK_OFFSET = 0;
        final int DAMAGE_RANGE = 3;
        final int TIME_UNIT = 35;
        
        int damage = calculateDamage(ATTACK_OFFSET, DAMAGE_RANGE);
        
                
        currentEnemy.takeDamage(damage);
        addTimeUnit(TIME_UNIT);
        poisonedCheck();

    }
    
    // --- Method Effects ---
    
    @Override
    public void poisonedCheck() {
        final int POISON_DAMAGE = 3;
        
        if (getIsPoisoned() == true) {
            isPoisonedFalse();
            this.takeDamage(POISON_DAMAGE);
            System.out.println(this.getName() + " took " + POISON_DAMAGE + " Poison Damage and slowed");
            System.out.println("====================");
        }
        //Finishing turn deals poison damage
    }
}
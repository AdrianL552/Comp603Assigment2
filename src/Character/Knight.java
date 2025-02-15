/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

import Enemies.Enemy;
import GameText.Text;
import Main.Mechanics;

import java.util.Scanner;
import java.util.Random;

/**
 * 
 * @Author Adrian
 * @Edited by David and Adrian
 * @FocusedOn by David
 * @Status Commented and Finished
 * 
 * Printed Text Generated by ChatGPT such as
 * "Knight performs Shield Bash!" or similar text instances
 */
public class Knight extends PlayerStats {
    private Enemy currentEnemy;

    public Knight(String playerName) {
        super(playerName, "Knight", 40, 8, 12, 9);
    }
    
    //Player Name, Character Name, Health, Attack, Speed, Defense
    
    @Override
    public void setCurrentEnemy(Enemy enemy) {
        this.currentEnemy = enemy;
    }
    //This sets currently spawned Enemy as the target Enemy
    
    @Override
    public void playerAttack(Scanner scanner) {
        System.out.println(Text.knightCombatPrint(this, currentEnemy));

        int chosenAttack = Mechanics.readInt("Your turn: ", 3, Text.knightCombatPrint(this, currentEnemy));

        switch (chosenAttack) {
            case 1:
                System.out.println("====================");
                System.out.println("Knight attacks with Slash!");
                performSlashAttack();
                break;
            case 2:
                System.out.println("====================");
                System.out.println("Knight performs Shield Bash!");
                performShieldBash();
                break;
            case 3:
                System.out.println("====================");
                System.out.println("Knight executes Holy Strike!");
                performHolyStrike();
                break;
            default:
                System.out.println("====================");
                System.out.println("Invalid choice. Knight hesitates.");
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
        
        Example: Damage = 8 + 0 + (0 to 3) - 2
        */
        
        if (damage < 0) {
            damage = 0;
        }
        //Prevents negative damage from accidentally healing the Enemy
        
        return damage;
    }
    
    // --- 3 Attacks available for Knight ---

    public void performSlashAttack() {
        final int ATTACK_OFFSET = 0;
        final int DAMAGE_RANGE = 4;
        
        int damage = calculateDamage(ATTACK_OFFSET, DAMAGE_RANGE);
        currentEnemy.takeDamage(damage);
        poisonedCheck();
    }

    public void performShieldBash() {
        final int ATTACK_OFFSET = 2;
        final int DAMAGE_RANGE = 5;
        
        int damage = calculateDamage(ATTACK_OFFSET, DAMAGE_RANGE);
        currentEnemy.takeDamage(damage);
        poisonedCheck();
    }

    public void performHolyStrike() {
        final int ATTACK_OFFSET = 4;
        final int DAMAGE_RANGE = 6;
        
        int damage = calculateDamage(ATTACK_OFFSET, DAMAGE_RANGE);
        currentEnemy.takeDamage(damage);
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

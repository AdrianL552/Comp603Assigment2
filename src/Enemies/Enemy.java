/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enemies;

import GameExecution.Combatant;
import GameExecution.EnemyCombatant;

import java.util.Random;

/**
 *
 * @Author David
 * @Edited by David and Adrian
 * @FocusedOn by David
 * @Status Commented and Finished
 */

public abstract class Enemy implements Combatant, EnemyCombatant{
    private final String name;
    private final int xpDropRangeMin, xpDropRangeMax, coinDropRangeMin, coinDropRangeMax, maxHp;
    private int hp, speed, defense;
    //Above values must be given for constructor
    
    private int currentTimeUnit;
    //Above values are the same for all enemy classes
    
    private boolean isSlowed, isDefending, isEvading, isPoisoned, isBurning = false;
    private final int originalSpeed, originalDefense;
    //Above values are used to check for special effects

    public Enemy(String name, int xpDropRangeMin, int xpDropRangeMax,
                 int coinDropRangeMin, int coinDropRangeMax,
                 int maxHp, int speed, int defense) {
        this.name = name;
        this.xpDropRangeMin = xpDropRangeMin;
        this.xpDropRangeMax = xpDropRangeMax;
        this.coinDropRangeMin = coinDropRangeMin;
        this.coinDropRangeMax = coinDropRangeMax;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.originalSpeed = speed;
        this.defense = defense;
        this.originalDefense = defense;
        this.currentTimeUnit = 100;
    }

    // --- Getter methods ---
    // Order of related Getter methods follow the order they appear in the constructor
    
    // -- Name --
    @Override
    public String getName() {
        return name;
    }
    
    // -- XP -- 
    public int getXpDropRangeMin() {
        return xpDropRangeMin;
    }

    public int getXpDropRangeMax() {
        return xpDropRangeMax;
    }
    
    public int getXpDropRange() {
        return xpDropRangeMax-xpDropRangeMin;
    }

    // -- Coin --
    public int getCoinDropRangeMin() {
        return coinDropRangeMin;
    }

    public int getCoinDropRangeMax() {
        return coinDropRangeMax;
    }
    
    public int getCoinDropRange() {
        return coinDropRangeMax-coinDropRangeMin;
    }

    // -- HP --
    @Override
    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
    
    @Override
    public void takeDamage(int damage) {
        final int TOTAL_CHANCE = 100;
        final int EVASION_CHANCE = 50;
        
        if (damage < 0) {
            damage = 0;
        } //Prevents any negative damage accidentally healing enemies
        
        if (this.isEvading == true) {
            Random random = new Random();
            int chance = random.nextInt(TOTAL_CHANCE);
            if (chance < EVASION_CHANCE) {
                this.hp -= damage;
            } else {
                System.out.println("But " + getName() + " evaded the attack!");
            } 
            //Damage given 50% of the if evading
        } else {
           this.hp -= damage;
        } //Damage given if not evading

        
        if (this.hp < 0) {
            this.hp = 0; // Ensure that hit points cannot be negative
        }
    }
    
    public void heal(int heal) {
        this.hp += hp;
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp; //Ensures that healing does not go over max Hp
        }
    }

    // -- Speed --
    public int getSpeed() {
        return speed;
    }
    
    public boolean getIsSlowed () {
        return this.isSlowed;
    }
    
    public abstract void slowedCheck();
    
    public void slowSpeed (int slowSpeed) {
        if (this.isSlowed == false) {
            this.speed -= slowSpeed;
            if (this.speed < 1) {
                this.speed = 1;
            }
            //Makes sure enemy can still move
        }
        //You can't slow a slowed enemy again
        this.isSlowed = true;
    }
    
    public void resetSpeed() {
        this.speed = this.originalSpeed;
        this.isSlowed = false;
        //Reset speed to original value
    }
    
    // -- Defense --
    public int getDefense() {
        return defense;
    }
    
    public boolean getIsDefending() {
       return this.isDefending;
    }
    
    public void increaseDefense(int amount) {
        this.defense += amount;
        this.isDefending = true;
    }
    
    public void isDefendingTrue() {
        this.isDefending = true;
    }
    
    public void isDefendingFalse() {
        this.isDefending = false;
        this.defense = this.originalDefense;
    }
    
    // -- Time Unit --
    public void subtractTimeUnit(int amount) {
        currentTimeUnit -= amount;
    }
    
    public void addTimeUnit (int amount) {
        currentTimeUnit += amount;
    }
    
    @Override
    public int getCurrentTimeUnit () {
        return currentTimeUnit;
    }
    
    // -- Evading --
    public boolean getIsEvading() {
        return this.isEvading;
    }
    
    public void isEvadingTrue() {
        this.isEvading = true;
    }
    
    public void isEvadingFalse() {
        this.isEvading = false;
    }
    
    // -- Burning --
    
    public boolean getIsBurning() {
        return this.isBurning;
    }
    
    public void isBurningTrue() {
        this.isBurning = true;
    }
    
    public void isBurningFalse() {
        this.isBurning = false;
    }
    
    public abstract void burningCheck();
    
    // -- Poisoned --
    
    public boolean getIsPoisoned() {
        return this.isPoisoned;
    }

    public void isPoisonedTrue() {
        this.isPoisoned = true;
        this.speed -= 3;
    }

    public void isPoisonedFalse() {
        this.isPoisoned = false;
        this.speed = this.originalSpeed;
    }
    
    public abstract void poisonedCheck();

    
    // --- Abstract Methods ---
    public abstract void attack();
    public abstract void specialAttack();
    public abstract void defend();
}
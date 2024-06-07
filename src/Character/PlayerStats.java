/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

import Enemies.Enemy;
import GameExecution.Combatant;
import JavaDB.AchievementsDB;

import java.util.Scanner;
import java.util.Random;

/**
 * 
 * @Author Adrian
 * @Edited by David and Adrian
 * @FocusedOn by David 
 * @Status Commented and Finished
 */
public abstract class PlayerStats implements Combatant {
    private final AchievementsDB ACHIEVEMENT = new AchievementsDB();
    
    private String playerName, characterName;
    private int hp, maxHp, speed, defense, attack;
    private final int originalSpeed;
    //Above values must be given for constructor
    
    private int xp, xpRequiredForNextLevel, money, level, currentTimeUnit;
    //Above values are the same for all character classes
    
    private boolean isPoisoned, isSlowed = false;
    
        public PlayerStats(String playerName, String characterName,
            int maxHp, int attack, int speed, int defense) {
        this.playerName = playerName;
        this.characterName = characterName;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.speed = speed;
        this.originalSpeed = speed;
        this.defense = defense;
        this.level = 1;
        this.xp = 0;
        this.xpRequiredForNextLevel = 20;
        this.money = 0;
        this.currentTimeUnit = 100;
    }
        
        // --- Getter Methods ---
    // Order of related Getter methods follow the order they appear in the constructor
    
    // -- Name --
    @Override
    public String getName() {
        return getPlayerName() + " the " + getCharacterName();
    }
    //This is to avoid calling both getPlayerName() and getCharacterName()
    
    public String getPlayerName() {
        return this.playerName;
    }

    public String getCharacterName() {
        return this.characterName;
    }
    
    // -- HP --
    public int getMaxHp() {
        return this.maxHp;
    }
    
    @Override
    public int getHp() {
        return this.hp;
    }
    
    // -- Attack --
    public int getAttack() {
        return this.attack;
    }
    
    public int getMaxDamage(int offset, int increase) {
        if (getAttack() + offset + increase <= 0) {
            return 0;
        } else {
            return getAttack() + offset + increase;   
        }
        //If statement needed to prevent displaying negative attack values as to not confuse the player
    }
    /*
    maxDamage = 
        + Character Attack Value 
        + Offset from Character Attack Value
        + Highest Damage Range
    */
    
    public int getMinDamage(int offset) {
        if (getAttack() + offset <= 0) {
            return 0;
        } else {
            return getAttack() + offset;
        }
        //If statement needed to prevent displaying negative attack values as to not confuse the player
    }
    /*
    minDamage =
        + Character Attack Value
        + Offset from Character Attack Value
    */
    
    // -- Speed and Defense --
    public int getSpeed() {
        return this.speed;
    }

    public int getDefense() {
        return this.defense;
    }

    // -- Level and Xp --
    public int getLevel() {
        return this.level;
    }
    
    public int getXp() {
        return this.xp;
    }

    public int getXpRequiredForNextLevel() {
        return this.xpRequiredForNextLevel;
    }

    // -- Money --
    public int getMoney() {
        return this.money;
    }
    
    // -- Time Unit --
    @Override
    public int getCurrentTimeUnit () {
        return this.currentTimeUnit;
    }
    
        // --- Setter Methods ---
    // Order of related Setter Methods follow the order they appear in the constructor
    
    // -- Name --
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    
    // -- HP --
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    
    // -- Attack --
    public void setAttack(int attack) {
        this.attack = attack;
    }

    // -- Speed --
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public boolean getIsSlowed () {
        return this.isSlowed;
    }
    
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
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    // -- Level and XP --
    public void setLevel(int level) {
        this.level = level;
    }
    
    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setXpRequiredForNextLevel(int xpRequiredForNextLevel) {
        this.xpRequiredForNextLevel = xpRequiredForNextLevel;
    }

    // -- Money --
    public void setMoney(int money) {
        this.money = money;
    }

    // -- Time Unit --
    public void setCurrentTimeUnit(int currentTimeUnit) {
        this.currentTimeUnit = currentTimeUnit;
    }

    
        // --- Other Methods ---
    // Order of related Methods follow the order they appear in the constructor
    
    // -- HP --
    public void increaseMaxHp(int maxHp) {
        this.setMaxHp(this.maxHp + maxHp);
        this.setHp(this.hp + maxHp);
        //Both Hp and maxHp is increasead by design
    }
    
    public void decreaseMaxHp(int maxHp) {
        this.setMaxHp(this.maxHp - maxHp);
        
        if (this.maxHp < this.hp) {
            setHp(this.maxHp);
            //Hp should not be allowed to go above maxHp
        }
        
        if (this.hp < 0) {
            this.setHp(0);
            ACHIEVEMENT.heavilyCursedToDeath();
            //Only happens if cursedStatueBuff() happens to decrease Max HP under 0
        }
    }
    
    @Override
    public void takeDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        } 
        //Negative Damage should not heal enemeies, but instead deal 0 damage
        
        this.setHp(this.hp - damage);
        
        if (this.hp < 0) {
            this.setHp(0); 
        }
        //Check is necessary to prevent Hp going below 0
    }
    
    public void heal(int heal) {
        this.setHp(this.hp + heal);
        
        if (this.hp > this.maxHp) {
            this.setHp(this.maxHp);
        }
        //Healing should never set Hp over maxHp
    }
    
    // -- Attack and Defense --
    public void decreaseAttack(int attack) {
        this.setAttack(this.attack - attack);
        
        if (this.attack <= 0) {
            this.setAttack(1);
        }
        //Prevents the game from setting an attack stat that makes the game impossible to win
    }
    
    public void increaseAttack(int attack) {
        this.setAttack(this.attack + attack);
    }
    
    public void increaseDefense(int defense) {
        this.setDefense(this.defense + defense);
    }
    
    public void decreaseDefense(int defense) {
        this.setDefense(this.defense - defense);
        
        if (this.defense < 0) {
            this.setDefense(0);
        } 
        //Defense value below 0 would mean player takes increase damage and should not be allowed
    }
    
    // -- XP --
    public void addXP(int xp) {
        this.setXp(this.xp + xp);
        
        System.out.println("====================");
        System.out.println("Current Level: " + this.level + " | " + this.xp + "/" + this.xpRequiredForNextLevel + " xp");
        //Always Display Current Level and XP / XP Required for Next Level

        while (this.xp >= this.xpRequiredForNextLevel) {
            int statIncrease = new Random().nextInt(3) + 1;
            this.setMaxHp(this.maxHp + statIncrease);
            this.setAttack(this.attack + statIncrease);
            this.setDefense(this.defense + statIncrease);
            //Increase Stats by a random number from 1-3

            System.out.println("====================");
            System.out.println("Congratulations! You have leveled up to level " + (this.level + 1) + "!");
            System.out.println("Your stats have increased by " + statIncrease + " points.");
            System.out.println("====================");
            //(this.level + 1) is used as level has not been increased yet
            
            this.setXp(this.xp - this.xpRequiredForNextLevel);
            this.setXpRequiredForNextLevel(this.xpRequiredForNextLevel + 20); 
            //Reset xp by xpRequiredForNextLevel, any extra xp is carried over
            //Set new xpRequiredForNextLevel
            
            System.out.println(this.xp + "/" + this.xpRequiredForNextLevel + " till level " + (this.level + 2));
            //Display updated xp and xpRequiredForNextLevel
            //(this.level + 2) is used as level has not been increased yet
            
            this.level++;
            //Increase level by 1
        }
        //While loop is used over For loop as it may be possible to level up multiple times
        //While loop is only displayed if the player levels up
    }
    
    // -- Money --
    public void addMoney(int money) {
        this.setMoney(this.money + money);
    }
    
    public void removeMoney (int money) {
        this.setMoney(this.money - money);
    }
    
    // -- Time Unit --
    public void subtractTimeUnit(int amount) {
        setCurrentTimeUnit(currentTimeUnit - amount);
    }
    
    public void addTimeUnit (int amount) {
        setCurrentTimeUnit(currentTimeUnit + amount);
    }
    
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
    public abstract void playerAttack(Scanner scanner);
    public abstract void setCurrentEnemy(Enemy enemy);
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameExecution;

/**
 *
 * @Author Adrian
 * @Edited by David
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */
import Character.PlayerStats;
import GameText.Format;
import GameText.Text;
import Main.Mechanics;
import JavaDB.AchievementsDB;

import java.util.Random;


public class Encounters 
{
    public Random random = new Random();
    public GameLoop gameLoop;
    //allows for random evenets 
    
    public Encounters(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }
    // game loop constructor

    public void findTreasure(PlayerStats player) {
        Format.ClearScreen();
        
        System.out.println(Text.findTreasurePrint());
        int amount = random.nextInt(10) + 1;
        player.addMoney(amount);
        if (amount == 1) {
            System.out.println(Text.oneCoinPrint(player, amount));
            Mechanics.unpause();
        } 
        else {
            System.out.println(Text.coinsPrint(player, amount));
            Mechanics.unpause();
        }
        //gives player random ammount of coints between 1-10
        //used to give player a reliable souce of coins
    }
    
    public void restAtCamp(PlayerStats player, AchievementsDB achievements) {
    Format.ClearScreen();
    int amount = random.nextInt(5) + 6;
    player.heal(amount);
        
    if (player.getMaxHp() == player.getHp()) {
        achievements.theFool();
    }
    //gives a random amount of health to player 1-10
    //uses the player.heal method
    //used to give player a reliable source of health
    //also checks if player meets achievements requirments
    
        
    System.out.println(Text.restAtCampPrint(player, amount));
    Mechanics.unpause();
    }
    
    public void wanderingHealer(PlayerStats player, AchievementsDB achievements) {
        Format.ClearScreen();
        System.out.println(Text.wanderingHealerPrint(player));

        if (player.getMoney() > 0) 
        {
            int input = Mechanics.readInt("enter your choice", 3, Text.wanderingHealerPrint(player));
            switch (input) {
                case 1:
                    break;
                case 2:
                    if (player.getMoney() >= 2) {
                        player.heal(5);
                        player.removeMoney(2);
                        Format.ClearScreen();
                        System.out.println(Text.wanderingHealerOption1Print(player));
                        achievements.charity();
                        Mechanics.unpause();
                        
                    } 
                    else {
                        Format.ClearScreen();
                        System.out.println(Text.wanderingHealerErrorPrint());
                        Mechanics.unpause();
                    }
                    break;
                case 3:
                    if (player.getMoney() >= 5) {
                        player.heal(10);
                        player.removeMoney(5);
                        Format.ClearScreen();
                        achievements.charity();
                        System.out.println(Text.wanderingHealerOption2Print(player));
                        Mechanics.unpause();
                        //heals player and deducts money using
                        //heal and removeMoney method
                    } 
                    else {
                        Format.ClearScreen();
                        System.out.println(Text.wanderingHealerErrorPrint());
                        Mechanics.unpause();
                    } break;
            }
        }     
        else {
            Random random = new Random();
            Format.ClearScreen();
            System.out.print(Text.wanderingHealerPrint(player));
            System.out.println(Text.wanderingHealerNotEnoughtPrint());
            Mechanics.unpause();
            
            if (random.nextInt(100) < 20 && player.getMaxHp() > (player.getHp() * 0.2)) {
                Format.ClearScreen();
                player.heal(10);
                achievements.compassionateHealer();
                System.out.print(Text.wanderingHealerMercyPrint(player));
                Mechanics.unpause();
                // else statment for if player has no money
                // generates random chance to heal if requirments are met
            }
        }
        // if statment used to check player money
   }
   
    public void enterShop(PlayerStats player) {
        boolean shopping = true;
        while(shopping) {
            Format.ClearScreen();
            System.out.println(Text.shopPrint(player));
            
            int input = Mechanics.readInt("You break it you buy it!", 3, Text.shopPrint(player));
            switch(input) {
                case 1:
                    shopping = false;
                    break;
                    // breaks while loop
                    // allows player to exit
                case 2:
                    if(player.getMoney() >= 5) {
                        player.addMoney(-5);
                        player.increaseAttack(5);
                        Format.ClearScreen();
                        System.out.println(Text.attackBuffPurchased(player));
                        Mechanics.unpause();
                        break;
                        // deducts and adds using 
                        // addMoney and IncreaseAttack methods
                    }
                    else {
                        Format.ClearScreen();
                        System.out.println(Text.cantAffordThis());
                        Mechanics.unpause();
                        break;
                    }
                case 3:
                    if(player.getMoney() >= 5) {
                        Format.ClearScreen();
                        System.out.println(Text.defenseBuff(player));
                        Mechanics.unpause();
                        player.addMoney(-5);
                        player.increaseDefense(5);
                        break;
                        // deducts and adds using 
                        // addMoney and IncreaseDefense methods
                    }
                    else {
                        Format.ClearScreen();
                        System.out.println(Text.cantAffordThis());
                        Mechanics.unpause();
                        break;
                        
                    }
                default:
                    break;
            }  
        }
        // while loop set to true so player
        // can buy items multiple times by
        // reEntering the loop
    }
    
    public void statueBuff(PlayerStats player, AchievementsDB achievements) {
        Format.ClearScreen();
        System.out.println(Text.statueBuffPrint(player));
        int input = Mechanics.readInt("Enter your choice", 2, Text.statueBuffPrint(player));
        
        switch(input) {
            case 1:
                if(player.getMoney() == 0) {
                    Format.ClearScreen();
                    System.out.println(Text.statueBuffNotEnough(player));
                    Mechanics.unpause();
                }
                // gives approiate message and returns player to case2
                while(player.getMoney() > 0){
                    Format.ClearScreen();
                    System.out.println(Text.statueBuffTossCoinPrint());
                    Mechanics.unpause();
                    Random random = new Random();
                    int chance = random.nextInt(100);
                    player.removeMoney(1);
                    // deducts money using removeMoney method
                    
                    if (chance < 20) {
                        System.out.println("The holy statue grants you a blessing!");
                        int buffType = random.nextInt(3);
                        int buffAmount = random.nextInt(1) + 1;

                        switch (buffType) {
                            case 0:
                                Format.ClearScreen();
                                player.increaseMaxHp(buffAmount);
                                System.out.println(Text.healthBuff1(player, buffAmount));
                                Mechanics.unpause();
                                break;
                            case 1:
                                Format.ClearScreen();
                                player.increaseAttack(buffAmount);
                                System.out.println(Text.attackBuff1(player, buffAmount));
                                Mechanics.unpause();
                                break;
                            case 2:
                                Format.ClearScreen();
                                player.increaseDefense(buffAmount);
                                System.out.println(Text.defenseBuff1(player, buffAmount));
                                Mechanics.unpause();
                                break;
                            // prints buff type, amount and increases it
                        }
                        Format.ClearScreen();
                        System.out.println(Text.moneyPrint(player, buffAmount));
                        Mechanics.unpause();
                    }
                    else{
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffFailPrint(player));
                        Mechanics.unpause();
                    }
                    if(player.getMoney() > 0){
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffThrowAnotherPrint());
                        int input2 = Mechanics.readInt("Enter Your Choice", 2, Text.statueBuffThrowAnotherPrint());
                        switch(input2){
                            case 1:
                                continue;
                            case 2:
                                Format.ClearScreen();
                                System.out.println(Text.statueBuffLeavePrint());
                                Mechanics.unpause();
                                return;
                        }
                    }
                    else{
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffLeavePrint());
                        Mechanics.unpause();
                        break;
                    }
                    // while loop used to allow players to throw as many coins
                    // into the well as long as they meet the requirments
                    // also gives users the option to leave the loop
                }   
            case 2:
            {
                Format.ClearScreen();
                System.out.println(Text.statueBuffTryGainCoinsPrint(player));
                int input3 = Mechanics.readInt("Enter your choice", 2, Text.statueBuffTryGainCoinsPrint(player));
                
                switch(input3){
                    case 1:
                        int chance = random.nextInt(100);
                        if(chance < 60){
                            int coinsFound = random.nextInt(10) + 1;
                            player.addMoney(coinsFound);
                            achievements.naughtyNaughty();
                            Format.ClearScreen();
                            System.out.println(Text.statueBuffGainedCoins(player, coinsFound));
                            Mechanics.unpause();
                        }
                        else{
                            Format.ClearScreen();
                            achievements.greedyPunishment();
                            System.out.println(Text.statueBuffEnemy());
                            Mechanics.unpause();
                            gameLoop.spawnEnemy();
                            gameLoop.turnBasedCombat();
                            return;
                        }
                    case 2:
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffWalkAwayPrint());
                        Mechanics.unpause();
                }
            }
            // case:2 allows the user to atempt try to gain coins out the fountain
            // if uses try it will generate a random number which determins the 
            // outcome. either gain coins or spawn an enemy.
        }
    }
    
    public void cursedStatueBuff(PlayerStats player, AchievementsDB achievements) {
        Format.ClearScreen();
        System.out.println(Text.cursedStatueBuffPrint(player));
        
        int input = Mechanics.readInt("Choose wisely", 2, Text.cursedStatueBuffPrint(player));
        switch(input){
            case 1:
                if(player.getMoney() == 0){
                    Format.ClearScreen();
                    System.out.println(Text.statueBuffNotEnough(player));
                    Mechanics.unpause();
                }
                while(player.getMoney() > 0) {
                    Random random = new Random();

                    Format.ClearScreen();
                    System.out.println(Text.statueBuffTossCoinPrint());
                    Mechanics.unpause();

                    player.removeMoney(1);
                    int chance = random.nextInt(100);
                    // deducts money

                    if (chance > 20) {
                        Format.ClearScreen();
                        System.out.println(Text.cursedStatueTrueBuffPrint());
                        Mechanics.unpause();

                        int buffType = random.nextInt(3);
                        int buffAmount = random.nextInt(1) + 2;
                        int debuffType;
                        do {
                            debuffType = random.nextInt(3);
                        } 
                        while (debuffType == buffType);
                        int debuffAmount = random.nextInt(2) + 4;
                        // generates a random number which determins
                        // defuff/buff type and amount of each

                        switch (buffType) {
                            case 0:
                                player.increaseMaxHp(buffAmount);
                                Format.ClearScreen();
                                System.out.println(Text.healthBuff1(player, buffAmount));
                                break;
                            case 1:
                                player.increaseAttack(buffAmount);
                                Format.ClearScreen();
                                System.out.println(Text.attackBuff1(player, buffAmount));
                                break;
                            case 2:
                                player.increaseDefense(buffAmount);
                                Format.ClearScreen();
                                System.out.println(Text.defenseBuff1(player, buffAmount));
                                break;
                        }
                        switch (debuffType) {
                            case 0:
                                player.decreaseMaxHp(debuffAmount);
                                System.out.println(Text.healthDebuff1(player, debuffAmount));
                                Mechanics.unpause();
                                break;
                            case 1:
                                player.decreaseAttack(debuffAmount);
                                System.out.println(Text.attackDebuff1(player, debuffAmount));
                                Mechanics.unpause();
                                break;
                            case 2:
                                player.decreaseDefense(debuffAmount);
                                System.out.println(Text.defenseDebuff1(player, debuffAmount));
                                Mechanics.unpause();
                                break;
                        }
                        Format.ClearScreen();
                        System.out.println(Text.moneyPrint(player, buffAmount));
                        Mechanics.unpause();
                    } 
                    else {
                        Format.ClearScreen();
                        System.out.println(Text.cursedStatueFailBuffPrint());
                        Mechanics.unpause();
                    }
                    if(player.getMoney() > 0) {
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffThrowAnotherPrint());
                            
                        int input2 = Mechanics.readInt("Enter Your Choice", 2, Text.statueBuffThrowAnotherPrint());
                        switch(input2){
                            case 1:
                                continue;
                            case 2:
                                Format.ClearScreen();
                                System.out.println(Text.statueBuffLeavePrint());
                                Mechanics.unpause();
                                return;
                        } 
                        // case 1 reEnters loop. case 2 exits
                    } 
                    else {
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffLeavePrint());
                        Mechanics.unpause();
                        break;
                    }
                    // while loop used to allow players to throw
                    // as many coins as the want as long as they
                    // meet the requirments
                }
            case 2:
                Format.ClearScreen();
                System.out.println(Text.statueBuffTryGainCoinsPrint(player));
                int chance = random.nextInt(100);
                
                int input2 = Mechanics.readInt("Choose wisely", 2, Text.statueBuffTryGainCoinsPrint(player));
                switch(input2)
                {
                    case 1:
                        if(chance  < 5){
                            int coinsFound = random.nextInt(10) + 1;
                            player.addMoney(coinsFound);
                            
                            Format.ClearScreen();
                            achievements.stealingFromTheDevil();
                            System.out.println(Text.statueBuffGainedCoins(player, coinsFound));
                            Mechanics.unpause();
                            
                        }
                        else{
                            Format.ClearScreen();
                            achievements.theDevilsAnger();
                            System.out.println(Text.cursedStatueComabatPrint());
                            Mechanics.unpause();
                            
                            int debuffAmount1 = random.nextInt(3)+3;
                            int debuffAmount2 = random.nextInt(3)+3;
                            int debuffAmount3 = random.nextInt(3)+3;
                            player.decreaseAttack(debuffAmount1);
                            player.decreaseDefense(debuffAmount2);
                            player.decreaseMaxHp(debuffAmount3);
                            
                            Format.ClearScreen();
                            System.out.println(Text.cursedStatueDebuffsPrint(debuffAmount1, debuffAmount2, debuffAmount3));
                            if(player.getMaxHp() <= 0) {
                                System.out.println("Your Max Hp went below 0 and have just died on the spot");
                                Mechanics.unpause();
                                // checks if player HP is 0 or bellow
                            } else if(player.getMaxHp() > 0) {
                                Mechanics.unpause();
                                gameLoop.spawnEnemy();
                                gameLoop.turnBasedCombat();
                                // spawns enemy and starts turn based combat
                            }
                            return;
                            // exits loop
                        }
                    case 2:
                        Format.ClearScreen();
                        System.out.println(Text.statueBuffWalkAwayPrint());
                        Mechanics.unpause();
                        return;
                    // case 2: allows player to try to gain coins, with a chance
                    // of encountering an enemy
                }
        }       
    } 
}
    
    

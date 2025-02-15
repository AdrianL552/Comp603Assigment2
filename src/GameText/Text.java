/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameText;

import Character.PlayerStats;
import Enemies.Enemy;
import GameExecution.Combatant;
import static GameText.Format.ClearScreen;
import JavaDB.AchievementsDB;
import JavaDB.AchievementsDB;

/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * @Status Commented and Finished
 */
public class Text 
{
    // Game Story Text was Generated by ChatGPT
    
    // needed to write in Static Strings instead of 
    // static void because void does not return
    // anything while String will return the String
    // which can be used in the error handling parameter
    // of the Mechanics.ReadInt method
    
    
    // game info prints
    public static void printIntroArea1() {
        Format.printHeading(
            "Welcome to the Fields of Syntax, young adventurer!\n" +
            "The sun shines brightly upon the golden wheat fields as you step into this picturesque landscape.\n" +
            "But beware, for danger lurks in the shadows of the code.\n" +
            "Syntax errors and bugs threaten to disrupt your journey through the land of Java.\n" +
            "Do you have what it takes to overcome these challenges and emerge victorious?"
        );// Story Text Generated By GhatGPT
    }

    public static void printOutroArea1() {
        Format.printHeading(
            "Congratulations, brave adventurer!\n" +
            "You have conquered the Fields of Syntax and proven your worth as a coder.\n" +
            "But the journey ahead is fraught with even greater challenges.\n" +
            "Take a moment to rest and prepare yourself for the trials that lie ahead."
        );// Story Text Generated By GhatGPT
    }

    public static void printIntroArea2() {
        Format.printHeading(
            "Welcome to the Forest of Methods, intrepid coder!\n" +
            "Dense fog obscures your vision as you venture deeper into this mystical woodland.\n" +
            "Recursive functions echo through the trees, testing your skills and intellect.\n" +
            "But fear not, for with each challenge overcome, you grow stronger.\n" +
            "Will you unravel the secrets hidden within the forest, or be lost to its depths forever?"
        );// Story Text Generated By GhatGPT
    }

    public static void printOutroArea2() {
        Format.printHeading(
            "Well done, courageous coder!\n" +
            "You have navigated the twists and turns of the Forest of Methods with skill and determination.\n" +
            "But your journey is far from over.\n" +
            "Take a moment to reflect on your accomplishments and prepare for the trials that await you."
        );// Story Text Generated By GhatGPT
    }
    
    public static void printIntroArea3(){
        Format.printHeading(
            "Welcome to the Citadel of Objects, masterful programmer!\n" +
            "Towering walls of code surround you as you stand before this ancient fortress.\n" +
            "Design patterns and architectural wonders await those brave enough to enter.\n" +
            "But beware, for the Architect King and his legion of objects will stop at nothing to defend their domain.\n" +
            "Will you emerge triumphant, or be consumed by the code?"
        );// Story Text Generated By GhatGPT
    }

    public static void printOutroArea3() {
        Format.printHeading(
            "Bravo, valiant programmer!\n" +
            "You have conquered the Citadel of Objects and proven yourself a true master of Java.\n" +
            "But the adventure doesn't end here.\n" +
            "Take pride in your accomplishments, for they are a testament to your skill and perseverance."
        );// Story Text Generated By GhatGPT
    }
    
    public static String printMenuPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("========== game Menu ==========\n");
        newString.append("1. Continue on quest\n");
        newString.append("2. View player information\n");
        newString.append("3. Quit game\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String areaPrint(int area,int section) {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("=== Area " + area + " - Section " + section);
        newString.append("\n====================");
        return newString.toString();
    }
    // game info prints
    
    
    
    // start menu prints
    public static void Title(){
        System.out.println(" _    __  __  _ __    __    __  ___   __   __   _   _   __   \n" +
"| |  /  \\|  \\| | _\\ /' _/  /__\\| __| |_ \\ /  \\ | \\ / | /  \\  \n" +
"| |_| /\\ | | ' | v |`._`. | \\/ | _|   _\\ | /\\ |`\\ V /'| /\\ | \n" +
"|___|_||_|_|\\__|__/ |___/  \\__/|_|   /___|_||_|  \\_/  |_||_| ");
    }// ASCII Art was made using website
     // https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
    
    public static void printStart(){
        Format.printHeading("Chronicles of the Elemental Realm!!! A java text based RPG!");
    }
    
    public static void printIntro(){
        Format.printHeading("An ancient curse has been released in the lands of Java. The King of Java sends you on a quest to defeat the great evil!");
    }
    
    public static String MainMenuPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("========== Main Menu ==========\n");
        newString.append("1. Begin your adventure\n");
        newString.append("2. How to Play\n");
        newString.append("3. Settings\n");
        newString.append("4. Achievements\n");
        newString.append("5. Credits\n");
        newString.append("6. Exit Game\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String SettingsPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("========== Settings ==========\n");
        newString.append("1. Change Area and Section Generation\n");
        newString.append("2. Reset Achievements\n");
        newString.append("3. Display Achievements\n");
        newString.append("4. Add Achievement Demos\n");
        newString.append("5. Exit Settings\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String SettingsAchievemensEdit() {
        StringBuilder newString = new StringBuilder();
        newString.append("========== Settings ==========\n");
        newString.append("Are you sure you want to reset all Achievements?\n");
        newString.append("1. yes\n");
        newString.append("2. No\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String AchievementsPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("========== Achievements ==========\n");
        newString.append(new AchievementsDB().displayAllAchievements());
        newString.append("==============================");
        return newString.toString();
    }

    public static String RulesPrint() {  
        StringBuilder newString = new StringBuilder();
        newString.append("========== Rules ==========\n");
        newString.append(" Place holder\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String CreditsPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("========== Credits ==========\n");
        newString.append("Created by Adrian and David!!!!\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String editGameLoopPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("========== Settings ==========\n");
        newString.append("1. Edit Amount of Sections per Area\n");
        newString.append("2. Edit Amount of Path per Section\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String settingsInvalidPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("========== Settings ==========\n");
        newString.append("Invalid input. Please enter a valid integer.");
        return newString.toString();
    }
    
    public static String settingsSectionAmountPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("Enter a new Section Amount: \n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String settingsPathAmountPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("Enter a new Path Amount: \n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String settingsSectionAmountUpdatePrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("Section Amount updated successfully.\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String settingsPathAmountUpdatePrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("Section Path updated successfully.\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String quitGamePrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("Are you sure you want to exit the game? (y/n)\n");
        newString.append("==============================");
        return newString.toString();    
    }
    
    public static String quitGameReprint(){
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("Invalid input. Please enter 'y' to exit or 'n' to continue playing.\n");
        newString.append("==============================");
        return newString.toString();    
    }
    // start menu prints
    
    
 
    // Character creater prints
    public static String LoadPlayerPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("An already existing player exists\n");
        newString.append("==============================\n");
        newString.append("1. Load profile\n");
        newString.append("2. Create New Player(WILL DELETE EXISITING FILE!)\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String ChooseClassPrint() {
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("You find yourself facing a dangerous enemy in a dark forest. How do you approach the situation?\n");
        newString.append("==============================\n");
        newString.append("1. Charge straight at the enemy with sword drawn, ready for close combat.\n");
        newString.append("2. Analyze the enemy's weaknesses and strengths before deciding on a course of action.\n");
        newString.append("3. Sneak around the enemy, looking for an opportune moment to strike from the shadows.\n");
        newString.append("4. Keep your distance from the enemy, finding a vantage point to attack with precision from afar.\n");
        newString.append("==============================");
        return newString.toString();
    }

    public static void printAskPlayerName(){
        Format.printQuestion("What is your name, hero? ");
    }
    
    public static void printYesOrNo(){
        Format.printQuestion("Are you sure? YES/NO ");
    }
    
    public static void printPlayerStats(PlayerStats player) {
        ClearScreen();
        Format.boarder(15);
        System.out.println(player.getPlayerName() + " The " + player.getCharacterName() + "!");
        System.out.println("Max Hp: " + player.getMaxHp());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        Format.boarder(15);
    }
    
    public static String PlayerStatsPrint(PlayerStats player) {
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append(player.getPlayerName()).append(" The ").append(player.getCharacterName()).append("!\n");
        newString.append("Max Hp: ").append(player.getMaxHp()).append("\n");
        newString.append("Attack: ").append(player.getAttack()).append("\n");
        newString.append("Defense: ").append(player.getDefense()).append("\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    
        public static String PlayerStatsPrint1() {
        StringBuilder newString = new StringBuilder();
        newString.append("==============================\n");
        newString.append("Max Hp: ").append("20").append("\n");
        newString.append("Attack: ").append("20").append("\n");
        newString.append("Defense: ").append("20").append("\n");
        newString.append("==============================");
        return newString.toString();
    }
    // Character creater prints
    

    
    // shop text prints
    public static String shopPrint(PlayerStats player) {
        StringBuilder newString = new StringBuilder();
        newString.append("====== Ye Olde Emporium ======\n");
        newString.append("1. Leave\n");
        newString.append("2. Attack Buff Cost: 5\n");
        newString.append("3. Defense Buff Cost: 5\n");
        newString.append("==============================\n");
        newString.append("You have a total of " + player.getMoney() + " coins\n");
        newString.append("==============================");
        return newString.toString();
    }
    
    public static String attackBuffPurchased(PlayerStats player) {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Attack Buff Purchased\n");
        newString.append("Your Attack is now" + player.getAttack() + "!!\n");
        newString.append("You have " + player.getMoney() + " coins\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String defenseBuff(PlayerStats player) {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Defense Buff Purchased\n");
        newString.append("Your Defense is now" + player.getDefense() + "!!\n");
        newString.append("You have " + player.getMoney() + " coins\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String cantAffordThis() {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You cant afford this bum!\n");
        newString.append("====================");
        return newString.toString();
    }
    // shop text prints
    
    
    
    // Treasure tex prints
    public static String findTreasurePrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You found a Treasure Chest filled with coins!!!");
        return newString.toString();
    }
    
    public static String oneCoinPrint(PlayerStats player, int amount){
        StringBuilder newString = new StringBuilder();
        newString.append("You gained " + amount + " coin\n");
        newString.append("====================\n");
        newString.append("You have a total of " + player.getMoney() + " coins \n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String coinsPrint(PlayerStats player, int amount){
        StringBuilder newString = new StringBuilder();
        newString.append("You gained " + amount + " coins!\n");
        newString.append("====================\n");
        newString.append("You have a total of " + player.getMoney() + " coins \n");
        newString.append("====================");
        return newString.toString();
    }
    // Treasure tex prints
    
    
    
    // Wondering healer text prints
    public static String wanderingHealerPrint(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("As you travel your path crosses with a wandering healer.\n");
        newString.append("He offers to heal \n");
        newString.append("====================\n");
        newString.append("1. Leave\n");
        newString.append("2. 5 health for 2 coins\n");
        newString.append("3. 10 health for 5 coins\n");
        newString.append("====================\n");
        newString.append("Your Current Health: " + player.getHp());
        newString.append("\nYou have " + player.getMoney() + " coins\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String wanderingHealerOption1Print(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You paid 2 coins and healed 5 health.\n");
        newString.append("You now have " + player.getMoney() + " coins");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String wanderingHealerOption2Print(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You paid 5 coins and healed 10 health.");
        newString.append("You now have " + player.getMoney() + " coins");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String wanderingHealerErrorPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You don't have enough coins to purchase healing.");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String wanderingHealerMercyPrint(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Seeing that you injured he heals you for 10 health anyways\n");
        newString.append("Your Current Health: " + player.getHp());
        newString.append("\n====================\n");
        return newString.toString();
    }
    
    public static String wanderingHealerNotEnoughtPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("\nYou don't have any coins at the moment so you go on your merry way\n");
        newString.append("====================");
        return newString.toString();
    }
    // Wondering healer text prints
        
        

    // rest at camp text prints
    public static String restAtCampPrint(PlayerStats player, int amount){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You rest at the camp.\n");
        newString.append("You healed " + amount + " hp");
        newString.append("\n====================\n");
        newString.append("HP: " + player.getHp());
        newString.append("\n====================");
        return newString.toString();
    }
    // rest at camp text prints
    
    
    
    
    // statue/curse buff prints
    public static String statueBuffPrint(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You stumble upon a holy statue with a well nearby\n");
        newString.append("Throw a coin into the well for a chance of a small buff?\n");
        newString.append("====================\n");
        newString.append("1. yes\n");
        newString.append("2. no\n");
        newString.append("====================\n");
        newString.append("You have " + player.getMoney() + " coins");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String statueBuffTossCoinPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You toss a coin into the well...\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String statueBuffFailPrint(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Unfortunately, the holy statue remains silent.\n");
        newString.append("You have " + player.getMoney() + " coins Left");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String statueBuffThrowAnotherPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Would you like to throw another coin into the well? \n");
        newString.append("====================\n");
        newString.append("1. Yes\n");
        newString.append("2. No\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String statueBuffNotEnough(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You try to attempt to attempt to throw some coins in... You don't have any\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String statueBuffTryGainCoinsPrint(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You see some coins glittering at the bottom of the well. Do you want to retrieve them?\n");
        newString.append("====================\n");
        newString.append("1. Yes\n");
        newString.append("2. No\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String statueBuffGainedCoins(PlayerStats player, int coinsFound){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You found " + coinsFound + " coins in the well!\n");
        newString.append("You have " + player.getMoney() + " coins");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String moneyPrint(PlayerStats player, int coinsFound){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You have " + player.getMoney() + " coins Left");
        newString.append("\n====================");
        return newString.toString();
    }
   
    public static String statueBuffLeavePrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You decide not to tempt fate and walk away from the well.");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String statueBuffRunoutPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("It seems like you have run out of coins. You silently bid farewell on continue on");
        newString.append("\n====================");
        return newString.toString();
    }

    public static String statueBuffEnemy(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("As you reach for the coins, the statue's eyes glow red...\n");
        newString.append("The statue crumbles, revealing a hidden enemy!\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String statueBuffWalkAwayPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You admire the beauty of the statue and walk away.");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String cursedStatueBuffPrint(PlayerStats player){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("You encounter a cursed statue with a dark aura.\n");
        newString.append("Throw coins into the well for a chance of a powerful buff, but beware of the curse!\n");
        newString.append("====================\n");
        newString.append("1. Yes\n");
        newString.append("2. No\n");
        newString.append("====================\n");
        newString.append("You have " + player.getMoney() + " coins");
        newString.append("\n====================");
        return newString.toString();
    }

    public static String cursedStatueTrueBuffPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("The cursed statue grants you a powerful blessing!\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String cursedStatueFailBuffPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Unfortunately, the cursed statue remains silent.\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String cursedStatueComabatPrint(){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("As you reach for the coins, the statue's glows violently, releasing an awful sound...\n");
        newString.append("It curses you heavily!!!\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String cursedStatueDebuffsPrint(int debuffAmount1, int debuffAmount2, int debuffAmount3){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Attack Decreased by " + debuffAmount1);
        newString.append("\nDefense Decreased by " + debuffAmount2);
        newString.append("\nMax HP Decreased by " + debuffAmount3);
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String attackBuff1(PlayerStats player, int buffAmount) {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Your attack has increased by " + buffAmount + "!");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String attackDebuff1(PlayerStats player, int debuffAmount) {
        StringBuilder newString = new StringBuilder();
        newString.append("However, your attack has decreased by " + debuffAmount + "!");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String defenseBuff1(PlayerStats player, int buffAmount) {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Your defense has increased by " + buffAmount + "!");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String defenseDebuff1(PlayerStats player, int debuffAmount) {
        StringBuilder newString = new StringBuilder();
        newString.append("However, your defense has decreased by " + debuffAmount + "!");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String healthBuff1(PlayerStats player, int buffAmount) {
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("Your health has increased by " + buffAmount + "!");
        newString.append("\n====================");
        return newString.toString();
    }
    
    public static String healthDebuff1(PlayerStats player, int debuffAmount) {
        StringBuilder newString = new StringBuilder();
        newString.append("However, your defense has decreased by " + debuffAmount + "!");
        newString.append("\n====================");
        return newString.toString();
    }
    // statue/curse buff prints
    
    
    
    //Combat Prints
    public static String spawnEnemyPrint(Enemy currentEnemy){
        StringBuilder newString = new StringBuilder();
        newString.append("====================\n");
        newString.append("A " + currentEnemy.getName() + " appears!\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String displayTimeUnitsPrint(Combatant firstCombatant, Combatant secondCombatant) {
        StringBuilder newString = new StringBuilder();
        newString.append("<====================\n");
        newString.append("ACTION BUFFER:\n");
        newString.append("Currently Moving: ").append(firstCombatant.getName()).append("\n");
        newString.append("2nd in Queue: ").append(secondCombatant.getName()).append(" | ").append(secondCombatant.getCurrentTimeUnit()).append(" Bits Left\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String TurnPrint(PlayerStats player, Enemy currentEnemy) {
        StringBuilder newString = new StringBuilder();
        newString.append("Player HP: ").append(player.getHp()).append("/").append(player.getMaxHp()).append("\n");
        newString.append("Enemy HP: ").append(currentEnemy.getHp()).append("/").append(currentEnemy.getMaxHp());
        newString.append("\n====================");
        return newString.toString();
    }
    
     // Used ChatGPT to help Learn and Debug how to format RogueCombatPrint 
     // then was able to make the other 3 based by Self
    public static String RogueCombatPrint(PlayerStats player, Enemy currentEnemy) {
        StringBuilder newString = new StringBuilder();
        newString.append("Player HP: ").append(player.getHp()).append("/").append(player.getMaxHp()).append("\n");
        newString.append("Enemy HP: \n").append(currentEnemy.getHp()).append("/").append(currentEnemy.getMaxHp());
        newString.append("====================\n");
        newString.append("1. Backstab (Damage on Crit, Successful, Failed Stabs: ")
        .append(player.getMinDamage(17)).append("-").append(player.getMaxDamage(17,5)).append(", ")
        .append(player.getMinDamage(7)).append("-").append(player.getMaxDamage(7,5)).append(", ")
        .append(player.getMinDamage(0)).append("-").append(player.getMaxDamage(0,1)).append("; Bits Cost: 80 \n");
        newString.append("2. Poison Strike (Damage: ").append(player.getMinDamage(5)).append("-").append(player.getMaxDamage(5,6)).append(", Bits Cost: 100\n");
        newString.append("3. Swift Strike (Damage: ").append(player.getMinDamage(0)).append("-").append(player.getMaxDamage(0,3)).append(", Bits Cost: 35\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String knightCombatPrint(PlayerStats player, Enemy currentEnemy) {
        StringBuilder newString = new StringBuilder();
        newString.append("Player HP: ").append(player.getHp()).append("/").append(player.getMaxHp()).append("\n");
        newString.append("Enemy HP: ").append(currentEnemy.getHp()).append("/").append(currentEnemy.getMaxHp());
        newString.append("\n====================\n");
        newString.append("1. Slash (Damage: ").append(player.getMinDamage(0)).append("-").append(player.getMaxDamage(0,4)).append(", Bits Cost: 50)\n");
        newString.append("2. Shield Bash (Damage: ").append(player.getMinDamage(2)).append("-").append(player.getMaxDamage(2,6)).append(", Bits Cost:65, Delay Enemy by 30 Bits)\n");
        newString.append("3. Holy Strike (Damage: ").append(player.getMinDamage(4)).append("-").append(player.getMaxDamage(4,8)).append(", Bits Cost:125)\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String MageCombatPrint(PlayerStats player, Enemy currentEnemy) {
        StringBuilder newString = new StringBuilder();
        newString.append("Player HP: ").append(player.getHp()).append("/").append(player.getMaxHp()).append("\n");
        newString.append("Enemy HP: ").append(currentEnemy.getHp()).append("/").append(currentEnemy.getMaxHp());
        newString.append("\n====================\n");
        newString.append("1. Fireball (Damage: ").append(player.getMinDamage(10)).append("-").append(player.getMaxDamage(10,4)).append(", Bits Cost: 40, Burn Damage on next Turn)\n");
        newString.append("2. Frostbolt (Damage: ").append(player.getMinDamage(0)).append("-").append(player.getMaxDamage(0,4)).append(", Bits Cost:70)\n");
        newString.append("3. Arcane Blast (Damage: ").append(player.getMinDamage(12)).append("-").append(player.getMaxDamage(12,8)).append(", Bits Cost: 150, Enemy is blown back by 50 Bits\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static String ArcherCombatPrint(PlayerStats player, Enemy currentEnemy) {
        StringBuilder newString = new StringBuilder();
        newString.append("Player HP: ").append(player.getHp()).append("/").append(player.getMaxHp()).append("\n");
        newString.append("Enemy HP: ").append(currentEnemy.getHp()).append("/").append(currentEnemy.getMaxHp());
        newString.append("\n====================\n");
        newString.append("1. Quick Shot (Damage: ").append(player.getMinDamage(2)).append("-").append(player.getMaxDamage(2,4)).append(", Bits Cost: 35)\n");
        newString.append("2. Aimed Shot (Damage: ").append(player.getMinDamage(6)).append("-").append(player.getMaxDamage(6,6)).append(", Bits Cost: 75)\n");
        newString.append("3. Multi-Shot (Damage each Arrow: ").append(player.getMinDamage(0)).append("-").append(player.getMaxDamage(0,3)).append(", 2-5 Arrows, Bits Cost for Each Arrow Shot: 30)\n");
        newString.append("====================");
        return newString.toString();
    }
    
    public static void printEnemyStats(Enemy enemy) {
        ClearScreen();
        Format.boarder(30);
        System.out.println("Enemy: " + enemy.getName());
        System.out.println("Max Hp: " + enemy.getHp());
        Format.boarder(30);
    }
    //Combat Prints
}
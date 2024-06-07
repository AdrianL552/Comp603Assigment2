package GUI;


 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Character.Archer;
import Character.Knight;
import Character.Mage;
import Character.PlayerStats;
import Character.Rogue;
import GameExecution.GameLoop;
import GameText.Text;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.Random;


import javax.swing.*;
import java.awt.*;

/**
 *
 * @Author Adrian
 * @Edited by Adrian
 * @FocusedOn by Adrian
 * 
 */

public class MainMenuFrame extends JFrame implements ActionListener{
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextField textField;
    private JLabel gif, KnightTitle, MageTitle, RogueTitle, ArcherTitle, StartKnightStats, StartMageStats, StartRogueStats, 
            StartArcherStats, KnightStats, MageStats, RogueStats, ArcherStats;
    public PlayerStats player;
    public String playerName;
    private JButton KnightButton , ArcherButton, MageButton, RogueButton, attack1, attack2, attack3;
    private int num = 1;
    private int OutxLeft, OutxRight, InxLeft, InxRight;
    private JButton path1, path2, path3, path4, path5, path6;
    private JPanel gameMenuPanel, shopPanel, treasurePanel, restAtCampPanel, healerPanel, enemiePanel;
    private String playerCurrentClass;
    int currentSection = 0;
    GameLoop gameLoop;
    
    private JLabel wonTitleLabel, lostTitleLabel;
    private JButton leaveButton, backToMenu;
    
    
    
    private JLabel[] playerStatLabel, enemyStatLabel;
    
    public MainMenuFrame(){
        setSize(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        CardLayout();
    }
    
    
    //creates a cardPanel for each differenet frame so we can switch between each Jpanel
    private void CardLayout(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        cardPanel.add(MainMenuPanel(), "MainMenu");
        cardPanel.add(PlayerNamePanel(), "GetPlayerName");
        cardPanel.add(PlayerClassPickerPanel(), "GetPlayerClass");
        cardPanel.add(GameMenuPanel(), "GameMenu");
        cardPanel.add(ShopPanel(), "ShopPanel");
        cardPanel.add(TreassurePanel(), "TreasurePanel");
        cardPanel.add(restAtCampPanel(), "CampPanel");
        cardPanel.add(wanderingHealerPanel(), "HealerPanel");
        cardPanel.add(enemiesPanel(), "EnemiesPanel");
        
        add(cardPanel);
    }
    
    
    // creates mainMenu Jpanel
    private JPanel MainMenuPanel(){
        JPanel mainMenuPanel = new JPanel(null);
        
        // setBackground to gray
        mainMenuPanel.setBackground(Color.gray);
        // add title using addTitle method with parameters
        addTitle(mainMenuPanel, "LANDS OF JAVA", 800, 250, 500, 120 ,50);
        
        // add buttons to mainMenu using addButton method with parameters
        addButton(mainMenuPanel, "Begin your Adventure", 855, 400, 230, 70, 20);
        addButton(mainMenuPanel, "How To Play", 855, 500, 230, 70, 20);
        addButton(mainMenuPanel, "Settings", 855, 600, 230, 70, 20);
        addButton(mainMenuPanel, "Achievements", 855, 700, 230, 70, 20);
        addButton(mainMenuPanel, "Credits", 855, 800, 230, 70, 20);
        addButton(mainMenuPanel, "Exit Game", 855, 900, 230, 70, 20);
        
        // creates outer edges for screen
        addSquare(mainMenuPanel, Color.gray, 20, 20, 1880, 980);
        addSquare(mainMenuPanel, Color.lightGray, 10, 10, 1900, 1000);
        
        //hides gif
        displayGif(false);
        return mainMenuPanel;
    }

    private JPanel PlayerNamePanel(){
        // creates player Jpanel
        JPanel playerNamePanel = new JPanel(null);
        playerNamePanel.setBackground(Color.gray);

        // add title
        addTitle(playerNamePanel, "Enter your Name hero", 875, 250, 500, 120,40);
        
        // Create text field to allow players input text for name
        addTextField(playerNamePanel,"", 875, 400, 400, 30);
        
        // add buttons
        addButton(playerNamePanel,"Confirm", 875, 900, 230, 70, 20);
        
        // creates outer edges for screen
        addSquare(playerNamePanel, Color.gray, 20, 20, 1880, 980);
        addSquare(playerNamePanel, Color.lightGray, 10, 10, 1900, 1000);
        return playerNamePanel;
    }

    
    private JPanel PlayerClassPickerPanel(){
        JPanel playerClassPickerPanel = new JPanel(null);
        playerClassPickerPanel.setBackground(Color.gray);

        // add title to prompt users to select a class
        addTitle(playerClassPickerPanel, "Select a Class(Click to pick!)", 200, 80, 5000, 120 ,40);
        
        // creates Class title as variables so we can hide them or show if needed
        KnightTitle = addTitle(playerClassPickerPanel, "Knight", 280, 160, 500, 120 ,40);
        MageTitle = addTitle(playerClassPickerPanel, "Mage", 280, 160, 200, 120 ,40);
        RogueTitle = addTitle(playerClassPickerPanel, "Rogue", 280, 160, 500, 120 ,40);
        ArcherTitle = addTitle(playerClassPickerPanel, "Archer", 280, 160, 500, 120 ,40);
        
        
        // creates class button as variables so we can hide them or show if needed
        KnightButton = addButtonIcon(playerClassPickerPanel, "./resources/Knight.png", 200, 250, 300, 500);
        MageButton = addButtonIcon(playerClassPickerPanel, "./resources/Mage.png", 200, 250, 300, 500);
        RogueButton = addButtonIcon(playerClassPickerPanel, "./resources/Rogue.png", 200, 250, 300, 500);
        ArcherButton = addButtonIcon(playerClassPickerPanel, "./resources/Archer.png", 200, 250, 300, 500);
        
        // creates class stats as variables so we can hide them or show if needed
        StartKnightStats = startingPlayerStats(playerClassPickerPanel, "Starting Stats", 40, 8, 12, 9, 920, 200, 400, 500, 30);
        StartMageStats = startingPlayerStats(playerClassPickerPanel, "Starting Stats", 30, 4, 9, 4, 920, 200, 400, 500, 30);
        StartRogueStats = startingPlayerStats(playerClassPickerPanel, "Starting Stats", 20, 3, 15, 4, 920, 200, 400, 500, 30);
        StartArcherStats = startingPlayerStats(playerClassPickerPanel, "Starting Stats", 25, 6, 15, 5, 920, 200, 400, 500, 30);

        
        // set only knight button to be visible initially
        KnightButton.setVisible(true);
        MageButton.setVisible(false);
        RogueButton.setVisible(false);
        ArcherButton.setVisible(false);
        
        
        // set only knight title to be visible initially
        KnightTitle.setVisible(true);
        MageTitle.setVisible(false);
        RogueTitle.setVisible(false);
        ArcherTitle.setVisible(false);
        
        // set only knight stats to be visible initially
        StartKnightStats.setVisible(true);
        StartMageStats.setVisible(false);
        StartRogueStats.setVisible(false);
        StartArcherStats.setVisible(false);
        
        
        // adds buttons to allow players to cycle throught classes
        addButton(playerClassPickerPanel,"==>", 400, 850, 180, 70, 20);
        addButton(playerClassPickerPanel,"<==", 100, 850, 180, 70, 20);
        
        // creates outer edges for screen
        addSquare(playerClassPickerPanel, Color.gray, 20, 20, 1880, 980);
        addSquare(playerClassPickerPanel, Color.lightGray, 10, 10, 1900, 1000);
        return playerClassPickerPanel;
    }
    
    
    
    // creates an initial empty jPanel for gameMenu
    // which we will later update with a updateGameMenuPanel void
    // we do this because initially player is null
    // meaning there is nothing to display on scrren
    // and since we have already added gameMenuPanel to our cardLayout
    // we will need to update the gameMenuPanel anyways
    private JPanel GameMenuPanel(){
        gameMenuPanel = new JPanel(null);
        gameMenuPanel.setBackground(Color.gray);
        return gameMenuPanel;
    }
    private void updateGameMenuPanel() {
        
        // create a new gameLoop with players parameters
        gameLoop = new GameLoop(player, 1, 1);
        
        
        // genereates random path and section
        int pathAmounts = gameLoop.getRandomPaths();
        int sections = gameLoop.getSections();
        
        // removes anything left in gameMenuPanel
        gameMenuPanel.removeAll();

        // check if player exits
        if (player != null) {
            // increases section everytime player returns to gamemenu
            currentSection++;
            PlayerStats(gameMenuPanel, player, "Player stats", 400, 570, 400, 500, 20);
            // prints player stats
            // generates encounters and adds buttons based on path amounnts
            if(currentSection <= sections){
                switch(pathAmounts){
                    case 1:
                        addTitle(gameMenuPanel, "current section" + currentSection, 800, 100, 500, 120 ,50);
                        path1 = addButtonIcon(gameMenuPanel, gameLoop.getRandomEncounterType(), 200, 250, 300, 350);
                        break;
                    case 2:
                        addTitle(gameMenuPanel, "current section" + currentSection, 800, 100, 500, 120 ,50);
                        path1 = addButtonIcon(gameMenuPanel, gameLoop.getRandomEncounterType(), 200, 250, 300, 350);
                        path2 = addButtonIcon(gameMenuPanel, gameLoop.getRandomEncounterType(), 600, 250, 300, 350);
                        break;
                    case 3:
                        addTitle(gameMenuPanel, "current section" + currentSection, 800, 100, 500, 120 ,50);
                        path1 = addButtonIcon(gameMenuPanel, gameLoop.getRandomEncounterType(), 200, 250, 300, 350);
                        path2 = addButtonIcon(gameMenuPanel, gameLoop.getRandomEncounterType(), 600, 250, 300, 350);
                        path3 = addButtonIcon(gameMenuPanel, gameLoop.getRandomEncounterType(), 1000, 250, 300, 350);
                        break;
                    case 4:
                        addTitle(gameMenuPanel, "4", 800, 100, 500, 120 ,50);
                        break;
                    case 5:
                        addTitle(gameMenuPanel, "5", 800, 100, 500, 120 ,50);
                        break;
                    case 6:
                        addTitle(gameMenuPanel, "6", 800, 100, 500, 120 ,50);
                        break;
                }
            }else{
                // displays you win
                addTitle(gameMenuPanel, "YOU WIN", 800, 100, 500, 120 ,50);
                backToMenu = addButton(gameMenuPanel, "BackToMenu", 960, 250, 300, 350, 20);
            }

        }

        // creates outer edges for screen
        addSquare(gameMenuPanel, Color.lightGray, 30, 690, 1860, 300);
        addSquare(gameMenuPanel, Color.gray, 20, 20, 1880, 980);
        addSquare(gameMenuPanel, Color.lightGray, 10, 10, 1900, 1000);

        gameMenuPanel.revalidate();
        gameMenuPanel.repaint();
    }
    
    
    // empty Jpanel  shopPanel
    private JPanel ShopPanel(){
        shopPanel = new JPanel(null);
        shopPanel.setBackground(Color.gray);
        return shopPanel;
    }
    //updates game panel
    private void updateShopPanel(){
        shopPanel.removeAll();
        shopPanel.setBackground(Color.gray);
    
        // if player exits add buttons to screen
        if(player != null){
            addButtonIcon(shopPanel, "./resources/AttackBuff.png", 200, 250, 300, 350);
            addButtonIcon(shopPanel, "./resources/DefenseBuff.png", 600, 250, 300, 350);
            addButton(shopPanel, "LEAVE", 1000, 250, 300, 350, 20);
            // adds leave button
            // prints player stats
            playerStatLabel = PlayerStats(shopPanel, player, "Player stats", 400, 570, 400, 500, 20);
        }
        
        // creates outer edges for screen
        addSquare(shopPanel, Color.lightGray, 30, 690, 1860, 300);
        addSquare(shopPanel, Color.gray, 20, 20, 1880, 980);
        addSquare(shopPanel, Color.lightGray, 10, 10, 1900, 1000);
        
        shopPanel.revalidate();
        shopPanel.repaint();
    }
    
    
    // empty Jpanel treasurePanel
    private JPanel TreassurePanel(){
        treasurePanel = new JPanel(null);
        treasurePanel.setBackground(Color.gray);
        return treasurePanel;
    }
    // updates treasurePanel
    private void updateTreasurePanel(){
        treasurePanel.removeAll();
        treasurePanel.setBackground(Color.gray);
    
        // if player != null
        // generate a random amount of money to be added to player
        // money
        if(player != null){
            Random random = new Random();
            int amount = random.nextInt(10) + 1;
            // method for adding money
            player.addMoney(amount);
            // gives feedback based on how much money you have recieved
            if (amount == 1) {
                addTitle(treasurePanel, "You gained 1 Coin!", 800, 150, 500, 120 ,50);
            } 
            else {
                addTitle(treasurePanel, "You gained " + amount + "coins!", 800, 150, 500, 120 ,50);
            }

            addImageIcon(treasurePanel, "./resources/Treasure.png", 200, 250, 300, 350);
            addButton(treasurePanel, "LEAVE", 1000, 250, 300, 350, 20);
            // adds leave button
            // prints player stats
            playerStatLabel = PlayerStats(treasurePanel, player, "Player stats", 400, 570, 400, 500, 20);
        }
        
        // creates outer edges for screen
        addSquare(treasurePanel, Color.lightGray, 30, 690, 1860, 300);
        addSquare(treasurePanel, Color.gray, 20, 20, 1880, 980);
        addSquare(treasurePanel, Color.lightGray, 10, 10, 1900, 1000);

        treasurePanel.revalidate();
        treasurePanel.repaint();
        
    }
    
    
    // empty Jpanel restAtCampPanel
    private JPanel restAtCampPanel(){
        restAtCampPanel = new JPanel(null);
        restAtCampPanel.setBackground(Color.gray);
        return restAtCampPanel;
    }
    // updates restAtCampPanel
    private void updateRestAtCampPanel(){
        restAtCampPanel.removeAll();
        restAtCampPanel.setBackground(Color.gray);
    
        // if player is not null
        if(player != null){
            //generate random number to heal the player by
            Random random = new Random();
            int amount = random.nextInt(5) + 6;
            // heal playre method
            player.heal(amount);
            // generates text for feedback
            if(player.getHp() == player.getMaxHp()){
                addTitle(restAtCampPanel, "You are full HP but you rested at camp anyways ", 800, 150, 5000, 120 ,30);
            }else{
                addTitle(restAtCampPanel, "You rested at camp and healed for " + amount, 800, 150, 500, 120 ,30);
            }
            addImageIcon(restAtCampPanel, "./resources/Camp.png", 200, 250, 300, 350);
            addButton(restAtCampPanel, "LEAVE", 1000, 250, 300, 350, 20);
            // adds leave button
            // prints player stats
            playerStatLabel = PlayerStats(restAtCampPanel, player, "Player stats", 400, 570, 400, 500, 20);
        }
        
        // creates outer edges for screen
        addSquare(restAtCampPanel, Color.lightGray, 30, 690, 1860, 300);
        addSquare(restAtCampPanel, Color.gray, 20, 20, 1880, 980);
        addSquare(restAtCampPanel, Color.lightGray, 10, 10, 1900, 1000);
        
        restAtCampPanel.revalidate();
        restAtCampPanel.repaint();
    }
    
    
    
    // empty Jpanel wanderingHealerPanel
    private JPanel wanderingHealerPanel(){
        healerPanel = new JPanel(null);
        healerPanel.setBackground(Color.gray);
        return healerPanel;
    }
    // updates wanderingHealerPanel
    private void updatewanderingHealerPanel(){
        healerPanel.removeAll();
        healerPanel.setBackground(Color.gray);
    
        // if player is not null
        if(player != null){
            // generates a random chance to be heal for free if conditions are met
            Random random = new Random();
            if (random.nextInt(100) < 20 && player.getMaxHp() > (player.getHp() * 0.2)) {
                player.heal(10);
                addTitle(healerPanel, "You got mercey healed for free! ", 800, 150, 5000, 120 ,30);
            }
            // add buttons for healing for money
            addButtonIcon(healerPanel, "./resources/Heal10.png", 200, 250, 300, 350);
            addButtonIcon(healerPanel, "./resources/Heal5.png", 600, 250, 300, 350);
            addButton(healerPanel, "LEAVE", 1000, 250, 300, 350, 20);
            // adds leave button
            // prints player stats
            playerStatLabel = PlayerStats(healerPanel, player, "Player stats", 400, 570, 400, 500, 20);
        }
        
        // creates outer edges for screen
        addSquare(healerPanel, Color.lightGray, 30, 690, 1860, 300);
        addSquare(healerPanel, Color.gray, 20, 20, 1880, 980);
        addSquare(healerPanel, Color.lightGray, 10, 10, 1900, 1000);
        
        healerPanel.revalidate();
        healerPanel.repaint();
    }
    
    
    // empty Jpanel enemiesPanel
    private JPanel enemiesPanel(){
        enemiePanel = new JPanel(null);
        enemiePanel.setBackground(Color.gray);
        return enemiePanel;
    }
    // updates enemiesPanel
    private void updateEnemiePanel(){
        enemiePanel.removeAll();
        enemiePanel.setBackground(Color.gray);

        // if player is not null
        if(player != null){
            //creates images for enemy and player
            addImageIcon(enemiePanel, gameLoop.spawnEnemyForGUI(), 1300, 250, 300, 350);
            addImageIcon(enemiePanel, playerCurrentClass, 200, 250, 300, 350);
            
            // prints enemy and player stats
            playerStatLabel = PlayerStats(enemiePanel, player, "Player stats", 400, 570, 400, 500, 20);
            enemyStatLabel = EnemyStats(enemiePanel, 1400, 200, 400, 40, 20);
            
            // adds attack buttons for character
            addAttackButtonsCharacter(enemiePanel, 1200, 800, 500, 45, 15);
            
            // buttons and lables for victory
            wonTitleLabel = addTitle(enemiePanel, "YOU WON!", 800, 100, 500, 120, 50);
            wonTitleLabel.setVisible(false);
            leaveButton = addButton(enemiePanel, "LEAVE", 960, 250, 300, 350, 20);
            leaveButton.setVisible(false);
            
            // buttons and lables for defeat
            lostTitleLabel = addTitle(enemiePanel, "YOU DIED!", 800, 100, 500, 120, 50);
            lostTitleLabel.setVisible(false);
            backToMenu = addButton(enemiePanel, "BackToMenu", 960, 250, 300, 350, 20);
            backToMenu.setVisible(false);
            
        }
        
        
        // creates outer edges for screen
        addSquare(enemiePanel, Color.lightGray, 30, 690, 1860, 300);
        addSquare(enemiePanel, Color.gray, 20, 20, 1880, 980);
        addSquare(enemiePanel, Color.lightGray, 10, 10, 1900, 1000);
        
        enemiePanel.revalidate();
        enemiePanel.repaint();
    }

    
    // method for creating the initial player stats
    private JLabel startingPlayerStats(JPanel panel, String text, int maxHp, int attack, int speed, int defense,
            int x, int y, int w, int l, int s){  
        String startingPlayerStat = "<html>" +//html tags for formatting
                            text + "<br>" +
                            "<br>" +
                            "Max Hp: " + maxHp + "<br>" +
                            "<br>" +
                            "Attack: " + attack + "<br>" +
                            "<br>" +
                            "Defense: " + defense + "<br>" +
                            "<br>" +
                            "Speed: " + speed + "<br>";

        JLabel startingPlayerStats = new JLabel(startingPlayerStat);
        startingPlayerStats.setFont(new Font("Arial", Font.ITALIC, s));// sets fonts
        startingPlayerStats.setBounds(x, y, w, l);// sets location and size 
        panel.add(startingPlayerStats);
        return startingPlayerStats;// adds and returns player stats
    }
    

    private JLabel[] PlayerStats(JPanel panel, PlayerStats player, String text,
            int x, int y, int w, int l, int s){  
        String PlayerStat = "<html>" +//html tags for formatting
                            player.getPlayerName()+ " The " + player.getCharacterName() + "<br>" +
                            "<br>" +
                            "Hp: " + player.getMaxHp() +"/"+player.getHp()+ "<br>" +
                            "<br>" +
                            "Attack: " + player.getAttack() + "<br>" +
                            "<br>" +
                            "Defense: " + player.getDefense() + "<br>" +
                            "<br>";
        
        String PlayerStat2 = "<html>" +
                            "Current Level: " + player.getXp() + "<br>" +
                            "<br>" +
                            "Required Xp for next level: " + player.getXpRequiredForNextLevel() + "<br>" +
                            "<br>" +
                            "Money: " + player.getMoney();

        JLabel PlayerStats = new JLabel(PlayerStat);
        JLabel PlayerStats2 = new JLabel(PlayerStat2);
        PlayerStats.setFont(new Font("Arial", Font.ITALIC, s));// sets fonts
        PlayerStats2.setFont(new Font("Arial", Font.ITALIC, s));// sets fonts
        PlayerStats.setBounds(x, y, w, l);// sets location and size
        PlayerStats2.setBounds((x +150), y, w, l);// sets location and size
        panel.add(PlayerStats);
        panel.add(PlayerStats2);
        return new JLabel[]{PlayerStats, PlayerStats2};// adds stats to array
    }
    
    //updates the player stats arrays
    private void updatePlayerStats() {
        if (playerStatLabel != null) {
            String PlayerStat = "<html>" +
                                player.getPlayerName() + " The " + player.getCharacterName() + "<br>" +
                                "<br>" +
                                "Hp: " + player.getMaxHp() + "/" + player.getHp() + "<br>" +
                                "<br>" +
                                "Attack: " + player.getAttack() + "<br>" +
                                "<br>" +
                                "Defense: " + player.getDefense() + "<br>" +
                                "<br>";

            String PlayerStat2 = "<html>" +
                                "Current Level: " + player.getXp() + "<br>" +
                                "<br>" +
                                "Required Xp for next level: " + player.getXpRequiredForNextLevel() + "<br>" +
                                "<br>" +
                                "Money: " + player.getMoney();

            playerStatLabel[0].setText(PlayerStat);
            playerStatLabel[1].setText(PlayerStat2);// updates playerStatsLabel array
        }
    }
    
    // method for creating the initial EnemyStats
    private JLabel[] EnemyStats(JPanel panel,
            int x, int y, int w, int l, int s){  
        String EnemyStat = "<html>" +
                            gameLoop.currentEnemy.getName() + "<br>" +
                            "Hp: " + gameLoop.currentEnemy.getMaxHp() +"/"+ gameLoop.currentEnemy.getHp() + "<br>";

        JLabel EnemyStats = new JLabel(EnemyStat);
        EnemyStats.setFont(new Font("Arial", Font.ITALIC, s));// sets fonts
        EnemyStats.setBounds(x, y, w, l);// sets location and size 
        panel.add(EnemyStats);
        return new JLabel[]{EnemyStats};// adds and returns EnemyStats
    }
    // updates EnemyStats
    private void updateEnemyStats() {
        if (enemyStatLabel != null) {
            String EnemyStat = "<html>" +
                            gameLoop.currentEnemy.getName() + "<br>" +
                            "Hp: " + gameLoop.currentEnemy.getMaxHp() +"/"+ gameLoop.currentEnemy.getHp() + "<br>";
            enemyStatLabel[0].setText(EnemyStat); // updates enemyStatLabel array
        }
    }

    
    
    private void addAttackButtonsCharacter(JPanel panel, int x, int y, int w, int l, int s) {
        // switch case to generate attack buttons based on players class
        // each variable uses the addButton Method to create a button with unique parameters for each attack
        // we later asign these variables to Strings to be used in the action actionPerformed method
        // we did this so we didnt have to create seperate Strings to be used in the actionPerformed method
        // for each seperate attack of the classes
        switch(player.getCharacterName()) {
            case "Knight":
                attack1 = addButton(panel, "<html>Slash (Damage: " + player.getMinDamage(0) +
                        "-" + player.getMaxDamage(0,4) + ")<br>(Bits Cost: 50)</html>", 
                        x, y, w, l, s);
                attack2 = addButton(panel, "<html>Shield Bash (Damage: " + player.getMinDamage(2) +
                        "-" + player.getMaxDamage(2,6) + ")<br>(Bits Cost: 65, Delay Enemy by 30 Bits)</html>", 
                        x, y + 50, w, l, s);
                attack3 = addButton(panel, "<html>Holy Strike (Damage: " + player.getMinDamage(4) +
                        "-" + player.getMaxDamage(4,8) + ")<br>(Bits Cost: 125)</html>", 
                        x, y + 100, w, l, s);
                break;
            case "Archer":
                attack1 = addButton(panel, "<html>Quick Shot (Damage: " + player.getMinDamage(2) +
                        "-" + player.getMaxDamage(2,4) + ")<br>(Bits Cost: 35)</html>", 
                        x, y, w, l, s);
                attack2 = addButton(panel, "<html>Aimed Shot (Damage: " + player.getMinDamage(6) +
                        "-" + player.getMaxDamage(6,6) + ")<br>(Bits Cost: 75)</html>", 
                        x, y + 50, w, l, s);
                attack3 = addButton(panel, "<html>Multi-Shot (Damage each Arrow: " + player.getMinDamage(0) +
                        "-" + player.getMaxDamage(0,3) + ", 2-5 Arrows)<br>(Bits Cost for Each Arrow Shot: 30)</html>", 
                        x, y + 100, w, l, s);
                break;
            case "Mage":
                attack1 = addButton(panel, "<html>Fireball (Damage: " + player.getMinDamage(10) +
                        "-" + player.getMaxDamage(10,4) + ")<br>(Bits Cost: 40, Burn Damage on next Turn)</html>", 
                        x, y, w, l, s);
                attack2 = addButton(panel, "<html>Frostbolt (Damage: " + player.getMinDamage(0) +
                        "-" + player.getMaxDamage(0,4) + ")<br>(Bits Cost: 70, Enemy's speed reduced by 5 till their next turn)</html>", 
                        x, y + 50, w, l, s);
                attack3 = addButton(panel, "<html>Arcane Blast (Damage: " + player.getMinDamage(12) +
                        "-" + player.getMaxDamage(12,8) + ")<br>(Bits Cost: 150, Enemy is blown back by 50 Bits)</html>", 
                        x, y + 100, w, l, s);
                break;
            case "Rogue":
                attack1 = addButton(panel, "<html>Backstab (Damage on Crit, Successful, Failed Stabs: " +
                        player.getMinDamage(17) + "-" + player.getMaxDamage(17,5) + ", " + player.getMinDamage(7) +
                        "-" + player.getMaxDamage(7,5) + ", " + player.getMinDamage(0) + "-" + player.getMaxDamage(0,1) +
                        ")<br>(Bits Cost: 80)</html>", 
                        x, y, w, l, s);
                attack2 = addButton(panel, "<html>Poison Strike (Damage: " + player.getMinDamage(5) +
                        "-" + player.getMaxDamage(5,6) + ")<br>(Bits Cost: 100)</html>", 
                        x, y + 50, w, l, s);
                attack3 = addButton(panel, "<html>Swift Strike (Damage: " + player.getMinDamage(0) +
                        "-" + player.getMaxDamage(0,3) + ")<br>(Bits Cost: 35)</html>", 
                        x, y + 100, w, l, s);
                break;
        }
        attack1.setActionCommand("Attack1");// adds a string to be assicated with button
        attack2.setActionCommand("Attack2");
        attack3.setActionCommand("Attack3");
    }

    private JPanel addSquare(JPanel panel, Color colour, int x, int y, int w, int l){
        JPanel square = new JPanel();// create new JPanel square
        square.setBackground(colour);// sets colour
        square.setBounds(x, y, w, l);// sets location
        panel.add(square);
        return square;// adds and return square
    }
    
    private JLabel addTitle(JPanel panel, String text, int x, int y, int w, int l, int s){
        JLabel title = new JLabel(text);// adds title
        title.setFont(new Font("Arial", Font.ITALIC, s));// sets font
        title.setBounds(x, y, w, l);// sets size and location
        panel.add(title);
        return title;// adds and return title
    }
    
    private JButton addButton(JPanel panel, String text, int x, int y, int w, int l, int s){
        JButton button = new JButton(text);// creates new Jbuttons and loads text to button
        button.setFont(new Font("Arial", Font.ITALIC,s));// sets font
        button.setBounds(x, y, w, l);// sets location
        button.addActionListener(this);// add ActionListener to button
        panel.add(button);
        return button;// adds and return button
    }
    
    private void addTextField(JPanel panel, String text, int x, int y, int w, int l){
        textField = new JTextField(text, 30);// adds text and text size
        textField.setBounds(x, y, w, l);// sets location and size of text bubble
        panel.add(textField);// adds text field
    }
    
    private JButton addButtonIcon(JPanel panel, String path, int x, int y, int w, int l){
        ImageIcon icon = new ImageIcon(path);// adds image into an icon
        JButton button = new JButton(icon);// adds icon into the button
        button.setBounds(x, y, w, l);// sets location
        button.setActionCommand(path);// sets the String to that is used in the actionPerformed to be the location of the image
        button.addActionListener(this);// add ActionListener to button
        panel.add(button);
        return button;// adds and return button
    }
    
    private ImageIcon addImageIcon(JPanel panel, String path, int x, int y, int w, int l){
        ImageIcon icon = new ImageIcon(path);// loads image into an ImageIcon
        JLabel label = new JLabel(icon);// loads imageIcon into a JLabel
        label.setBounds(x, y, w, l);// sets bounds
        panel.add(label);// adds label
        return icon;// returns icon
    }

    private void displayGif(boolean x) {
        gif = new JLabel(new ImageIcon("./resources/polish-cow-icegif.gif"));// loads gif
        gif.setBounds(100, 100, 300, 300);// sets bound
        gif.setVisible(x);// for setting visiblity
        add(gif);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();// gets the String associated with the button
        switch(event){// activates event based on what button is clicked
            case "Begin your Adventure":
                cardLayout.show(cardPanel, "GetPlayerName");//switches panel using cardLayout
                gif.setVisible(false);// sets gifs to false
                break;     
            case "How To Play":
                gif.setVisible(true);// sets gif to true
                break;
            case "Settings":
                gif.setVisible(false);// sets gifs to false
                break;
            case "Achievements":
                break;
            case "Credits":
                break;
            case "Exit Game":
                break;
            case "Confirm":
                playerName = textField.getText();// sets playerName to the value given by textField
                cardLayout.show(cardPanel, "GetPlayerClass");// switches panel to the player selection panel
                break;
                
                // each button represents a class the player can select
                // once selected it will create a new class with the
                // respective class and load in the playerName
                // then it will switch the panel to the GameMenu
            case "./resources/Knight.png":
                playerCurrentClass = "./resources/Knight.png";
                player = new Knight(playerName);
                Text.printPlayerStats(player);
                updateGameMenuPanel();
                cardLayout.show(cardPanel, "GameMenu");
                break;
            case "./resources/Mage.png":
                playerCurrentClass = "./resources/Mage.png";
                player = new Mage(playerName);
                Text.printPlayerStats(player);
                updateGameMenuPanel();
                cardLayout.show(cardPanel, "GameMenu");
                break;
            case "./resources/Rogue.png":
                playerCurrentClass = "./resources/Rogue.png";
                player = new Rogue(playerName);
                Text.printPlayerStats(player);
                updateGameMenuPanel();
                cardLayout.show(cardPanel, "GameMenu");
                break;
            case "./resources/Archer.png":
                playerCurrentClass = "./resources/Archer.png";
                player = new Archer(playerName);
                Text.printPlayerStats(player);
                updateGameMenuPanel();
                cardLayout.show(cardPanel, "GameMenu");
                break;
                ///////
                
                
                // each arrow key is used to cycle throught
                // each class by setting the current class on
                // screen to false and the next one to true
            case "==>":
                switch(num){
                    case 1:
                        KnightButton.setVisible(false);
                        KnightTitle.setVisible(false);
                        StartKnightStats.setVisible(false);
                        
                        MageButton.setVisible(true);
                        MageTitle.setVisible(true);
                        StartMageStats.setVisible(true);
                        num = 2;
                        break;
                    case 2:
                        MageButton.setVisible(false);
                        MageTitle.setVisible(false);
                        StartMageStats.setVisible(false);
                        
                        RogueButton.setVisible(true);
                        RogueTitle.setVisible(true);
                        StartRogueStats.setVisible(true);
                        num = 3;
                        break;
                    case 3:
                        RogueButton.setVisible(false);
                        RogueTitle.setVisible(false);
                        StartRogueStats.setVisible(false);
                        
                        ArcherButton.setVisible(true);
                        ArcherTitle.setVisible(true);
                        StartArcherStats.setVisible(true);
                        num = 4;
                        break;
                    } 
                break;
            case "<==":
                switch(num){
                    case 2:
                        KnightButton.setVisible(true);
                        KnightTitle.setVisible(true);
                        StartKnightStats.setVisible(true);
                        
                        MageButton.setVisible(false);
                        MageTitle.setVisible(false);
                        StartMageStats.setVisible(false);
                        
                        num = 1;
                        break;
                    case 3:
                        MageButton.setVisible(true);
                        MageTitle.setVisible(true);
                        StartMageStats.setVisible(true);
                        
                        RogueButton.setVisible(false);
                        RogueTitle.setVisible(false);
                        StartRogueStats.setVisible(false);
                        
                        num = 2;
                        break;
                    case 4:
                        RogueButton.setVisible(true);
                        RogueTitle.setVisible(true);
                        StartRogueStats.setVisible(true);
                        
                        ArcherButton.setVisible(false);
                        ArcherTitle.setVisible(false);
                        StartArcherStats.setVisible(false);
                        
                        num = 3;
                        break;
                    }
                break;
                ////////////
                
            // each button represents an encounter type
            // when click it will switch to the
            // respective panel
            case "./resources/Enemy.png":
                updateEnemiePanel();
                cardLayout.show(cardPanel, "EnemiesPanel");
                break;
            case "./resources/Treasure.png":
                updateTreasurePanel();
                cardLayout.show(cardPanel, "TreasurePanel");
                break;
            case "./resources/Camp.png":
                updateRestAtCampPanel();
                cardLayout.show(cardPanel, "CampPanel");
                break;
            case "./resources/WanderingHealer.png":
                updatewanderingHealerPanel();
                cardLayout.show(cardPanel, "HealerPanel");
                break;
            case "./resources/Statue.png":
                break;
            case "./resources/Store.png":
                updateShopPanel();
                cardLayout.show(cardPanel, "ShopPanel");
                System.out.println("Store");
                break;
            //////   
                
            
                
             
                /// buttons used for the shop
            case "./resources/AttackBuff.png":
                if(player.getMoney() >= 5){
                    player.addMoney(-5);// removes money
                    player.increaseAttack(5);// adds to attack
                    updatePlayerStats();// updates player stats
                }
                else{
                    System.out.println("TOO POOR");
                }
                break;
            case "./resources/DefenseBuff.png":
                if(player.getMoney() >= 5){
                    player.addMoney(-5);// removes money
                    player.increaseDefense(5);// adds to defense
                    updatePlayerStats();// updates player stats
                }
                else{
                    System.out.println("TOO POOR");
                }
                break;
                case "LEAVE":// returns to gameMenu
                    updateGameMenuPanel();
                    cardLayout.show(cardPanel, "GameMenu");
                break;
                /////
                
                
                //// buttons used for the wondering healer
            case "./resources/Heal10.png":
                if (player.getMoney() >= 5 && player.getHp() < player.getMaxHp()) {
                        player.heal(10);// heals for 10
                        player.removeMoney(5);// deducts money
                        updatePlayerStats();// updates stats
                    } 
                break;
            case "./resources/Heal5.png":
                if (player.getMoney() >= 2 && player.getHp() < player.getMaxHp()) {
                        player.heal(5);// heals for 5
                        player.removeMoney(2);// deducts money
                        updatePlayerStats();// updates stats
                    } 
                break;
                ////////
                
                
            // buttons used for players attack.
            // all 3 attack buttons work the same
            case "Attack1":
                switch(player.getCharacterName()){// switch case to get the corrisponding class
                    case "Knight":
                        ((Knight) player).performSlashAttack();// calls the attack 1 of the class
                        break;
                    case "Archer":
                        ((Archer) player).performQuickShot();
                        break;
                    case "Mage":
                        ((Mage) player).performFireball();
                        break;
                    case "Rogue":
                        ((Rogue) player).performBackstab();
                        break;
                }
                if(gameLoop.currentEnemy.getHp() >= 0){
                            gameLoop.enemyAttack();//after the player attacks if the enemy is still alive they will perform an attack
                        }
                updatePlayerStats();//update player stats
                updateEnemyStats();//updates enemy stats
                break;
            case "Attack2":
                switch(player.getCharacterName()){
                    case "Knight":
                        ((Knight) player).performShieldBash();
                        break;
                    case "Archer":
                        ((Archer) player).performAimedShot();
                        break;
                    case "Mage":
                        ((Mage) player).performFrostbolt();
                        break;
                    case "Rogue":
                        ((Rogue) player).performPoisonStrike();
                        break;
                }
                if(gameLoop.currentEnemy.getHp() >= 0){
                            gameLoop.enemyAttack();
                        }
                updatePlayerStats();
                updateEnemyStats();
                break;
            case "Attack3":
                switch(player.getCharacterName()){
                    case "Knight":
                        ((Knight) player).performHolyStrike();
                        break;
                    case "Archer":
                        ((Archer) player).performMultiShot();
                        break;
                    case "Mage":
                        ((Mage) player).performArcaneBlast();
                        break;
                    case "Rogue":
                        ((Rogue) player).performSwiftStrike();
                        break;
                }
                if(gameLoop.currentEnemy.getHp() >= 0){
                            gameLoop.enemyAttack();
                        }
                updatePlayerStats();
                updateEnemyStats();
                break;
                
                
            //button to return to menu    
            case "BackToMenu":
                currentSection = 0;
                cardLayout.show(cardPanel, "MainMenu");
                break;
        }
        
        // currentEnemy is dead
        if (gameLoop.currentEnemy.getHp() <= 0) {
            wonTitleLabel.setVisible(true);// set win title to true
            leaveButton.setVisible(true);// set win leave button to true
            attack1.setVisible(false); // set attack buttons to false as they no longer need to attack
            attack2.setVisible(false);
            attack3.setVisible(false);
            Random random = new Random();// generates random values for Xp and coins to be added to player
            player.addXP(random.nextInt(gameLoop.currentEnemy.getXpDropRange())+gameLoop.currentEnemy.getXpDropRangeMin());
            player.addMoney(random.nextInt(gameLoop.currentEnemy.getCoinDropRange())+gameLoop.currentEnemy.getCoinDropRangeMin());
            
        }else if(player.getHp() <= 0){// if player dies
            lostTitleLabel.setVisible(true);// sets lost title to false
            backToMenu.setVisible(true);// allow player to return back to menu
            attack1.setVisible(false);// set attack buttons to false as they no longer need to attack
            attack2.setVisible(false);
            attack3.setVisible(false);
            currentSection = 0;// reset current section
        }
    }
    
    public static void main(String[] args){
        MainMenuFrame frame = new MainMenuFrame();
        frame.setVisible(true);
    }

}
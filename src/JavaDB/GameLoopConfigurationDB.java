/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaDB;

/**
 *
 * @Author David
 * @Edited by David
 * @FocusedOn by David
 * @Status Commented and Finished
 */

import GameText.Format;
import GameText.Text;
import Main.Mechanics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.InputMismatchException;


public class GameLoopConfigurationDB {
    
    // Apache Derby JDBC URL
    private static final String DB_URL = "jdbc:derby:GameInfoDB;create=true";
    private static final String TABLE_NAME = "GameLoopConfig";
    private static final int DEFAULT_SECTION_AMOUNT = 6;
    private static final int DEFAULT_PATH_AMOUNT = 3;
    
    public GameLoopConfigurationDB() {
        createConfigTable();
        initializeDefaultConfig();
    }
    
    public void editGameLoopPrompt() {
        Format.ClearScreen();
        System.out.println(Text.editGameLoopPrint());
        int input = Mechanics.readInt("Enter Choice", 2, Text.editGameLoopPrint());

        switch (input) {
            case 1:
                editSectionAmount();
                break;
            case 2:
                editPathAmount();
                break;
        }
    }

    private void createConfigTable() {
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " ("
                + "config_key VARCHAR(255) PRIMARY KEY, "
                + "config_value INT)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Apache Derby SQL state code for "table already exists"
            if (!e.getSQLState().equals("X0Y32")) {
                System.err.println("Error creating config table: " + e.getMessage());
            }
        }
    }

    private void initializeDefaultConfig() {
        if (getConfig("Section Amount") == -1) {
            setConfig("Section Amount", DEFAULT_SECTION_AMOUNT);
        }
        if (getConfig("Path Amount") == -1) {
            setConfig("Path Amount", DEFAULT_PATH_AMOUNT);
        }
    }


    private void setConfig(String key, int value) {
        if (getConfig(key) == -1) {
            String insertSQL = "INSERT INTO " + TABLE_NAME + " (config_key, config_value) VALUES (?, ?)";
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                stmt.setString(1, key);
                stmt.setInt(2, value);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error setting config: " + e.getMessage());
            }
        } else {
            updateConfig(key, value);
        }
    }

    private void updateConfig(String key, int value) {
        String updateSQL = "UPDATE " + TABLE_NAME + " SET config_value = ? WHERE config_key = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(updateSQL)) {
            stmt.setInt(1, value);
            stmt.setString(2, key);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating config: " + e.getMessage());
        }
    }

    public int getConfig(String key) {
        String query = "SELECT config_value FROM " + TABLE_NAME + " WHERE config_key = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("config_value");
            }
        } catch (SQLException e) {
            System.err.println("Error getting config: " + e.getMessage());
        }
        return -1;
    }

    public int[] readConfigAmounts() {
        int[] data = new int[2];
        data[0] = getConfig("Section Amount");
        data[1] = getConfig("Path Amount");
        return data;
    }

    public void editSectionAmount() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                Format.ClearScreen();
                int currentSectionAmount = getConfig("Section Amount");
                System.out.println("========== Settings ==========");
                System.out.println("Current Section Amount: " + currentSectionAmount);
                System.out.println(Text.settingsSectionAmountPrint());
                int newSectionAmount = scanner.nextInt();

                if (newSectionAmount > 0) {
                    updateConfig("Section Amount", newSectionAmount);
                    System.out.println(Text.settingsSectionAmountUpdatePrint());
                    Mechanics.unpause();
                    validInput = true;
                } else {
                    Format.ClearScreen();
                    System.out.println(Text.settingsInvalidPrint());
                }
            } catch (InputMismatchException e) {
                Format.ClearScreen();
                System.out.println(Text.settingsInvalidPrint());
                scanner.next(); // Clear the invalid input from the scanner
            }
        } while (!validInput);
    }


    public void editPathAmount() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                Format.ClearScreen();
                int currentPathAmount = getConfig("Path Amount");
                System.out.println("========== Settings ==========");
                System.out.println("Current Path Amount: " + currentPathAmount);
                System.out.println(Text.settingsPathAmountPrint());
                int newAmount = scanner.nextInt();

                if (newAmount > 0) {
                    updateConfig("Path Amount", newAmount);
                    System.out.println(Text.settingsPathAmountUpdatePrint());
                    Mechanics.unpause();
                    validInput = true;
                } else {
                    Format.ClearScreen();
                    System.out.println(Text.settingsInvalidPrint());
                }
            } catch (InputMismatchException e) {
                Format.ClearScreen();
                System.out.println(Text.settingsInvalidPrint());
                scanner.next(); // Clear the invalid input from the scanner
            }
        } while (!validInput);
    }

}


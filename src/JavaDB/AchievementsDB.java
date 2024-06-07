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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AchievementsDB {
    
    // Apache Derby JDBC URL
    private static final String DB_URL = "jdbc:derby:GameInfoDB;create=true";
    private static final String TABLE_NAME = "Achievements";
    
    public AchievementsDB() {
        createAchievementsTable();
    }
    
    private void createAchievementsTable() {
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " ("
                + "achievement VARCHAR(255) PRIMARY KEY)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Apache Derby SQL state code for "table already exists"
            if (!e.getSQLState().equals("X0Y32")) {
                System.err.println("Error creating achievements table: " + e.getMessage());
            }
        }
    }

    public boolean isAchievementAlreadyExists(String achievement) {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE achievement = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, achievement.trim());
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error checking achievement: " + e.getMessage());
        }
        return false;
    }

    public void addAchievement(String achievement) {
        if (isAchievementAlreadyExists(achievement)) return;
        
        String insertSQL = "INSERT INTO " + TABLE_NAME + " (achievement) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
            stmt.setString(1, achievement.trim());
            stmt.executeUpdate();
            System.out.println("Achievement unlocked: " + achievement);
        } catch (SQLException e) {
            System.err.println("Error adding achievement: " + e.getMessage());
        }
    }

    public void deleteAllAchievements() {
        String deleteSQL = "DELETE FROM " + TABLE_NAME;
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(deleteSQL)) {
            stmt.executeUpdate();
            System.out.println("All achievements reset successfully.");
        } catch (SQLException e) {
            System.err.println("Error resetting achievements: " + e.getMessage());
        }
    }

    public String displayAllAchievements() {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT achievement FROM " + TABLE_NAME;
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                sb.append(rs.getString("achievement")).append("\n");
            }
        } catch (SQLException e) {
            System.err.println("Error displaying achievements: " + e.getMessage());
        }
        return sb.toString();
    }

    // -- Achievement Methods to be called --

    public void areaCompletion(int areaNumber) {
        addAchievement("Achievement: Area " + areaNumber + " Completed");
    }

    public void gameCompletion(String characterName) {
        addAchievement("Achievement: Full Game Completed");
        addAchievement("Achievement: Full Game Completed as " + characterName);
    }

    public void greedyPunishment() {
        addAchievement("Achievement: Greedy Punishment");
    }

    public void naughtyNaughty() {
        addAchievement("Achievement: Naughty Naughty");
    }

    public void theDevilsAnger() {
        addAchievement("Achievement: The Devils Anger");
    }

    public void stealingFromTheDevil() {
        addAchievement("Achievement: Stealing From the Devil");
    }

    public void heavilyCursedToDeath() {
        addAchievement("Achievement: Heavily Cursed to Death");
    }

    public void compassionateHealer() {
        addAchievement("Achievement: Compassionate Healer");
    }

    public void charity() {
        addAchievement("Achievement: Charity");
    }

    public void theFool() {
        addAchievement("Achievement: The Fool");
    }
}


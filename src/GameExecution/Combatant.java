/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameExecution;

/**
 *
 * @Author David
 * @Edited by David
 * @FocusedOn by David
 * @Status Commented and Finished
 */
public interface Combatant {
    void takeDamage(int damage);
    int getHp();//
    String getName();//This is needed to allow to get the character name
    int getCurrentTimeUnit();//This is needed to allow speed-turn-based combat
}
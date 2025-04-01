/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sf23abk
 */
public abstract class Ship implements Serializable{
    private String name;
    private int battleSkill;
    public double commissionFee;
    private ShipState state;
    public ArrayList<String> encounterType;// Array to hold the encounters ship can peform in 
    
    public Ship(String name,double commissionFee, int battleSkill) {
        this.name = name;
        this.battleSkill = battleSkill;
        this.state = ShipState.RESERVE; // Default state
        this.encounterType = new ArrayList<>();
    }
    
    // Getters and setters
    public String getName() { return name; }
    public int getBattleSkill() { return battleSkill; }
    public ShipState getState() { return state; }
    public void setState(ShipState state) { this.state = state; }
    
    // Ship-specific functionality
    public abstract String getType();
    
    public double getcommissionFee(){
         return commissionFee;
        
    }
    
    @Override
    public String toString() {
        return name + " (" + getType() + ") "  + 
               ", Battle Skill: " + battleSkill + ", State: " + state;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author sf23abk
 */
public abstract class Ship {
    private String name;
    public double commissionFee;
    private int battleSkill;
    private ShipState state;
    
    public Ship(String name, double commissionFee, int battleSkill) {
        this.name = name;
        this.commissionFee = commissionFee;
        this.battleSkill = battleSkill;
        this.state = ShipState.RESERVE; // Default state
    }
    
    // Getters and setters
    public String getName() { return name; }
    public double getCommissionFee() { return commissionFee; }
    public int getBattleSkill() { return battleSkill; }
    public ShipState getState() { return state; }
    public void setState(ShipState state) { this.state = state; }
    
    // Ship-specific functionality
    public abstract String getType();
    
    @Override
    public String toString() {
        return name + " (" + getType() + ") - Fee: " + commissionFee + 
               ", Battle Skill: " + battleSkill + ", State: " + state;
    }
}


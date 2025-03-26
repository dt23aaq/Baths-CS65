/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author SF23abk
 */
public class Encounter {
    private String location;
    private String type;
    private int skillRequired;
    private double prize;
    
    public Encounter( String type, String location, 
                     int skillRequired, double prize) {
        this.location = location;
        this.type = type;
        this.skillRequired = skillRequired;
        this.prize = prize;
    }
    
    // Getters
    
    public String getLocation() { return location; }
    public String getType() { return type; }
    public int getskillRequired() { return skillRequired; }
    public double getPrize() { return prize; }
    
    @Override
    public String toString() {
        return "Encounter #" +  ": " + location + 
               " (" + type + ") - Rating: " + skillRequired + 
               ", Prize: " + prize;
    }
}

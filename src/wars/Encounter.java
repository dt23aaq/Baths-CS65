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
    private int encounterNumber;
    private String location;
    private EncounterType type;
    private int skillRequired;
    private double prize;
    
    public Encounter(int encounterNumber, String location, EncounterType type, 
                     int skillRequired, double prize) {
        this.encounterNumber = encounterNumber;
        this.location = location;
        this.type = type;
        this.skillRequired = skillRequired;
        this.prize = prize;
    }
    
    // Getters
    public int getEncounterNumber() { return encounterNumber; }
    public String getLocation() { return location; }
    public EncounterType getType() { return type; }
    public int getskillRequired() { return skillRequired; }
    public double getPrize() { return prize; }
    
    @Override
    public String toString() {
        return "Encounter #" + encounterNumber + ": " + location + 
               " (" + type + ") - Rating: " + skillRequired + 
               ", Prize: " + prize;
    }
}

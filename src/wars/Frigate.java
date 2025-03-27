/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;



/**
 *
 * @author lekan
 */
public class Frigate extends Ship  {
    private int cannons;
    private boolean docOrPin;
    private String captain;
    
    
    public Frigate(String name, double commissionFee, int battleSkill, int cannons,String captain,boolean docOrPin){
        super(name,commissionFee, battleSkill);
        super.commissionFee = 10.0 * cannons;
        this.cannons  = cannons;
        this.docOrPin = docOrPin;
        this.captain = captain;
        
        if(this.docOrPin){super.encounterType.add("Blockade");}
        super.encounterType.add("Battle");
         super.encounterType.add("Skirmish");
         
    }
    
    @Override
    public String getType(){
        return"Frigate";
    }
   
   
    @Override
    public String toString() { return super.toString()+ "- Fee: " + super.commissionFee + ", Captain: " + captain + ", No of Cannons: " + cannons + ", Doctor Or Pinnace: " + docOrPin;}
}

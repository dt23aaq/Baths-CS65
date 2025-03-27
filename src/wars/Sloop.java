/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;



/**
 *
 * @author lekan
 */
public class Sloop extends Ship {
    private String captain;
    private boolean docOrPin;
    
    
    public Sloop(String name, double commissionFee, int battleSkill, String captain,boolean docOrPin){
        super(name,commissionFee, battleSkill);
        super.commissionFee = commissionFee;
        this.captain = captain;
        this.docOrPin = docOrPin;
        
        super.encounterType.add("Battle");
         super.encounterType.add("Skirmish");
    }
    
    @Override
    public String getType(){
        return"Sloop";
    }
   
    
    @Override
     public String toString() { return super.toString()+ "- Fee: " + super.commissionFee+ ", Captain: " + captain + ", DoctorOrPinnace: " + docOrPin;}
}

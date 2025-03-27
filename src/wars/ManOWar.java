/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;



/**
 *
 * @author lekan
 */
public class ManOWar extends Ship {
    private int deck;
    private int marines;
    private String captain;
    
    
      
    public ManOWar(String name, double commissionFee, int battleSkill,int deck,String captain, int marines){
        super(name,commissionFee,  battleSkill);
        super.commissionFee = commissionFee;
        this.deck = deck ;
        this.marines = marines;
        this.captain = captain;
         if(deck < 3){
            super.commissionFee = 300.0;
        }
        else{
            super.commissionFee = 500.0;
        }
         
         super.encounterType.add("Battle");
         super.encounterType.add("Blockade");
    
    }
    
    @Override
    public String getType(){
        return"ManOwar";
    }
 
    
    @Override
    public String toString() { return super.toString()+ "- Fee: " + super.commissionFee   + ", Captain: " + captain +", Deck: " + deck + ",  Marines: " + marines;}
   
}

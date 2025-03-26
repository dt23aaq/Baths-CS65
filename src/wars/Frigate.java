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
    public Frigate(String name, double commissionFee, int battleSkill, int cannons){
        super(name, commissionFee, battleSkill);
        this.cannons  = cannons;
        super.commissionFee = 10.0 * cannons;
      
    }
    
    @Override
    public String getType(){
        return"Frigate";
    }
}

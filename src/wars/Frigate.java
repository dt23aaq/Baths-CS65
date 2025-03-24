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
    public Frigate(String name, double commissionFee, int battleSkill){
        super(name, commissionFee, battleSkill);
        
    }
    
    @Override
    public String getType(){
        return"Frigate";
    }
}

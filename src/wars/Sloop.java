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
    public Sloop(String name, double commissionFee, int battleSkill){
        super(name, commissionFee, battleSkill);
        
    }
    
    @Override
    public String getType(){
        return"Sloop";
    }
    
}

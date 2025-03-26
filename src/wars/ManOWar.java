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
      
    public ManOWar(String name, double commissionFee, int battleSkill,int deck){
        super(name, commissionFee, battleSkill);
        this.deck = deck ;
              if(deck < 3){
         super.commissionFee = 300.0;
        }
        else{
          super.commissionFee = 500.0;
        }
    
    }
    
    @Override
    public String getType(){
        return"ManOwar";
    }
    public double getcommissionFee(){
         return commissionFee;
        
    }
   
}

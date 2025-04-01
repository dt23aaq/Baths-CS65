/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
/**
 *
 * @author lekan
 */
import java.io.*;
import java.util.ArrayList;
public class Tester  implements Serializable{
    
    public static void main(String[] args) {
        
            Ship Surprise = new Frigate("Surprise",100, 6, 10,"Fred Fox", false);
            Ship Arrow = new Sloop("Arrow",150,5,"Dan Dare",true);
            Ship Victory = new ManOWar("Victory",500,3,3,"Alan Aikin",30);
            Encounter Blockade  = new Encounter("Blockade","Brest",3,150);
            ArrayList<Ship> squadron = new ArrayList<>();
            squadron.add(Arrow);
            squadron.add(Surprise);
            squadron.add(Victory);
            
            SeaBattles lekan = new SeaBattles("lekan", "encountersAM.txt");
             lekan.commissionShip("Victory");
        lekan.commissionShip("Surprise");
        lekan.commissionShip("Arrow");
            lekan.fightEncounter(5);
//            lekan.decommissionShip("Victory");
            System.out.println(lekan.getSquadron());
        System.out.println(Surprise.encounterType.contains(Blockade.getType()));
        
//        ArrayList<Ship> bestShips = new ArrayList<>();
//        for (Ship ship: squadron){
//            if(ship.encounterType.contains("Blockade")){
//                ship.setState(ShipState.ACTIVE);
//                bestShips.add(ship);
//                
//            }
//            
//         
//        }
//        System.out.println(bestShips.toString());
//        
//        
//        
//        
//        // Find a suitable ship for the encounter
//        Ship bestShip = null;
//        for (Ship ship : bestShips) {
//            if (ship.getState() == ShipState.ACTIVE) {
//                if (bestShip == null || ship.getBattleSkill() > bestShip.getBattleSkill()) {
//                    bestShip = ship;
//                }
//            }
//        }
//        System.out.println(bestShip);  
//        
//        System.out.println(Blockade.getType());
            
        
    }
  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
/**
 *
 * @author lekan
 */
import java.util.*;
import java.io.*;
public class Tester  implements Serializable{
    
    public static void main(String[] args) {
        

            SeaBattles lekan = new SeaBattles("lekan", "encountersAM.txt");
            lekan.commissionShip("Jupiter");
            System.out.println(lekan.toString());
            System.out.println(lekan.fightEncounter(3));
            
            
    }
  
}

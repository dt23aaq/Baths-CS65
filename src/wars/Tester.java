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
public class Tester {
    public static void main(String[] args) {
       ArrayList<Ship> ships;
        ships = new ArrayList<>();
       Ship victory = new ManOWar("victory",500,3,3);
       Ship colCannon = new ManOWar("colCannon",500,4,2);
       Ship edEvans = new ManOWar("edvans",500,8,3);
       Ship benBaggins = new Frigate("bebBaggins",160, 8, 16);
       Ship fredFox = new Frigate("fredFox",100, 6, 10);
       Ship gilGamage = new Frigate("gilgamage",200, 7, 20);
       Ship dandare = new Sloop("dandare",150,5);
       Ship halHenry = new Sloop("halHenry",200,5);
       Ship ianIdle = new Sloop("ianidle",400,5);
       Ship johnJones = new Sloop("johnJones",100,2);
       
       ships.add(victory);
       ships.add( edEvans);
       ships.add( colCannon);
//       ships.put(benBaggins.getName(), benBaggins);
//       ships.put(fredFox.getName(), fredFox);
//       ships.put(gilGamage.getName(),gilGamage);
//       ships.put (dandare.getName(),dandare);
//       ships.put(halHenry.getName(), halHenry);
//       ships.put(johnJones.getName(), johnJones);
//       ships.put(ianIdle.getName(), ianIdle);
            
       Ship  ship = ships.getFirst();
        System.out.println(ship);
    }      
}

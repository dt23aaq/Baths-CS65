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

            SeaBattles lekan = new SeaBattles("lekan");
            System.out.println(lekan.commissionShip("Victory"));
            System.out.println(lekan.commissionShip("Sophie"));
            System.out.println(lekan.commissionShip("Beast"));
            System.out.println(lekan.getWarChest());
            
    }      
}

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
    String user;
    String passwor;
    public static void main(String[] args) {
        
//        Tester user = new Tester();
//        user.user = "leakan";
//        user.passwor ="12345";
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.odt"))) {
//            out.writeObject(user);
//            System.out.println("Game saved successfully.");
//        } catch (IOException e) {
//            System.err.println("Error saving game: " + e.getMessage());
//        }
            
//            SeaBattles lekan = new SeaBattles("lekan", "encountersAM.txt");
//            lekan.commissionShip("Victory");
//            lekan.commissionShip("Sophie");
//            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.odt"))) {
//            out.writeObject(lekan);
//            System.out.println("Game saved successfully.");
//        } catch (IOException e) {
//            System.err.println("Error saving game: " + e.getMessage());
//        }
//            
//            lekan.loadGame("lekan.dot");
//            System.out.println(lekan.getSquadron());


        String filename = "seabattles.sav";

        // Create a new game instance
        SeaBattles game = new SeaBattles("Admiral Nelson");
        System.out.println("Before Saving: " + game);

        // Save the game
        game.saveGame(filename);

        // Load the game
        SeaBattles loadedGame = game.loadGame(filename);
        if (loadedGame != null) {
            System.out.println("After Loading: " + loadedGame);
        }
           
    }    
}

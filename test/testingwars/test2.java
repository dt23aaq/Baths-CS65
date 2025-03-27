/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package testingwars;
import java.io.File;
import wars.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wars.SeaBattles;

/**
 *
 * @author lekan
 */
public class test2 {
    BATHS game;
    public test2() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new SeaBattles("Admiral Test");
    }
    
    @After
    public void tearDown() {
    }
    @Test
       public void testInitialGameState() {
           assertEquals("Admiral Test", game.toString().split("\n")[0].split(": ")[1]);
           assertEquals(1000.0, game.getWarChest(), 0.01);
           assertEquals("No ships", game.getSquadron());
           assertEquals("No ships", game.getReserveFleet());
       }

       // Ship Management Tests
       @Test
       public void testShipCommissioningSequence() {
           // Commission multiple ships
           String[] shipNames = {"Victory", "Sophie"};

           for (String shipName : shipNames) {
               String result = game.commissionShip(shipName);
               assertEquals("Ship commissioned", result);
               assertTrue(game.isInSquadron(shipName));
           }

           // Verify squadron size
           assertNotEquals("No ships commissioned", game.getSquadron());
       }

       @Test
       public void testShipCommissioningWithInsufficientFunds() {
           // Simulate depleting war chest
           for (int i = 0; i < 10; i++) {
               game.fightEncounter(1);  // Assuming this reduces war chest
           }

           String result = game.commissionShip("Victory");
           assertTrue(result.contains("Not enough money"));
       }

       @Test
       public void testShipDecommissioningAndRestoration() {
           // Commission a ship
           game.commissionShip("Surprise");
           assertTrue(game.isInSquadron("Surprise"));

           // Decommission
           assertTrue(game.decommissionShip("Surprise"));
           assertFalse(game.isInSquadron("Surprise"));
//
//           // Restore
           game.commissionShip("Surprise");
           assertTrue(game.isInSquadron("Surprise"));
       }

       // Encounter Tests
       @Test
       public void testEncounterVariety() {
           game.commissionShip("Sophie");

           // Test multiple encounter types
           int[] encounterNumbers = {1, 2};  // Assuming at least these encounters exist

           for (int encounterNum : encounterNumbers) {
               String encounterDetails = game.getEncounter(encounterNum);
               assertNotEquals("\nNo such encounter", encounterDetails);

               String fightResult = game.fightEncounter(encounterNum);
               assertTrue(fightResult.startsWith("0-") || 
                          fightResult.startsWith("1-") || 
                          fightResult.startsWith("2-"));
           }
       }

       @Test
       public void testNonExistentEncounter() {
           String result = game.fightEncounter(9999);
           assertEquals("-1 No such encounter", result);
       }

       // War Chest Management Tests
       @Test
       public void testWarChestFluctuations() {
           game.commissionShip("Victory");
           double initialWarChest = game.getWarChest();

           // Fight multiple encounters
           for (int i = 1; i <= 3; i++) {
               game.fightEncounter(i);
           }

           // War chest should have changed
           assertNotEquals(initialWarChest, game.getWarChest(), 0.01);
       }

       // Persistence Tests
       @Test
       public void testGameSaveAndLoad() {
           // Commission some ships and fight some encounters
           game.commissionShip("Warspite");
           game.fightEncounter(1);

           String filename = "test_game_save.ser";

           // Save game
           game.saveGame(filename);

           // Load game
           SeaBattles loadedGame = game.loadGame(filename);

           assertNotNull(loadedGame);
           assertEquals(game.getWarChest(), loadedGame.getWarChest(), 0.01);

           // Clean up save file
           new File(filename).delete();
       }

       // Ship Information Tests
       @Test
       public void testShipInformationRetrieval() {
           // Get details of ships
           String[] shipNames = {"Sophie", "Victory"};

           for (String shipName : shipNames) {
               String details = game.getShipDetails(shipName);
               assertNotEquals("\nNo such ship", details);
               assertTrue(details.contains(shipName));
           }
       }

       // Complex Scenario Tests
       @Test
       public void testComplexGameScenario() {
           // Simulate a complex game scenario
           game.commissionShip("Belerophon");
           game.commissionShip("Beast");

           // Fight multiple encounters
           for (int i = 1; i <= 5; i++) {
               game.fightEncounter(i);
           }

           // Decommission some ships
           game.decommissionShip("Sophie");

           // Check final state
           assertFalse(game.isDefeated());
       }

       // Boundary Condition Tests
       @Test
       public void testDefeatConditionBoundary() {
           // Simulate continuous encounters to reach defeat
           while (!game.isDefeated()) {
               game.fightEncounter(1);
           }

           assertTrue(game.isDefeated());
           assertTrue(game.getWarChest() <= 0);
       }
   
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

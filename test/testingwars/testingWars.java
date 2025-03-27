/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package testingwars;
import  wars.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lekan
 */
public class testingWars {
    BATHS game;
    
    public testingWars() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new SeaBattles("Olek");
    }
    
    @After
    public void tearDown() {
    }
@Test
    public void testInitialWarChest() {
        // Check initial war chest value
        assertEquals(1000.0, game.getWarChest(), 0.01);
    }
    
    @Test
    public void testCommissionShip() {
        // Attempt to commission a ship that exists
        String result = game.commissionShip("Athena");
        assertEquals("Ship commissioned", result);
        
        // Verify the ship is in squadron
        assertTrue(game.isInSquadron("Athena"));
    }
    
    @Test
    public void testCommissionNonExistentShip() {
        // Try to commission a non-existent ship
        String result = game.commissionShip("Ghost Ship");
        assertEquals("- Ship not found", result);
    }
    
    @Test
    public void testDecommissionShip() {
        // First commission a ship
        game.commissionShip("Athena");
        
        // Then decommission
        assertTrue(game.decommissionShip("Athena"));
        
        // Verify ship is no longer in squadron
        assertFalse(game.isInSquadron("Athena"));
    }
    
    @Test
    public void testFightEncounter() {
        // Commission a ship first
        game.commissionShip("Athena");
        
        // Fight first encounter
        String result = game.fightEncounter(1);
        
        // Result should start with 0 (win) or 1/2 (loss)
        assertTrue(result.startsWith("0-") || result.startsWith("1-") || result.startsWith("2-"));
    }
    
    @Test
    public void testGetShipDetails() {
        // Check details of an existing ship
        String details = game.getShipDetails("Athena");
        assertNotEquals("\nNo such ship", details);
    }
    
    @Test
    public void testGetNonExistentShipDetails() {
        // Check details of non-existent ship
        String details = game.getShipDetails("Victoryer");
        assertEquals("\nNo such ship", details);
    }
    
    @Test
    public void testIsDefeated() {
        // Initially not defeated
        assertFalse(game.isDefeated());
    }
    
    @Test
    public void testDefeatCondition() {
        // Simulate losing all encounters to deplete war chest
        while (!game.isDefeated()) {
            game.fightEncounter(1);  // Assuming encounter 1 can be lost
        }
        
        // Verify defeat condition
        assertTrue(game.isDefeated());
    }
    
    // Extra Tests - More comprehensive scenario testing
    @Test
    public void testShipLifeCycle() {
        // Full ship lifecycle test
        // 1. Commission ship
        String commissionResult = game.commissionShip("Athena");
        assertEquals("Ship commissioned", commissionResult);
        
        // 2. Verify in squadron
        assertTrue(game.isInSquadron("Athena"));
        
        // 3. Decommission ship
        assertTrue(game.decommissionShip("Athena"));
        
        // 4. Attempt to recommission
        commissionResult = game.commissionShip("Athena");
        assertEquals("Ship commissioned", commissionResult);
    }
    
    @Test
    public void testMultipleEncounters() {
        // Commission a strong ship
        game.commissionShip("Athena");
        
        // Fight multiple encounters
        for (int i = 1; i <= 3; i++) {
            String result = game.fightEncounter(i);
            assertNotNull(result);
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

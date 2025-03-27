package wars;

import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the BATHS
 system as required for 5COM2007 Cwk1B BATHS - Feb 2025
 * 
 * @author A.A.Marczyk 
 * @version 16/02/25
 */

public class SeaBattles implements BATHS
{
    // may have one HashMap and select on stat

    private String admiral;
    private double warChest;
    private static final long serialVersionUID = 1L;
    
    // Collections to store ships and encounters
    private HashMap<String, Ship> ships; // All ships indexed by name
    private ArrayList<Ship> squadron ; // Ships in the admiral's squadron
    private ArrayList<Ship> reserveFleet ; // Ships in reserve
    private ArrayList<Ship> sunkShips ; // Ships that have been sunk
    private HashMap<Integer, Encounter> encounters; // All encounters indexed by number
//**************** BATHS ************************** 
    /** Constructor requires the name of the admiral
     * @param adm the name of the admiral
     */  
    public SeaBattles(String adm)
    {
        this.admiral = adm;
        warChest = 1000.0; 
        this.squadron = new ArrayList<>();
        this.reserveFleet = new ArrayList<>();
        this.sunkShips = new ArrayList<>();
        this.ships = new HashMap<>();
        this.encounters = new HashMap<>();

       setupShips();
       setupEncounters();
    }
    
    /** Constructor requires the name of the admiral and the
     * name of the file storing encounters
     * @param admir the name of the admiral
     * @param filename name of file storing encounters
     */  
    public SeaBattles(String admir, String filename)  //Task 3
    {
       // setupEncounters();
       // uncomment for testing Task 
       this(admir);
        readEncounters(filename);
        setupShips();
    }
    
    
    /**Returns a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     * @return a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     **/
    @Override
    public String toString()
    {
        
       StringBuilder sb = new StringBuilder();
        sb.append("Admiral: ").append(admiral).append("\n");
        sb.append("War Chest: ").append(warChest).append("\n");
        sb.append("Defeated: ").append(isDefeated()).append("\n\n");
        
        sb.append("Squadron:\n");
        sb.append(getSquadron()).append("\n\n");
        
        sb.append("Reserve Fleet:\n");
        sb.append(getReserveFleet());
        
        return sb.toString();
    }
    
    
    /** returns true if War Chest <=0 and the admiral's squadron has no ships which 
     * can be retired. 
     * @return 
     * @returns true if War Chest <=0 and the admiral's fleet has no ships 
     * which can be retired. 
     */
    
    @Override
    public boolean isDefeated()
    {
        if (warChest > 0) return false;
        
        // Check if any ships can be retired
        for (Ship ship : squadron) {
            if (ship.getState() == ShipState.ACTIVE) {
                return false;
            }
        }
        return true;
    }
    
    /** returns the amount of money in the War Chest
     * @return 
     * @returns the amount of money in the War Chest
     */
    @Override
    public double getWarChest()
    {
        return warChest;
    }
    
    
    /**Returns a String representation of all ships in the reserve fleet
     * @return a String representation of all ships in the reserve fleet
     **/
    @Override
    public String getReserveFleet()
    {   //assumes reserves is a Hashmap
        if (reserveFleet.isEmpty()) {
           return "No ships";
        }
        StringBuilder sb = new StringBuilder();
        for(Ship ship:reserveFleet){
           sb.append(ship.toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**Returns a String representation of the ships in the admiral's squadron
     * or the message "No ships commissioned"
     * @return a String representation of the ships in the admiral's fleet
     **/
    @Override
    public String getSquadron()
    {
        StringBuilder sb = new StringBuilder();
        if (squadron.isEmpty()) {
           return "No ships";
        } 
        for(Ship ship:squadron){
           sb.append(ship.toString()).append("\n");
           
        }
        return sb.toString();
    }
    
    /**Returns a String representation of the ships sunk (or "no ships sunk yet")
     * @return a String representation of the ships sunk
     **/
    @Override
    public String getSunkShips()
    {
       
        StringBuilder sb = new StringBuilder();
        if (sunkShips.isEmpty()) {
           return "No ships sunk yet";
        } 
        for(Ship ship:sunkShips){
           sb.append(ship.toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**Returns a String representation of the all ships in the game
     * including their status
     * @return a String representation of the ships in the game
     **/
    @Override
    public String getAllShips()
    {if (ships.isEmpty()) {
            return "No ships";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Ship ship : ships.values()) {
            sb.append(ship.toString()).append("\n");
        }
        return sb.toString();
  
    }
    
    
    /** Returns details of any ship with the given name
     * @return details of any ship with the given name
     **/
    @Override
    public String getShipDetails(String nme)
    {
        Ship ship = ships.get(nme);
               if (ship == null) {
                   return "\nNo such ship";
               }
               return ship.toString();
    }     
 
    // ***************** Fleet Ships ************************   
    /** Allows a ship to be commissioned to the admiral's squadron, if there 
     * is enough money in the War Chest for the commission fee.The ship's 
     * state is set to "active"
     * @param nme represents the name of the ship
     * @return "Ship commissioned" if ship is commissioned, "Not found" if 
     * ship not found, "Not available" if ship is not in the reserve fleet, "Not 
     * enough money" if not enough money in the warChest
     **/        
    @Override
    public String commissionShip(String nme)
    {
         Ship ship = ships.get(nme);
        
        if (ship == null) {
            return "- Ship not found";
        }
        
        if (ship.getState() != ShipState.RESERVE) {
            return "- Not available";
        }
        
        if (warChest < ship.getcommissionFee()) {
            return "- Not enough money";
        }
    
        // Commission the ship
        warChest = warChest - ship.getcommissionFee();
        ship.setState(ShipState.ACTIVE);
        reserveFleet.remove(ship);
        squadron.add(ship);
        return "Ship commissioned";
        
    }
        
    /** Returns true if the ship with the name is in the admiral's squadron, false otherwise.
     * @param nme is the name of the ship
     * @return returns true if the ship with the name is in the admiral's squadron, false otherwise.
     **/
    @Override
    public boolean isInSquadron(String nme)
    {
        Ship ship = ships.get(nme);
        return ship != null && squadron.contains(ship);
    }
    
    /** Decommissions a ship from the squadron to the reserve fleet (if they are in the squadron)
     * pre-condition: isInSquadron(nme)
     * @param nme is the name of the ship
     * @return true if ship decommissioned, else false
     **/
    @Override
    public boolean decommissionShip(String nme)
    {
        Ship ship = ships.get(nme);
        
        if (!isInSquadron(nme)|| ship.getState()== ShipState.SUNK) {
            return false;
        }
        ship.setState(ShipState.RESERVE);
        squadron.remove(ship);
        reserveFleet.add(ship);
        warChest = warChest + ship.getcommissionFee()/2;
        
        return true;
    }
    
  
    /**Restores a ship to the squadron by setting their state to ACTIVE 
     * @param ref the name of the ship to be restored
     */
    @Override
    public void restoreShip(String ref)
    {
        Ship ship = ships.get(ref);
        if (ship != null && squadron.contains(ship)) {
            ship.setState(ShipState.ACTIVE);
            System.out.println(ref +": Restored and now Active ");
        }
        
    }
    
//**********************Encounters************************* 
    /** returns true if the number represents a encounter
     * @param num is the reference number of the encounter
     * @returns true if the reference number represents a encounter, else false
     **/
    @Override
     public boolean isEncounter(int num)
     {
         
        return encounters.containsKey(num);
     }
     
     
/** Retrieves the encounter represented by the encounter 
      * number.Finds a ship from the fleet which can fight the 
      * encounter.The results of fighting an encounter will be 
      * one of the following: 
      * 0-Encounter won by...(ship reference and name)-add prize money to War 
      * Chest and set ship's state to RESTING,  
      * 1-Encounter lost as no ship available - deduct prize from the War Chest,
      * 2-Encounter lost on battle skill and (ship name) sunk" - deduct prize 
      * from War Chest and set ship state to SUNK.
      * If an encounter is lost and admiral is completely defeated because there 
      * are no ships to decommission,add "You have been defeated " to message, 
      * -1 No such encounter
      * Ensure that the state of the war chest is also included in the return message.
      * @param encNo is the number of the encounter
      * @return a String showing the result of fighting the encounter
      */ 
    @Override
    public String fightEncounter(int encNo)
    {
       Encounter encounter = encounters.get(encNo);
        if (encounter == null) {
            return "-1 No such encounter";
        }
        
        // Find a suitable ship for the encounter
        Ship bestShip = null;
        for (Ship ship : squadron) {
            if (ship.getState() == ShipState.ACTIVE) {
                if (bestShip == null || ship.getBattleSkill() > bestShip.getBattleSkill()) {
                    bestShip = ship;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        // No ships available
        if (bestShip == null ) {
            warChest -= encounter.getPrize();
            result.append("1-Encounter lost as no ship available - deducted ")
                  .append(encounter.getPrize())
                  .append(" from War Chest.");
            
            if (isDefeated()) {
                result.append(" You have been defeated!");
            }
        } 
        // Ship vs encounter battle
        else {
            // Compare ship skill vs encounter rating
            if (bestShip.getBattleSkill() >= encounter.getskillRequired() && bestShip.encounterType.contains(encounter.getType())) {
                // Ship wins
                warChest += encounter.getPrize();
                bestShip.setState(ShipState.RESTING);
                
                result.append("0-Encounter won by ")
                      .append(bestShip.getName())
                      .append(" - added ")
                      .append(encounter.getPrize())
                      .append(" to War Chest.");
            } else {
                // Ship loses and sinks
                warChest -= encounter.getPrize();
                bestShip.setState(ShipState.SUNK);
                squadron.remove(bestShip);
                sunkShips.add(bestShip);
                if(bestShip.getBattleSkill() <= encounter.getskillRequired()){
                result.append("2-Encounter lost on battle skill and ")
                      .append(bestShip.getName())
                      .append(" sunk - deducted ")
                      .append(encounter.getPrize())
                      .append(" from War Chest.");
                }
                
                if(!bestShip.encounterType.contains(encounter.getType())){
                result.append("2-Encounter lost on encounter type. "+ bestShip.getType()+ " Cannot participate in ")
                      .append(encounter.getType()+ "\n")
                      .append(bestShip.getName())
                      .append(" sunk - deducted ")
                      .append(encounter.getPrize())
                      .append(" from War Chest.");
                }
                
                if (isDefeated()) {
                    result.append(" You have been defeated!");
                }
            }
            for (Ship ship : squadron){
                if(ship.getState() == ShipState.RESTING && ship != bestShip )
                    ship.setState(ShipState.ACTIVE);
            }
        }
        
        result.append(" War Chest: ").append(warChest);
        return result.toString();
    
    }

    /** Provides a String representation of an encounter given by 
     * the encounter number
     * @param num the number of the encounter
     * @return returns a String representation of a encounter given by 
     * the encounter number
     **/
    public String getEncounter(int num)
    {
        Encounter encounter = encounters.get(num);
        if (encounter == null) {
            return "\nNo such encounter";
        }
        return encounter.toString();
        
    }
    
    /** Provides a String representation of all encounters 
     * @return returns a String representation of all encounters
     **/
    @Override
    public String getAllEncounters()
    {
 
        if (encounters.isEmpty()) {
            return "No encounters";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Encounter encounter : encounters.values()) {
            sb.append(encounter.toString()).append("\n");
        }
        return sb.toString();
    
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
     private void setupShips()
     {
       ships = new HashMap<>();
       Ship Victory = new ManOWar("Victory",500,3,3,"Alan Aikin",30);
       Ship Endeavour = new ManOWar("Endeavour",500,4,2,"Col Cannon",20);
       Ship Belerophon = new ManOWar("Belerophon",500,8,3,"Ed Evans", 50);
       Ship Sophie = new Frigate("Sophie",160, 8, 16,"Ben Baggins",true);
       Ship Surprise = new Frigate("Surprise",100, 6, 10,"Fred Fox", false);
       Ship Jupiter = new Frigate("Jupiter",200, 7, 20,"Gil Gamage",false);
       Ship Arrow = new Sloop("Arrow",150,5,"Dan Dare",true);
       Ship Paris = new Sloop("Paris",200,5,"Hal Henry",true);
       Ship Beast = new Sloop("Beast",400,5,"Ian Idle", false);
       Ship Athena = new Sloop("Athena",100,5,"John Jones ", true);
       
       ships.put(Victory.getName(),Victory);
       ships.put(Endeavour.getName(), Endeavour);
       ships.put(Belerophon.getName(), Belerophon);
       ships.put(Sophie.getName(), Sophie);
       ships.put(Surprise.getName(), Surprise);
       ships.put(Jupiter.getName(),Jupiter);
       ships.put (Arrow.getName(),Arrow);
       ships.put(Paris.getName(), Paris);
       ships.put(Beast.getName(), Beast);
       ships.put(Athena.getName(), Athena);
     }
     
    private void setupEncounters(){
     
        readEncounters("encountersAM.txt");
    }
 
        
    // Useful private methods to "get" objects from collections/maps

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3 ************************************************/

    
    //******************************** Task 3.5 **********************************
    /** reads data about encounters from a text file and stores in collection of 
     * encounters.Data in the file is editable
     * @param filename name of the file to be read
     */
    public void readEncounters(String filename)
    { 
        
        try(FileReader readfile = new FileReader(filename)){
        Scanner reader = new Scanner(readfile);
        int countline = 1;
            while (reader.hasNext()){
                String line = reader.nextLine();
                String[] array = line.split(",");
                String type = array[0];
                String  location = array[1];
                int skillRequired = Integer.parseInt(array[2]);
                double prize = Double.parseDouble(array[3]);

     
                encounters.put(countline,new Encounter(type,location,skillRequired,prize));

                countline+= 1;
            }
        reader.close();
        readfile.close();
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }   
 
    
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    @Override
    public void saveGame(String fname)
    {   // uses object serialisation 
           try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fname))) {
            out.writeObject(this);
            out.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as an SeaBattles object)
     */
    @Override
    public SeaBattles loadGame(String fname)
    {   // uses object serialisation 
       
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname))) {
            return (SeaBattles) in.readObject(); // type casting it with SeaBattles
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game: " + e.getMessage());
            return null;
        }
    } 
    
 
}




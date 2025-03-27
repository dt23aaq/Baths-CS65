package wars;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/02/12
 */
public class GameGUI 
{
    private BATHS gp = new SeaBattles("Fred");
    private JFrame myFrame = new JFrame("Game GUI");
    private Container contentPane = myFrame.getContentPane();
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight Encounter");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
        addEastPanelButtons();
    }
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        listing.setEditable(false);
        listing.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentPane.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(clearBtn);
        clearBtn.addActionListener(new ClearHandler());
        eastPanel.add(quitBtn);
        quitBtn.addActionListener(new QuitHandler());
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 400);
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the Ships menu
        JMenu shipsMenu = new JMenu("Ships");
        menubar.add(shipsMenu);
        
        // List Squadron menu item
        JMenuItem listSquadronItem = new JMenuItem("List Squadron");
        listSquadronItem.addActionListener(new ListSquadronHandler());
        shipsMenu.add(listSquadronItem);
        
        // View Ship menu item
        JMenuItem viewShipItem = new JMenuItem("View a Ship");
        viewShipItem.addActionListener(new ViewShipHandler());
        shipsMenu.add(viewShipItem);
        
        // Commission Ship menu item
        JMenuItem commissionShipItem = new JMenuItem("Commission Ship");
        commissionShipItem.addActionListener(new CommissionShipHandler());
        shipsMenu.add(commissionShipItem);
        
        // Existing list of reserve ships and decommission menu items
        JMenuItem listReserveItem = new JMenuItem("List reserve Ships");
        listReserveItem.addActionListener(new ListFleetHandler());
        shipsMenu.add(listReserveItem);
        
        JMenuItem decommissionItem = new JMenuItem("De-commission Ship");
        decommissionItem.addActionListener(new DecommissionHandler());
        shipsMenu.add(decommissionItem);
    }
    
    /**
     * Add buttons to the east panel
     */
    private void addEastPanelButtons() {
        // View State button
        eastPanel.add(viewBtn);
        viewBtn.addActionListener(new ViewStateHandler());
        
        // Fight Encounter button
        eastPanel.add(fightBtn);
        fightBtn.addActionListener(new FightEncounterHandler());
    }
    
    // Handler for listing squadron
    private class ListSquadronHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getSquadron();
            listing.setText("SQUADRON DETAILS:\n" + xx);
        }
    }
    
    // Handler for viewing a specific ship
    private class ViewShipHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String shipName = JOptionPane.showInputDialog(myFrame, "Enter ship name:");
            if (shipName != null && !shipName.trim().isEmpty()) {
                String details = gp.getShipDetails(shipName);
                JOptionPane.showMessageDialog(myFrame, details, 
                    "Ship Details", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    // Handler for commissioning a ship
    private class CommissionShipHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String shipName = JOptionPane.showInputDialog(myFrame, "Enter ship name to commission:");
            if (shipName != null && !shipName.trim().isEmpty()) {
                String result = gp.commissionShip(shipName);
                JOptionPane.showMessageDialog(myFrame, result, 
                    "Commission Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    // Handler for viewing game state
    private class ViewStateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String gameState = gp.toString();
            listing.setText("GAME STATE:\n" + gameState);
        }
    }
    
    // Handler for fighting an encounter
    private class FightEncounterHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String encounterNumStr = JOptionPane.showInputDialog(myFrame, "Enter encounter number:");
            if (encounterNumStr != null && !encounterNumStr.trim().isEmpty()) {
                try {
                    int encounterNum = Integer.parseInt(encounterNumStr);
                    String result = gp.fightEncounter(encounterNum);
                    JOptionPane.showMessageDialog(myFrame, result, 
                        "Encounter Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(myFrame, "Invalid encounter number", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    // Existing handlers...
    private class ListFleetHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getReserveFleet();
            listing.setText("RESERVE FLEET:\n" + xx);
        }
    }
    
    private class ClearHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText("");
            listing.setVisible(false);            
        }
    }
    
    private class DecommissionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "";
            String inputValue = JOptionPane.showInputDialog("Ship code ?: ");
            
            if(gp.isInSquadron(inputValue)) 
            {
                gp.decommissionShip(inputValue);
                result = inputValue + " is decommissioned";
            }
            else
            {
                result = inputValue + " not in fleet";
            }
            JOptionPane.showMessageDialog(myFrame,result);    
        }
    }
    
    // Quit handler
    private class QuitHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int response = JOptionPane.showConfirmDialog(
                myFrame, 
                "Are you sure you want to quit?", 
                "Confirm Quit", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
    
    // Main method to launch the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
/**
 *
 * @author lekan
 */
public class Tester {
    public static void main(String[] args) {
        Frigate fship = new Frigate("a",1000,1);
        System.out.println(fship.getBattleSkill());
        System.out.println(fship);
        System.out.println(fship.getType());
        System.out.println(fship.getState()== ShipState.RESERVE);
    }
}

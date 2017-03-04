/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.world;

/**
 *
 * @author Ajikozau
 */
public class City extends WorldElement {    
    private enum Type {
        VILLAGE, TOWN, CITY, METROPOLIS, CAPITOL
    }
    private Type type;
    
    public City(String name, int x, int y, int faction, Type type){
        super(name, x, y, faction);
        this.type = type;
    }
}

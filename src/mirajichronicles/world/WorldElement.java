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
public abstract class WorldElement {
    protected String name;    
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }    
    private int x;
    public int getX() { return x; }
    public void setX(int x) {
        this.x = x;
    }    
    private int y;    
    public int getY() { return y; }
    public void setY(int y) {
        this.y = y;
    }
    private int faction;
    public int getFaction() { return faction; }
    public void setFaction(int faction) {
        this.faction = faction;
    }
    
    public WorldElement(String name, int x, int y, int faction){
        this.name = name;
        this.x = x;
        this.y = y;
    }    
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}

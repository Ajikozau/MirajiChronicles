/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.world;

import org.engine.graph.Texture;

/**
 *
 * @author Ajikozau
 */
public class WorldTile {
    
    public enum Type{GRASS, MOUNTAIN, LAKE, ROAD, FOREST};
    private final Type type;
    
    private final int x; 
    public int getX() { return x; }
    private final int y;
    public int getY() { return y; }   

    public WorldTile(int x, int y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    
    public int getPassability() { 
        switch(type){
            case GRASS: 
                return 2;
            case MOUNTAIN: 
                return 3;
            case LAKE:
                return 99;
            case ROAD:
                return 1;
            case FOREST:
                return 3;
            default:
                return 0;
        }
    }        
}

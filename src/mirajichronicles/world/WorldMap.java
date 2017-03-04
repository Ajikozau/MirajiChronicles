/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.world;

import helper.StaticHelpers;
import java.util.HashSet;
import java.util.Set;
import org.joml.Vector4f;

/**
 *
 * @author Ajikozau
 */
public class WorldMap {
    private final Set<WorldElement>[][] worldElements;
    public Set<WorldElement>[][] getWorldElements() { return worldElements; }    
    private final WorldTile[][] tiles;
    public WorldTile[][] getTiles() { return tiles; }
    
    public WorldMap(WorldTile[][] tiles){
        worldElements = new HashSet[tiles.length][tiles[0].length];
        this.tiles = tiles;
    }
    
    public Set<WorldElement> getElementsAtTile(int x, int y){
        return worldElements[x][y];
    }
    
    public City getCityAtTile(int x, int y){
        Set<WorldElement> elements = getElementsAtTile(x, y);
        for (WorldElement e : elements){
            if (e instanceof City){
                return (City) e;
            }            
        }
        return null;
    }
    
    public Army getArmyAtTile(int x, int y){
        Set<WorldElement> elements = getElementsAtTile(x, y);
        for (WorldElement e : elements){
            if (e instanceof Army){
                return (Army) e;
            }            
        }
        return null;
    }
}

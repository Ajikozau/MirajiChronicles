/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.world;

import org.engine.elements.Entity;
import org.engine.graph.Mesh;

/**
 *
 * @author Ajikozau
 */
public class WorldEntity extends WorldElement {    
    private Entity entity;
    private City city;
    private Army army;
    
    public WorldEntity(String name, int x, int y, int faction, Entity entity) {
        super(name, x, y, faction);
        city = null;
        army = null;
    }            
}

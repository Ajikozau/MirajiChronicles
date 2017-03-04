/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.states;

import mirajichronicles.world.WorldMap;
import org.engine.MouseInput;
import org.engine.Window;
import org.game.Game;
import org.game.GameState;
import org.joml.Vector3f;

/**
 *
 * @author Ajikozau
 */
public class WorldMapState extends GameState {
    
    private WorldMap worldMap;
    public WorldMap getWorldMap() { return worldMap; }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }        
    
    public WorldMapState(Game game, Vector3f cameraInc, float angleInc, float lightAngle, WorldMap worldMap) {
        super(game, cameraInc, angleInc, lightAngle);
    }   

    @Override
    public void init(Window window) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void input(Window window, MouseInput mouseInput) {
        
    }

    @Override
    public void update(float interval, MouseInput mouseInput, Window window) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Window window) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cleanup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

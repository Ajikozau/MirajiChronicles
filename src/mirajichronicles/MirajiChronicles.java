/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles;

import helper.Random;
import helper.StaticHelpers;
import java.util.ArrayList;
import mirajichronicles.world.WorldMap;
import mirajichronicles.world.WorldTile;
import org.engine.Scene;
import org.engine.Window;
import org.engine.elements.GameElement;
import org.engine.graph.Material;
import org.engine.graph.Mesh;
import org.engine.graph.Texture;
import org.engine.loaders.obj.OBJLoader;
import org.game.DefaultGameState;
import org.game.Game;
import org.game.GameState;
import org.game.MouseBoxSelectionDetector;
import org.joml.Vector3f;
import org.lwjgl.openal.AL11;

/**
 *
 * @author Ajikozau
 */
public class MirajiChronicles extends Game {      
    
    private GameState start;
    private WorldMap worldMap;
    
    public MirajiChronicles(){
        super();
        createGameStates();
        gameState = start;
    }        
    
    public void initGameElements() throws Exception {
        gameElements = new ArrayList<>();
        Mesh tableMesh = OBJLoader.loadMesh("/models/Table.obj", 1);
        tableMesh.setMaterial(new Material(new Texture("/textures/TableTexture.png", 1, 1), 1));
        GameElement table = new GameElement(tableMesh);        
        table.setScale(0.96f);
        table.setPosition(0, -0.0001f, 0);
        Mesh borderMesh = OBJLoader.loadMesh("/models/Border.obj", 1);
        borderMesh.setMaterial(new Material(new Texture("/textures/Border.png", -10, -10), 1));
        GameElement border = new GameElement(borderMesh);
        //1920, 1080, 0.144 //0,192
        border.setScale(0.96f);
        border.setPosition(0, 0, 0);
        Mesh worldMapM = OBJLoader.loadMesh("/models/WorldMapTable.obj", 1);
        worldMapM.setMaterial(new Material(new Vector3f(255, 255, 153), 1));
        GameElement worldMapTable = new GameElement(worldMapM);
        //1881.6, 1041.6
        worldMapTable.setScale(0.9408f);
        worldMapTable.setPosition(0, 0, 0);
        gameElements.add(table);
        gameElements.add(border);
        createWorldMap(worldMapTable);
        Mesh pieceMesh = OBJLoader.loadMesh("/models/PieceBase.obj", 1);
        pieceMesh.setMaterial(new Material(new Texture("/textures/PieceBase.png", 1, 1), 1));
        GameElement piece = new GameElement(pieceMesh);        
        piece.setScale(0.050f);
        float sx = worldMapTable.getBounds()[0] * worldMapTable.getScale();
        float sy = worldMapTable.getBounds()[2] * worldMapTable.getScale() + 0.0001f;
        float tileScale = worldMapTable.getScale()/9f;
        float ox = piece.getBounds()[0] * tileScale;
        piece.setPosition(sx-ox, -0.0001f, sy-ox);
        /*Mesh worldMapBorderM = OBJLoader.loadMesh("/models/WorldMapBorder.obj", 1);
        worldMapBorderM.setMaterial(new Material(new Vector3f(255, 0, 153), 1));
        GameElement worldMapBorder = new GameElement(worldMapBorderM);
        worldMapBorder.setScale(1);
        worldMapBorder.setPosition(0, 0.001f, 0);*/
        
          
        
        gameElements.add(piece);
        //gameElements.add(worldMapTable);
        //gameElements.add(worldMapBorder);
        scene.setGameElements(gameElements);
    }   
    
    @Override
    protected void createGameStates(){
        start = new DefaultGameState(this, new Vector3f(0.0f, 0.0f, 0.0f), 0, 45){
            @Override
            public void init(Window window) throws Exception {
                hud.init(window);
                renderer.init(window);
                leftButtonPressed = false;
                scene = new Scene();
                selectDetector = new MouseBoxSelectionDetector();
                initGameElements();
                setupLights();
                camera.getPosition().x = 0f;
                camera.getPosition().y = 0.94f;
                camera.getPosition().z = 0f;
                camera.getRotation().x = 90f;
                camera.getRotation().y = 0;
                // Sounds
                soundMgr.init();
                soundMgr.setAttenuationModel(AL11.AL_EXPONENT_DISTANCE);
                setupSounds();
            }
        };
    }
    
    @Override
    public void render(Window window) {
        renderer.render(window, camera, scene);
        hud.render(window);
    }
    
    private void createWorldMap(GameElement worldMapTable) throws Exception {
        WorldTile[][] tiles = new WorldTile[9][5];   
        Mesh grass = OBJLoader.loadMesh("/models/tile.obj", 1);
        grass.setMaterial(new Material(new Texture("/textures/tiles/grass.png", 1, 1), 1));
        Mesh mountain = OBJLoader.loadMesh("/models/tile.obj", 1);
        mountain.setMaterial(new Material(new Texture("/textures/tiles/mountain.png", 1, 1), 1));
        Mesh lake = OBJLoader.loadMesh("/models/tile.obj", 1);
        lake.setMaterial(new Material(new Texture("/textures/tiles/water.png", 1, 1), 1));
        Mesh road = OBJLoader.loadMesh("/models/tile.obj", 1);
        road.setMaterial(new Material(new Texture("/textures/tiles/road.png", 1, 1), 1));
        Mesh forest = OBJLoader.loadMesh("/models/tile.obj", 1);
        forest.setMaterial(new Material(new Texture("/textures/tiles/forest.png", 1, 1), 1));
        float sx = worldMapTable.getBounds()[0] * worldMapTable.getScale();
        float sy = worldMapTable.getBounds()[2] * worldMapTable.getScale() + 0.0001f;
        float tileScale = worldMapTable.getScale()/9f;
        StaticHelpers.fill2DArray(tiles, (x, y) -> {    
            Random r = new Random();
            WorldTile tile;
            GameElement tileElement;
            switch(r.nextInt(5)){
                case 0:
                    tileElement = new GameElement(grass);                    
                    tile = new WorldTile(x, y, WorldTile.Type.GRASS);
                    break;
                case 1:
                    tileElement = new GameElement(mountain);
                    tile = new WorldTile(x, y, WorldTile.Type.MOUNTAIN);
                    break;
                case 2:
                    tileElement = new GameElement(lake);
                    tile = new WorldTile(x, y, WorldTile.Type.LAKE);
                    break;
                case 3:
                    tileElement = new GameElement(road);
                    tile = new WorldTile(x, y, WorldTile.Type.ROAD);
                    break;
                case 4:
                    tileElement = new GameElement(forest);
                    tile = new WorldTile(x, y, WorldTile.Type.FOREST);
                    break;   
                default: 
                    tileElement = new GameElement();
                    return null;
            }           
            tileElement.setScale(0.102f);
            float size = tileElement.getBounds()[0] * tileScale;
            float offsetX = (1 + (x * 2)) * size;
            float offsetY = (1 + (y * 2)) * size;
            float tileX = (sx - offsetX);
            float tileZ = (sy - offsetY);
            tileElement.setPosition(tileX, 0.0001f, tileZ);
            gameElements.add(tileElement);
            return tile;
        });
        worldMap = new WorldMap(tiles);        
    }
}

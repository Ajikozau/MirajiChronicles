/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles;

import org.engine.GameEngine;
import org.engine.Window;
import org.game.Game;
/**
 *
 * @author Ajikozau
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            boolean vSync = true;
            Game game = new MirajiChronicles();
            Window.WindowOptions opts = new Window.WindowOptions();
            opts.cullFace = true;
            opts.showFps = true;
            opts.compatibleProfile = true;
            opts.antialiasing = true;
            GameEngine gameEng = new GameEngine("GAME", vSync, opts, game);
            gameEng.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
    
}

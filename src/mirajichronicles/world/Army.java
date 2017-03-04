/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.world;

import helper.StaticHelpers;
import java.util.List;
import mirajichronicles.entities.GameCharacter;

/**
 *
 * @author Ajikozau
 */
public class Army extends WorldElement {
    private int maxSize;
    private int cost;
    private List<GameCharacter> pieces;    

    public Army(String name, int x, int y, int faction, int maxSize, List<GameCharacter> pieces) {
        super(name, x, y, faction);
        this.maxSize = maxSize;
        this.pieces = pieces;
        cost = 0;
        StaticHelpers.iterateList(pieces, piece -> {
            cost += piece.getCost();
        }); 
    }    
    
    public void addPiece(GameCharacter piece){
        pieces.add(piece);
        cost += piece.getCost();
    }
    
    public void removePiece(GameCharacter piece){
        pieces.remove(piece);
        cost -= piece.getCost();
    }
}

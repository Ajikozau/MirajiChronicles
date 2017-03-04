/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirajichronicles.entities;

import helper.Utils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.game.GameEntity;

/**
 *
 * @author Ajikozau
 */
public class GameCharacter extends GameEntity {
    
    private String name;
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    
    private int cost;
    public int getCost() { return cost; }

    public void setCost(int cost) {
        this.cost = cost;
    }    
    
    private int toughness;
    private int might;
    private int magic;
    private int leadership;
    private int lore;
    private int speed;
    
    private boolean warrior = false;
    private boolean mage = false;
    private boolean faith = false;
    private boolean rogue  = false;
    private boolean human = false;
    private boolean divinity = false;
    private boolean demon = false;

    public GameCharacter(String fileName) {
        super(fileName);
    }   

    @Override
    public void parseFile(String fileName) {
        try {
            List<String> lines = Utils.readAllLines(fileName);
            name = lines.get(0);
            cost = Integer.parseInt(lines.get(1));
            toughness = Integer.parseInt(lines.get(2));
            might = Integer.parseInt(lines.get(3));
            magic = Integer.parseInt(lines.get(4));
            leadership = Integer.parseInt(lines.get(5));
            lore = Integer.parseInt(lines.get(6));
            speed = Integer.parseInt(lines.get(7));
            for (int i = 8; i < lines.size(); i++){
                switch(lines.get(i)){
                    case "w":
                        warrior = true;
                        break;
                    case "m":
                        mage = true;
                        break;
                    case "f":
                        faith = true;
                        break;
                    case "r":
                        rogue = true;
                        break;
                    case "h":
                        human = true;
                        break;
                    case "d":
                        divinity = true;
                        break;
                    case "D":
                        demon = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GameCharacter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

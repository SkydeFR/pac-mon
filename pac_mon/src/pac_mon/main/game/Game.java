/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game;

import pac_mon.main.game.level.Level;

/**
 * Jeu
 * @author Skyde
 */
public class Game {
    
    Level level;
    
    /**
     * Construction du jeu
     */
    public Game() {
        this.level = new Level();
    }
    
    /**
     * Initialisation du jeu
     */
    public void init() {
        level.init();
    }
    
    /**
     * Mise a jour du jeu
     */
    public void update() {
        level.update();
    }
    
    /**
     * Affiche le rendu du jeu
     */
    public void render() {
        level.render();
    }
    
}

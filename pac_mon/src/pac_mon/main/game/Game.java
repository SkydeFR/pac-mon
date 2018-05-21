/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac_mon.main.game;

/**
 * Jeu
 * @author Skyde
 */
public class Game {
    
    Level level;
    
    public Game() {
        level = new Level();
    }
    
    public void init() {
        level.init();
    }
    
    public void update() {
        level.update();
    }
    
    public void render(int time) {
        level.render(time);        
    }
    
}
